// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.IOException;

// === xdr source ============================================================

//  enum SCPStatementType
//  {
//      SCP_ST_PREPARE = 0,
//      SCP_ST_CONFIRM = 1,
//      SCP_ST_EXTERNALIZE = 2,
//      SCP_ST_NOMINATE = 3
//  };

//  ===========================================================================
public enum SCPStatementType implements XdrElement {
  SCP_ST_PREPARE(0),
  SCP_ST_CONFIRM(1),
  SCP_ST_EXTERNALIZE(2),
  SCP_ST_NOMINATE(3),
  ;
  private int mValue;

  SCPStatementType(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static SCPStatementType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return SCP_ST_PREPARE;
      case 1:
        return SCP_ST_CONFIRM;
      case 2:
        return SCP_ST_EXTERNALIZE;
      case 3:
        return SCP_ST_NOMINATE;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, SCPStatementType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}
