/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#include "ApiServidor_types.h"

#include <algorithm>
#include <ostream>

#include <thrift/TToString.h>

namespace Thrift {


Conductor::~Conductor() throw() {
}


void Conductor::__set_curp(const std::string& val) {
  this->curp = val;
}

void Conductor::__set_fechaNac(const std::string& val) {
  this->fechaNac = val;
}

void Conductor::__set_nombreComp(const std::string& val) {
  this->nombreComp = val;
}

void Conductor::__set_numLicencia(const int64_t val) {
  this->numLicencia = val;
}

void Conductor::__set_telefono(const int64_t val) {
  this->telefono = val;
}

void Conductor::__set_estatus(const int32_t val) {
  this->estatus = val;
}

void Conductor::__set_contrasena(const std::string& val) {
  this->contrasena = val;
}
std::ostream& operator<<(std::ostream& out, const Conductor& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t Conductor::read(::apache::thrift::protocol::TProtocol* iprot) {

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
          xfer += iprot->readString(this->curp);
          this->__isset.curp = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->fechaNac);
          this->__isset.fechaNac = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->nombreComp);
          this->__isset.nombreComp = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->numLicencia);
          this->__isset.numLicencia = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_I64) {
          xfer += iprot->readI64(this->telefono);
          this->__isset.telefono = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->estatus);
          this->__isset.estatus = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 7:
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

uint32_t Conductor::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("Conductor");

  xfer += oprot->writeFieldBegin("curp", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->curp);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("fechaNac", ::apache::thrift::protocol::T_STRING, 2);
  xfer += oprot->writeString(this->fechaNac);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("nombreComp", ::apache::thrift::protocol::T_STRING, 3);
  xfer += oprot->writeString(this->nombreComp);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("numLicencia", ::apache::thrift::protocol::T_I64, 4);
  xfer += oprot->writeI64(this->numLicencia);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("telefono", ::apache::thrift::protocol::T_I64, 5);
  xfer += oprot->writeI64(this->telefono);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("estatus", ::apache::thrift::protocol::T_I32, 6);
  xfer += oprot->writeI32(this->estatus);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("contrasena", ::apache::thrift::protocol::T_STRING, 7);
  xfer += oprot->writeString(this->contrasena);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(Conductor &a, Conductor &b) {
  using ::std::swap;
  swap(a.curp, b.curp);
  swap(a.fechaNac, b.fechaNac);
  swap(a.nombreComp, b.nombreComp);
  swap(a.numLicencia, b.numLicencia);
  swap(a.telefono, b.telefono);
  swap(a.estatus, b.estatus);
  swap(a.contrasena, b.contrasena);
  swap(a.__isset, b.__isset);
}

Conductor::Conductor(const Conductor& other0) {
  curp = other0.curp;
  fechaNac = other0.fechaNac;
  nombreComp = other0.nombreComp;
  numLicencia = other0.numLicencia;
  telefono = other0.telefono;
  estatus = other0.estatus;
  contrasena = other0.contrasena;
  __isset = other0.__isset;
}
Conductor& Conductor::operator=(const Conductor& other1) {
  curp = other1.curp;
  fechaNac = other1.fechaNac;
  nombreComp = other1.nombreComp;
  numLicencia = other1.numLicencia;
  telefono = other1.telefono;
  estatus = other1.estatus;
  contrasena = other1.contrasena;
  __isset = other1.__isset;
  return *this;
}
void Conductor::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "Conductor(";
  out << "curp=" << to_string(curp);
  out << ", " << "fechaNac=" << to_string(fechaNac);
  out << ", " << "nombreComp=" << to_string(nombreComp);
  out << ", " << "numLicencia=" << to_string(numLicencia);
  out << ", " << "telefono=" << to_string(telefono);
  out << ", " << "estatus=" << to_string(estatus);
  out << ", " << "contrasena=" << to_string(contrasena);
  out << ")";
}


Vehiculo::~Vehiculo() throw() {
}


