// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

// === xdr source ============================================================

//  union SCSpecUDTUnionCaseV0 switch (SCSpecUDTUnionCaseV0Kind kind)
//  {
//  case SC_SPEC_UDT_UNION_CASE_VOID_V0:
//      SCSpecUDTUnionCaseVoidV0 voidCase;
//  case SC_SPEC_UDT_UNION_CASE_TUPLE_V0:
//      SCSpecUDTUnionCaseTupleV0 tupleCase;
//  };

//  ===========================================================================
public class SCSpecUDTUnionCaseV0 implements XdrElement {
  public SCSpecUDTUnionCaseV0() {}

  SCSpecUDTUnionCaseV0Kind kind;

  public SCSpecUDTUnionCaseV0Kind getDiscriminant() {
    return this.kind;
  }

  public void setDiscriminant(SCSpecUDTUnionCaseV0Kind value) {
    this.kind = value;
  }

  private SCSpecUDTUnionCaseVoidV0 voidCase;

  public SCSpecUDTUnionCaseVoidV0 getVoidCase() {
    return this.voidCase;
  }

  public void setVoidCase(SCSpecUDTUnionCaseVoidV0 value) {
    this.voidCase = value;
  }

  private SCSpecUDTUnionCaseTupleV0 tupleCase;

  public SCSpecUDTUnionCaseTupleV0 getTupleCase() {
    return this.tupleCase;
  }

  public void setTupleCase(SCSpecUDTUnionCaseTupleV0 value) {
    this.tupleCase = value;
  }

  public static final class Builder {
    private SCSpecUDTUnionCaseV0Kind discriminant;
    private SCSpecUDTUnionCaseVoidV0 voidCase;
    private SCSpecUDTUnionCaseTupleV0 tupleCase;

    public Builder discriminant(SCSpecUDTUnionCaseV0Kind discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder voidCase(SCSpecUDTUnionCaseVoidV0 voidCase) {
      this.voidCase = voidCase;
      return this;
    }

    public Builder tupleCase(SCSpecUDTUnionCaseTupleV0 tupleCase) {
      this.tupleCase = tupleCase;
      return this;
    }

    public SCSpecUDTUnionCaseV0 build() {
      SCSpecUDTUnionCaseV0 val = new SCSpecUDTUnionCaseV0();
      val.setDiscriminant(discriminant);
      val.setVoidCase(this.voidCase);
      val.setTupleCase(this.tupleCase);
      return val;
    }
  }

  public static void encode(
      XdrDataOutputStream stream, SCSpecUDTUnionCaseV0 encodedSCSpecUDTUnionCaseV0)
      throws IOException {
    // Xdrgen::AST::Identifier
    // SCSpecUDTUnionCaseV0Kind
    stream.writeInt(encodedSCSpecUDTUnionCaseV0.getDiscriminant().getValue());
    switch (encodedSCSpecUDTUnionCaseV0.getDiscriminant()) {
      case SC_SPEC_UDT_UNION_CASE_VOID_V0:
        SCSpecUDTUnionCaseVoidV0.encode(stream, encodedSCSpecUDTUnionCaseV0.voidCase);
        break;
      case SC_SPEC_UDT_UNION_CASE_TUPLE_V0:
        SCSpecUDTUnionCaseTupleV0.encode(stream, encodedSCSpecUDTUnionCaseV0.tupleCase);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecUDTUnionCaseV0 decode(XdrDataInputStream stream) throws IOException {
    SCSpecUDTUnionCaseV0 decodedSCSpecUDTUnionCaseV0 = new SCSpecUDTUnionCaseV0();
    SCSpecUDTUnionCaseV0Kind discriminant = SCSpecUDTUnionCaseV0Kind.decode(stream);
    decodedSCSpecUDTUnionCaseV0.setDiscriminant(discriminant);
    switch (decodedSCSpecUDTUnionCaseV0.getDiscriminant()) {
      case SC_SPEC_UDT_UNION_CASE_VOID_V0:
        decodedSCSpecUDTUnionCaseV0.voidCase = SCSpecUDTUnionCaseVoidV0.decode(stream);
        break;
      case SC_SPEC_UDT_UNION_CASE_TUPLE_V0:
        decodedSCSpecUDTUnionCaseV0.tupleCase = SCSpecUDTUnionCaseTupleV0.decode(stream);
        break;
    }
    return decodedSCSpecUDTUnionCaseV0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.voidCase, this.tupleCase, this.kind);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecUDTUnionCaseV0)) {
      return false;
    }

    SCSpecUDTUnionCaseV0 other = (SCSpecUDTUnionCaseV0) object;
    return Objects.equals(this.voidCase, other.voidCase)
        && Objects.equals(this.tupleCase, other.tupleCase)
        && Objects.equals(this.kind, other.kind);
  }

  @Override
  public String toXdrBase64() throws IOException {
    return Base64.getEncoder().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static SCSpecUDTUnionCaseV0 fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCSpecUDTUnionCaseV0 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}