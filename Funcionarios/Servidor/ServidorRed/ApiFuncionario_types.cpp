/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#include "ApiFuncionario_types.h"

#include <algorithm>
#include <ostream>

#include <thrift/TToString.h>

namespace Thrift {


Funcionario::~Funcionario() throw() {
}


void Funcionario::__set_nombre(const std::string& val) {
  this->nombre = val;
}

void Funcionario::__set_estatus(const int32_t val) {
  this->estatus = val;
}

void Funcionario::__set_cargo(const std::string& val) {
  this->cargo = val;
}

void Funcionario::__set_usuario(const std::string& val) {
  this->usuario = val;
}

void Funcionario::__set_contrasena(const std::string& val) {
  this->contrasena = val;
}
std::ostream& operator<<(std::ostream& out, const Funcionario& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t Funcionario::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->nombre);
          this->__isset.nombre = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->estatus);
          this->__isset.estatus = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->cargo);
          this->__isset.cargo = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->usuario);
          this->__isset.usuario = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->contrasena);
          this->__isset.contrasena = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t Funcionario::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("Funcionario");

  xfer += oprot->writeFieldBegin("nombre", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->nombre);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("estatus", ::apache::thrift::protocol::T_I32, 3);
  xfer += oprot->writeI32(this->estatus);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("cargo", ::apache::thrift::protocol::T_STRING, 4);
  xfer += oprot->writeString(this->cargo);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("usuario", ::apache::thrift::protocol::T_STRING, 5);
  xfer += oprot->writeString(this->usuario);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("contrasena", ::apache::thrift::protocol::T_STRING, 6);
  xfer += oprot->writeString(this->contrasena);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(Funcionario &a, Funcionario &b) {
  using ::std::swap;
  swap(a.nombre, b.nombre);
  swap(a.estatus, b.estatus);
  swap(a.cargo, b.cargo);
  swap(a.usuario, b.usuario);
  swap(a.contrasena, b.contrasena);
  swap(a.__isset, b.__isset);
}

Funcionario::Funcionario(const Funcionario& other0) {
  nombre = other0.nombre;
  estatus = other0.estatus;
  cargo = other0.cargo;
  usuario = other0.usuario;
  contrasena = other0.contrasena;
  __isset = other0.__isset;
}
Funcionario& Funcionario::operator=(const Funcionario& other1) {
  nombre = other1.nombre;
  estatus = other1.estatus;
  cargo = other1.cargo;
  usuario = other1.usuario;
  contrasena = other1.contrasena;
  __isset = other1.__isset;
  return *this;
}
void Funcionario::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "Funcionario(";
  out << "nombre=" << to_string(nombre);
  out << ", " << "estatus=" << to_string(estatus);
  out << ", " << "cargo=" << to_string(cargo);
  out << ", " << "usuario=" << to_string(usuario);
  out << ", " << "contrasena=" << to_string(contrasena);
  out << ")";
}


Reporte::~Reporte() throw() {
}


void Reporte::__set_idreporte(const int32_t val) {
  this->idreporte = val;
}

void Reporte::__set_latitud(const std::string& val) {
  this->latitud = val;
}

void Reporte::__set_longitud(const std::string& val) {
  this->longitud = val;
}

void Reporte::__set_nombreOtroConduc(const std::string& val) {
  this->nombreOtroConduc = val;
}

void Reporte::__set_idconductor(const int32_t val) {
  this->idconductor = val;
}

void Reporte::__set_folioUnico_dictamen(const int32_t val) {
  this->folioUnico_dictamen = val;
}

void Reporte::__set_idFuncionario(const int32_t val) {
  this->idFuncionario = val;
}

void Reporte::__set_nombreConductor(const std::string& val) {
  this->nombreConductor = val;
}

void Reporte::__set_dictamen(const int32_t val) {
  this->dictamen = val;
}

