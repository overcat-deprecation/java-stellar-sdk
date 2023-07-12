// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  struct PathPaymentStrictSendOp
//  {
//      Asset sendAsset;  // asset we pay with
//      int64 sendAmount; // amount of sendAsset to send (excluding fees)
//
//      MuxedAccount destination; // recipient of the payment
//      Asset destAsset;          // what they end up with
//      int64 destMin;            // the minimum amount of dest asset to
//                                // be received
//                                // The operation will fail if it can't be met
//
//      Asset path<5>; // additional hops it must go through to get there
//  };

//  ===========================================================================
public class PathPaymentStrictSendOp implements XdrElement {
  public PathPaymentStrictSendOp() {}

  private Asset sendAsset;

  public Asset getSendAsset() {
    return this.sendAsset;
  }

  public void setSendAsset(Asset value) {
    this.sendAsset = value;
  }

  private Int64 sendAmount;

  public Int64 getSendAmount() {
    return this.sendAmount;
  }

  public void setSendAmount(Int64 value) {
    this.sendAmount = value;
  }

  private MuxedAccount destination;

  public MuxedAccount getDestination() {
    return this.destination;
  }

  public void setDestination(MuxedAccount value) {
    this.destination = value;
  }

  private Asset destAsset;

  public Asset getDestAsset() {
    return this.destAsset;
  }

  public void setDestAsset(Asset value) {
    this.destAsset = value;
  }

  private Int64 destMin;

  public Int64 getDestMin() {
    return this.destMin;
  }

  public void setDestMin(Int64 value) {
    this.destMin = value;
  }

  private Asset[] path;

  public Asset[] getPath() {
    return this.path;
  }

  public void setPath(Asset[] value) {
    this.path = value;
  }

  public static void encode(
      XdrDataOutputStream stream, PathPaymentStrictSendOp encodedPathPaymentStrictSendOp)
      throws IOException {
    Asset.encode(stream, encodedPathPaymentStrictSendOp.sendAsset);
    Int64.encode(stream, encodedPathPaymentStrictSendOp.sendAmount);
    MuxedAccount.encode(stream, encodedPathPaymentStrictSendOp.destination);
    Asset.encode(stream, encodedPathPaymentStrictSendOp.destAsset);
    Int64.encode(stream, encodedPathPaymentStrictSendOp.destMin);
    int pathsize = encodedPathPaymentStrictSendOp.getPath().length;
    stream.writeInt(pathsize);
    for (int i = 0; i < pathsize; i++) {
      Asset.encode(stream, encodedPathPaymentStrictSendOp.path[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static PathPaymentStrictSendOp decode(XdrDataInputStream stream) throws IOException {
    PathPaymentStrictSendOp decodedPathPaymentStrictSendOp = new PathPaymentStrictSendOp();
    decodedPathPaymentStrictSendOp.sendAsset = Asset.decode(stream);
    decodedPathPaymentStrictSendOp.sendAmount = Int64.decode(stream);
    decodedPathPaymentStrictSendOp.destination = MuxedAccount.decode(stream);
    decodedPathPaymentStrictSendOp.destAsset = Asset.decode(stream);
    decodedPathPaymentStrictSendOp.destMin = Int64.decode(stream);
    int pathsize = stream.readInt();
    decodedPathPaymentStrictSendOp.path = new Asset[pathsize];
    for (int i = 0; i < pathsize; i++) {
      decodedPathPaymentStrictSendOp.path[i] = Asset.decode(stream);
    }
    return decodedPathPaymentStrictSendOp;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        this.sendAsset,
        this.sendAmount,
        this.destination,
        this.destAsset,
        this.destMin,
        Arrays.hashCode(this.path));
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof PathPaymentStrictSendOp)) {
      return false;
    }

    PathPaymentStrictSendOp other = (PathPaymentStrictSendOp) object;
    return Objects.equal(this.sendAsset, other.sendAsset)
        && Objects.equal(this.sendAmount, other.sendAmount)
        && Objects.equal(this.destination, other.destination)
        && Objects.equal(this.destAsset, other.destAsset)
        && Objects.equal(this.destMin, other.destMin)
        && Arrays.equals(this.path, other.path);
  }

  public static final class Builder {
    private Asset sendAsset;
    private Int64 sendAmount;
    private MuxedAccount destination;
    private Asset destAsset;
    private Int64 destMin;
    private Asset[] path;

    public Builder sendAsset(Asset sendAsset) {
      this.sendAsset = sendAsset;
      return this;
    }

    public Builder sendAmount(Int64 sendAmount) {
      this.sendAmount = sendAmount;
      return this;
    }

    public Builder destination(MuxedAccount destination) {
      this.destination = destination;
      return this;
    }

    public Builder destAsset(Asset destAsset) {
      this.destAsset = destAsset;
      return this;
    }

    public Builder destMin(Int64 destMin) {
      this.destMin = destMin;
      return this;
    }

    public Builder path(Asset[] path) {
      this.path = path;
      return this;
    }

    public PathPaymentStrictSendOp build() {
      PathPaymentStrictSendOp val = new PathPaymentStrictSendOp();
      val.setSendAsset(this.sendAsset);
      val.setSendAmount(this.sendAmount);
      val.setDestination(this.destination);
      val.setDestAsset(this.destAsset);
      val.setDestMin(this.destMin);
      val.setPath(this.path);
      return val;
    }
  }
}
