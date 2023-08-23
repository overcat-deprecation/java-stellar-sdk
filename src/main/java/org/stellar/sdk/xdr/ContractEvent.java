// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  struct ContractEvent
//  {
//      // We can use this to add more fields, or because it
//      // is first, to change ContractEvent into a union.
//      ExtensionPoint ext;
//
//      Hash* contractID;
//      ContractEventType type;
//
//      union switch (int v)
//      {
//      case 0:
//          struct
//          {
//              SCVal topics<>;
//              SCVal data;
//          } v0;
//      }
//      body;
//  };

//  ===========================================================================
public class ContractEvent implements XdrElement {
  public ContractEvent() {}

  private ExtensionPoint ext;

  public ExtensionPoint getExt() {
    return this.ext;
  }

  public void setExt(ExtensionPoint value) {
    this.ext = value;
  }

  private Hash contractID;

  public Hash getContractID() {
    return this.contractID;
  }

  public void setContractID(Hash value) {
    this.contractID = value;
  }

  private ContractEventType type;

  public ContractEventType getType() {
    return this.type;
  }

  public void setType(ContractEventType value) {
    this.type = value;
  }

  private ContractEventBody body;

  public ContractEventBody getBody() {
    return this.body;
  }

  public void setBody(ContractEventBody value) {
    this.body = value;
  }