void Reporte::__set_fecha(const std::string& val) {
  this->fecha = val;
}
std::ostream& operator<<(std::ostream& out, const Reporte& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t Reporte::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->idreporte);
          this->__isset.idreporte = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->latitud);
          this->__isset.latitud = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->longitud);
          this->__isset.longitud = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->nombreOtroConduc);
          this->__isset.nombreOtroConduc = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->idconductor);
          this->__isset.idconductor = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->folioUnico_dictamen);
          this->__isset.folioUnico_dictamen = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 7:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->idFuncionario);
          this->__isset.idFuncionario = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 8:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->nombreConductor);
          this->__isset.nombreConductor = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 9:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->dictamen);
          this->__isset.dictamen = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 10:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->fecha);
          this->__isset.fecha = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t Reporte::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("Reporte");

  xfer += oprot->writeFieldBegin("idreporte", ::apache::thrift::protocol::T_I32, 1);
  xfer += oprot->writeI32(this->idreporte);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("latitud", ::apache::thrift::protocol::T_STRING, 2);
  xfer += oprot->writeString(this->latitud);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("longitud", ::apache::thrift::protocol::T_STRING, 3);
  xfer += oprot->writeString(this->longitud);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("nombreOtroConduc", ::apache::thrift::protocol::T_STRING, 4);
  xfer += oprot->writeString(this->nombreOtroConduc);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("idconductor", ::apache::thrift::protocol::T_I32, 5);
  xfer += oprot->writeI32(this->idconductor);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("folioUnico_dictamen", ::apache::thrift::protocol::T_I32, 6);
  xfer += oprot->writeI32(this->folioUnico_dictamen);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("idFuncionario", ::apache::thrift::protocol::T_I32, 7);
  xfer += oprot->writeI32(this->idFuncionario);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("nombreConductor", ::apache::thrift::protocol::T_STRING, 8);
  xfer += oprot->writeString(this->nombreConductor);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("dictamen", ::apache::thrift::protocol::T_I32, 9);
  xfer += oprot->writeI32(this->dictamen);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("fecha", ::apache::thrift::protocol::T_STRING, 10);
  xfer += oprot->writeString(this->fecha);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(Reporte &a, Reporte &b) {
  using ::std::swap;
  swap(a.idreporte, b.idreporte);
  swap(a.latitud, b.latitud);
  swap(a.longitud, b.longitud);
  swap(a.nombreOtroConduc, b.nombreOtroConduc);
  swap(a.idconductor, b.idconductor);
  swap(a.folioUnico_dictamen, b.folioUnico_dictamen);
  swap(a.idFuncionario, b.idFuncionario);
  swap(a.nombreConductor, b.nombreConductor);
  swap(a.dictamen, b.dictamen);
  swap(a.fecha, b.fecha);
  swap(a.__isset, b.__isset);
}

Reporte::Reporte(const Reporte& other2) {
  idreporte = other2.idreporte;
  latitud = other2.latitud;
  longitud = other2.longitud;
  nombreOtroConduc = other2.nombreOtroConduc;
  idconductor = other2.idconductor;
  folioUnico_dictamen = other2.folioUnico_dictamen;
  idFuncionario = other2.idFuncionario;
  nombreConductor = other2.nombreConductor;
  dictamen = other2.dictamen;
  fecha = other2.fecha;
  __isset = other2.__isset;
}
Reporte& Reporte::operator=(const Reporte& other3) {
  idreporte = other3.idreporte;
  latitud = other3.latitud;
  longitud = other3.longitud;
  nombreOtroConduc = other3.nombreOtroConduc;
  idconductor = other3.idconductor;
  folioUnico_dictamen = other3.folioUnico_dictamen;
  idFuncionario = other3.idFuncionario;
  nombreConductor = other3.nombreConductor;
  dictamen = other3.dictamen;
  fecha = other3.fecha;
  __isset = other3.__isset;
  return *this;
}
void Reporte::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "Reporte(";
  out << "idreporte=" << to_string(idreporte);
  out << ", " << "latitud=" << to_string(latitud);
  out << ", " << "longitud=" << to_string(longitud);
  out << ", " << "nombreOtroConduc=" << to_string(nombreOtroConduc);
  out << ", " << "idconductor=" << to_string(idconductor);
  out << ", " << "folioUnico_dictamen=" << to_string(folioUnico_dictamen);
  out << ", " << "idFuncionario=" << to_string(idFuncionario);
  out << ", " << "nombreConductor=" << to_string(nombreConductor);
  out << ", " << "dictamen=" << to_string(dictamen);
  out << ", " << "fecha=" << to_string(fecha);
  out << ")";
}


