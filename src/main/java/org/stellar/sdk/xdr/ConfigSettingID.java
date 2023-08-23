// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// === xdr source ============================================================

//  enum ConfigSettingID
//  {
//      CONFIG_SETTING_CONTRACT_MAX_SIZE_BYTES = 0,
//      CONFIG_SETTING_CONTRACT_COMPUTE_V0 = 1,
//      CONFIG_SETTING_CONTRACT_LEDGER_COST_V0 = 2,
//      CONFIG_SETTING_CONTRACT_HISTORICAL_DATA_V0 = 3,
//      CONFIG_SETTING_CONTRACT_EVENTS_V0 = 4,
//      CONFIG_SETTING_CONTRACT_BANDWIDTH_V0 = 5,
//      CONFIG_SETTING_CONTRACT_COST_PARAMS_CPU_INSTRUCTIONS = 6,
//      CONFIG_SETTING_CONTRACT_COST_PARAMS_MEMORY_BYTES = 7,
//      CONFIG_SETTING_CONTRACT_DATA_KEY_SIZE_BYTES = 8,
//      CONFIG_SETTING_CONTRACT_DATA_ENTRY_SIZE_BYTES = 9,
//      CONFIG_SETTING_STATE_EXPIRATION = 10,
//      CONFIG_SETTING_CONTRACT_EXECUTION_LANES = 11,
//      CONFIG_SETTING_BUCKETLIST_SIZE_WINDOW = 12,
//      CONFIG_SETTING_EVICTION_ITERATOR = 13
//  };

//  ===========================================================================
public enum ConfigSettingID implements XdrElement {
  CONFIG_SETTING_CONTRACT_MAX_SIZE_BYTES(0),
  CONFIG_SETTING_CONTRACT_COMPUTE_V0(1),
  CONFIG_SETTING_CONTRACT_LEDGER_COST_V0(2),
  CONFIG_SETTING_CONTRACT_HISTORICAL_DATA_V0(3),
  CONFIG_SETTING_CONTRACT_EVENTS_V0(4),
  CONFIG_SETTING_CONTRACT_BANDWIDTH_V0(5),
  CONFIG_SETTING_CONTRACT_COST_PARAMS_CPU_INSTRUCTIONS(6),
  CONFIG_SETTING_CONTRACT_COST_PARAMS_MEMORY_BYTES(7),
  CONFIG_SETTING_CONTRACT_DATA_KEY_SIZE_BYTES(8),
  CONFIG_SETTING_CONTRACT_DATA_ENTRY_SIZE_BYTES(9),
  CONFIG_SETTING_STATE_EXPIRATION(10),
  CONFIG_SETTING_CONTRACT_EXECUTION_LANES(11),
  CONFIG_SETTING_BUCKETLIST_SIZE_WINDOW(12),
  CONFIG_SETTING_EVICTION_ITERATOR(13),
  ;
  private int mValue;

  ConfigSettingID(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static ConfigSettingID decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return CONFIG_SETTING_CONTRACT_MAX_SIZE_BYTES;
      case 1:
        return CONFIG_SETTING_CONTRACT_COMPUTE_V0;
      case 2:
        return CONFIG_SETTING_CONTRACT_LEDGER_COST_V0;
      case 3:
        return CONFIG_SETTING_CONTRACT_HISTORICAL_DATA_V0;
      case 4:
        return CONFIG_SETTING_CONTRACT_EVENTS_V0;
      case 5:
        return CONFIG_SETTING_CONTRACT_BANDWIDTH_V0;
      case 6:
        return CONFIG_SETTING_CONTRACT_COST_PARAMS_CPU_INSTRUCTIONS;
      case 7:
        return CONFIG_SETTING_CONTRACT_COST_PARAMS_MEMORY_BYTES;
      case 8:
        return CONFIG_SETTING_CONTRACT_DATA_KEY_SIZE_BYTES;
      case 9:
        return CONFIG_SETTING_CONTRACT_DATA_ENTRY_SIZE_BYTES;
      case 10:
        return CONFIG_SETTING_STATE_EXPIRATION;
      case 11:
        return CONFIG_SETTING_CONTRACT_EXECUTION_LANES;
      case 12:
        return CONFIG_SETTING_BUCKETLIST_SIZE_WINDOW;
      case 13:
        return CONFIG_SETTING_EVICTION_ITERATOR;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, ConfigSettingID value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  @Override
  public String toXdrBase64() throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    return base64Encoding.encode(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static ConfigSettingID fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ConfigSettingID fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