void Vehiculo::__set_ano(const int32_t val) {
  this->ano = val;
}

void Vehiculo::__set_color(const std::string& val) {
  this->color = val;
}

void Vehiculo::__set_marca(const std::string& val) {
  this->marca = val;
}

void Vehiculo::__set_modelo(const std::string& val) {
  this->modelo = val;
}

void Vehiculo::__set_nomAseguradora(const std::string& val) {
  this->nomAseguradora = val;
}

void Vehiculo::__set_numPlaca(const std::string& val) {
  this->numPlaca = val;
}

void Vehiculo::__set_numPoliza(const std::string& val) {
  this->numPoliza = val;
}

void Vehiculo::__set_estatus(const int32_t val) {
  this->estatus = val;
}
std::ostream& operator<<(std::ostream& out, const Vehiculo& obj)
{
  obj.printTo(out);
  return out;
}


uint32_t Vehiculo::read(::apache::thrift::protocol::TProtocol* iprot) {

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
          xfer += iprot->readI32(this->ano);
          this->__isset.ano = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->color);
          this->__isset.color = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->marca);
          this->__isset.marca = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->modelo);
          this->__isset.modelo = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->nomAseguradora);
          this->__isset.nomAseguradora = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->numPlaca);
          this->__isset.numPlaca = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 7:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->numPoliza);
          this->__isset.numPoliza = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 8:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->estatus);
          this->__isset.estatus = true;
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

uint32_t Vehiculo::write(::apache::thrift::protocol::TProtocol* oprot) const {
  uint32_t xfer = 0;
  ::apache::thrift::protocol::TOutputRecursionTracker tracker(*oprot);
  xfer += oprot->writeStructBegin("Vehiculo");

  xfer += oprot->writeFieldBegin("ano", ::apache::thrift::protocol::T_I32, 1);
  xfer += oprot->writeI32(this->ano);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("color", ::apache::thrift::protocol::T_STRING, 2);
  xfer += oprot->writeString(this->color);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("marca", ::apache::thrift::protocol::T_STRING, 3);
  xfer += oprot->writeString(this->marca);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("modelo", ::apache::thrift::protocol::T_STRING, 4);
  xfer += oprot->writeString(this->modelo);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("nomAseguradora", ::apache::thrift::protocol::T_STRING, 5);
  xfer += oprot->writeString(this->nomAseguradora);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("numPlaca", ::apache::thrift::protocol::T_STRING, 6);
  xfer += oprot->writeString(this->numPlaca);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("numPoliza", ::apache::thrift::protocol::T_STRING, 7);
  xfer += oprot->writeString(this->numPoliza);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("estatus", ::apache::thrift::protocol::T_I32, 8);
  xfer += oprot->writeI32(this->estatus);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(Vehiculo &a, Vehiculo &b) {
  using ::std::swap;
  swap(a.ano, b.ano);
  swap(a.color, b.color);
  swap(a.marca, b.marca);
  swap(a.modelo, b.modelo);
  swap(a.nomAseguradora, b.nomAseguradora);
  swap(a.numPlaca, b.numPlaca);
  swap(a.numPoliza, b.numPoliza);
  swap(a.estatus, b.estatus);
  swap(a.__isset, b.__isset);
}

Vehiculo::Vehiculo(const Vehiculo& other2) {
  ano = other2.ano;
  color = other2.color;
  marca = other2.marca;
  modelo = other2.modelo;
  nomAseguradora = other2.nomAseguradora;
  numPlaca = other2.numPlaca;
  numPoliza = other2.numPoliza;
  estatus = other2.estatus;
  __isset = other2.__isset;
}
Vehiculo& Vehiculo::operator=(const Vehiculo& other3) {
  ano = other3.ano;
  color = other3.color;
  marca = other3.marca;
  modelo = other3.modelo;
  nomAseguradora = other3.nomAseguradora;
  numPlaca = other3.numPlaca;
  numPoliza = other3.numPoliza;
  estatus = other3.estatus;
  __isset = other3.__isset;
  return *this;
}
void Vehiculo::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "Vehiculo(";
  out << "ano=" << to_string(ano);
  out << ", " << "color=" << to_string(color);
  out << ", " << "marca=" << to_string(marca);
  out << ", " << "modelo=" << to_string(modelo);
  out << ", " << "nomAseguradora=" << to_string(nomAseguradora);
  out << ", " << "numPlaca=" << to_string(numPlaca);
  out << ", " << "numPoliza=" << to_string(numPoliza);
  out << ", " << "estatus=" << to_string(estatus);
  out << ")";
}


