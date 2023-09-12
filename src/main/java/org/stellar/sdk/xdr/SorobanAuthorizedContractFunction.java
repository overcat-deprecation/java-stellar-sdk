// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

// === xdr source ============================================================

//  struct SorobanAuthorizedContractFunction
//  {
//      SCAddress contractAddress;
//      SCSymbol functionName;
//      SCVec args;
//  };

//  ===========================================================================
public class SorobanAuthorizedContractFunction implements XdrElement {
  public SorobanAuthorizedContractFunction() {}

  private SCAddress contractAddress;

  public SCAddress getContractAddress() {
    return this.contractAddress;
  }

  public void setContractAddress(SCAddress value) {
    this.contractAddress = value;
  }

  private SCSymbol functionName;

  public SCSymbol getFunctionName() {
    return this.functionName;
  }

  public void setFunctionName(SCSymbol value) {
    this.functionName = value;
  }

  private SCVec args;

  public SCVec getArgs() {
    return this.args;
  }

  public void setArgs(SCVec value) {
    this.args = value;
  }

  public static void encode(
      XdrDataOutputStream stream,
      SorobanAuthorizedContractFunction encodedSorobanAuthorizedContractFunction)
      throws IOException {
    SCAddress.encode(stream, encodedSorobanAuthorizedContractFunction.contractAddress);
    SCSymbol.encode(stream, encodedSorobanAuthorizedContractFunction.functionName);
    SCVec.encode(stream, encodedSorobanAuthorizedContractFunction.args);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SorobanAuthorizedContractFunction decode(XdrDataInputStream stream)
      throws IOException {
    SorobanAuthorizedContractFunction decodedSorobanAuthorizedContractFunction =
        new SorobanAuthorizedContractFunction();
    decodedSorobanAuthorizedContractFunction.contractAddress = SCAddress.decode(stream);
    decodedSorobanAuthorizedContractFunction.functionName = SCSymbol.decode(stream);
    decodedSorobanAuthorizedContractFunction.args = SCVec.decode(stream);
    return decodedSorobanAuthorizedContractFunction;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.contractAddress, this.functionName, this.args);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SorobanAuthorizedContractFunction)) {
      return false;
    }

    SorobanAuthorizedContractFunction other = (SorobanAuthorizedContractFunction) object;
    return Objects.equals(this.contractAddress, other.contractAddress)
        && Objects.equals(this.functionName, other.functionName)
        && Objects.equals(this.args, other.args);
  }

  @Override
  public String toXdrBase64() throws IOException {
    return Base64.getEncoder().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static SorobanAuthorizedContractFunction fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SorobanAuthorizedContractFunction fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private SCAddress contractAddress;
    private SCSymbol functionName;
    private SCVec args;

    public Builder contractAddress(SCAddress contractAddress) {
      this.contractAddress = contractAddress;
      return this;
    }

    public Builder functionName(SCSymbol functionName) {
      this.functionName = functionName;
      return this;
    }

    public Builder args(SCVec args) {
      this.args = args;
      return this;
    }

    public SorobanAuthorizedContractFunction build() {
      SorobanAuthorizedContractFunction val = new SorobanAuthorizedContractFunction();
      val.setContractAddress(this.contractAddress);
      val.setFunctionName(this.functionName);
      val.setArgs(this.args);
      return val;
    }
  }
}
