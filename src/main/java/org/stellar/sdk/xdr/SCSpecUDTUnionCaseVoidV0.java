// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;

// === xdr source ============================================================

//  struct SCSpecUDTUnionCaseVoidV0
//  {
//      string doc<SC_SPEC_DOC_LIMIT>;
//      string name<60>;
//  };

//  ===========================================================================
public class SCSpecUDTUnionCaseVoidV0 implements XdrElement {
  public SCSpecUDTUnionCaseVoidV0() {}

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

  public static void encode(
      XdrDataOutputStream stream, SCSpecUDTUnionCaseVoidV0 encodedSCSpecUDTUnionCaseVoidV0)
      throws IOException {
    encodedSCSpecUDTUnionCaseVoidV0.doc.encode(stream);
    encodedSCSpecUDTUnionCaseVoidV0.name.encode(stream);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecUDTUnionCaseVoidV0 decode(XdrDataInputStream stream) throws IOException {
    SCSpecUDTUnionCaseVoidV0 decodedSCSpecUDTUnionCaseVoidV0 = new SCSpecUDTUnionCaseVoidV0();
    decodedSCSpecUDTUnionCaseVoidV0.doc = XdrString.decode(stream, SC_SPEC_DOC_LIMIT);
    decodedSCSpecUDTUnionCaseVoidV0.name = XdrString.decode(stream, 60);
    return decodedSCSpecUDTUnionCaseVoidV0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.doc, this.name);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecUDTUnionCaseVoidV0)) {
      return false;
    }

    SCSpecUDTUnionCaseVoidV0 other = (SCSpecUDTUnionCaseVoidV0) object;
    return Objects.equal(this.doc, other.doc) && Objects.equal(this.name, other.name);
  }

  public static final class Builder {
    private XdrString doc;
    private XdrString name;

    public Builder doc(XdrString doc) {
      this.doc = doc;
      return this;
    }

    public Builder name(XdrString name) {
      this.name = name;
      return this;
    }

    public SCSpecUDTUnionCaseVoidV0 build() {
      SCSpecUDTUnionCaseVoidV0 val = new SCSpecUDTUnionCaseVoidV0();
      val.setDoc(this.doc);
      val.setName(this.name);
      return val;
    }
  }
}
