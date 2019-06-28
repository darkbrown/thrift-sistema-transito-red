// This autogenerated skeleton file illustrates how to build a server.
/* You should copy it to another filename to avoid overwriting it.

#include "ApiFuncionario.h"
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>

using namespace ::apache::thrift;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::server;

using namespace  ::Thrift;

class ApiFuncionarioHandler : virtual public ApiFuncionarioIf {
 public:
  ApiFuncionarioHandler() {
    // Your initialization goes here
  }

  bool verificarFuncionario(const std::string& usuario, const std::string& contrasena) {
    // Your implementation goes here
    printf("verificarFuncionario\n");
  }

  void getFuncionario(Funcionario& _return, const std::string& usuario) {
    // Your implementation goes here
    printf("getFuncionario\n");
  }

  void getFuncionarios(std::vector<Funcionario> & _return) {
    // Your implementation goes here
    printf("getFuncionarios\n");
  }

  bool cambiarEstatusFuncionario(const std::string& usuario) {
    // Your implementation goes here
    printf("cambiarEstatusFuncionario\n");
  }

  bool modificarPerito(const Funcionario& peritoAnterior, const Funcionario& peritoNuevo) {
    // Your implementation goes here
    printf("modificarPerito\n");
  }

  bool cambiarContrasenaPerito(const std::string& usuario, const std::string& contrasena) {
    // Your implementation goes here
    printf("cambiarContrasenaPerito\n");
  }

  bool registrarPerito(const Funcionario& perito) {
    // Your implementation goes here
    printf("registrarPerito\n");
  }

  void getPerito(Funcionario& _return, const std::string& usuario) {
    // Your implementation goes here
    printf("getPerito\n");
  }

  void getPeritos(std::vector<Funcionario> & _return) {
    // Your implementation goes here
    printf("getPeritos\n");
  }

  int32_t getIdPerito(const std::string& usuario) {
    // Your implementation goes here
    printf("getIdPerito\n");
  }

  void getReportesPendientes(std::vector<Reporte> & _return) {
    // Your implementation goes here
    printf("getReportesPendientes\n");
  }

  void getReportesAsignados(std::vector<Reporte> & _return, const int32_t idPerito) {
    // Your implementation goes here
    printf("getReportesAsignados\n");
  }

  bool asignarReportePerito(const int32_t idPerito, const int32_t idReporte) {
    // Your implementation goes here
    printf("asignarReportePerito\n");
  }

  void getReporte(Reporte& _return, const int32_t idReporte) {
    // Your implementation goes here
    printf("getReporte\n");
  }

  bool levantarDictamen(const Dictamen& dictamen) {
    // Your implementation goes here
    printf("levantarDictamen\n");
  }

  void getDictamen(Dictamen& _return, const int32_t idReporte) {
    // Your implementation goes here
    printf("getDictamen\n");
  }

  void getPlacasVehiculosReporte(std::vector<VehiculosReporte> & _return) {
    // Your implementation goes here
    printf("getPlacasVehiculosReporte\n");
  }

  bool cargarImagenes(const std::vector<std::string> & listaImagenes, const int32_t idreporte) {
    // Your implementation goes here
    printf("cargarImagenes\n");
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
}*/