Dictamen::~Dictamen() throw() {
}


void Dictamen::__set_dictamen(const std::string& val) {
  this->dictamen = val;
}

void Dictamen::__set_fecha(const std::string& val) {
  this->fecha = val;
}

void Dictamen::__set_idfuncionario(const int32_t val) {
  this->idfuncionario = val;
}

void Dictamen::__set_idreporte(const int32_t val) {
  this->idreporte = val;
}

void Dictamen::__set_folioUnico(const int32_t val) {
  this->folioUnico = val;
}
std::ostream& operator<<(std::ostream& out, const Dictamen& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t Dictamen::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->dictamen);
          this->__isset.dictamen = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->fecha);
          this->__isset.fecha = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->idfuncionario);
          this->__isset.idfuncionario = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->idreporte);
          this->__isset.idreporte = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->folioUnico);
          this->__isset.folioUnico = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t Dictamen::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("Dictamen");

  xfer += oprot->writeFieldBegin("dictamen", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->dictamen);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("fecha", ::apache::thrift::protocol::T_STRING, 2);
  xfer += oprot->writeString(this->fecha);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("idfuncionario", ::apache::thrift::protocol::T_I32, 3);
  xfer += oprot->writeI32(this->idfuncionario);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("idreporte", ::apache::thrift::protocol::T_I32, 4);
  xfer += oprot->writeI32(this->idreporte);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("folioUnico", ::apache::thrift::protocol::T_I32, 5);
  xfer += oprot->writeI32(this->folioUnico);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(Dictamen &a, Dictamen &b) {
  using ::std::swap;
  swap(a.dictamen, b.dictamen);
  swap(a.fecha, b.fecha);
  swap(a.idfuncionario, b.idfuncionario);
  swap(a.idreporte, b.idreporte);
  swap(a.folioUnico, b.folioUnico);
  swap(a.__isset, b.__isset);
}

Dictamen::Dictamen(const Dictamen& other4) {
  dictamen = other4.dictamen;
  fecha = other4.fecha;
  idfuncionario = other4.idfuncionario;
  idreporte = other4.idreporte;
  folioUnico = other4.folioUnico;
  __isset = other4.__isset;
}
Dictamen& Dictamen::operator=(const Dictamen& other5) {
  dictamen = other5.dictamen;
  fecha = other5.fecha;
  idfuncionario = other5.idfuncionario;
  idreporte = other5.idreporte;
  folioUnico = other5.folioUnico;
  __isset = other5.__isset;
  return *this;
}
void Dictamen::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "Dictamen(";
  out << "dictamen=" << to_string(dictamen);
  out << ", " << "fecha=" << to_string(fecha);
  out << ", " << "idfuncionario=" << to_string(idfuncionario);
  out << ", " << "idreporte=" << to_string(idreporte);
  out << ", " << "folioUnico=" << to_string(folioUnico);
  out << ")";
}


ErrorBD::~ErrorBD() throw() {
}


void ErrorBD::__set_problema(const std::string& val) {
  this->problema = val;
}

