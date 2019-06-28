#include <iostream>
#include <stdlib.h>
#include "ApiFuncionario.h"
#include "ConexionesDB.cpp"
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>
#include <cstring>
#include <QDebug>
#include <QString>


using namespace ::apache::thrift;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::server;
using namespace std;

using boost::shared_ptr;

using namespace  ::Thrift;

class ApiFuncionarioHandler : virtual public ApiFuncionarioIf {
    ConexionesDB conexiones;
public:
    ApiFuncionarioHandler() {
        qDebug() << "Servidor iniciado";
}

  bool verificarFuncionario(const std::string& usuario, const std::string& contrasena) {
      FuncionarioR resultado = conexiones.getFuncionario(QString::fromStdString(usuario));
      if(resultado.estatus == 0){
          if(resultado.funcionario.contrasena == contrasena){
              return true;
          }else{
              return false;
          }
      }else{
          ErrorBD error;
          throw error;
      }
  }

  void getFuncionario(Funcionario& _return, const std::string& usuario) {
      FuncionarioR resultado = conexiones.getFuncionario(QString::fromStdString(usuario));
      if(resultado.estatus == 0){
          _return = resultado.funcionario;
      }else{
          ErrorBD error;
          throw error;
      }
  }

  void getFuncionarios(std::vector<Funcionario> & _return) {
      ListaFuncionarioR resultado = conexiones.getFuncionarios();
      if(resultado.estatus == 0){
          _return = resultado.funcionarios;
      }else{
          ErrorBD error;
          throw error;
      }
  }

  bool cambiarEstatusFuncionario(const std::string& usuario) {
     BoolR resultado = conexiones.cambiarEstatusFuncionario(QString::fromStdString(usuario));
     if(resultado.estatus == 0){
         return resultado.respuesta;
     }else{
         ErrorBD error;
         throw error;
     }
  }

  bool modificarPerito(const Funcionario& peritoAnterior, const Funcionario& peritoNuevo) {

      BoolR resultado = conexiones.modificarPerito(peritoAnterior, peritoNuevo);
      if(resultado.estatus == 0){
          return resultado.respuesta;
      }else{
          ErrorBD error;
          throw error;
      }
  }

  bool cambiarContrasenaPerito(const std::string& usuario, const std::string& contrasena) {
    BoolR resultado = conexiones.cambiarContrasena(QString::fromStdString(usuario), QString::fromStdString(contrasena));
    if(resultado.estatus == 0){
        return resultado.respuesta;
    }else{
        ErrorBD error;
        throw error;
    }
  }

  bool registrarPerito(const Funcionario& perito) {
      BoolR resultado = conexiones.registrarPerito(perito);
      if(resultado.estatus == 0){
          return resultado.respuesta;
      }else{
          ErrorBD error;
          throw error;
      }
  }

  void getPerito(Funcionario& _return, const std::string& usuario) {
      FuncionarioR resultado = conexiones.getFuncionario(QString::fromStdString(usuario));
      if(resultado.estatus == 0){
          _return = resultado.funcionario;
      }else{
          ErrorBD error;
          throw error;
      }
  }

  void getPeritos(std::vector<Funcionario> & _return) {
      ListaFuncionarioR resultado = conexiones.getPeritos();
      if(resultado.estatus == 0){
          _return = resultado.funcionarios;
      }else{
          ErrorBD error;
          throw error;
      }
  }

  int32_t getIdPerito(const std::string& usuario) {
    IntR resultado = conexiones.getIdFuncionario(QString::fromStdString(usuario));
    if(resultado.estatus == 0){
        return resultado.respuesta;
    }else{
        ErrorBD error;
        throw error;
    }
  }

  void getReportesPendientes(std::vector<Reporte> & _return) {
      ListaReportesR resultado = conexiones.getReportesPendientes();
      if(resultado.estatus == 0){
          _return = resultado.reportes;
      }else{
          ErrorBD error;
          throw error;
      }

  }

  void getReportesAsignados(std::vector<Reporte> & _return, const int32_t idPerito) {
      ListaReportesR resultado = conexiones.getReportesAsignados(idPerito);
      if(resultado.estatus == 0){
          _return = resultado.reportes;
      }else{
          ErrorBD error;
          throw error;
      }
  }

  bool asignarReportePerito(const int32_t idPerito, const int32_t idReporte) {
      BoolR resultado = conexiones.asignarReportePerito(idPerito, idReporte);
      if(resultado.estatus == 0){
          return resultado.respuesta;
      }else{
          ErrorBD error;
          throw error;
      }
  }

  void getReporte(Reporte& _return, const int32_t idReporte) {
      ReporteR resultado = conexiones.getReporte(idReporte);
      if(resultado.estatus == 0){
          _return = resultado.reporte;
      }else{
          ErrorBD error;
          throw error;
      }

  }

  bool levantarDictamen(const Dictamen& dictamen) {
      BoolR resultado = conexiones.registrarDictamen(dictamen);
      if(resultado.estatus == 0){
          return resultado.respuesta;
      }else{
          ErrorBD error;
          throw error;
      }
  }

  void getDictamen(Dictamen& _return, const int32_t idReporte) {
    DictamenR resultado = conexiones.getDictamen(idReporte);
    if(resultado.estatus == 0){
        _return = resultado.dictamen;
    }else{
        ErrorBD error;
        throw error;
    }
  }

  void getPlacasVehiculosReporte(std::vector<VehiculosReporte> & _return) {
    ListaVehiculosMatriculasR resultado = conexiones.getPlacasAfectados();
    if(resultado.estatus == 0){
        vector<VehiculosReporte> listaVehiculos;
        VehiculosReporte vehiculo;
        for (int i= 0; i < resultado.vehiculos.size(); i++) {
            vehiculo.__set_placaVehiculo1(resultado.vehiculos.at(i).placa1.toStdString());
            vehiculo.__set_placaVehiculo2(resultado.vehiculos.at(i).placa2.toStdString());
            listaVehiculos.push_back(vehiculo);
        }
        _return = listaVehiculos;

    }else{
        ErrorBD error;
        throw error;
    }
  }

  bool cargarImagenes(const std::vector<std::string> & listaImagenes, const int32_t idreporte) {
    qDebug() << "Listaimagenes: " << listaImagenes.size();
  }

  void getImagenes(std::vector<std::string> & _return, const int32_t idreporte) {
    // Your implementation goes here
    printf("getImagenes\n");
  }

};

int main(int argc, char **argv) {
  int port = 9090;
  ::apache::thrift::stdcxx::shared_ptr<ApiFuncionarioHandler> handler(new ApiFuncionarioHandler());
  ::apache::thrift::stdcxx::shared_ptr<TProcessor> processor(new ApiFuncionarioProcessor(handler));
  ::apache::thrift::stdcxx::shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
  ::apache::thrift::stdcxx::shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
  ::apache::thrift::stdcxx::shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

  TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);
  server.serve();
  return 0;
}

