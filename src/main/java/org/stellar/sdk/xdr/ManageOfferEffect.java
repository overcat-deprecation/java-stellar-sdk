// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  enum ManageOfferEffect
//  {
//      MANAGE_OFFER_CREATED = 0,
//      MANAGE_OFFER_UPDATED = 1,
//      MANAGE_OFFER_DELETED = 2
//  };

//  ===========================================================================
public enum ManageOfferEffect implements XdrElement {
  MANAGE_OFFER_CREATED(0),
  MANAGE_OFFER_UPDATED(1),
  MANAGE_OFFER_DELETED(2),
  ;
  private int mValue;

  ManageOfferEffect(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static ManageOfferEffect decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return MANAGE_OFFER_CREATED;
      case 1:
        return MANAGE_OFFER_UPDATED;
      case 2:
        return MANAGE_OFFER_DELETED;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, ManageOfferEffect value)
      throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
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

  public static ManageOfferEffect fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ManageOfferEffect fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