void ErrorBD::__set_codigoError(const int16_t val) {
  this->codigoError = val;
}
std::ostream& operator<<(std::ostream& out, const ErrorBD& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t ErrorBD::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->problema);
          this->__isset.problema = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_I16) {
          xfer += iprot->readI16(this->codigoError);
          this->__isset.codigoError = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t ErrorBD::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("ErrorBD");

  xfer += oprot->writeFieldBegin("problema", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->problema);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("codigoError", ::apache::thrift::protocol::T_I16, 2);
  xfer += oprot->writeI16(this->codigoError);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(ErrorBD &a, ErrorBD &b) {
  using ::std::swap;
  swap(a.problema, b.problema);
  swap(a.codigoError, b.codigoError);
  swap(a.__isset, b.__isset);
}

ErrorBD::ErrorBD(const ErrorBD& other6) : TException() {
  problema = other6.problema;
  codigoError = other6.codigoError;
  __isset = other6.__isset;
}
ErrorBD& ErrorBD::operator=(const ErrorBD& other7) {
  problema = other7.problema;
  codigoError = other7.codigoError;
  __isset = other7.__isset;
  return *this;
}
void ErrorBD::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "ErrorBD(";
  out << "problema=" << to_string(problema);
  out << ", " << "codigoError=" << to_string(codigoError);
  out << ")";
}

const char* ErrorBD::what() const throw() {
  try {
    std::stringstream ss;
    ss << "TException - service has thrown: " << *this;
    this->thriftTExceptionMessageHolder_ = ss.str();
    return this->thriftTExceptionMessageHolder_.c_str();
  } catch (const std::exception&) {
    return "TException - service has thrown: ErrorBD";
  }
}


VehiculosReporte::~VehiculosReporte() throw() {
}


void VehiculosReporte::__set_placaVehiculo1(const std::string& val) {
  this->placaVehiculo1 = val;
}

void VehiculosReporte::__set_placaVehiculo2(const std::string& val) {
  this->placaVehiculo2 = val;
}
std::ostream& operator<<(std::ostream& out, const VehiculosReporte& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t VehiculosReporte::read(::apache::thrift::protocol::TProtocol* iprot) {

  ::apache::thrift::protocol::TInputRecursionTracker tracker(*iprot);
  uint32_t xfer = 0;
  std::string fname;
  ::apache::thrift::protocol::TType ftype;
  int16_t fid;

  xfer += iprot->readStructBegin(fname);

  using ::apache::thrift::protocol::TProtocolException;


  while (true)
  {
    xfer += iprot->readFieldBegin(fname, ftype, fid);
    if (ftype == ::apache::thrift::protocol::T_STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->placaVehiculo1);
          this->__isset.placaVehiculo1 = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->placaVehiculo2);
          this->__isset.placaVehiculo2 = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      default:
        xfer += iprot->skip(ftype);
        break;
    }
    xfer += iprot->readFieldEnd();
  }

  xfer += iprot->readStructEnd();

  return xfer;
}

uint32_t VehiculosReporte::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("VehiculosReporte");

  xfer += oprot->writeFieldBegin("placaVehiculo1", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->placaVehiculo1);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("placaVehiculo2", ::apache::thrift::protocol::T_STRING, 2);
  xfer += oprot->writeString(this->placaVehiculo2);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(VehiculosReporte &a, VehiculosReporte &b) {
  using ::std::swap;
  swap(a.placaVehiculo1, b.placaVehiculo1);
  swap(a.placaVehiculo2, b.placaVehiculo2);
  swap(a.__isset, b.__isset);
}

VehiculosReporte::VehiculosReporte(const VehiculosReporte& other8) {
  placaVehiculo1 = other8.placaVehiculo1;
  placaVehiculo2 = other8.placaVehiculo2;
  __isset = other8.__isset;
}
VehiculosReporte& VehiculosReporte::operator=(const VehiculosReporte& other9) {
  placaVehiculo1 = other9.placaVehiculo1;
  placaVehiculo2 = other9.placaVehiculo2;
  __isset = other9.__isset;
  return *this;
}
void VehiculosReporte::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "VehiculosReporte(";
  out << "placaVehiculo1=" << to_string(placaVehiculo1);
  out << ", " << "placaVehiculo2=" << to_string(placaVehiculo2);
  out << ")";
}

} // namespace
