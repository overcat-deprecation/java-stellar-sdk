// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  struct SCSpecUDTUnionCaseTupleV0
//  {
//      string doc<SC_SPEC_DOC_LIMIT>;
//      string name<60>;
//      SCSpecTypeDef type<12>;
//  };

//  ===========================================================================
public class SCSpecUDTUnionCaseTupleV0 implements XdrElement {
  public SCSpecUDTUnionCaseTupleV0() {}

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

  private SCSpecTypeDef[] type;

  public SCSpecTypeDef[] getType() {
    return this.type;
  }

  public void setType(SCSpecTypeDef[] value) {
    this.type = value;
  }

  public static void encode(
      XdrDataOutputStream stream, SCSpecUDTUnionCaseTupleV0 encodedSCSpecUDTUnionCaseTupleV0)
      throws IOException {
    encodedSCSpecUDTUnionCaseTupleV0.doc.encode(stream);
    encodedSCSpecUDTUnionCaseTupleV0.name.encode(stream);
    int typesize = encodedSCSpecUDTUnionCaseTupleV0.getType().length;
    stream.writeInt(typesize);
    for (int i = 0; i < typesize; i++) {
      SCSpecTypeDef.encode(stream, encodedSCSpecUDTUnionCaseTupleV0.type[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecUDTUnionCaseTupleV0 decode(XdrDataInputStream stream) throws IOException {
    SCSpecUDTUnionCaseTupleV0 decodedSCSpecUDTUnionCaseTupleV0 = new SCSpecUDTUnionCaseTupleV0();
    decodedSCSpecUDTUnionCaseTupleV0.doc = XdrString.decode(stream, SC_SPEC_DOC_LIMIT);
    decodedSCSpecUDTUnionCaseTupleV0.name = XdrString.decode(stream, 60);
    int typesize = stream.readInt();
    decodedSCSpecUDTUnionCaseTupleV0.type = new SCSpecTypeDef[typesize];
    for (int i = 0; i < typesize; i++) {
      decodedSCSpecUDTUnionCaseTupleV0.type[i] = SCSpecTypeDef.decode(stream);
    }
    return decodedSCSpecUDTUnionCaseTupleV0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.doc, this.name, Arrays.hashCode(this.type));
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecUDTUnionCaseTupleV0)) {
      return false;
    }

    SCSpecUDTUnionCaseTupleV0 other = (SCSpecUDTUnionCaseTupleV0) object;
    return Objects.equal(this.doc, other.doc)
        && Objects.equal(this.name, other.name)
        && Arrays.equals(this.type, other.type);
  }

  public static final class Builder {
    private XdrString doc;
    private XdrString name;
    private SCSpecTypeDef[] type;

    public Builder doc(XdrString doc) {
      this.doc = doc;
      return this;
    }

    public Builder name(XdrString name) {
      this.name = name;
      return this;
    }

    public Builder type(SCSpecTypeDef[] type) {
      this.type = type;
      return this;
    }

    public SCSpecUDTUnionCaseTupleV0 build() {
      SCSpecUDTUnionCaseTupleV0 val = new SCSpecUDTUnionCaseTupleV0();
      val.setDoc(this.doc);
      val.setName(this.name);
      val.setType(this.type);
      return val;
    }
  }
}
