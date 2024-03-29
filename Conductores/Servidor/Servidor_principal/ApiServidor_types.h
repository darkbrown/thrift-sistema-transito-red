/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef ApiServidor_TYPES_H
#define ApiServidor_TYPES_H

#include <iosfwd>

#include <thrift/Thrift.h>
#include <thrift/TApplicationException.h>
#include <thrift/TBase.h>
#include <thrift/protocol/TProtocol.h>
#include <thrift/transport/TTransport.h>

#include <thrift/stdcxx.h>


namespace Thrift {

class Conductor;

class Vehiculo;

class Reporte;

class Dictamen;

class ErrorBD;

typedef struct _Conductor__isset {
  _Conductor__isset() : curp(false), fechaNac(false), nombreComp(false), numLicencia(false), telefono(false), estatus(false), contrasena(false) {}
  bool curp :1;
  bool fechaNac :1;
  bool nombreComp :1;
  bool numLicencia :1;
  bool telefono :1;
  bool estatus :1;
  bool contrasena :1;
} _Conductor__isset;

class Conductor : public virtual ::apache::thrift::TBase {
 public:

  Conductor(const Conductor&);
  Conductor& operator=(const Conductor&);
  Conductor() : curp(), fechaNac(), nombreComp(), numLicencia(0), telefono(0), estatus(0), contrasena() {
  }

  virtual ~Conductor() throw();
  std::string curp;
  std::string fechaNac;
  std::string nombreComp;
  int64_t numLicencia;
  int64_t telefono;
  int32_t estatus;
  std::string contrasena;

  _Conductor__isset __isset;

  void __set_curp(const std::string& val);

  void __set_fechaNac(const std::string& val);

  void __set_nombreComp(const std::string& val);

  void __set_numLicencia(const int64_t val);

  void __set_telefono(const int64_t val);

  void __set_estatus(const int32_t val);

  void __set_contrasena(const std::string& val);