Reporte::~Reporte() throw() {
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

void Reporte::__set_idconductor1(const int32_t val) {
  this->idconductor1 = val;
}

void Reporte::__set_folioUnico_dictamen(const int32_t val) {
  this->folioUnico_dictamen = val;
}

void Reporte::__set_idFuncionario(const int32_t val) {
  this->idFuncionario = val;
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
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->latitud);
          this->__isset.latitud = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->longitud);
          this->__isset.longitud = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->nombreOtroConduc);
          this->__isset.nombreOtroConduc = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->idconductor1);
          this->__isset.idconductor1 = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->folioUnico_dictamen);
          this->__isset.folioUnico_dictamen = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 6:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->idFuncionario);
          this->__isset.idFuncionario = true;
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

  xfer += oprot->writeFieldBegin("latitud", ::apache::thrift::protocol::T_STRING, 1);
  xfer += oprot->writeString(this->latitud);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("longitud", ::apache::thrift::protocol::T_STRING, 2);
  xfer += oprot->writeString(this->longitud);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("nombreOtroConduc", ::apache::thrift::protocol::T_STRING, 3);
  xfer += oprot->writeString(this->nombreOtroConduc);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("idconductor1", ::apache::thrift::protocol::T_I32, 4);
  xfer += oprot->writeI32(this->idconductor1);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("folioUnico_dictamen", ::apache::thrift::protocol::T_I32, 5);
  xfer += oprot->writeI32(this->folioUnico_dictamen);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("idFuncionario", ::apache::thrift::protocol::T_I32, 6);
  xfer += oprot->writeI32(this->idFuncionario);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(Reporte &a, Reporte &b) {
  using ::std::swap;
  swap(a.latitud, b.latitud);
  swap(a.longitud, b.longitud);
  swap(a.nombreOtroConduc, b.nombreOtroConduc);
  swap(a.idconductor1, b.idconductor1);
  swap(a.folioUnico_dictamen, b.folioUnico_dictamen);
  swap(a.idFuncionario, b.idFuncionario);
  swap(a.__isset, b.__isset);
}

Reporte::Reporte(const Reporte& other4) {
  latitud = other4.latitud;
  longitud = other4.longitud;
  nombreOtroConduc = other4.nombreOtroConduc;
  idconductor1 = other4.idconductor1;
  folioUnico_dictamen = other4.folioUnico_dictamen;
  idFuncionario = other4.idFuncionario;
  __isset = other4.__isset;
}
Reporte& Reporte::operator=(const Reporte& other5) {
  latitud = other5.latitud;
  longitud = other5.longitud;
  nombreOtroConduc = other5.nombreOtroConduc;
  idconductor1 = other5.idconductor1;
  folioUnico_dictamen = other5.folioUnico_dictamen;
  idFuncionario = other5.idFuncionario;
  __isset = other5.__isset;
  return *this;
}
void Reporte::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "Reporte(";
  out << "latitud=" << to_string(latitud);
  out << ", " << "longitud=" << to_string(longitud);
  out << ", " << "nombreOtroConduc=" << to_string(nombreOtroConduc);
  out << ", " << "idconductor1=" << to_string(idconductor1);
  out << ", " << "folioUnico_dictamen=" << to_string(folioUnico_dictamen);
  out << ", " << "idFuncionario=" << to_string(idFuncionario);
  out << ")";
}


