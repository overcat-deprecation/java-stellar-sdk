// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  struct LedgerHeaderHistoryEntry
//  {
//      Hash hash;
//      LedgerHeader header;
//
//      // reserved for future use
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  };

//  ===========================================================================
public class LedgerHeaderHistoryEntry implements XdrElement {
  public LedgerHeaderHistoryEntry() {}

  private Hash hash;

  public Hash getHash() {
    return this.hash;
  }

  public void setHash(Hash value) {
    this.hash = value;
  }

  private LedgerHeader header;

  public LedgerHeader getHeader() {
    return this.header;
  }

  public void setHeader(LedgerHeader value) {
    this.header = value;
  }

  private LedgerHeaderHistoryEntryExt ext;

  public LedgerHeaderHistoryEntryExt getExt() {
    return this.ext;
  }

  public void setExt(LedgerHeaderHistoryEntryExt value) {
    this.ext = value;
  }

  public static void encode(
      XdrDataOutputStream stream, LedgerHeaderHistoryEntry encodedLedgerHeaderHistoryEntry)
      throws IOException {
    Hash.encode(stream, encodedLedgerHeaderHistoryEntry.hash);
    LedgerHeader.encode(stream, encodedLedgerHeaderHistoryEntry.header);
    LedgerHeaderHistoryEntryExt.encode(stream, encodedLedgerHeaderHistoryEntry.ext);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static LedgerHeaderHistoryEntry decode(XdrDataInputStream stream) throws IOException {
    LedgerHeaderHistoryEntry decodedLedgerHeaderHistoryEntry = new LedgerHeaderHistoryEntry();
    decodedLedgerHeaderHistoryEntry.hash = Hash.decode(stream);
    decodedLedgerHeaderHistoryEntry.header = LedgerHeader.decode(stream);
    decodedLedgerHeaderHistoryEntry.ext = LedgerHeaderHistoryEntryExt.decode(stream);
    return decodedLedgerHeaderHistoryEntry;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.hash, this.header, this.ext);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LedgerHeaderHistoryEntry)) {
      return false;
    }

    LedgerHeaderHistoryEntry other = (LedgerHeaderHistoryEntry) object;
    return Objects.equals(this.hash, other.hash)
        && Objects.equals(this.header, other.header)
        && Objects.equals(this.ext, other.ext);
  }

  @Override
  public String toXdrBase64() throws IOException {
    return Base64Factory.getInstance().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static LedgerHeaderHistoryEntry fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LedgerHeaderHistoryEntry fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Hash hash;
    private LedgerHeader header;
    private LedgerHeaderHistoryEntryExt ext;

    public Builder hash(Hash hash) {
      this.hash = hash;
      return this;
    }

    public Builder header(LedgerHeader header) {
      this.header = header;
      return this;
    }

    public Builder ext(LedgerHeaderHistoryEntryExt ext) {
      this.ext = ext;
      return this;
    }

    public LedgerHeaderHistoryEntry build() {
      LedgerHeaderHistoryEntry val = new LedgerHeaderHistoryEntry();
      val.setHash(this.hash);
      val.setHeader(this.header);
      val.setExt(this.ext);
      return val;
    }
  }

  public static class LedgerHeaderHistoryEntryExt implements XdrElement {
    public LedgerHeaderHistoryEntryExt() {}

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

      public LedgerHeaderHistoryEntryExt build() {
        LedgerHeaderHistoryEntryExt val = new LedgerHeaderHistoryEntryExt();
        val.setDiscriminant(discriminant);
        return val;
      }
    }

    public static void encode(
        XdrDataOutputStream stream, LedgerHeaderHistoryEntryExt encodedLedgerHeaderHistoryEntryExt)
        throws IOException {
      // Xdrgen::AST::Typespecs::Int
      // Integer
      stream.writeInt(encodedLedgerHeaderHistoryEntryExt.getDiscriminant().intValue());
      switch (encodedLedgerHeaderHistoryEntryExt.getDiscriminant()) {
        case 0:
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static LedgerHeaderHistoryEntryExt decode(XdrDataInputStream stream) throws IOException {
      LedgerHeaderHistoryEntryExt decodedLedgerHeaderHistoryEntryExt =
          new LedgerHeaderHistoryEntryExt();
      Integer discriminant = stream.readInt();
      decodedLedgerHeaderHistoryEntryExt.setDiscriminant(discriminant);
      switch (decodedLedgerHeaderHistoryEntryExt.getDiscriminant()) {
        case 0:
          break;
      }
      return decodedLedgerHeaderHistoryEntryExt;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.v);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof LedgerHeaderHistoryEntryExt)) {
        return false;
      }

      LedgerHeaderHistoryEntryExt other = (LedgerHeaderHistoryEntryExt) object;
      return Objects.equals(this.v, other.v);
    }

    @Override
    public String toXdrBase64() throws IOException {
      return Base64Factory.getInstance().encodeToString(toXdrByteArray());
    }

    @Override
    public byte[] toXdrByteArray() throws IOException {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
      encode(xdrDataOutputStream);
      return byteArrayOutputStream.toByteArray();
    }

    public static LedgerHeaderHistoryEntryExt fromXdrBase64(String xdr) throws IOException {
      byte[] bytes = Base64Factory.getInstance().decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static LedgerHeaderHistoryEntryExt fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }
  }
}
