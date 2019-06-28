#include "ApiFuncionario_types.h"
#include "estructuras.cpp"
#include <QSqlDatabase>
#include <QDebug>
#include <iostream>
#include <QSqlTableModel>
#include <QSqlQuery>
#include <QtSql/QSqlRecord>
#include <QDateTime>
#include <QSqlError>

using namespace std;
using namespace ::Thrift;


class ConexionesDB{

    QSqlDatabase db;

public:
    ConexionesDB(){
        this->db = QSqlDatabase::addDatabase("QMYSQL");
        db.setHostName("192.168.43.195");
        db.setDatabaseName("sistema_transito");
        db.setPort(3306);
        db.setUserName("administrador");
        db.setPassword("admi-S1s");
    }

    QSqlDatabase abrirConexion(){
        this->db.open();
        qDebug() << "Conexion db abierta";
        return db;
    }

    void cerrarConexion(){
        this->db.close();
        qDebug() << "Conexion db cerrada";
    }

    /*FUNCIONARIO*/

    IntR getIdFuncionario(QString usuario){

        IntR respuesta;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("funcionario");
        model.setFilter("usuario = '" + usuario +"'");
        model.select();
            respuesta.estatus = 0;
            respuesta.respuesta = model.record(0).value("idfuncionario").toInt();
            cerrarConexion();
            return respuesta;
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            cerrarConexion();
            return respuesta;
        }

    }

    FuncionarioR getFuncionario(QString usuario){
        FuncionarioR respuesta;
        Funcionario funcionario;

        QSqlTableModel model;
        if (db.open()){
        model.setTable("funcionario");
        model.setFilter("usuario = '" + usuario + "'");
        model.select();
            if(model.rowCount() > 0){
                QString nombre = model.record(0).value("nombreComp").toString();
                int estatus = model.record(0).value("estatus").toInt();
                QString contrasena = model.record(0).value("contrasena").toString();
                QString cargo = model.record(0).value("cargo").toString();

                funcionario.__set_nombre(nombre.toStdString());
                funcionario.__set_cargo(cargo.toStdString());
                funcionario.__set_usuario(usuario.toStdString());
                funcionario.__set_estatus(estatus);
                funcionario.__set_contrasena(contrasena.toStdString());

                respuesta.funcionario = funcionario;
                respuesta.estatus = 0;
                cerrarConexion();
                return respuesta;
            }else{
                respuesta.estatus = 0;
                cerrarConexion();
                return respuesta;
            }
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }

     }

    ListaFuncionarioR getFuncionarios(){
        Funcionario funcionario;
        ListaFuncionarioR respuesta;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("funcionario");
        model.select();
            respuesta.estatus = 0;
            for (int i=0; i < model.rowCount() ;i++) {
                QString nombre = model.record(i).value("nombreComp").toString();
                int estatus = model.record(i).value("estatus").toInt();
                QString cargo = model.record(i).value("cargo").toString();
                QString usuario = model.record(i).value("usuario").toString();

                funcionario.__set_nombre(nombre.toStdString());
                funcionario.__set_cargo(cargo.toStdString());
                funcionario.__set_estatus(estatus);
                funcionario.__set_usuario(usuario.toStdString());
                respuesta.funcionarios.push_back(funcionario);
            }
            cerrarConexion();
            return respuesta;
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            cerrarConexion();
            return respuesta;
        }
    }

    BoolR cambiarEstatusFuncionario(QString usuario){
        BoolR respuesta;
        QSqlTableModel model;
        model.setTable("funcionario");
        if (db.open()){
        model.setFilter("usuario = '" + usuario + "'");
        model.select();
            respuesta.estatus = 0;
            QSqlRecord record = model.record(0);
            int estatus = record.value("estatus").toInt();
            if(estatus == 1){
                estatus = 0;
            }else if (estatus == 0) {
                estatus = 1;
            }else{
                respuesta.respuesta = false;
                cerrarConexion();
                return respuesta;
            }
            record.setValue("estatus", estatus);
            if(model.setRecord(0, record)){
                model.submitAll();
                respuesta.respuesta = true;
                cerrarConexion();
                return respuesta;
            }else{
                respuesta.respuesta = false;
                cerrarConexion();
                return respuesta;
            }
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }

    }


    BoolR cambiarContrasena(QString usuario, QString contrasena){
        BoolR respuesta;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("funcionario");
        model.setFilter("usuario = '" + usuario + "'");
        model.select();
            respuesta.estatus = 0;
            QSqlRecord record = model.record(0);
            record.setValue("contrasena", contrasena);
            if(model.setRecord(0, record)){
                model.submitAll();
                respuesta.respuesta = true;
                cerrarConexion();
                return respuesta;
            }else{
                respuesta.respuesta = false;
                cerrarConexion();
                return respuesta;
            }
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }

    }

    /*PERITO*/



    BoolR registrarPerito(Funcionario perito){
        BoolR respuesta;

        QSqlTableModel model;
        if (db.open()){
        model.setTable("funcionario");
        QSqlRecord record = model.record();
        record.remove(record.indexOf("idfuncionario"));
        record.setValue("cargo", QString::fromStdString(perito.cargo));
        record.setValue("contrasena", QString::fromStdString(perito.contrasena));
        record.setValue("nombreComp", QString::fromStdString(perito.nombre));
        record.setValue("estatus", perito.estatus);
        record.setValue("usuario", QString::fromStdString(perito.usuario));

        bool resultadoInsert = model.insertRecord(-1, record);

            respuesta.estatus = 0;
            if(resultadoInsert){
                model.submitAll();
                respuesta.respuesta = true;
                cerrarConexion();
                return respuesta;
            }else{
                respuesta.respuesta = false;
                cerrarConexion();
                return respuesta;
            }
        }else{
            //qDebug() << "Imprimiendo el error";
            //qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }



    }

    ListaFuncionarioR getPeritos(){
        Funcionario funcionario;
        ListaFuncionarioR respuesta;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("funcionario");
        model.setFilter("cargo = 'PERITO'");
        model.select();
            respuesta.estatus = 0;
            for (int i=0; i < model.rowCount() ;i++) {
                QString nombre = model.record(i).value("nombreComp").toString();
                int estatus = model.record(i).value("estatus").toInt();
                QString cargo = model.record(i).value("cargo").toString();
                QString usuario = model.record(i).value("usuario").toString();

                funcionario.__set_nombre(nombre.toStdString());
                funcionario.__set_cargo(cargo.toStdString());
                funcionario.__set_estatus(estatus);
                funcionario.__set_usuario(usuario.toStdString());
                respuesta.funcionarios.push_back(funcionario);
            }
            cerrarConexion();
            return respuesta;
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }
    }

    BoolR verificarReporteSinAsignar(int idReporte){
        BoolR respuesta;
        QSqlTableModel model;
        if (db.open()){
            model.setTable("reporte");
            model.setFilter("idreporte = " + QString::number(idReporte));
            model.setFilter("idfuncionario IS NULL");
            model.select();

            if(model.rowCount() > 0){
                respuesta.respuesta = true;
                respuesta.estatus = 0;
                return respuesta;
            }else{
                respuesta.estatus = 0;
                respuesta.respuesta = false;
                return respuesta;
            }
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }
    }




    ListaVehiculoReporteR getVehiculosReporteSinAsignar(){
        VehiculoReporteR vehiculoReporte;
        ListaVehiculoReporteR listaVehiculoReporte;

        QSqlTableModel model;
        if (db.open()){
            model.setTable("vehiculo_reporte");
            model.select();

            for (int i=0; i < model.rowCount() ;i++) {

                int idReporte = model.record(i).value("idreporte").toInt();
                if(verificarReporteSinAsignar(idReporte).respuesta){
                    int vehiculo1 = model.record(i).value("idvehiculo").toInt();
                    int vehiculo2 = model.record(i).value("idvehiculo2").toInt();

                    vehiculoReporte.vehiculo1 = vehiculo1;
                    vehiculoReporte.vehiculo2 = vehiculo2;
                    vehiculoReporte.idreporte = idReporte;
                    vehiculoReporte.estatus = 0;
                    listaVehiculoReporte.vehiculoReportes.push_back(vehiculoReporte);
                }
            }

            listaVehiculoReporte.estatus = 0;

            cerrarConexion();
            return listaVehiculoReporte;
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            listaVehiculoReporte.estatus = 1;
            cerrarConexion();
            return listaVehiculoReporte;
        }
    }

    VehiculoR getPlacaAuto(int idVehiculo){
        VehiculoR vehiculo;
        QSqlTableModel model;
        if (db.open()){
            model.setTable("vehiculo");
            model.setFilter("idvehiculo = " + QString::number(idVehiculo));
            model.select();
            QString placa = model.record(0).value("numPlaca").toString();
            vehiculo.estatus = 0;
            vehiculo.placa = placa;
            return vehiculo;
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            vehiculo.estatus = 1;
            cerrarConexion();
            return vehiculo;
        }
    }

     ListaVehiculosMatriculasR getPlacasAfectados(){
        VehiculoReporteMatriculasR vehiculo;
        ListaVehiculosMatriculasR listaVehiculos;
        ListaVehiculoReporteR resultado = getVehiculosReporteSinAsignar();
        if(resultado.estatus == 0){
            for (int i=0; i < resultado.vehiculoReportes.size();i++) {
                QString placaVehiculo1 = getPlacaAuto(resultado.vehiculoReportes.at(i).vehiculo1).placa;
                QString placaVehiculo2 = getPlacaAuto(resultado.vehiculoReportes.at(i).vehiculo2).placa;
                int idreporte = resultado.vehiculoReportes.at(i).idreporte;

                vehiculo.idreporte = idreporte;
                vehiculo.placa1 = placaVehiculo1;
                vehiculo.placa2 = placaVehiculo2;
                listaVehiculos.vehiculos.push_back(vehiculo);
            }
            cerrarConexion();
            listaVehiculos.estatus = 0;
            return listaVehiculos;
        }else{
            vehiculo.estatus = 1;
            cerrarConexion();
            return listaVehiculos;
        }
    }



    BoolR modificarPerito(Funcionario peritoAnterior, Funcionario peritoNuevo){
        BoolR respuesta;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("funcionario");
        model.setFilter("usuario = '" + QString::fromStdString(peritoAnterior.usuario) + "'");
        model.select();

            respuesta.estatus = 0;
            QSqlRecord record = model.record(0);
            QString usuario = record.value("usuario").toString();
            QString nombre = record.value("nombreComp").toString();
            bool mismosDatos = false;


            if(usuario != QString::fromStdString(peritoNuevo.usuario)){
                record.setValue("usuario", QString::fromStdString(peritoNuevo.usuario));
            }else{
                mismosDatos = true;
            }

            if(nombre != QString::fromStdString(peritoNuevo.nombre)){
                record.setValue("nombreComp", QString::fromStdString(peritoNuevo.nombre));
            }



            if(model.setRecord(0, record)){
                model.submitAll();
                 cerrarConexion();
                respuesta.respuesta = true;
                return respuesta;
            }else if(mismosDatos){
                respuesta.respuesta = true;
                  cerrarConexion();
                return respuesta;
            }else{
                  cerrarConexion();
                respuesta.respuesta = false;
                return respuesta;
            }
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }



    }



    /*Reportes*/

    ListaReportesR getReportesPendientes(){
        Reporte reporte;
        ListaReportesR respuesta;
        QSqlTableModel model;
        cerrarConexion();
        if (db.open()){
        model.setTable("reporte");
        model.setFilter("idfuncionario IS NULL");
        model.select();
            respuesta.estatus = 0;
            for (int i=0; i < model.rowCount() ;i++) {
                QString latitud = model.record(i).value("latitud").toString();
                QString longitud = model.record(i).value("longitud").toString();
                QString nombreOtroConduc = model.record(i).value("nombreOtroConduc").toString();
                int idconductor = model.record(i).value("idconductor").toInt();
                int idreporte = model.record(i).value("idreporte").toInt();
                QSqlTableModel modelConductor;
                modelConductor.setTable("conductor");
                modelConductor.setFilter("idconductor = " + QString::number(idconductor));
                modelConductor.select();
                    QString nombreConductor = modelConductor.record(0).value("nombreComp").toString();
                    reporte.idreporte = idreporte;
                    reporte.latitud = latitud.toStdString();
                    reporte.longitud = longitud.toStdString();
                    reporte.nombreOtroConduc = nombreOtroConduc.toStdString();
                    reporte.nombreConductor = nombreConductor.toStdString();
                    respuesta.reportes.push_back(reporte);
            }
            cerrarConexion();
            return respuesta;
        }else{
            //qDebug() << "Imprimiendo el error";
            //qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }
    }

    BoolR asignarReportePerito(int idPerito, int idReporte){
        BoolR respuesta;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("reporte");
        model.setFilter("idreporte = " + QString::number(idReporte));
        model.select();
            respuesta.estatus = 0;
            QSqlRecord record = model.record(0);
            record.setValue("idFuncionario", QString::number(idPerito));
            if(model.setRecord(0, record)){
                model.submitAll();
                respuesta.respuesta = true;
                cerrarConexion();
                return respuesta;
            }else{
                respuesta.respuesta = false;
                cerrarConexion();
                return respuesta;
            }
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }



    }




    ListaReportesR getReportesAsignados(int idPerito){
        Reporte reporte;
        ListaReportesR respuesta;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("reporte");
        model.setFilter("idfuncionario = " + QString::number(idPerito));
        model.select();
            respuesta.estatus = 0;
            for (int i=0; i < model.rowCount() ;i++) {

                QString latitud = model.record(i).value("latitud").toString();
                QString longitud = model.record(i).value("longitud").toString();
                QString nombreOtroConduc = model.record(i).value("nombreOtroConduc").toString();
                int idconductor = model.record(i).value("idconductor").toInt();
                int idreporte = model.record(i).value("idreporte").toInt();
                int folioUnico_dictamen = model.record(i).value("folioUnico_dictamen").toInt();

                cerrarConexion();
                QSqlTableModel modelConductor;
                if (db.open()){
                modelConductor.setTable("conductor");
                modelConductor.setFilter("idconductor = " + QString::number(idconductor));
                modelConductor.select();


                    QString nombreConductor = modelConductor.record(0).value("nombreComp").toString();

                    reporte.idreporte = idreporte;
                    reporte.latitud = latitud.toStdString();
                    reporte.longitud = longitud.toStdString();
                    reporte.nombreOtroConduc = nombreOtroConduc.toStdString();
                    reporte.nombreConductor = nombreConductor.toStdString();
                    reporte.dictamen = folioUnico_dictamen;
                     respuesta.reportes.push_back(reporte);

                }else{
                    qDebug() << "Imprimiendo el error";
                    qDebug() << model.lastError();
                    respuesta.estatus = 1;
                    cerrarConexion();
                    return respuesta;
                }
            }
            cerrarConexion();
            return respuesta;
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }
    }


    ReporteR getReporte(int idReporte){
        ReporteR respuesta;
        Reporte reporte;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("reporte");
        model.setFilter("idreporte = " + QString::number(idReporte));
        model.select();

            respuesta.estatus = 0;

            QString latitud = model.record(0).value("latitud").toString();
            QString longitud = model.record(0).value("longitud").toString();
            QString nombreOtroConduc = model.record(0).value("nombreOtroConduc").toString();
            int idconductor = model.record(0).value("idconductor").toInt();
            int idreporte = model.record(0).value("idreporte").toInt();
            int folioUnico_dictamen = model.record(0).value("folioUnico_dictamen").toInt();
            cerrarConexion();
            QString nombreConductor;
            QSqlTableModel modelConductor;
            if (db.open()){
            modelConductor.setTable("conductor");
            modelConductor.setFilter("idconductor = " + QString::number(idconductor));
            modelConductor.select();
            cerrarConexion();
                nombreConductor = modelConductor.record(0).value("nombreComp").toString();
            }else{
                qDebug() << "Imprimiendo el error";
                qDebug() << model.lastError();
                respuesta.estatus = 1;
                cerrarConexion();
                return respuesta;
            }

            reporte.idreporte = idreporte;
            reporte.latitud = latitud.toStdString();
            reporte.longitud = longitud.toStdString();
            reporte.nombreOtroConduc = nombreOtroConduc.toStdString();
            reporte.nombreConductor = nombreConductor.toStdString();
            reporte.dictamen = folioUnico_dictamen;

            respuesta.reporte = reporte;
            return respuesta;
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }

    }

    /*DICTAMEN*/

    BoolR registrarDictamen(Dictamen dictamen){
        BoolR respuesta;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("dictamen");
        QSqlRecord record = model.record();
        record.remove(record.indexOf("folioUnico"));
        record.setValue("dictamen", QString::fromStdString(dictamen.dictamen));
        record.setValue("idfuncionario", dictamen.idfuncionario);
        record.setValue("idReporte", dictamen.idreporte);
        record.setValue("fechaHora", QDateTime::currentDateTime());
        bool insertRespuesta = model.insertRecord(-1, record);
            respuesta.estatus = 0;
            if(insertRespuesta){
                model.submitAll();
                QString idInsertado = getUltimoDictamen();
                cerrarConexion();
                //Actualizar el reporte
                QSqlTableModel modelReporte;
                if (db.open()){
                modelReporte.setTable("reporte");
                modelReporte.setFilter("idreporte = " + QString::number(dictamen.idreporte));
                modelReporte.select();
                    QSqlRecord record2 = modelReporte.record(0);
                    record2.setValue("folioUnico_dictamen", idInsertado);
                    if(modelReporte.setRecord(0, record2)){
                        modelReporte.submitAll();
                        respuesta.respuesta = true;
                        cerrarConexion();
                        return respuesta;
                    }else{
                        respuesta.respuesta = false;
                        cerrarConexion();
                        return respuesta;
                    }
                }else{
                    respuesta.respuesta = false;
                    cerrarConexion();
                    return respuesta;
                }
            }else{
                qDebug() << "Imprimiendo el error";
                qDebug() << model.lastError();
                respuesta.estatus = 1;
                return respuesta;
            }
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }



    }

    QString getUltimoDictamen(){
         abrirConexion();
         QSqlQuery query("SELECT * FROM dictamen ORDER BY folioUnico DESC LIMIT 1");
         query.exec();
         query.next();
         QString id = query.value(0).toString();
         cerrarConexion();
         return id;
    }




    DictamenR getDictamen(int idReporte){
        DictamenR respuesta;
        Dictamen dictamen;
        QSqlTableModel model;
        if (db.open()){
        model.setTable("dictamen");
        model.setFilter("idreporte = " + QString::number(idReporte));
        model.select();
            respuesta.estatus = 0;
            int folioUnico = model.record(0).value("folioUnico").toInt();
            QString dictamenTexto = model.record(0).value("dictamen").toString();
            QString fechaHora = model.record(0).value("fechaHora").toDateTime().toString().toUtf8().constData();
            int idfuncionario = model.record(0).value("idfuncionario").toInt();
            int idreporte = model.record(0).value("idreporte").toInt();

            dictamen.folioUnico = folioUnico;
            dictamen.dictamen = dictamenTexto.toStdString();
            dictamen.fecha = fechaHora.toStdString();
            dictamen.idfuncionario = idfuncionario;
            dictamen.idreporte = idreporte;

            respuesta.dictamen = dictamen;
            cerrarConexion();
            return respuesta;
        }else{
            qDebug() << "Imprimiendo el error";
            qDebug() << model.lastError();
            respuesta.estatus = 1;
            return respuesta;
        }

    }



};