Dictamen::~Dictamen() throw() {
}


void Dictamen::__set_folioUnico(const int32_t val) {
  this->folioUnico = val;
}

void Dictamen::__set_dictamen(const std::string& val) {
  this->dictamen = val;
}

void Dictamen::__set_fechaHora(const std::string& val) {
  this->fechaHora = val;
}

void Dictamen::__set_idFuncionario(const int32_t val) {
  this->idFuncionario = val;
}

void Dictamen::__set_idReporte(const int32_t val) {
  this->idReporte = val;
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
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->folioUnico);
          this->__isset.folioUnico = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 2:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->dictamen);
          this->__isset.dictamen = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 3:
        if (ftype == ::apache::thrift::protocol::T_STRING) {
          xfer += iprot->readString(this->fechaHora);
          this->__isset.fechaHora = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 4:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->idFuncionario);
          this->__isset.idFuncionario = true;
        } else {
          xfer += iprot->skip(ftype);
        }
        break;
      case 5:
        if (ftype == ::apache::thrift::protocol::T_I32) {
          xfer += iprot->readI32(this->idReporte);
          this->__isset.idReporte = true;
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

  xfer += oprot->writeFieldBegin("folioUnico", ::apache::thrift::protocol::T_I32, 1);
  xfer += oprot->writeI32(this->folioUnico);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("dictamen", ::apache::thrift::protocol::T_STRING, 2);
  xfer += oprot->writeString(this->dictamen);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("fechaHora", ::apache::thrift::protocol::T_STRING, 3);
  xfer += oprot->writeString(this->fechaHora);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("idFuncionario", ::apache::thrift::protocol::T_I32, 4);
  xfer += oprot->writeI32(this->idFuncionario);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldBegin("idReporte", ::apache::thrift::protocol::T_I32, 5);
  xfer += oprot->writeI32(this->idReporte);
  xfer += oprot->writeFieldEnd();

  xfer += oprot->writeFieldStop();
  xfer += oprot->writeStructEnd();
  return xfer;
}

void swap(Dictamen &a, Dictamen &b) {
  using ::std::swap;
  swap(a.folioUnico, b.folioUnico);
  swap(a.dictamen, b.dictamen);
  swap(a.fechaHora, b.fechaHora);
  swap(a.idFuncionario, b.idFuncionario);
  swap(a.idReporte, b.idReporte);
  swap(a.__isset, b.__isset);
}

Dictamen::Dictamen(const Dictamen& other6) {
  folioUnico = other6.folioUnico;
  dictamen = other6.dictamen;
  fechaHora = other6.fechaHora;
  idFuncionario = other6.idFuncionario;
  idReporte = other6.idReporte;
  __isset = other6.__isset;
}
Dictamen& Dictamen::operator=(const Dictamen& other7) {
  folioUnico = other7.folioUnico;
  dictamen = other7.dictamen;
  fechaHora = other7.fechaHora;
  idFuncionario = other7.idFuncionario;
  idReporte = other7.idReporte;
  __isset = other7.__isset;
  return *this;
}
void Dictamen::printTo(std::ostream& out) const {
  using ::apache::thrift::to_string;
  out << "Dictamen(";
  out << "folioUnico=" << to_string(folioUnico);
  out << ", " << "dictamen=" << to_string(dictamen);
  out << ", " << "fechaHora=" << to_string(fechaHora);
  out << ", " << "idFuncionario=" << to_string(idFuncionario);
  out << ", " << "idReporte=" << to_string(idReporte);
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

ErrorBD::ErrorBD(const ErrorBD& other8) : TException() {
  problema = other8.problema;
  codigoError = other8.codigoError;
  __isset = other8.__isset;
}
ErrorBD& ErrorBD::operator=(const ErrorBD& other9) {
  problema = other9.problema;
  codigoError = other9.codigoError;
  __isset = other9.__isset;
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

} // namespace