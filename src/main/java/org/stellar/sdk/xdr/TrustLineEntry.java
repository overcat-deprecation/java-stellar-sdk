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

//  struct TrustLineEntry
//  {
//      AccountID accountID;  // account this trustline belongs to
//      TrustLineAsset asset; // type of asset (with issuer)
//      int64 balance;        // how much of this asset the user has.
//                            // Asset defines the unit for this;
//
//      int64 limit;  // balance cannot be above this
//      uint32 flags; // see TrustLineFlags
//
//      // reserved for future use
//      union switch (int v)
//      {
//      case 0:
//          void;
//      case 1:
//          struct
//          {
//              Liabilities liabilities;
//
//              union switch (int v)
//              {
//              case 0:
//                  void;
//              case 2:
//                  TrustLineEntryExtensionV2 v2;
//              }
//              ext;
//          } v1;
//      }
//      ext;
//  };

//  ===========================================================================
public class TrustLineEntry implements XdrElement {
  public TrustLineEntry() {}

  private AccountID accountID;

  public AccountID getAccountID() {
    return this.accountID;
  }

  public void setAccountID(AccountID value) {
    this.accountID = value;
  }

  private TrustLineAsset asset;

  public TrustLineAsset getAsset() {
    return this.asset;
  }

  public void setAsset(TrustLineAsset value) {
    this.asset = value;
  }

  private Int64 balance;

  public Int64 getBalance() {
    return this.balance;
  }

  public void setBalance(Int64 value) {
    this.balance = value;
  }

  private Int64 limit;

  public Int64 getLimit() {
    return this.limit;
  }

  public void setLimit(Int64 value) {
    this.limit = value;
  }

  private Uint32 flags;

  public Uint32 getFlags() {
    return this.flags;
  }

  public void setFlags(Uint32 value) {
    this.flags = value;
  }

  private TrustLineEntryExt ext;

  public TrustLineEntryExt getExt() {
    return this.ext;
  }

  public void setExt(TrustLineEntryExt value) {
    this.ext = value;
  }

