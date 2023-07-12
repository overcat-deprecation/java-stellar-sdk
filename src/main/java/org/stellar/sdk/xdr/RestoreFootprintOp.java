// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;

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
    return Objects.hashCode(this.ext);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof RestoreFootprintOp)) {
      return false;
    }

    RestoreFootprintOp other = (RestoreFootprintOp) object;
    return Objects.equal(this.ext, other.ext);
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
