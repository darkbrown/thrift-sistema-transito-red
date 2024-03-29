/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package Thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-06-28")
public class Funcionario implements org.apache.thrift.TBase<Funcionario, Funcionario._Fields>, java.io.Serializable, Cloneable, Comparable<Funcionario> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Funcionario");

  private static final org.apache.thrift.protocol.TField NOMBRE_FIELD_DESC = new org.apache.thrift.protocol.TField("nombre", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ESTATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("estatus", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField CARGO_FIELD_DESC = new org.apache.thrift.protocol.TField("cargo", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField USUARIO_FIELD_DESC = new org.apache.thrift.protocol.TField("usuario", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField CONTRASENA_FIELD_DESC = new org.apache.thrift.protocol.TField("contrasena", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FuncionarioStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FuncionarioTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String nombre; // required
  public int estatus; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String cargo; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String usuario; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String contrasena; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NOMBRE((short)1, "nombre"),
    ESTATUS((short)3, "estatus"),
    CARGO((short)4, "cargo"),
    USUARIO((short)5, "usuario"),
    CONTRASENA((short)6, "contrasena");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NOMBRE
          return NOMBRE;
        case 3: // ESTATUS
          return ESTATUS;
        case 4: // CARGO
          return CARGO;
        case 5: // USUARIO
          return USUARIO;
        case 6: // CONTRASENA
          return CONTRASENA;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ESTATUS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NOMBRE, new org.apache.thrift.meta_data.FieldMetaData("nombre", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ESTATUS, new org.apache.thrift.meta_data.FieldMetaData("estatus", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CARGO, new org.apache.thrift.meta_data.FieldMetaData("cargo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USUARIO, new org.apache.thrift.meta_data.FieldMetaData("usuario", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CONTRASENA, new org.apache.thrift.meta_data.FieldMetaData("contrasena", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Funcionario.class, metaDataMap);
  }

  public Funcionario() {
  }

  public Funcionario(
    java.lang.String nombre,
    int estatus,
    java.lang.String cargo,
    java.lang.String usuario,
    java.lang.String contrasena)
  {
    this();
    this.nombre = nombre;
    this.estatus = estatus;
    setEstatusIsSet(true);
    this.cargo = cargo;
    this.usuario = usuario;
    this.contrasena = contrasena;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Funcionario(Funcionario other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetNombre()) {
      this.nombre = other.nombre;
    }
    this.estatus = other.estatus;
    if (other.isSetCargo()) {
      this.cargo = other.cargo;
    }
    if (other.isSetUsuario()) {
      this.usuario = other.usuario;
    }
    if (other.isSetContrasena()) {
      this.contrasena = other.contrasena;
    }
  }

  public Funcionario deepCopy() {
    return new Funcionario(this);
  }

  @Override
  public void clear() {
    this.nombre = null;
    setEstatusIsSet(false);
    this.estatus = 0;
    this.cargo = null;
    this.usuario = null;
    this.contrasena = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getNombre() {
    return this.nombre;
  }

  public Funcionario setNombre(@org.apache.thrift.annotation.Nullable java.lang.String nombre) {
    this.nombre = nombre;
    return this;
  }

  public void unsetNombre() {
    this.nombre = null;
  }

  /** Returns true if field nombre is set (has been assigned a value) and false otherwise */
  public boolean isSetNombre() {
    return this.nombre != null;
  }

  public void setNombreIsSet(boolean value) {
    if (!value) {
      this.nombre = null;
    }
  }

  public int getEstatus() {
    return this.estatus;
  }

  public Funcionario setEstatus(int estatus) {
    this.estatus = estatus;
    setEstatusIsSet(true);
    return this;
  }

  public void unsetEstatus() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ESTATUS_ISSET_ID);
  }

  /** Returns true if field estatus is set (has been assigned a value) and false otherwise */
  public boolean isSetEstatus() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ESTATUS_ISSET_ID);
  }

  public void setEstatusIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ESTATUS_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getCargo() {
    return this.cargo;
  }

  public Funcionario setCargo(@org.apache.thrift.annotation.Nullable java.lang.String cargo) {
    this.cargo = cargo;
    return this;
  }

  public void unsetCargo() {
    this.cargo = null;
  }

  /** Returns true if field cargo is set (has been assigned a value) and false otherwise */
  public boolean isSetCargo() {
    return this.cargo != null;
  }

  public void setCargoIsSet(boolean value) {
    if (!value) {
      this.cargo = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getUsuario() {
    return this.usuario;
  }

  public Funcionario setUsuario(@org.apache.thrift.annotation.Nullable java.lang.String usuario) {
    this.usuario = usuario;
    return this;
  }

  public void unsetUsuario() {
    this.usuario = null;
  }

  /** Returns true if field usuario is set (has been assigned a value) and false otherwise */
  public boolean isSetUsuario() {
    return this.usuario != null;
  }

  public void setUsuarioIsSet(boolean value) {
    if (!value) {
      this.usuario = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getContrasena() {
    return this.contrasena;
  }

  public Funcionario setContrasena(@org.apache.thrift.annotation.Nullable java.lang.String contrasena) {
    this.contrasena = contrasena;
    return this;
  }

  public void unsetContrasena() {
    this.contrasena = null;
  }

  /** Returns true if field contrasena is set (has been assigned a value) and false otherwise */
  public boolean isSetContrasena() {
    return this.contrasena != null;
  }

  public void setContrasenaIsSet(boolean value) {
    if (!value) {
      this.contrasena = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case NOMBRE:
      if (value == null) {
        unsetNombre();
      } else {
        setNombre((java.lang.String)value);
      }
      break;

    case ESTATUS:
      if (value == null) {
        unsetEstatus();
      } else {
        setEstatus((java.lang.Integer)value);
      }
      break;

    case CARGO:
      if (value == null) {
        unsetCargo();
      } else {
        setCargo((java.lang.String)value);
      }
      break;

    case USUARIO:
      if (value == null) {
        unsetUsuario();
      } else {
        setUsuario((java.lang.String)value);
      }
      break;

    case CONTRASENA:
      if (value == null) {
        unsetContrasena();
      } else {
        setContrasena((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NOMBRE:
      return getNombre();

    case ESTATUS:
      return getEstatus();

    case CARGO:
      return getCargo();

    case USUARIO:
      return getUsuario();

    case CONTRASENA:
      return getContrasena();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NOMBRE:
      return isSetNombre();
    case ESTATUS:
      return isSetEstatus();
    case CARGO:
      return isSetCargo();
    case USUARIO:
      return isSetUsuario();
    case CONTRASENA:
      return isSetContrasena();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Funcionario)
      return this.equals((Funcionario)that);
    return false;
  }

  public boolean equals(Funcionario that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_nombre = true && this.isSetNombre();
    boolean that_present_nombre = true && that.isSetNombre();
    if (this_present_nombre || that_present_nombre) {
      if (!(this_present_nombre && that_present_nombre))
        return false;
      if (!this.nombre.equals(that.nombre))
        return false;
    }

    boolean this_present_estatus = true;
    boolean that_present_estatus = true;
    if (this_present_estatus || that_present_estatus) {
      if (!(this_present_estatus && that_present_estatus))
        return false;
      if (this.estatus != that.estatus)
        return false;
    }

    boolean this_present_cargo = true && this.isSetCargo();
    boolean that_present_cargo = true && that.isSetCargo();
    if (this_present_cargo || that_present_cargo) {
      if (!(this_present_cargo && that_present_cargo))
        return false;
      if (!this.cargo.equals(that.cargo))
        return false;
    }

    boolean this_present_usuario = true && this.isSetUsuario();
    boolean that_present_usuario = true && that.isSetUsuario();
    if (this_present_usuario || that_present_usuario) {
      if (!(this_present_usuario && that_present_usuario))
        return false;
      if (!this.usuario.equals(that.usuario))
        return false;
    }

    boolean this_present_contrasena = true && this.isSetContrasena();
    boolean that_present_contrasena = true && that.isSetContrasena();
    if (this_present_contrasena || that_present_contrasena) {
      if (!(this_present_contrasena && that_present_contrasena))
        return false;
      if (!this.contrasena.equals(that.contrasena))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetNombre()) ? 131071 : 524287);
    if (isSetNombre())
      hashCode = hashCode * 8191 + nombre.hashCode();

    hashCode = hashCode * 8191 + estatus;

    hashCode = hashCode * 8191 + ((isSetCargo()) ? 131071 : 524287);
    if (isSetCargo())
      hashCode = hashCode * 8191 + cargo.hashCode();

    hashCode = hashCode * 8191 + ((isSetUsuario()) ? 131071 : 524287);
    if (isSetUsuario())
      hashCode = hashCode * 8191 + usuario.hashCode();

    hashCode = hashCode * 8191 + ((isSetContrasena()) ? 131071 : 524287);
    if (isSetContrasena())
      hashCode = hashCode * 8191 + contrasena.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Funcionario other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetNombre()).compareTo(other.isSetNombre());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNombre()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nombre, other.nombre);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetEstatus()).compareTo(other.isSetEstatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEstatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.estatus, other.estatus);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCargo()).compareTo(other.isSetCargo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCargo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cargo, other.cargo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetUsuario()).compareTo(other.isSetUsuario());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUsuario()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.usuario, other.usuario);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetContrasena()).compareTo(other.isSetContrasena());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetContrasena()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.contrasena, other.contrasena);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Funcionario(");
    boolean first = true;

    sb.append("nombre:");
    if (this.nombre == null) {
      sb.append("null");
    } else {
      sb.append(this.nombre);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("estatus:");
    sb.append(this.estatus);
    first = false;
    if (!first) sb.append(", ");
    sb.append("cargo:");
    if (this.cargo == null) {
      sb.append("null");
    } else {
      sb.append(this.cargo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("usuario:");
    if (this.usuario == null) {
      sb.append("null");
    } else {
      sb.append(this.usuario);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("contrasena:");
    if (this.contrasena == null) {
      sb.append("null");
    } else {
      sb.append(this.contrasena);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FuncionarioStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FuncionarioStandardScheme getScheme() {
      return new FuncionarioStandardScheme();
    }
  }

  private static class FuncionarioStandardScheme extends org.apache.thrift.scheme.StandardScheme<Funcionario> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Funcionario struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NOMBRE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.nombre = iprot.readString();
              struct.setNombreIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ESTATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.estatus = iprot.readI32();
              struct.setEstatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CARGO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.cargo = iprot.readString();
              struct.setCargoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // USUARIO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.usuario = iprot.readString();
              struct.setUsuarioIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // CONTRASENA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.contrasena = iprot.readString();
              struct.setContrasenaIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Funcionario struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.nombre != null) {
        oprot.writeFieldBegin(NOMBRE_FIELD_DESC);
        oprot.writeString(struct.nombre);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ESTATUS_FIELD_DESC);
      oprot.writeI32(struct.estatus);
      oprot.writeFieldEnd();
      if (struct.cargo != null) {
        oprot.writeFieldBegin(CARGO_FIELD_DESC);
        oprot.writeString(struct.cargo);
        oprot.writeFieldEnd();
      }
      if (struct.usuario != null) {
        oprot.writeFieldBegin(USUARIO_FIELD_DESC);
        oprot.writeString(struct.usuario);
        oprot.writeFieldEnd();
      }
      if (struct.contrasena != null) {
        oprot.writeFieldBegin(CONTRASENA_FIELD_DESC);
        oprot.writeString(struct.contrasena);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FuncionarioTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FuncionarioTupleScheme getScheme() {
      return new FuncionarioTupleScheme();
    }
  }

  private static class FuncionarioTupleScheme extends org.apache.thrift.scheme.TupleScheme<Funcionario> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Funcionario struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetNombre()) {
        optionals.set(0);
      }
      if (struct.isSetEstatus()) {
        optionals.set(1);
      }
      if (struct.isSetCargo()) {
        optionals.set(2);
      }
      if (struct.isSetUsuario()) {
        optionals.set(3);
      }
      if (struct.isSetContrasena()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetNombre()) {
        oprot.writeString(struct.nombre);
      }
      if (struct.isSetEstatus()) {
        oprot.writeI32(struct.estatus);
      }
      if (struct.isSetCargo()) {
        oprot.writeString(struct.cargo);
      }
      if (struct.isSetUsuario()) {
        oprot.writeString(struct.usuario);
      }
      if (struct.isSetContrasena()) {
        oprot.writeString(struct.contrasena);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Funcionario struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.nombre = iprot.readString();
        struct.setNombreIsSet(true);
      }
      if (incoming.get(1)) {
        struct.estatus = iprot.readI32();
        struct.setEstatusIsSet(true);
      }
      if (incoming.get(2)) {
        struct.cargo = iprot.readString();
        struct.setCargoIsSet(true);
      }
      if (incoming.get(3)) {
        struct.usuario = iprot.readString();
        struct.setUsuarioIsSet(true);
      }
      if (incoming.get(4)) {
        struct.contrasena = iprot.readString();
        struct.setContrasenaIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

