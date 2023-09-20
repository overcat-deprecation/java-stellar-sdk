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

//  struct SCSpecUDTErrorEnumCaseV0
//  {
//      string doc<SC_SPEC_DOC_LIMIT>;
//      string name<60>;
//      uint32 value;
//  };

//  ===========================================================================
public class SCSpecUDTErrorEnumCaseV0 implements XdrElement {
  public SCSpecUDTErrorEnumCaseV0() {}

  private XdrString doc;

  public XdrString getDoc() {
    return this.doc;
  }

  public void setDoc(XdrString value) {
    this.doc = value;
  }

  private XdrString name;

  public XdrString getName() {
    return this.name;
  }

  public void setName(XdrString value) {
    this.name = value;
  }

  private Uint32 value;

  public Uint32 getValue() {
    return this.value;
  }

  public void setValue(Uint32 value) {
    this.value = value;
  }

  public static void encode(
      XdrDataOutputStream stream, SCSpecUDTErrorEnumCaseV0 encodedSCSpecUDTErrorEnumCaseV0)
      throws IOException {
    encodedSCSpecUDTErrorEnumCaseV0.doc.encode(stream);
    encodedSCSpecUDTErrorEnumCaseV0.name.encode(stream);
    Uint32.encode(stream, encodedSCSpecUDTErrorEnumCaseV0.value);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecUDTErrorEnumCaseV0 decode(XdrDataInputStream stream) throws IOException {
    SCSpecUDTErrorEnumCaseV0 decodedSCSpecUDTErrorEnumCaseV0 = new SCSpecUDTErrorEnumCaseV0();
    decodedSCSpecUDTErrorEnumCaseV0.doc = XdrString.decode(stream, SC_SPEC_DOC_LIMIT);
    decodedSCSpecUDTErrorEnumCaseV0.name = XdrString.decode(stream, 60);
    decodedSCSpecUDTErrorEnumCaseV0.value = Uint32.decode(stream);
    return decodedSCSpecUDTErrorEnumCaseV0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.doc, this.name, this.value);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecUDTErrorEnumCaseV0)) {
      return false;
    }

    SCSpecUDTErrorEnumCaseV0 other = (SCSpecUDTErrorEnumCaseV0) object;
    return Objects.equals(this.doc, other.doc)
        && Objects.equals(this.name, other.name)
        && Objects.equals(this.value, other.value);
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

  public static SCSpecUDTErrorEnumCaseV0 fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCSpecUDTErrorEnumCaseV0 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private XdrString doc;
    private XdrString name;
    private Uint32 value;

    public Builder doc(XdrString doc) {
      this.doc = doc;
      return this;
    }

    public Builder name(XdrString name) {
      this.name = name;
      return this;
    }

    public Builder value(Uint32 value) {
      this.value = value;
      return this;
    }

    public SCSpecUDTErrorEnumCaseV0 build() {
      SCSpecUDTErrorEnumCaseV0 val = new SCSpecUDTErrorEnumCaseV0();
      val.setDoc(this.doc);
      val.setName(this.name);
      val.setValue(this.value);
      return val;
    }
  }
}