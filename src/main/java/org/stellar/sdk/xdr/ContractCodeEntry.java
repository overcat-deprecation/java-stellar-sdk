// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

// === xdr source ============================================================

//  struct ContractCodeEntry {
//      ExtensionPoint ext;
//
//      Hash hash;
//      union switch (ContractEntryBodyType bodyType)
//      {
//      case DATA_ENTRY:
//          opaque code<>;
//      case EXPIRATION_EXTENSION:
//          void;
//      } body;
//
//      uint32 expirationLedgerSeq;
//  };

//  ===========================================================================
public class ContractCodeEntry implements XdrElement {
  public ContractCodeEntry() {}

  private ExtensionPoint ext;

  public ExtensionPoint getExt() {
    return this.ext;
  }

  public void setExt(ExtensionPoint value) {
    this.ext = value;
  }

  private Hash hash;

  public Hash getHash() {
    return this.hash;
  }

  public void setHash(Hash value) {
    this.hash = value;
  }

  private ContractCodeEntryBody body;

  public ContractCodeEntryBody getBody() {
    return this.body;
  }

  public void setBody(ContractCodeEntryBody value) {
    this.body = value;
  }

  private Uint32 expirationLedgerSeq;

  public Uint32 getExpirationLedgerSeq() {
    return this.expirationLedgerSeq;
  }

  public void setExpirationLedgerSeq(Uint32 value) {
    this.expirationLedgerSeq = value;
  }

  public static void encode(XdrDataOutputStream stream, ContractCodeEntry encodedContractCodeEntry)
      throws IOException {
    ExtensionPoint.encode(stream, encodedContractCodeEntry.ext);
    Hash.encode(stream, encodedContractCodeEntry.hash);
    ContractCodeEntryBody.encode(stream, encodedContractCodeEntry.body);
    Uint32.encode(stream, encodedContractCodeEntry.expirationLedgerSeq);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ContractCodeEntry decode(XdrDataInputStream stream) throws IOException {
    ContractCodeEntry decodedContractCodeEntry = new ContractCodeEntry();
    decodedContractCodeEntry.ext = ExtensionPoint.decode(stream);
    decodedContractCodeEntry.hash = Hash.decode(stream);
    decodedContractCodeEntry.body = ContractCodeEntryBody.decode(stream);
    decodedContractCodeEntry.expirationLedgerSeq = Uint32.decode(stream);
    return decodedContractCodeEntry;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.ext, this.hash, this.body, this.expirationLedgerSeq);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ContractCodeEntry)) {
      return false;
    }

    ContractCodeEntry other = (ContractCodeEntry) object;
    return Objects.equals(this.ext, other.ext)
        && Objects.equals(this.hash, other.hash)
        && Objects.equals(this.body, other.body)
        && Objects.equals(this.expirationLedgerSeq, other.expirationLedgerSeq);
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

  public static ContractCodeEntry fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ContractCodeEntry fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private ExtensionPoint ext;
    private Hash hash;
    private ContractCodeEntryBody body;
    private Uint32 expirationLedgerSeq;

    public Builder ext(ExtensionPoint ext) {
      this.ext = ext;
      return this;
    }

    public Builder hash(Hash hash) {
      this.hash = hash;
      return this;
    }

    public Builder body(ContractCodeEntryBody body) {
      this.body = body;
      return this;
    }

    public Builder expirationLedgerSeq(Uint32 expirationLedgerSeq) {
      this.expirationLedgerSeq = expirationLedgerSeq;
      return this;
    }

    public ContractCodeEntry build() {
      ContractCodeEntry val = new ContractCodeEntry();
      val.setExt(this.ext);
      val.setHash(this.hash);
      val.setBody(this.body);
      val.setExpirationLedgerSeq(this.expirationLedgerSeq);
      return val;
    }
  }

  public static class ContractCodeEntryBody implements XdrElement {
    public ContractCodeEntryBody() {}

    ContractEntryBodyType bodyType;

    public ContractEntryBodyType getDiscriminant() {
      return this.bodyType;
    }

    public void setDiscriminant(ContractEntryBodyType value) {
      this.bodyType = value;
    }

    private byte[] code;

    public byte[] getCode() {
      return this.code;
    }

    public void setCode(byte[] value) {
      this.code = value;
    }

    public static final class Builder {
      private ContractEntryBodyType discriminant;
      private byte[] code;

      public Builder discriminant(ContractEntryBodyType discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public Builder code(byte[] code) {
        this.code = code;
        return this;
      }

      public ContractCodeEntryBody build() {
        ContractCodeEntryBody val = new ContractCodeEntryBody();
        val.setDiscriminant(discriminant);
        val.setCode(this.code);
        return val;
      }
    }

    public static void encode(
        XdrDataOutputStream stream, ContractCodeEntryBody encodedContractCodeEntryBody)
        throws IOException {
      // Xdrgen::AST::Identifier
      // ContractEntryBodyType
      stream.writeInt(encodedContractCodeEntryBody.getDiscriminant().getValue());
      switch (encodedContractCodeEntryBody.getDiscriminant()) {
        case DATA_ENTRY:
          int codesize = encodedContractCodeEntryBody.code.length;
          stream.writeInt(codesize);
          stream.write(encodedContractCodeEntryBody.getCode(), 0, codesize);
          break;
        case EXPIRATION_EXTENSION:
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static ContractCodeEntryBody decode(XdrDataInputStream stream) throws IOException {
      ContractCodeEntryBody decodedContractCodeEntryBody = new ContractCodeEntryBody();
      ContractEntryBodyType discriminant = ContractEntryBodyType.decode(stream);
      decodedContractCodeEntryBody.setDiscriminant(discriminant);
      switch (decodedContractCodeEntryBody.getDiscriminant()) {
        case DATA_ENTRY:
          int codesize = stream.readInt();
          decodedContractCodeEntryBody.code = new byte[codesize];
          stream.read(decodedContractCodeEntryBody.code, 0, codesize);
          break;
        case EXPIRATION_EXTENSION:
          break;
      }
      return decodedContractCodeEntryBody;
    }

    @Override
    public int hashCode() {
      return Objects.hash(Arrays.hashCode(this.code), this.bodyType);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof ContractCodeEntryBody)) {
        return false;
      }

      ContractCodeEntryBody other = (ContractCodeEntryBody) object;
      return Arrays.equals(this.code, other.code) && Objects.equals(this.bodyType, other.bodyType);
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

    public static ContractCodeEntryBody fromXdrBase64(String xdr) throws IOException {
      byte[] bytes = Base64.getDecoder().decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static ContractCodeEntryBody fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }
  }
}