  public static void encode(XdrDataOutputStream stream, TrustLineEntry encodedTrustLineEntry)
      throws IOException {
    AccountID.encode(stream, encodedTrustLineEntry.accountID);
    TrustLineAsset.encode(stream, encodedTrustLineEntry.asset);
    Int64.encode(stream, encodedTrustLineEntry.balance);
    Int64.encode(stream, encodedTrustLineEntry.limit);
    Uint32.encode(stream, encodedTrustLineEntry.flags);
    TrustLineEntryExt.encode(stream, encodedTrustLineEntry.ext);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static TrustLineEntry decode(XdrDataInputStream stream) throws IOException {
    TrustLineEntry decodedTrustLineEntry = new TrustLineEntry();
    decodedTrustLineEntry.accountID = AccountID.decode(stream);
    decodedTrustLineEntry.asset = TrustLineAsset.decode(stream);
    decodedTrustLineEntry.balance = Int64.decode(stream);
    decodedTrustLineEntry.limit = Int64.decode(stream);
    decodedTrustLineEntry.flags = Uint32.decode(stream);
    decodedTrustLineEntry.ext = TrustLineEntryExt.decode(stream);
    return decodedTrustLineEntry;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.accountID, this.asset, this.balance, this.limit, this.flags, this.ext);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof TrustLineEntry)) {
      return false;
    }

    TrustLineEntry other = (TrustLineEntry) object;
    return Objects.equals(this.accountID, other.accountID)
        && Objects.equals(this.asset, other.asset)
        && Objects.equals(this.balance, other.balance)
        && Objects.equals(this.limit, other.limit)
        && Objects.equals(this.flags, other.flags)
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

  public static TrustLineEntry fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static TrustLineEntry fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private AccountID accountID;
    private TrustLineAsset asset;
    private Int64 balance;
    private Int64 limit;
    private Uint32 flags;
    private TrustLineEntryExt ext;

    public Builder accountID(AccountID accountID) {
      this.accountID = accountID;
      return this;
    }

    public Builder asset(TrustLineAsset asset) {
      this.asset = asset;
      return this;
    }

    public Builder balance(Int64 balance) {
      this.balance = balance;
      return this;
    }

    public Builder limit(Int64 limit) {
      this.limit = limit;
      return this;
    }

    public Builder flags(Uint32 flags) {
      this.flags = flags;
      return this;
    }

    public Builder ext(TrustLineEntryExt ext) {
      this.ext = ext;
      return this;
    }

    public TrustLineEntry build() {
      TrustLineEntry val = new TrustLineEntry();
      val.setAccountID(this.accountID);
      val.setAsset(this.asset);
      val.setBalance(this.balance);
      val.setLimit(this.limit);
      val.setFlags(this.flags);
      val.setExt(this.ext);
      return val;
    }
  }

  public static class TrustLineEntryExt implements XdrElement {
    public TrustLineEntryExt() {}

    Integer v;

    public Integer getDiscriminant() {
      return this.v;
    }

    public void setDiscriminant(Integer value) {
      this.v = value;
    }

    private TrustLineEntryV1 v1;

    public TrustLineEntryV1 getV1() {
      return this.v1;
    }

    public void setV1(TrustLineEntryV1 value) {
      this.v1 = value;
    }

    public static final class Builder {
      private Integer discriminant;
      private TrustLineEntryV1 v1;

      public Builder discriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public Builder v1(TrustLineEntryV1 v1) {
        this.v1 = v1;
        return this;
      }

      public TrustLineEntryExt build() {
        TrustLineEntryExt val = new TrustLineEntryExt();
        val.setDiscriminant(discriminant);
        val.setV1(this.v1);
        return val;
      }
    }

    public static void encode(
        XdrDataOutputStream stream, TrustLineEntryExt encodedTrustLineEntryExt) throws IOException {
      // Xdrgen::AST::Typespecs::Int
      // Integer
      stream.writeInt(encodedTrustLineEntryExt.getDiscriminant().intValue());
      switch (encodedTrustLineEntryExt.getDiscriminant()) {
        case 0:
          break;
        case 1:
          TrustLineEntryV1.encode(stream, encodedTrustLineEntryExt.v1);
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static TrustLineEntryExt decode(XdrDataInputStream stream) throws IOException {
      TrustLineEntryExt decodedTrustLineEntryExt = new TrustLineEntryExt();
      Integer discriminant = stream.readInt();
      decodedTrustLineEntryExt.setDiscriminant(discriminant);
      switch (decodedTrustLineEntryExt.getDiscriminant()) {
        case 0:
          break;
        case 1:
          decodedTrustLineEntryExt.v1 = TrustLineEntryV1.decode(stream);
          break;
      }
      return decodedTrustLineEntryExt;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.v1, this.v);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof TrustLineEntryExt)) {
        return false;
      }

      TrustLineEntryExt other = (TrustLineEntryExt) object;
      return Objects.equals(this.v1, other.v1) && Objects.equals(this.v, other.v);
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

    public static TrustLineEntryExt fromXdrBase64(String xdr) throws IOException {
      byte[] bytes = Base64Factory.getInstance().decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static TrustLineEntryExt fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }

    public static class TrustLineEntryV1 implements XdrElement {
      public TrustLineEntryV1() {}

      private Liabilities liabilities;

      public Liabilities getLiabilities() {
        return this.liabilities;
      }

      public void setLiabilities(Liabilities value) {
        this.liabilities = value;
      }

      private TrustLineEntryV1Ext ext;

      public TrustLineEntryV1Ext getExt() {
        return this.ext;
      }

      public void setExt(TrustLineEntryV1Ext value) {
        this.ext = value;
      }

      public static void encode(
          XdrDataOutputStream stream, TrustLineEntryV1 encodedTrustLineEntryV1) throws IOException {
        Liabilities.encode(stream, encodedTrustLineEntryV1.liabilities);
        TrustLineEntryV1Ext.encode(stream, encodedTrustLineEntryV1.ext);
      }

      public void encode(XdrDataOutputStream stream) throws IOException {
        encode(stream, this);
      }

      public static TrustLineEntryV1 decode(XdrDataInputStream stream) throws IOException {
        TrustLineEntryV1 decodedTrustLineEntryV1 = new TrustLineEntryV1();
        decodedTrustLineEntryV1.liabilities = Liabilities.decode(stream);
        decodedTrustLineEntryV1.ext = TrustLineEntryV1Ext.decode(stream);
        return decodedTrustLineEntryV1;
      }

      @Override
      public int hashCode() {
        return Objects.hash(this.liabilities, this.ext);
      }

      @Override
      public boolean equals(Object object) {
        if (!(object instanceof TrustLineEntryV1)) {
          return false;
        }

        TrustLineEntryV1 other = (TrustLineEntryV1) object;
        return Objects.equals(this.liabilities, other.liabilities)
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

      public static TrustLineEntryV1 fromXdrBase64(String xdr) throws IOException {
        byte[] bytes = Base64Factory.getInstance().decode(xdr);
        return fromXdrByteArray(bytes);
      }

      public static TrustLineEntryV1 fromXdrByteArray(byte[] xdr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
        XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
        return decode(xdrDataInputStream);
      }

      public static final class Builder {
        private Liabilities liabilities;
        private TrustLineEntryV1Ext ext;

        public Builder liabilities(Liabilities liabilities) {
          this.liabilities = liabilities;
          return this;
        }

        public Builder ext(TrustLineEntryV1Ext ext) {
          this.ext = ext;
          return this;
        }

        public TrustLineEntryV1 build() {
          TrustLineEntryV1 val = new TrustLineEntryV1();
          val.setLiabilities(this.liabilities);
          val.setExt(this.ext);
          return val;
        }
      }

      public static class TrustLineEntryV1Ext implements XdrElement {
        public TrustLineEntryV1Ext() {}

        Integer v;

        public Integer getDiscriminant() {
          return this.v;
        }

        public void setDiscriminant(Integer value) {
          this.v = value;
        }

        private TrustLineEntryExtensionV2 v2;

        public TrustLineEntryExtensionV2 getV2() {
          return this.v2;
        }

        public void setV2(TrustLineEntryExtensionV2 value) {
          this.v2 = value;
        }

        public static final class Builder {
          private Integer discriminant;
          private TrustLineEntryExtensionV2 v2;

          public Builder discriminant(Integer discriminant) {
            this.discriminant = discriminant;
            return this;
          }

          public Builder v2(TrustLineEntryExtensionV2 v2) {
            this.v2 = v2;
            return this;
          }

          public TrustLineEntryV1Ext build() {
            TrustLineEntryV1Ext val = new TrustLineEntryV1Ext();
            val.setDiscriminant(discriminant);
            val.setV2(this.v2);
            return val;
          }
        }

        public static void encode(
            XdrDataOutputStream stream, TrustLineEntryV1Ext encodedTrustLineEntryV1Ext)
            throws IOException {
          // Xdrgen::AST::Typespecs::Int
          // Integer
          stream.writeInt(encodedTrustLineEntryV1Ext.getDiscriminant().intValue());
          switch (encodedTrustLineEntryV1Ext.getDiscriminant()) {
            case 0:
              break;
            case 2:
              TrustLineEntryExtensionV2.encode(stream, encodedTrustLineEntryV1Ext.v2);
              break;
          }
        }

        public void encode(XdrDataOutputStream stream) throws IOException {
          encode(stream, this);
        }

        public static TrustLineEntryV1Ext decode(XdrDataInputStream stream) throws IOException {
          TrustLineEntryV1Ext decodedTrustLineEntryV1Ext = new TrustLineEntryV1Ext();
          Integer discriminant = stream.readInt();
          decodedTrustLineEntryV1Ext.setDiscriminant(discriminant);
          switch (decodedTrustLineEntryV1Ext.getDiscriminant()) {
            case 0:
              break;
            case 2:
              decodedTrustLineEntryV1Ext.v2 = TrustLineEntryExtensionV2.decode(stream);
              break;
          }
          return decodedTrustLineEntryV1Ext;
        }

        @Override
        public int hashCode() {
          return Objects.hash(this.v2, this.v);
        }

        @Override
        public boolean equals(Object object) {
          if (!(object instanceof TrustLineEntryV1Ext)) {
            return false;
          }

          TrustLineEntryV1Ext other = (TrustLineEntryV1Ext) object;
          return Objects.equals(this.v2, other.v2) && Objects.equals(this.v, other.v);
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

        public static TrustLineEntryV1Ext fromXdrBase64(String xdr) throws IOException {
          byte[] bytes = Base64Factory.getInstance().decode(xdr);
          return fromXdrByteArray(bytes);
        }

        public static TrustLineEntryV1Ext fromXdrByteArray(byte[] xdr) throws IOException {
          ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
          XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
          return decode(xdrDataInputStream);
        }
      }
    }
  }
}