  bool operator == (const Conductor & rhs) const
  {
    if (!(curp == rhs.curp))
      return false;
    if (!(fechaNac == rhs.fechaNac))
      return false;
    if (!(nombreComp == rhs.nombreComp))
      return false;
    if (!(numLicencia == rhs.numLicencia))
      return false;
    if (!(telefono == rhs.telefono))
      return false;
    if (!(estatus == rhs.estatus))
      return false;
    if (!(contrasena == rhs.contrasena))
      return false;
    return true;
  }
  bool operator != (const Conductor &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Conductor & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(Conductor &a, Conductor &b);

std::ostream& operator<<(std::ostream& out, const Conductor& obj);

typedef struct _Vehiculo__isset {
  _Vehiculo__isset() : ano(false), color(false), marca(false), modelo(false), nomAseguradora(false), numPlaca(false), numPoliza(false), estatus(false) {}
  bool ano :1;
  bool color :1;
  bool marca :1;
  bool modelo :1;
  bool nomAseguradora :1;
  bool numPlaca :1;
  bool numPoliza :1;
  bool estatus :1;
} _Vehiculo__isset;

class Vehiculo : public virtual ::apache::thrift::TBase {
 public:

  Vehiculo(const Vehiculo&);
  Vehiculo& operator=(const Vehiculo&);
  Vehiculo() : ano(0), color(), marca(), modelo(), nomAseguradora(), numPlaca(), numPoliza(), estatus(0) {
  }

  virtual ~Vehiculo() throw();
  int32_t ano;
  std::string color;
  std::string marca;
  std::string modelo;
  std::string nomAseguradora;
  std::string numPlaca;
  std::string numPoliza;
  int32_t estatus;

  _Vehiculo__isset __isset;

  void __set_ano(const int32_t val);

  void __set_color(const std::string& val);

  void __set_marca(const std::string& val);

  void __set_modelo(const std::string& val);

  void __set_nomAseguradora(const std::string& val);

  void __set_numPlaca(const std::string& val);

  void __set_numPoliza(const std::string& val);

  void __set_estatus(const int32_t val);

  bool operator == (const Vehiculo & rhs) const
  {
    if (!(ano == rhs.ano))
      return false;
    if (!(color == rhs.color))
      return false;
    if (!(marca == rhs.marca))
      return false;
    if (!(modelo == rhs.modelo))
      return false;
    if (!(nomAseguradora == rhs.nomAseguradora))
      return false;
    if (!(numPlaca == rhs.numPlaca))
      return false;
    if (!(numPoliza == rhs.numPoliza))
      return false;
    if (!(estatus == rhs.estatus))
      return false;
    return true;
  }
  bool operator != (const Vehiculo &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Vehiculo & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(Vehiculo &a, Vehiculo &b);

std::ostream& operator<<(std::ostream& out, const Vehiculo& obj);

typedef struct _Reporte__isset {
  _Reporte__isset() : latitud(false), longitud(false), nombreOtroConduc(false), idconductor1(false), folioUnico_dictamen(false), idFuncionario(false) {}
  bool latitud :1;
  bool longitud :1;
  bool nombreOtroConduc :1;
  bool idconductor1 :1;
  bool folioUnico_dictamen :1;
  bool idFuncionario :1;
} _Reporte__isset;

class Reporte : public virtual ::apache::thrift::TBase {
 public:

  Reporte(const Reporte&);
  Reporte& operator=(const Reporte&);
  Reporte() : latitud(), longitud(), nombreOtroConduc(), idconductor1(0), folioUnico_dictamen(0), idFuncionario(0) {
  }

  virtual ~Reporte() throw();
  std::string latitud;
  std::string longitud;
  std::string nombreOtroConduc;
  int32_t idconductor1;
  int32_t folioUnico_dictamen;
  int32_t idFuncionario;

  _Reporte__isset __isset;

  void __set_latitud(const std::string& val);

  void __set_longitud(const std::string& val);

  void __set_nombreOtroConduc(const std::string& val);

  void __set_idconductor1(const int32_t val);

  void __set_folioUnico_dictamen(const int32_t val);

  void __set_idFuncionario(const int32_t val);

  bool operator == (const Reporte & rhs) const
  {
    if (!(latitud == rhs.latitud))
      return false;
    if (!(longitud == rhs.longitud))
      return false;
    if (!(nombreOtroConduc == rhs.nombreOtroConduc))
      return false;
    if (!(idconductor1 == rhs.idconductor1))
      return false;
    if (!(folioUnico_dictamen == rhs.folioUnico_dictamen))
      return false;
    if (!(idFuncionario == rhs.idFuncionario))
      return false;
    return true;
  }
  bool operator != (const Reporte &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Reporte & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(Reporte &a, Reporte &b);

std::ostream& operator<<(std::ostream& out, const Reporte& obj);

typedef struct _Dictamen__isset {
  _Dictamen__isset() : folioUnico(false), dictamen(false), fechaHora(false), idFuncionario(false), idReporte(false) {}
  bool folioUnico :1;
  bool dictamen :1;
  bool fechaHora :1;
  bool idFuncionario :1;
  bool idReporte :1;
} _Dictamen__isset;

class Dictamen : public virtual ::apache::thrift::TBase {
 public:

  Dictamen(const Dictamen&);
  Dictamen& operator=(const Dictamen&);
  Dictamen() : folioUnico(0), dictamen(), fechaHora(), idFuncionario(0), idReporte(0) {
  }

  virtual ~Dictamen() throw();
  int32_t folioUnico;
  std::string dictamen;
  std::string fechaHora;
  int32_t idFuncionario;
  int32_t idReporte;

  _Dictamen__isset __isset;

  void __set_folioUnico(const int32_t val);

  void __set_dictamen(const std::string& val);

  void __set_fechaHora(const std::string& val);

  void __set_idFuncionario(const int32_t val);

  void __set_idReporte(const int32_t val);

  bool operator == (const Dictamen & rhs) const
  {
    if (!(folioUnico == rhs.folioUnico))
      return false;
    if (!(dictamen == rhs.dictamen))
      return false;
    if (!(fechaHora == rhs.fechaHora))
      return false;
    if (!(idFuncionario == rhs.idFuncionario))
      return false;
    if (!(idReporte == rhs.idReporte))
      return false;
    return true;
  }
  bool operator != (const Dictamen &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const Dictamen & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
};

void swap(Dictamen &a, Dictamen &b);

std::ostream& operator<<(std::ostream& out, const Dictamen& obj);

typedef struct _ErrorBD__isset {
  _ErrorBD__isset() : problema(true), codigoError(true) {}
  bool problema :1;
  bool codigoError :1;
} _ErrorBD__isset;

class ErrorBD : public ::apache::thrift::TException {
 public:

  ErrorBD(const ErrorBD&);
  ErrorBD& operator=(const ErrorBD&);
  ErrorBD() : problema("Error de conexion"), codigoError(500) {
  }

  virtual ~ErrorBD() throw();
  std::string problema;
  int16_t codigoError;

  _ErrorBD__isset __isset;

  void __set_problema(const std::string& val);

  void __set_codigoError(const int16_t val);

  bool operator == (const ErrorBD & rhs) const
  {
    if (!(problema == rhs.problema))
      return false;
    if (!(codigoError == rhs.codigoError))
      return false;
    return true;
  }
  bool operator != (const ErrorBD &rhs) const {
    return !(*this == rhs);
  }

  bool operator < (const ErrorBD & ) const;

  uint32_t read(::apache::thrift::protocol::TProtocol* iprot);
  uint32_t write(::apache::thrift::protocol::TProtocol* oprot) const;

  virtual void printTo(std::ostream& out) const;
  mutable std::string thriftTExceptionMessageHolder_;
  const char* what() const throw();
};

void swap(ErrorBD &a, ErrorBD &b);

std::ostream& operator<<(std::ostream& out, const ErrorBD& obj);

} // namespace

#endif
