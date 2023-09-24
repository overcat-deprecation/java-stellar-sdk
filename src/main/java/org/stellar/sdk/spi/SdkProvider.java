package org.stellar.sdk.spi;

import org.stellar.sdk.Base64;

public interface SdkProvider {
  default Base64 createBase64() {
    // we allow this to be null, if this is the case the SDK will use the default implementation
    return null;
  }
}
