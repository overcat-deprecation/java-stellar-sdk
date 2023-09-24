package org.stellar.sdk;

class JDKBase64Provider implements Base64 {
  @Override
  public String encodeToString(byte[] data) {
    return java.util.Base64.getEncoder().encodeToString(data);
  }

  @Override
  public byte[] encode(byte[] data) {
    return java.util.Base64.getEncoder().encode(data);
  }

  @Override
  public byte[] decode(String data) {
    return java.util.Base64.getDecoder().decode(data);
  }
}
