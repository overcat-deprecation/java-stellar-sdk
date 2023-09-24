package org.stellar.sdk;

public interface Base64 {
  /**
   * Encodes bytes to base64 string
   *
   * @param data bytes to encode
   * @return encoded string
   */
  String encodeToString(byte[] data);

  /**
   * Encodes bytes to base64 bytes
   *
   * @param data bytes to encode
   * @return encoded bytes
   */
  byte[] encode(byte[] data);

  /**
   * Decodes base64 string to bytes
   *
   * @param data string to decode
   * @return decoded bytes
   */
  byte[] decode(String data);
}
