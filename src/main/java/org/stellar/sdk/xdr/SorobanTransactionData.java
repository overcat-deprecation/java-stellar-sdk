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

//  struct SorobanTransactionData
//  {
//      ExtensionPoint ext;
//      SorobanResources resources;
//      // Portion of transaction `fee` allocated to refundable fees.
//      int64 refundableFee;
//  };

//  ===========================================================================
public class SorobanTransactionData implements XdrElement {
  public SorobanTransactionData() {}

  private ExtensionPoint ext;

  public ExtensionPoint getExt() {
    return this.ext;
  }

  public void setExt(ExtensionPoint value) {
    this.ext = value;
  }

  private SorobanResources resources;

  public SorobanResources getResources() {
    return this.resources;
  }

  public void setResources(SorobanResources value) {
    this.resources = value;
  }

  private Int64 refundableFee;

  public Int64 getRefundableFee() {
    return this.refundableFee;
  }

  public void setRefundableFee(Int64 value) {
    this.refundableFee = value;
  }

  public static void encode(
      XdrDataOutputStream stream, SorobanTransactionData encodedSorobanTransactionData)
      throws IOException {
    ExtensionPoint.encode(stream, encodedSorobanTransactionData.ext);
    SorobanResources.encode(stream, encodedSorobanTransactionData.resources);
    Int64.encode(stream, encodedSorobanTransactionData.refundableFee);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SorobanTransactionData decode(XdrDataInputStream stream) throws IOException {
    SorobanTransactionData decodedSorobanTransactionData = new SorobanTransactionData();
    decodedSorobanTransactionData.ext = ExtensionPoint.decode(stream);
    decodedSorobanTransactionData.resources = SorobanResources.decode(stream);
    decodedSorobanTransactionData.refundableFee = Int64.decode(stream);
    return decodedSorobanTransactionData;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.ext, this.resources, this.refundableFee);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SorobanTransactionData)) {
      return false;
    }

    SorobanTransactionData other = (SorobanTransactionData) object;
    return Objects.equals(this.ext, other.ext)
        && Objects.equals(this.resources, other.resources)
        && Objects.equals(this.refundableFee, other.refundableFee);
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

  public static SorobanTransactionData fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SorobanTransactionData fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private ExtensionPoint ext;
    private SorobanResources resources;
    private Int64 refundableFee;

    public Builder ext(ExtensionPoint ext) {
      this.ext = ext;
      return this;
    }

    public Builder resources(SorobanResources resources) {
      this.resources = resources;
      return this;
    }

    public Builder refundableFee(Int64 refundableFee) {
      this.refundableFee = refundableFee;
      return this;
    }

    public SorobanTransactionData build() {
      SorobanTransactionData val = new SorobanTransactionData();
      val.setExt(this.ext);
      val.setResources(this.resources);
      val.setRefundableFee(this.refundableFee);
      return val;
    }
  }
}
