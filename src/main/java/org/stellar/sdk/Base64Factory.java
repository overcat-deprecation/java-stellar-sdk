package org.stellar.sdk;

import java.util.Iterator;
import java.util.ServiceLoader;
import lombok.Getter;
import org.stellar.sdk.spi.SdkProvider;

public class Base64Factory {
  @Getter private static Base64 instance = new JDKBase64Provider();

  static {
    ServiceLoader<SdkProvider> load = ServiceLoader.load(SdkProvider.class);
    Iterator<SdkProvider> iterator = load.iterator();
    if (iterator.hasNext()) {
      SdkProvider sdkProvider = iterator.next();
      Base64 newInstance = sdkProvider.createBase64();
      if (newInstance != null) {
        instance = newInstance;
      }
    }
  }
}