  public static void encode(XdrDataOutputStream stream, ContractEvent encodedContractEvent)
      throws IOException {
    ExtensionPoint.encode(stream, encodedContractEvent.ext);
    if (encodedContractEvent.contractID != null) {
      stream.writeInt(1);
      Hash.encode(stream, encodedContractEvent.contractID);
    } else {
      stream.writeInt(0);
    }
    ContractEventType.encode(stream, encodedContractEvent.type);
    ContractEventBody.encode(stream, encodedContractEvent.body);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ContractEvent decode(XdrDataInputStream stream) throws IOException {
    ContractEvent decodedContractEvent = new ContractEvent();
    decodedContractEvent.ext = ExtensionPoint.decode(stream);
    int contractIDPresent = stream.readInt();
    if (contractIDPresent != 0) {
      decodedContractEvent.contractID = Hash.decode(stream);
    }
    decodedContractEvent.type = ContractEventType.decode(stream);
    decodedContractEvent.body = ContractEventBody.decode(stream);
    return decodedContractEvent;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.ext, this.contractID, this.type, this.body);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ContractEvent)) {
      return false;
    }

    ContractEvent other = (ContractEvent) object;
    return Objects.equal(this.ext, other.ext)
        && Objects.equal(this.contractID, other.contractID)
        && Objects.equal(this.type, other.type)
        && Objects.equal(this.body, other.body);
  }

  @Override
  public String toXdrBase64() throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    return base64Encoding.encode(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static ContractEvent fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ContractEvent fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private ExtensionPoint ext;
    private Hash contractID;
    private ContractEventType type;
    private ContractEventBody body;

    public Builder ext(ExtensionPoint ext) {
      this.ext = ext;
      return this;
    }

    public Builder contractID(Hash contractID) {
      this.contractID = contractID;
      return this;
    }

    public Builder type(ContractEventType type) {
      this.type = type;
      return this;
    }

    public Builder body(ContractEventBody body) {
      this.body = body;
      return this;
    }

    public ContractEvent build() {
      ContractEvent val = new ContractEvent();
      val.setExt(this.ext);
      val.setContractID(this.contractID);
      val.setType(this.type);
      val.setBody(this.body);
      return val;
    }
  }

  public static class ContractEventBody implements XdrElement {
    public ContractEventBody() {}

    Integer v;

    public Integer getDiscriminant() {
      return this.v;
    }

    public void setDiscriminant(Integer value) {
      this.v = value;
    }

    private ContractEventV0 v0;

    public ContractEventV0 getV0() {
      return this.v0;
    }

    public void setV0(ContractEventV0 value) {
      this.v0 = value;
    }

    public static final class Builder {
      private Integer discriminant;
      private ContractEventV0 v0;

      public Builder discriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public Builder v0(ContractEventV0 v0) {
        this.v0 = v0;
        return this;
      }

      public ContractEventBody build() {
        ContractEventBody val = new ContractEventBody();
        val.setDiscriminant(discriminant);
        val.setV0(this.v0);
        return val;
      }
    }

    public static void encode(
        XdrDataOutputStream stream, ContractEventBody encodedContractEventBody) throws IOException {
      // Xdrgen::AST::Typespecs::Int
      // Integer
      stream.writeInt(encodedContractEventBody.getDiscriminant().intValue());
      switch (encodedContractEventBody.getDiscriminant()) {
        case 0:
          ContractEventV0.encode(stream, encodedContractEventBody.v0);
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static ContractEventBody decode(XdrDataInputStream stream) throws IOException {
      ContractEventBody decodedContractEventBody = new ContractEventBody();
      Integer discriminant = stream.readInt();
      decodedContractEventBody.setDiscriminant(discriminant);
      switch (decodedContractEventBody.getDiscriminant()) {
        case 0:
          decodedContractEventBody.v0 = ContractEventV0.decode(stream);
          break;
      }
      return decodedContractEventBody;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(this.v0, this.v);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof ContractEventBody)) {
        return false;
      }

      ContractEventBody other = (ContractEventBody) object;
      return Objects.equal(this.v0, other.v0) && Objects.equal(this.v, other.v);
    }

    @Override
    public String toXdrBase64() throws IOException {
      BaseEncoding base64Encoding = BaseEncoding.base64();
      return base64Encoding.encode(toXdrByteArray());
    }

    @Override
    public byte[] toXdrByteArray() throws IOException {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
      encode(xdrDataOutputStream);
      return byteArrayOutputStream.toByteArray();
    }

    public static ContractEventBody fromXdrBase64(String xdr) throws IOException {
      BaseEncoding base64Encoding = BaseEncoding.base64();
      byte[] bytes = base64Encoding.decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static ContractEventBody fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }

    public static class ContractEventV0 implements XdrElement {
      public ContractEventV0() {}

      private SCVal[] topics;

      public SCVal[] getTopics() {
        return this.topics;
      }

      public void setTopics(SCVal[] value) {
        this.topics = value;
      }

      private SCVal data;

      public SCVal getData() {
        return this.data;
      }

      public void setData(SCVal value) {
        this.data = value;
      }

      public static void encode(XdrDataOutputStream stream, ContractEventV0 encodedContractEventV0)
          throws IOException {
        int topicssize = encodedContractEventV0.getTopics().length;
        stream.writeInt(topicssize);
        for (int i = 0; i < topicssize; i++) {
          SCVal.encode(stream, encodedContractEventV0.topics[i]);
        }
        SCVal.encode(stream, encodedContractEventV0.data);
      }

      public void encode(XdrDataOutputStream stream) throws IOException {
        encode(stream, this);
      }

      public static ContractEventV0 decode(XdrDataInputStream stream) throws IOException {
        ContractEventV0 decodedContractEventV0 = new ContractEventV0();
        int topicssize = stream.readInt();
        decodedContractEventV0.topics = new SCVal[topicssize];
        for (int i = 0; i < topicssize; i++) {
          decodedContractEventV0.topics[i] = SCVal.decode(stream);
        }
        decodedContractEventV0.data = SCVal.decode(stream);
        return decodedContractEventV0;
      }

      @Override
      public int hashCode() {
        return Objects.hashCode(Arrays.hashCode(this.topics), this.data);
      }

      @Override
      public boolean equals(Object object) {
        if (!(object instanceof ContractEventV0)) {
          return false;
        }

        ContractEventV0 other = (ContractEventV0) object;
        return Arrays.equals(this.topics, other.topics) && Objects.equal(this.data, other.data);
      }

      @Override
      public String toXdrBase64() throws IOException {
        BaseEncoding base64Encoding = BaseEncoding.base64();
        return base64Encoding.encode(toXdrByteArray());
      }

      @Override
      public byte[] toXdrByteArray() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
        encode(xdrDataOutputStream);
        return byteArrayOutputStream.toByteArray();
      }

      public static ContractEventV0 fromXdrBase64(String xdr) throws IOException {
        BaseEncoding base64Encoding = BaseEncoding.base64();
        byte[] bytes = base64Encoding.decode(xdr);
        return fromXdrByteArray(bytes);
      }

      public static ContractEventV0 fromXdrByteArray(byte[] xdr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
        XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
        return decode(xdrDataInputStream);
      }

      public static final class Builder {
        private SCVal[] topics;
        private SCVal data;

        public Builder topics(SCVal[] topics) {
          this.topics = topics;
          return this;
        }

        public Builder data(SCVal data) {
          this.data = data;
          return this;
        }

        public ContractEventV0 build() {
          ContractEventV0 val = new ContractEventV0();
          val.setTopics(this.topics);
          val.setData(this.data);
          return val;
        }
      }
    }
  }
}
