/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package Thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
//@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-06-27")
public class ErrorBD extends org.apache.thrift.TException implements org.apache.thrift.TBase<ErrorBD, ErrorBD._Fields>, java.io.Serializable, Cloneable, Comparable<ErrorBD> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ErrorBD");

  private static final org.apache.thrift.protocol.TField PROBLEMA_FIELD_DESC = new org.apache.thrift.protocol.TField("problema", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CODIGO_ERROR_FIELD_DESC = new org.apache.thrift.protocol.TField("codigoError", org.apache.thrift.protocol.TType.I16, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ErrorBDStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ErrorBDTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String problema; // required
  public short codigoError; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PROBLEMA((short)1, "problema"),
    CODIGO_ERROR((short)2, "codigoError");

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
        case 1: // PROBLEMA
          return PROBLEMA;
        case 2: // CODIGO_ERROR
          return CODIGO_ERROR;
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
  private static final int __CODIGOERROR_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PROBLEMA, new org.apache.thrift.meta_data.FieldMetaData("problema", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CODIGO_ERROR, new org.apache.thrift.meta_data.FieldMetaData("codigoError", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ErrorBD.class, metaDataMap);
  }

  public ErrorBD() {
    this.problema = "Error de conexion";

    this.codigoError = (short)500;

  }

  public ErrorBD(
    java.lang.String problema,
    short codigoError)
  {
    this();
    this.problema = problema;
    this.codigoError = codigoError;
    setCodigoErrorIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ErrorBD(ErrorBD other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetProblema()) {
      this.problema = other.problema;
    }
    this.codigoError = other.codigoError;
  }

  public ErrorBD deepCopy() {
    return new ErrorBD(this);
  }

  @Override
  public void clear() {
    this.problema = "Error de conexion";

    this.codigoError = (short)500;

  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getProblema() {
    return this.problema;
  }

  public ErrorBD setProblema(@org.apache.thrift.annotation.Nullable java.lang.String problema) {
    this.problema = problema;
    return this;
  }

  public void unsetProblema() {
    this.problema = null;
  }

  /** Returns true if field problema is set (has been assigned a value) and false otherwise */
  public boolean isSetProblema() {
    return this.problema != null;
  }

  public void setProblemaIsSet(boolean value) {
    if (!value) {
      this.problema = null;
    }
  }

  public short getCodigoError() {
    return this.codigoError;
  }

  public ErrorBD setCodigoError(short codigoError) {
    this.codigoError = codigoError;
    setCodigoErrorIsSet(true);
    return this;
  }

  public void unsetCodigoError() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CODIGOERROR_ISSET_ID);
  }

  /** Returns true if field codigoError is set (has been assigned a value) and false otherwise */
  public boolean isSetCodigoError() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CODIGOERROR_ISSET_ID);
  }

  public void setCodigoErrorIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CODIGOERROR_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case PROBLEMA:
      if (value == null) {
        unsetProblema();
      } else {
        setProblema((java.lang.String)value);
      }
      break;

    case CODIGO_ERROR:
      if (value == null) {
        unsetCodigoError();
      } else {
        setCodigoError((java.lang.Short)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case PROBLEMA:
      return getProblema();

    case CODIGO_ERROR:
      return getCodigoError();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case PROBLEMA:
      return isSetProblema();
    case CODIGO_ERROR:
      return isSetCodigoError();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ErrorBD)
      return this.equals((ErrorBD)that);
    return false;
  }

  public boolean equals(ErrorBD that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_problema = true && this.isSetProblema();
    boolean that_present_problema = true && that.isSetProblema();
    if (this_present_problema || that_present_problema) {
      if (!(this_present_problema && that_present_problema))
        return false;
      if (!this.problema.equals(that.problema))
        return false;
    }

    boolean this_present_codigoError = true;
    boolean that_present_codigoError = true;
    if (this_present_codigoError || that_present_codigoError) {
      if (!(this_present_codigoError && that_present_codigoError))
        return false;
      if (this.codigoError != that.codigoError)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetProblema()) ? 131071 : 524287);
    if (isSetProblema())
      hashCode = hashCode * 8191 + problema.hashCode();

    hashCode = hashCode * 8191 + codigoError;

    return hashCode;
  }

  @Override
  public int compareTo(ErrorBD other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetProblema()).compareTo(other.isSetProblema());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProblema()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.problema, other.problema);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCodigoError()).compareTo(other.isSetCodigoError());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCodigoError()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.codigoError, other.codigoError);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ErrorBD(");
    boolean first = true;

    sb.append("problema:");
    if (this.problema == null) {
      sb.append("null");
    } else {
      sb.append(this.problema);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("codigoError:");
    sb.append(this.codigoError);
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

  private static class ErrorBDStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ErrorBDStandardScheme getScheme() {
      return new ErrorBDStandardScheme();
    }
  }

  private static class ErrorBDStandardScheme extends org.apache.thrift.scheme.StandardScheme<ErrorBD> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ErrorBD struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PROBLEMA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.problema = iprot.readString();
              struct.setProblemaIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CODIGO_ERROR
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.codigoError = iprot.readI16();
              struct.setCodigoErrorIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ErrorBD struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.problema != null) {
        oprot.writeFieldBegin(PROBLEMA_FIELD_DESC);
        oprot.writeString(struct.problema);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CODIGO_ERROR_FIELD_DESC);
      oprot.writeI16(struct.codigoError);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ErrorBDTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ErrorBDTupleScheme getScheme() {
      return new ErrorBDTupleScheme();
    }
  }

  private static class ErrorBDTupleScheme extends org.apache.thrift.scheme.TupleScheme<ErrorBD> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ErrorBD struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetProblema()) {
        optionals.set(0);
      }
      if (struct.isSetCodigoError()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetProblema()) {
        oprot.writeString(struct.problema);
      }
      if (struct.isSetCodigoError()) {
        oprot.writeI16(struct.codigoError);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ErrorBD struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.problema = iprot.readString();
        struct.setProblemaIsSet(true);
      }
      if (incoming.get(1)) {
        struct.codigoError = iprot.readI16();
        struct.setCodigoErrorIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

