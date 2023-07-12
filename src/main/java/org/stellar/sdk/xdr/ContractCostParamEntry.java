// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;

// === xdr source ============================================================

//  struct ContractCostParamEntry {
//      // use `ext` to add more terms (e.g. higher order polynomials) in the future
//      ExtensionPoint ext;
//
//      int64 constTerm;
//      int64 linearTerm;
//  };

//  ===========================================================================
public class ContractCostParamEntry implements XdrElement {
  public ContractCostParamEntry() {}

  private ExtensionPoint ext;

  public ExtensionPoint getExt() {
    return this.ext;
  }

  public void setExt(ExtensionPoint value) {
    this.ext = value;
  }

  private Int64 constTerm;

  public Int64 getConstTerm() {
    return this.constTerm;
  }

  public void setConstTerm(Int64 value) {
    this.constTerm = value;
  }

  private Int64 linearTerm;

  public Int64 getLinearTerm() {
    return this.linearTerm;
  }

  public void setLinearTerm(Int64 value) {
    this.linearTerm = value;
  }

  public static void encode(
      XdrDataOutputStream stream, ContractCostParamEntry encodedContractCostParamEntry)
      throws IOException {
    ExtensionPoint.encode(stream, encodedContractCostParamEntry.ext);
    Int64.encode(stream, encodedContractCostParamEntry.constTerm);
    Int64.encode(stream, encodedContractCostParamEntry.linearTerm);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ContractCostParamEntry decode(XdrDataInputStream stream) throws IOException {
    ContractCostParamEntry decodedContractCostParamEntry = new ContractCostParamEntry();
    decodedContractCostParamEntry.ext = ExtensionPoint.decode(stream);
    decodedContractCostParamEntry.constTerm = Int64.decode(stream);
    decodedContractCostParamEntry.linearTerm = Int64.decode(stream);
    return decodedContractCostParamEntry;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.ext, this.constTerm, this.linearTerm);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ContractCostParamEntry)) {
      return false;
    }

    ContractCostParamEntry other = (ContractCostParamEntry) object;
    return Objects.equal(this.ext, other.ext)
        && Objects.equal(this.constTerm, other.constTerm)
        && Objects.equal(this.linearTerm, other.linearTerm);
  }

  public static final class Builder {
    private ExtensionPoint ext;
    private Int64 constTerm;
    private Int64 linearTerm;

    public Builder ext(ExtensionPoint ext) {
      this.ext = ext;
      return this;
    }

    public Builder constTerm(Int64 constTerm) {
      this.constTerm = constTerm;
      return this;
    }

    public Builder linearTerm(Int64 linearTerm) {
      this.linearTerm = linearTerm;
      return this;
    }

    public ContractCostParamEntry build() {
      ContractCostParamEntry val = new ContractCostParamEntry();
      val.setExt(this.ext);
      val.setConstTerm(this.constTerm);
      val.setLinearTerm(this.linearTerm);
      return val;
    }
  }
}
