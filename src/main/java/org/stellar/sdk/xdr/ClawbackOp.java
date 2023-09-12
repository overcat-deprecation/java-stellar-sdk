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

//  struct ClawbackOp
//  {
//      Asset asset;
//      MuxedAccount from;
//      int64 amount;
//  };

//  ===========================================================================
public class ClawbackOp implements XdrElement {
  public ClawbackOp() {}

  private Asset asset;

  public Asset getAsset() {
    return this.asset;
  }

  public void setAsset(Asset value) {
    this.asset = value;
  }

  private MuxedAccount from;

  public MuxedAccount getFrom() {
    return this.from;
  }

  public void setFrom(MuxedAccount value) {
    this.from = value;
  }

  private Int64 amount;

  public Int64 getAmount() {
    return this.amount;
  }

  public void setAmount(Int64 value) {
    this.amount = value;
  }

  public static void encode(XdrDataOutputStream stream, ClawbackOp encodedClawbackOp)
      throws IOException {
    Asset.encode(stream, encodedClawbackOp.asset);
    MuxedAccount.encode(stream, encodedClawbackOp.from);
    Int64.encode(stream, encodedClawbackOp.amount);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ClawbackOp decode(XdrDataInputStream stream) throws IOException {
    ClawbackOp decodedClawbackOp = new ClawbackOp();
    decodedClawbackOp.asset = Asset.decode(stream);
    decodedClawbackOp.from = MuxedAccount.decode(stream);
    decodedClawbackOp.amount = Int64.decode(stream);
    return decodedClawbackOp;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.asset, this.from, this.amount);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ClawbackOp)) {
      return false;
    }

    ClawbackOp other = (ClawbackOp) object;
    return Objects.equals(this.asset, other.asset)
        && Objects.equals(this.from, other.from)
        && Objects.equals(this.amount, other.amount);
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

  public static ClawbackOp fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ClawbackOp fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Asset asset;
    private MuxedAccount from;
    private Int64 amount;

    public Builder asset(Asset asset) {
      this.asset = asset;
      return this;
    }

    public Builder from(MuxedAccount from) {
      this.from = from;
      return this;
    }

    public Builder amount(Int64 amount) {
      this.amount = amount;
      return this;
    }

    public ClawbackOp build() {
      ClawbackOp val = new ClawbackOp();
      val.setAsset(this.asset);
      val.setFrom(this.from);
      val.setAmount(this.amount);
      return val;
    }
  }
}
