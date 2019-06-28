namespace java Thrift
namespace cpp Thrift

struct Conductor{
  1: string curp,
  2: string fechaNac,
  3: string nombreComp,
  4: i64 numLicencia,
  5: i64 telefono,
  6: i32 estatus,
  7: string contrasena
}

struct Vehiculo{
  1: i32 ano,
  2: string color,
  3: string marca,
  4: string modelo,
  5: string nomAseguradora,
  6: string numPlaca,
  7: string numPoliza,
  8: i32 estatus
}

struct Reporte{
  1: string latitud,
  2: string longitud,
  3: string nombreOtroConduc,
  4: i32 idconductor1,
  5: i32 folioUnico_dictamen,
  6: i32 idFuncionario
}

struct Dictamen{
  1: i32 folioUnico,
  2: string dictamen,
  3: string fechaHora,
  4: i32 idFuncionario,
  5: i32 idReporte
}

exception ErrorBD{
  1: string problema = "Error de conexion",
  2: i16 codigoError = 500
}

service ApiServidor {
 bool confirmarConductor(1: i64 telefono, 2: string contrasena) throws(1: ErrorBD ebd),
 bool registrarConductor(1: Conductor conductor) throws(1: ErrorBD ebd),
 bool registrarVehiculo(1: Vehiculo vehiculo, 2: i64 telefono) throws(1: ErrorBD ebd),
 bool modificarVehiculo(1: Vehiculo vehiculo, 2: string numPLacaAnt) throws(1: ErrorBD ebd),
 bool deshabilitarVehiculo(1: string numPlaca) throws(1: ErrorBD ebd),
 list<Vehiculo> consultarVehiculoPropio(1: i64 telefono) throws(1: ErrorBD ebd),
 Vehiculo consultarVehiculoInfo(1: string numPlaca) throws(1: ErrorBD ebd),
 bool registrarReporte(1: Reporte reporte, 2: i64 telefono) throws(1: ErrorBD ebd),
 bool registrarFotografia(1: list<string> fotografias, 2: i64 telefono) throws(1: ErrorBD ebd),
 list<string> consultarFotografia(1: i32 folioUnico_dictamen) throws(1: ErrorBD ebd),
 string registrarVehiculoReporte(1: Vehiculo vehiculo) throws(1: ErrorBD ebd),
 list<Reporte> consultarReporte(1: i64 telefono) throws(1: ErrorBD ebd),
 list<Dictamen> consultarDictamen(1: list<i32> folioUnico) throws(1: ErrorBD ebd),
 Conductor consultarConductorPropio(1: i64 telefono) throws(1: ErrorBD ebd),
 string recuperarNFuncionario(1: i32 folioUnico) throws(1: ErrorBD ebd),
 list<Vehiculo> recuperarVehiculoReporte(1: i32 folioUnico_dictamen) throws(1: ErrorBD ebd),
 bool asociarVehiculoReporte(1: list<string> numPLacas, 2: i64 telefono) throws(1: ErrorBD ebd)
}
