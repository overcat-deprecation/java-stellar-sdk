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

//  struct ConfigSettingContractEventsV0
//  {
//      // Maximum size of events that a contract call can emit.
//      uint32 txMaxContractEventsSizeBytes;
//      // Fee for generating 1KB of contract events.
//      int64 feeContractEvents1KB;
//  };

//  ===========================================================================
public class ConfigSettingContractEventsV0 implements XdrElement {
  public ConfigSettingContractEventsV0() {}

  private Uint32 txMaxContractEventsSizeBytes;

  public Uint32 getTxMaxContractEventsSizeBytes() {
    return this.txMaxContractEventsSizeBytes;
  }

  public void setTxMaxContractEventsSizeBytes(Uint32 value) {
    this.txMaxContractEventsSizeBytes = value;
  }

  private Int64 feeContractEvents1KB;

  public Int64 getFeeContractEvents1KB() {
    return this.feeContractEvents1KB;
  }

  public void setFeeContractEvents1KB(Int64 value) {
    this.feeContractEvents1KB = value;
  }

  public static void encode(
      XdrDataOutputStream stream,
      ConfigSettingContractEventsV0 encodedConfigSettingContractEventsV0)
      throws IOException {
    Uint32.encode(stream, encodedConfigSettingContractEventsV0.txMaxContractEventsSizeBytes);
    Int64.encode(stream, encodedConfigSettingContractEventsV0.feeContractEvents1KB);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ConfigSettingContractEventsV0 decode(XdrDataInputStream stream) throws IOException {
    ConfigSettingContractEventsV0 decodedConfigSettingContractEventsV0 =
        new ConfigSettingContractEventsV0();
    decodedConfigSettingContractEventsV0.txMaxContractEventsSizeBytes = Uint32.decode(stream);
    decodedConfigSettingContractEventsV0.feeContractEvents1KB = Int64.decode(stream);
    return decodedConfigSettingContractEventsV0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.txMaxContractEventsSizeBytes, this.feeContractEvents1KB);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ConfigSettingContractEventsV0)) {
      return false;
    }

    ConfigSettingContractEventsV0 other = (ConfigSettingContractEventsV0) object;
    return Objects.equal(this.txMaxContractEventsSizeBytes, other.txMaxContractEventsSizeBytes)
        && Objects.equal(this.feeContractEvents1KB, other.feeContractEvents1KB);
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

  public static ConfigSettingContractEventsV0 fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ConfigSettingContractEventsV0 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Uint32 txMaxContractEventsSizeBytes;
    private Int64 feeContractEvents1KB;

    public Builder txMaxContractEventsSizeBytes(Uint32 txMaxContractEventsSizeBytes) {
      this.txMaxContractEventsSizeBytes = txMaxContractEventsSizeBytes;
      return this;
    }

    public Builder feeContractEvents1KB(Int64 feeContractEvents1KB) {
      this.feeContractEvents1KB = feeContractEvents1KB;
      return this;
    }

    public ConfigSettingContractEventsV0 build() {
      ConfigSettingContractEventsV0 val = new ConfigSettingContractEventsV0();
      val.setTxMaxContractEventsSizeBytes(this.txMaxContractEventsSizeBytes);
      val.setFeeContractEvents1KB(this.feeContractEvents1KB);
      return val;
    }
  }
}
