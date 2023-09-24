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

//  struct RestoreFootprintOp
//  {
//      ExtensionPoint ext;
//  };

//  ===========================================================================
public class RestoreFootprintOp implements XdrElement {
  public RestoreFootprintOp() {}

  private ExtensionPoint ext;

  public ExtensionPoint getExt() {
    return this.ext;
  }

  public void setExt(ExtensionPoint value) {
    this.ext = value;
  }

  public static void encode(
      XdrDataOutputStream stream, RestoreFootprintOp encodedRestoreFootprintOp) throws IOException {
    ExtensionPoint.encode(stream, encodedRestoreFootprintOp.ext);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static RestoreFootprintOp decode(XdrDataInputStream stream) throws IOException {
    RestoreFootprintOp decodedRestoreFootprintOp = new RestoreFootprintOp();
    decodedRestoreFootprintOp.ext = ExtensionPoint.decode(stream);
    return decodedRestoreFootprintOp;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.ext);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof RestoreFootprintOp)) {
      return false;
    }

    RestoreFootprintOp other = (RestoreFootprintOp) object;
    return Objects.equals(this.ext, other.ext);
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

  public static RestoreFootprintOp fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static RestoreFootprintOp fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private ExtensionPoint ext;

    public Builder ext(ExtensionPoint ext) {
      this.ext = ext;
      return this;
    }

    public RestoreFootprintOp build() {
      RestoreFootprintOp val = new RestoreFootprintOp();
      val.setExt(this.ext);
      return val;
    }
  }
}
