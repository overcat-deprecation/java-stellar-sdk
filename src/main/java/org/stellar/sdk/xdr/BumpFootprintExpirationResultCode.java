// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// === xdr source ============================================================

//  enum BumpFootprintExpirationResultCode
//  {
//      // codes considered as "success" for the operation
//      BUMP_FOOTPRINT_EXPIRATION_SUCCESS = 0,
//
//      // codes considered as "failure" for the operation
//      BUMP_FOOTPRINT_EXPIRATION_MALFORMED = -1,
//      BUMP_FOOTPRINT_EXPIRATION_RESOURCE_LIMIT_EXCEEDED = -2
//  };

//  ===========================================================================
public enum BumpFootprintExpirationResultCode implements XdrElement {
  BUMP_FOOTPRINT_EXPIRATION_SUCCESS(0),
  BUMP_FOOTPRINT_EXPIRATION_MALFORMED(-1),
  BUMP_FOOTPRINT_EXPIRATION_RESOURCE_LIMIT_EXCEEDED(-2),
  ;
  private int mValue;

  BumpFootprintExpirationResultCode(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static BumpFootprintExpirationResultCode decode(XdrDataInputStream stream)
      throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return BUMP_FOOTPRINT_EXPIRATION_SUCCESS;
      case -1:
        return BUMP_FOOTPRINT_EXPIRATION_MALFORMED;
      case -2:
        return BUMP_FOOTPRINT_EXPIRATION_RESOURCE_LIMIT_EXCEEDED;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, BumpFootprintExpirationResultCode value)
      throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
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

  public static BumpFootprintExpirationResultCode fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static BumpFootprintExpirationResultCode fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}