// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// === xdr source ============================================================

//  struct SorobanAddressCredentials
//  {
//      SCAddress address;
//      int64 nonce;
//      uint32 signatureExpirationLedger;
//      SCVal signature;
//  };

//  ===========================================================================
public class SorobanAddressCredentials implements XdrElement {
  public SorobanAddressCredentials() {}

  private SCAddress address;

  public SCAddress getAddress() {
    return this.address;
  }

  public void setAddress(SCAddress value) {
    this.address = value;
  }

  private Int64 nonce;

  public Int64 getNonce() {
    return this.nonce;
  }

  public void setNonce(Int64 value) {
    this.nonce = value;
  }

  private Uint32 signatureExpirationLedger;

  public Uint32 getSignatureExpirationLedger() {
    return this.signatureExpirationLedger;
  }

  public void setSignatureExpirationLedger(Uint32 value) {
    this.signatureExpirationLedger = value;
  }

  private SCVal signature;

  public SCVal getSignature() {
    return this.signature;
  }

  public void setSignature(SCVal value) {
    this.signature = value;
  }

  public static void encode(
      XdrDataOutputStream stream, SorobanAddressCredentials encodedSorobanAddressCredentials)
      throws IOException {
    SCAddress.encode(stream, encodedSorobanAddressCredentials.address);
    Int64.encode(stream, encodedSorobanAddressCredentials.nonce);
    Uint32.encode(stream, encodedSorobanAddressCredentials.signatureExpirationLedger);
    SCVal.encode(stream, encodedSorobanAddressCredentials.signature);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SorobanAddressCredentials decode(XdrDataInputStream stream) throws IOException {
    SorobanAddressCredentials decodedSorobanAddressCredentials = new SorobanAddressCredentials();
    decodedSorobanAddressCredentials.address = SCAddress.decode(stream);
    decodedSorobanAddressCredentials.nonce = Int64.decode(stream);
    decodedSorobanAddressCredentials.signatureExpirationLedger = Uint32.decode(stream);
    decodedSorobanAddressCredentials.signature = SCVal.decode(stream);
    return decodedSorobanAddressCredentials;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        this.address, this.nonce, this.signatureExpirationLedger, this.signature);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SorobanAddressCredentials)) {
      return false;
    }

    SorobanAddressCredentials other = (SorobanAddressCredentials) object;
    return Objects.equal(this.address, other.address)
        && Objects.equal(this.nonce, other.nonce)
        && Objects.equal(this.signatureExpirationLedger, other.signatureExpirationLedger)
        && Objects.equal(this.signature, other.signature);
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

  public static SorobanAddressCredentials fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SorobanAddressCredentials fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private SCAddress address;
    private Int64 nonce;
    private Uint32 signatureExpirationLedger;
    private SCVal signature;

    public Builder address(SCAddress address) {
      this.address = address;
      return this;
    }

    public Builder nonce(Int64 nonce) {
      this.nonce = nonce;
      return this;
    }

    public Builder signatureExpirationLedger(Uint32 signatureExpirationLedger) {
      this.signatureExpirationLedger = signatureExpirationLedger;
      return this;
    }

    public Builder signature(SCVal signature) {
      this.signature = signature;
      return this;
    }

    public SorobanAddressCredentials build() {
      SorobanAddressCredentials val = new SorobanAddressCredentials();
      val.setAddress(this.address);
      val.setNonce(this.nonce);
      val.setSignatureExpirationLedger(this.signatureExpirationLedger);
      val.setSignature(this.signature);
      return val;
    }
  }
}
