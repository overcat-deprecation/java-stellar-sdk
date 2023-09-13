// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

// === xdr source ============================================================

//  enum SCErrorCode
//  {
//      SCEC_ARITH_DOMAIN = 0,      // some arithmetic wasn't defined (overflow, divide-by-zero)
//      SCEC_INDEX_BOUNDS = 1,      // something was indexed beyond its bounds
//      SCEC_INVALID_INPUT = 2,     // user provided some otherwise-bad data
//      SCEC_MISSING_VALUE = 3,     // some value was required but not provided
//      SCEC_EXISTING_VALUE = 4,    // some value was provided where not allowed
//      SCEC_EXCEEDED_LIMIT = 5,    // some arbitrary limit -- gas or otherwise -- was hit
//      SCEC_INVALID_ACTION = 6,    // data was valid but action requested was not
//      SCEC_INTERNAL_ERROR = 7,    // the internal state of the host was otherwise-bad
//      SCEC_UNEXPECTED_TYPE = 8,   // some type wasn't as expected
//      SCEC_UNEXPECTED_SIZE = 9    // something's size wasn't as expected
//  };

//  ===========================================================================
public enum SCErrorCode implements XdrElement {
  SCEC_ARITH_DOMAIN(0),
  SCEC_INDEX_BOUNDS(1),
  SCEC_INVALID_INPUT(2),
  SCEC_MISSING_VALUE(3),
  SCEC_EXISTING_VALUE(4),
  SCEC_EXCEEDED_LIMIT(5),
  SCEC_INVALID_ACTION(6),
  SCEC_INTERNAL_ERROR(7),
  SCEC_UNEXPECTED_TYPE(8),
  SCEC_UNEXPECTED_SIZE(9),
  ;
  private int mValue;

  SCErrorCode(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static SCErrorCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return SCEC_ARITH_DOMAIN;
      case 1:
        return SCEC_INDEX_BOUNDS;
      case 2:
        return SCEC_INVALID_INPUT;
      case 3:
        return SCEC_MISSING_VALUE;
      case 4:
        return SCEC_EXISTING_VALUE;
      case 5:
        return SCEC_EXCEEDED_LIMIT;
      case 6:
        return SCEC_INVALID_ACTION;
      case 7:
        return SCEC_INTERNAL_ERROR;
      case 8:
        return SCEC_UNEXPECTED_TYPE;
      case 9:
        return SCEC_UNEXPECTED_SIZE;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, SCErrorCode value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
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

  public static SCErrorCode fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCErrorCode fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}