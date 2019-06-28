#include "ApiServidor.h"
#include "estructuras.cpp"
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>
#include <iostream>

#include <QCoreApplication>
#include <QtSql>
#include <iostream>
#include <QSqlDatabase>
#include <QSqlTableModel>
#include <QString>
#include <QSqlError>
#include <QtSql>
#include <qsqldatabase.h>
#include <QDir>
#include <sstream>
#include <string>

using namespace ::apache::thrift;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::server;

using namespace std;

using namespace  ::Thrift;

class ApiServidorHandler : virtual public ApiServidorIf {

    QSqlDatabase db;
public:
    ApiServidorHandler() {

        db = QSqlDatabase::addDatabase("QMYSQL");
        db.setHostName("192.168.43.195");//192.168.43.195
        db.setPort(3306);
        db.setDatabaseName("sistema_transito");
        db.setUserName("administrador");
        db.setPassword("admi-S1s");
        if(!db.open()){
            cout << db.lastError().text().toUtf8().constData() << endl;
        }
    }

    bool confirmarConductor(const int64_t telefono, const std::string& contrasena) {

        QSqlTableModel model;
        if(db.open()){

            model.setTable("conductor");
            stringstream appendStatement;
            QString statement;

            appendStatement << "telefono = " << std::to_string(telefono);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();

            QString consultaUsuario = model.record(0).value("telefono").toString();
            appendStatement.str("");
            appendStatement << "contrasena = " << "'" << contrasena << "'";
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();

            QString consultaContrasena = model.record(0).value("contrasena").toString();
            if(consultaUsuario.size() == 0 || consultaContrasena.size() == 0){

                cout << "<<Intento de inicio de sesion fallido>>" << endl;
                db.close();
                return false;
            } else {
                cout << "<<Inicio de sesion exitoso>>" << endl;
                db.close();
                return true;
            }
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    bool registrarConductor(const Conductor& conductor) {

        QSqlTableModel model;
        if(db.open()){
            unsigned long long telefono = conductor.telefono;
            unsigned long long numLicencia = conductor.numLicencia;
            model.setTable("conductor");
            QSqlRecord record = model.record();

            record.remove(record.indexOf("idconductor"));
            record.setValue("curp", QString::fromStdString(conductor.curp));
            record.setValue("fechaNac", QString::fromStdString(conductor.fechaNac));
            record.setValue("nombreComp", QString::fromStdString(conductor.nombreComp));
            record.setValue("numLicencia", numLicencia);
            record.setValue("telefono", telefono);
            record.setValue("estatus", 0);
            record.setValue("contrasena", QString::fromStdString(conductor.contrasena));
            if(model.insertRecord(-1, record)){

                cout << "<<Insercion exitosa>>" <<endl;
                model.submitAll();
                db.close();
                return true;
            } else {

                cout << "<<Insercion inexitosa>>" <<endl;
                db.close();
                return false;
            }
        }else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    bool registrarVehiculo(const Vehiculo& vehiculo, const int64_t telefono) {

        QSqlTableModel model;
        if(db.open()){
            model.setTable("vehiculo");
            QSqlRecord record = model.record();
            record.remove(record.indexOf("idvehiculo"));
            record.setValue("ano", vehiculo.ano);
            record.setValue("color", QString::fromStdString(vehiculo.color));
            record.setValue("marca", QString::fromStdString(vehiculo.marca));
            record.setValue("modelo", QString::fromStdString(vehiculo.modelo));
            record.setValue("numPlaca", QString::fromStdString(vehiculo.numPlaca));
            record.setValue("numPoliza", QString::fromStdString(vehiculo.numPoliza));
            record.setValue("nomAseguradora", QString::fromStdString(vehiculo.nomAseguradora));
            record.setValue("estatus", vehiculo.estatus);
            if(model.insertRecord(-1, record)){

                cout << "<<Insercion vehiculo exitosa>>" <<endl;
                model.submitAll();
            } else {

                cout << "<<Insercion vehiculo inexitosa>>" <<endl;
                db.close();
                return false;
            }

            stringstream appendStatement;
            QString statement;
            appendStatement << "numPlaca = " << "'" << vehiculo.numPlaca << "'";
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idvehiculo = model.record(0).value("idvehiculo").toInt();
            cout << "idvehiculo: " << idvehiculo << endl;
            model.setTable("conductor");
            appendStatement.str("");
            appendStatement << "telefono = " << std::to_string(telefono);
            cout << "telefono: " << telefono << endl;
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idconductor = model.record(0).value("idconductor").toInt();
            cout << "idconductor: " << idconductor << endl;
            model.setTable("conductor_vehiculo");
            record = model.record();
            record.setValue("idvehiculo", idvehiculo);
            record.setValue("idconductor", idconductor);
            if(model.insertRecord(-1, record)){

                cout << "<<Insercion relacion exitosa>>" <<endl;
                model.submitAll();
                db.close();
                return true;
            } else {

                cout << "<<Insercion relacion inexitosa>>" <<endl;
                model.setTable("vehiculo");
                appendStatement.str("");
                appendStatement << "idvehiculo = " << std::to_string(idvehiculo);
                statement = QString::fromStdString(appendStatement.str());
                model.setFilter(statement);
                model.select();
                model.removeRows(0, 1);

                model.submitAll();
                db.close();
                return false;
            }
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    bool modificarVehiculo(const Vehiculo& vehiculo, const std::string& numPLacaAnt) {

        QSqlTableModel model;
        if(db.open()){
            model.setTable("vehiculo");
            stringstream appendStatement;
            QString statement;
            appendStatement << "numPlaca = " << "'" << numPLacaAnt << "'";
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();

            QSqlRecord record = model.record(0);
            record.setValue("ano", vehiculo.ano);
            record.setValue("color", QString::fromStdString(vehiculo.color));
            record.setValue("marca", QString::fromStdString(vehiculo.marca));
            record.setValue("modelo", QString::fromStdString(vehiculo.modelo));
            record.setValue("numPlaca", QString::fromStdString(vehiculo.numPlaca));
            record.setValue("numPoliza", QString::fromStdString(vehiculo.numPoliza));
            record.setValue("nomAseguradora", QString::fromStdString(vehiculo.nomAseguradora));
            record.setValue("estatus", vehiculo.estatus);
            model.setRecord(0, record);
            if(model.submitAll()){

                db.close();
                return true;
            } else {

                db.close();
                return true;
            }
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    bool deshabilitarVehiculo(const std::string& numPlaca) {

        QSqlTableModel model;
        if(db.open()){
            model.setTable("vehiculo");
            stringstream appendStatement;
            QString statement;
            appendStatement << "numPlaca = " << "'" << numPlaca << "'";
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();

            QSqlRecord record = model.record(0);
            record.setValue("estatus", 1);
            model.setRecord(0, record);
            if(model.submitAll()){

                db.close();
                return true;
            } else {

                db.close();
                return true;
            }
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    void consultarVehiculoPropio(std::vector<Vehiculo> & _return, const int64_t telefono) {

        QSqlTableModel model;
        if(db.open()){
            model.setTable("conductor");
            stringstream appendStatement;
            QString statement;
            appendStatement << "telefono = " << std::to_string(telefono);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idconductor = model.record(0).value("idconductor").toInt();

            model.setTable("conductor_vehiculo");
            appendStatement.str("");
            appendStatement << "idconductor = " << std::to_string(idconductor);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();

            QSqlTableModel modelVehiculo;
            modelVehiculo.setTable("vehiculo");
            Vehiculo vehiculoRecuperado;
            for (int i = 0; i < model.rowCount(); ++i) {

                int idvehiculo = model.record(i).value("idvehiculo").toInt();
                appendStatement.str("");
                appendStatement << "idvehiculo = " << std::to_string(idvehiculo);
                statement = QString::fromStdString(appendStatement.str());
                modelVehiculo.setFilter(statement);
                modelVehiculo.select();
                int estatus = modelVehiculo.record(0).value("estatus").toInt();
                if(estatus == 0){

                    vehiculoRecuperado.__set_ano(modelVehiculo.record(0).value("ano").toInt());
                    vehiculoRecuperado.__set_modelo(modelVehiculo.record(0).value("modelo").toString().toUtf8().constData());
                    vehiculoRecuperado.__set_numPlaca(modelVehiculo.record(0).value("numPlaca").toString().toUtf8().constData());
                    _return.push_back(vehiculoRecuperado);
                }
            }
            db.close();
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    void consultarVehiculoInfo(Vehiculo& _return, const std::string& numPlaca) {

        QSqlTableModel model;
        Vehiculo vehiculoRecuperado;
        if(db.open()){
            model.setTable("vehiculo");
            stringstream appendStatement;
            QString statement;
            appendStatement << "numPlaca = " << "'" << numPlaca << "'";
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();

            vehiculoRecuperado.__set_ano(model.record(0).value("ano").toInt());
            vehiculoRecuperado.__set_color(model.record(0).value("color").toString().toUtf8().constData());
            vehiculoRecuperado.__set_marca(model.record(0).value("marca").toString().toUtf8().constData());
            vehiculoRecuperado.__set_modelo(model.record(0).value("modelo").toString().toUtf8().constData());
            vehiculoRecuperado.__set_numPlaca(model.record(0).value("numPlaca").toString().toUtf8().constData());
            vehiculoRecuperado.__set_estatus(model.record(0).value("estatus").toInt());
            vehiculoRecuperado.__set_numPoliza(model.record(0).value("numPaliza").toString().toUtf8().constData());
            vehiculoRecuperado.__set_nomAseguradora(model.record(0).value("nomAseguradora").toString().toUtf8().constData());
            db.close();
            _return = vehiculoRecuperado;
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    bool registrarReporte(const Reporte& reporte, const int64_t telefono) {

        QSqlTableModel model;
        if(db.open()){

            model.setTable("conductor");
            stringstream appendStatement;
            QString statement;
            appendStatement << "telefono = " << std::to_string(telefono);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idconductor = model.record(0).value("idconductor").toInt();

            model.setTable("reporte");
            QSqlRecord record = model.record();
            record.remove(record.indexOf("idreporte"));
            record.setValue("latitud", QString::fromStdString(reporte.latitud));
            record.setValue("longitud", QString::fromStdString(reporte.longitud));
            record.setValue("nombreOtroConduc", QString::fromStdString(reporte.nombreOtroConduc));
            record.setValue("fechaHora", QDateTime::currentDateTime().toUTC());
            record.setValue("idconductor", idconductor);
            if(model.insertRecord(-1, record)){

                cout << "<<Insercion reporte exitosa>>" <<endl;
                model.submitAll();
                db.close();
                return true;
            } else {

                cout << "<<Insercion reporte inexitosa>>" <<endl;
                db.close();
                return false;
            }
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    bool registrarFotografias(const std::vector<std::string> & fotografias, const int64_t telefono) {

        QSqlTableModel model;
        if(db.open()){

            model.setTable("conductor");
            stringstream appendStatement;
            QString statement;
            appendStatement << "telefono = " << std::to_string(telefono);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idconductor = model.record(0).value("idconductor").toInt();

            model.setTable("reporte");
            appendStatement.str("");
            appendStatement << "idconductor = " << std::to_string(idconductor);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idreporte = model.record(0).value("idreporte").toInt();

            model.setTable("fotografia_reporte");
            QSqlRecord record = model.record();
            bool exito = true;
            for(int i = 0; i < fotografias.size(); i++){
                record.setValue("idreporte",idreporte);
                record.setValue("fotografia", QString::fromStdString(fotografias[i]));
                cout << "esto llego: " << fotografias[i];
                if(model.insertRecord(-1, record)){

                    cout << "<<Insercion exitosa>>" <<endl;
                    model.submitAll();
                } else {

                    cout << "<<Insercion inexitosa>>" <<endl;
                    db.close();
                    return false;
                }
            }
            db.close();
            return exito;
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    bool registrarFotografia(const std::vector<std::string> & fotografias, const int64_t telefono) {
        // Your implementation goes here
        printf("registrarFotografia\n");
    }

    void consultarFotografias(std::vector<std::string> & _return, const int32_t folioUnico_dictamen) {
        // Your implementation goes here
        printf("consultarFotografias\n");
    }

    void consultarFotografia(std::vector<std::string> & _return, const int32_t folioUnico_dictamen) {
        // Your implementation goes here
        printf("consultarFotografia\n");
    }

    void registrarVehiculoReporte(std::string& _return, const Vehiculo& vehiculo){

        QSqlTableModel model;
        if(db.open()){
            model.setTable("vehiculo");
            QSqlRecord record = model.record();
            record.remove(record.indexOf("idvehiculo"));
            record.setValue("ano", vehiculo.ano);
            record.setValue("color", QString::fromStdString(vehiculo.color));
            record.setValue("marca", QString::fromStdString(vehiculo.marca));
            record.setValue("modelo", QString::fromStdString(vehiculo.modelo));
            record.setValue("numPlaca", QString::fromStdString(vehiculo.numPlaca));
            record.setValue("numPoliza", QString::fromStdString(vehiculo.numPoliza));
            record.setValue("nomAseguradora", QString::fromStdString(vehiculo.nomAseguradora));
            record.setValue("estatus", vehiculo.estatus);
            if(model.insertRecord(-1, record)){

                cout << "<<Insercion vehiculo reporte exitosa>>" <<endl;
                model.submitAll();
                db.close();
                _return = vehiculo.numPlaca;
            } else {

                cout << "<<Insercion vehiculo reporte inexitosa>>" <<endl;
                db.close();
                _return = nullptr;
            }
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    void consultarReporte(std::vector<Reporte> & _return, const int64_t telefono) {

        QSqlTableModel model;
        if(db.open()){
            Reporte reporteRecuperado;
            model.setTable("conductor");
            stringstream appendStatement;
            QString statement;
            appendStatement << "telefono = " << std::to_string(telefono);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idconductor = model.record(0).value("idconductor").toInt();

            model.setTable("reporte");
            appendStatement.str("");
            appendStatement << "idconductor = " << std::to_string(idconductor);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            for (int i = 0; i < model.rowCount(); ++i) {

                reporteRecuperado.__set_latitud(model.record(i).value("latitud").toString().toUtf8().constData());
                reporteRecuperado.__set_longitud(model.record(i).value("longitud").toString().toUtf8().constData());
                reporteRecuperado.__set_nombreOtroConduc(model.record(i).value("nombreOtroConduc").toString().toUtf8().constData());
                reporteRecuperado.__set_idconductor1(model.record(i).value("idconductor").toInt());
                reporteRecuperado.__set_folioUnico_dictamen(model.record(i).value("folioUnico_dictamen").toInt());
                _return.push_back(reporteRecuperado);
            }
            db.close();
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    void consultarDictamen(std::vector<Dictamen> & _return, const std::vector<int32_t> & folioUnico) {

        QSqlTableModel model;
        if(db.open()){

            Dictamen dictamenRecuperado;
            model.setTable("dictamen");
            stringstream appendStatement;
            QString statement;
            list <int> :: iterator it;
            for(int i = 0; i < folioUnico.size(); i++){

                appendStatement.str("");
                appendStatement << "folioUnico = " << std::to_string(folioUnico[i]);
                statement = QString::fromStdString(appendStatement.str());
                model.setFilter(statement);
                model.select();
                dictamenRecuperado.__set_folioUnico(model.record(0).value("folioUnico").toInt());
                dictamenRecuperado.__set_fechaHora(model.record(0).value("fechaHora").toDateTime().toString().toUtf8().constData());
                dictamenRecuperado.__set_dictamen(model.record(0).value("dictamen").toString().toUtf8().constData());
                dictamenRecuperado.__set_idReporte(model.record(0).value("idReporte").toInt());
                dictamenRecuperado.__set_idFuncionario(model.record(0).value("idFuncionario").toInt());
                _return.push_back(dictamenRecuperado);
            }
            db.close();
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    void consultarConductorPropio(Conductor& _return, const int64_t telefono) {

        QSqlTableModel model;
        if(db.open()){

            model.setTable("conductor");
            stringstream appendStatement;
            QString statement;
            appendStatement << "telefono = " << std::to_string(telefono);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();

            _return.__set_curp(model.record(0).value("curp").toString().toUtf8().constData());
            _return.__set_fechaNac(model.record(0).value("fechaNac").toDate().toString().toUtf8().constData());
            _return.__set_telefono(model.record(0).value("telefono").toLongLong());
            _return.__set_nombreComp(model.record(0).value("nombreComp").toString().toUtf8().constData());
            _return.__set_numLicencia(model.record(0).value("numLicencia").toLongLong());
            db.close();
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    void recuperarNFuncionario(std::string& _return, const int32_t folioUnico) {

        QSqlTableModel model;
        if(db.open()){

            model.setTable("dictamen");
            stringstream appendStatement;
            QString statement;
            appendStatement << "folioUnico = " << std::to_string(folioUnico);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idfuncionario = model.record(0).value("idfuncionario").toInt();

            model.setTable("funcionario");
            appendStatement.str("");
            appendStatement << "idfuncionario = " << std::to_string(idfuncionario);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            _return = model.record(0).value("nombreComp").toString().toUtf8().constData();
            db.close();
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    void recuperarVehiculoReporte(std::vector<Vehiculo> & _return, const int32_t folioUnico_dictamen) {

        QSqlTableModel model;
        Vehiculo vehiculoRecuperado;
        int idvehiculo;
        if(db.open()){

            model.setTable("reporte");
            stringstream appendStatement;
            QString statement;
            appendStatement << "folioUnico_dictamen = " << std::to_string(folioUnico_dictamen);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idreporte = model.record(0).value("idreporte").toInt();

            model.setTable("vehiculo_reporte");
            appendStatement.str("");
            appendStatement << "idreporte = " << std::to_string(idreporte);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            //for(int i = 0; i < model.rowCount(); i++){

                idvehiculo = model.record(0).value("idvehiculo").toInt();
                int idvehiculo2 = model.record(0).value("idvehiculo2").toInt();
                QSqlTableModel modelVehiculo;
                modelVehiculo.setTable("vehiculo");
                appendStatement.str("");
                appendStatement << "idvehiculo = " << std::to_string(idvehiculo);
                statement = QString::fromStdString(appendStatement.str());
                modelVehiculo.setFilter(statement);
                modelVehiculo.select();

                vehiculoRecuperado.__set_ano(modelVehiculo.record(0).value("ano").toInt());
                vehiculoRecuperado.__set_color(modelVehiculo.record(0).value("color").toString().toUtf8().constData());
                vehiculoRecuperado.__set_marca(modelVehiculo.record(0).value("marca").toString().toUtf8().constData());
                vehiculoRecuperado.__set_modelo(modelVehiculo.record(0).value("modelo").toString().toUtf8().constData());
                vehiculoRecuperado.__set_numPlaca(modelVehiculo.record(0).value("numPlaca").toString().toUtf8().constData());
                vehiculoRecuperado.__set_estatus(modelVehiculo.record(0).value("estatus").toInt());
                vehiculoRecuperado.__set_numPoliza(modelVehiculo.record(0).value("numPaliza").toString().toUtf8().constData());
                vehiculoRecuperado.__set_nomAseguradora(modelVehiculo.record(0).value("nomAseguradora").toString().toUtf8().constData());
                _return.push_back(vehiculoRecuperado);

                appendStatement.str("");
                appendStatement << "idvehiculo = " << std::to_string(idvehiculo2);
                statement = QString::fromStdString(appendStatement.str());
                modelVehiculo.setFilter(statement);
                modelVehiculo.select();
                vehiculoRecuperado.__set_ano(modelVehiculo.record(0).value("ano").toInt());
                vehiculoRecuperado.__set_color(modelVehiculo.record(0).value("color").toString().toUtf8().constData());
                vehiculoRecuperado.__set_marca(modelVehiculo.record(0).value("marca").toString().toUtf8().constData());
                vehiculoRecuperado.__set_modelo(modelVehiculo.record(0).value("modelo").toString().toUtf8().constData());
                vehiculoRecuperado.__set_numPlaca(modelVehiculo.record(0).value("numPlaca").toString().toUtf8().constData());
                vehiculoRecuperado.__set_estatus(modelVehiculo.record(0).value("estatus").toInt());
                vehiculoRecuperado.__set_numPoliza(modelVehiculo.record(0).value("numPaliza").toString().toUtf8().constData());
                vehiculoRecuperado.__set_nomAseguradora(modelVehiculo.record(0).value("nomAseguradora").toString().toUtf8().constData());
                _return.push_back(vehiculoRecuperado);
            //}
            db.close();
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }

    bool asociarVehiculoReporte(const std::vector<std::string> & numPLacas, const int64_t telefono) {

        QSqlTableModel model;
        int idvehiculo;
        bool exito = true;
        if(db.open()){

            model.setTable("conductor");
            stringstream appendStatement;
            QString statement;
            appendStatement << "telefono = " << std::to_string(telefono);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int idconductor = model.record(0).value("idconductor").toInt();
            model.setTable("reporte");
            appendStatement.str("");
            appendStatement << "idconductor = " << std::to_string(idconductor);
            statement = QString::fromStdString(appendStatement.str());
            model.setFilter(statement);
            model.select();
            int cont = 0;
            for(int i = 0; i < model.rowCount(); i++){

                cont++;
            }
            int idreporte = model.record(cont - 1).value("idreporte").toInt();

            //for(int i = 0; i < numPLacas.size(); i++){

                model.setTable("vehiculo");
                appendStatement.str("");
                appendStatement << "numPlaca = " << "'" << numPLacas[0] << "'";
                statement = QString::fromStdString(appendStatement.str());
                model.setFilter(statement);
                model.select();
                idvehiculo = model.record(0).value("idvehiculo").toInt();

                appendStatement.str("");
                appendStatement << "numPlaca = " << "'" << numPLacas[1] << "'";
                statement = QString::fromStdString(appendStatement.str());
                model.setFilter(statement);
                model.select();
                int idvehiculo2 = model.record(0).value("idvehiculo").toInt();

                model.setTable("vehiculo_reporte");
                QSqlRecord record = model.record();
                record.setValue("idvehiculo", idvehiculo);
                record.setValue("idreporte", idreporte);
                record.setValue("idvehiculo2", idvehiculo2);
                if(model.insertRecord(-1, record)){

                    cout << "<<Asociacion vehiculo exitosa>>" <<endl;
                    model.submitAll();
                } else {

                    cout << "<<Asociacion vehiculo inexitosa>>" <<endl;
                    exito = false;
                }
            //}
            db.close();
            return exito;
        } else {

            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            db.close();
            ErrorBD error;
            throw error;
        }
    }
};

int main(int argc, char **argv) {

    int port = 9090;
    cout << "<<El servidor esta corriendo>>" << endl;
    ::apache::thrift::stdcxx::shared_ptr<ApiServidorHandler> handler(new ApiServidorHandler());
    ::apache::thrift::stdcxx::shared_ptr<TProcessor> processor(new ApiServidorProcessor(handler));
    ::apache::thrift::stdcxx::shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
    ::apache::thrift::stdcxx::shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
    ::apache::thrift::stdcxx::shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

    TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);

    server.serve();

    return 0;
}
