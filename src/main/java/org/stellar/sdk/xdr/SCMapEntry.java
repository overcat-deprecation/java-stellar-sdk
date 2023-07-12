// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;

// === xdr source ============================================================

//  struct SCMapEntry
//  {
//      SCVal key;
//      SCVal val;
//  };

//  ===========================================================================
public class SCMapEntry implements XdrElement {
  public SCMapEntry() {}

  private SCVal key;

  public SCVal getKey() {
    return this.key;
  }

  public void setKey(SCVal value) {
    this.key = value;
  }

  private SCVal val;

  public SCVal getVal() {
    return this.val;
  }

  public void setVal(SCVal value) {
    this.val = value;
  }

  public static void encode(XdrDataOutputStream stream, SCMapEntry encodedSCMapEntry)
      throws IOException {
    SCVal.encode(stream, encodedSCMapEntry.key);
    SCVal.encode(stream, encodedSCMapEntry.val);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCMapEntry decode(XdrDataInputStream stream) throws IOException {
    SCMapEntry decodedSCMapEntry = new SCMapEntry();
    decodedSCMapEntry.key = SCVal.decode(stream);
    decodedSCMapEntry.val = SCVal.decode(stream);
    return decodedSCMapEntry;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.key, this.val);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCMapEntry)) {
      return false;
    }

    SCMapEntry other = (SCMapEntry) object;
    return Objects.equal(this.key, other.key) && Objects.equal(this.val, other.val);
  }

  public static final class Builder {
    private SCVal key;
    private SCVal val;

    public Builder key(SCVal key) {
      this.key = key;
      return this;
    }

    public Builder val(SCVal val) {
      this.val = val;
      return this;
    }

    public SCMapEntry build() {
      SCMapEntry val = new SCMapEntry();
      val.setKey(this.key);
      val.setVal(this.val);
      return val;
    }
  }
}
