package org.stellar.sdk.spi;

import org.stellar.sdk.Base64;

public interface SdkProvider {
  Base64 createBase64();
}
