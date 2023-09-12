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

//  struct LedgerHeaderExtensionV1
//  {
//      uint32 flags; // LedgerHeaderFlags
//
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  };

//  ===========================================================================
public class LedgerHeaderExtensionV1 implements XdrElement {
  public LedgerHeaderExtensionV1() {}

  private Uint32 flags;

  public Uint32 getFlags() {
    return this.flags;
  }

  public void setFlags(Uint32 value) {
    this.flags = value;
  }

  private LedgerHeaderExtensionV1Ext ext;

  public LedgerHeaderExtensionV1Ext getExt() {
    return this.ext;
  }

  public void setExt(LedgerHeaderExtensionV1Ext value) {
    this.ext = value;
  }

  public static void encode(
      XdrDataOutputStream stream, LedgerHeaderExtensionV1 encodedLedgerHeaderExtensionV1)
      throws IOException {
    Uint32.encode(stream, encodedLedgerHeaderExtensionV1.flags);
    LedgerHeaderExtensionV1Ext.encode(stream, encodedLedgerHeaderExtensionV1.ext);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static LedgerHeaderExtensionV1 decode(XdrDataInputStream stream) throws IOException {
    LedgerHeaderExtensionV1 decodedLedgerHeaderExtensionV1 = new LedgerHeaderExtensionV1();
    decodedLedgerHeaderExtensionV1.flags = Uint32.decode(stream);
    decodedLedgerHeaderExtensionV1.ext = LedgerHeaderExtensionV1Ext.decode(stream);
    return decodedLedgerHeaderExtensionV1;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.flags, this.ext);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LedgerHeaderExtensionV1)) {
      return false;
    }

    LedgerHeaderExtensionV1 other = (LedgerHeaderExtensionV1) object;
    return Objects.equals(this.flags, other.flags) && Objects.equals(this.ext, other.ext);
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

  public static LedgerHeaderExtensionV1 fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LedgerHeaderExtensionV1 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Uint32 flags;
    private LedgerHeaderExtensionV1Ext ext;

    public Builder flags(Uint32 flags) {
      this.flags = flags;
      return this;
    }

    public Builder ext(LedgerHeaderExtensionV1Ext ext) {
      this.ext = ext;
      return this;
    }

    public LedgerHeaderExtensionV1 build() {
      LedgerHeaderExtensionV1 val = new LedgerHeaderExtensionV1();
      val.setFlags(this.flags);
      val.setExt(this.ext);
      return val;
    }
  }

  public static class LedgerHeaderExtensionV1Ext implements XdrElement {
    public LedgerHeaderExtensionV1Ext() {}

    Integer v;

    public Integer getDiscriminant() {
      return this.v;
    }

    public void setDiscriminant(Integer value) {
      this.v = value;
    }

    public static final class Builder {
      private Integer discriminant;

      public Builder discriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public LedgerHeaderExtensionV1Ext build() {
        LedgerHeaderExtensionV1Ext val = new LedgerHeaderExtensionV1Ext();
        val.setDiscriminant(discriminant);
        return val;
      }
    }

    public static void encode(
        XdrDataOutputStream stream, LedgerHeaderExtensionV1Ext encodedLedgerHeaderExtensionV1Ext)
        throws IOException {
      // Xdrgen::AST::Typespecs::Int
      // Integer
      stream.writeInt(encodedLedgerHeaderExtensionV1Ext.getDiscriminant().intValue());
      switch (encodedLedgerHeaderExtensionV1Ext.getDiscriminant()) {
        case 0:
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static LedgerHeaderExtensionV1Ext decode(XdrDataInputStream stream) throws IOException {
      LedgerHeaderExtensionV1Ext decodedLedgerHeaderExtensionV1Ext =
          new LedgerHeaderExtensionV1Ext();
      Integer discriminant = stream.readInt();
      decodedLedgerHeaderExtensionV1Ext.setDiscriminant(discriminant);
      switch (decodedLedgerHeaderExtensionV1Ext.getDiscriminant()) {
        case 0:
          break;
      }
      return decodedLedgerHeaderExtensionV1Ext;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.v);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof LedgerHeaderExtensionV1Ext)) {
        return false;
      }

      LedgerHeaderExtensionV1Ext other = (LedgerHeaderExtensionV1Ext) object;
      return Objects.equals(this.v, other.v);
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

    public static LedgerHeaderExtensionV1Ext fromXdrBase64(String xdr) throws IOException {
      byte[] bytes = Base64.getDecoder().decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static LedgerHeaderExtensionV1Ext fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }
  }
}
