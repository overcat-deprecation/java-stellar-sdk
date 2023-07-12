// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;

// === xdr source ============================================================

//  struct SCContractInstance {
//      ContractExecutable executable;
//      SCMap* storage;
//  };

//  ===========================================================================
public class SCContractInstance implements XdrElement {
  public SCContractInstance() {}

  private ContractExecutable executable;

  public ContractExecutable getExecutable() {
    return this.executable;
  }

  public void setExecutable(ContractExecutable value) {
    this.executable = value;
  }

  private SCMap storage;

  public SCMap getStorage() {
    return this.storage;
  }

  public void setStorage(SCMap value) {
    this.storage = value;
  }

  public static void encode(
      XdrDataOutputStream stream, SCContractInstance encodedSCContractInstance) throws IOException {
    ContractExecutable.encode(stream, encodedSCContractInstance.executable);
    if (encodedSCContractInstance.storage != null) {
      stream.writeInt(1);
      SCMap.encode(stream, encodedSCContractInstance.storage);
    } else {
      stream.writeInt(0);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCContractInstance decode(XdrDataInputStream stream) throws IOException {
    SCContractInstance decodedSCContractInstance = new SCContractInstance();
    decodedSCContractInstance.executable = ContractExecutable.decode(stream);
    int storagePresent = stream.readInt();
    if (storagePresent != 0) {
      decodedSCContractInstance.storage = SCMap.decode(stream);
    }
    return decodedSCContractInstance;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.executable, this.storage);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCContractInstance)) {
      return false;
    }

    SCContractInstance other = (SCContractInstance) object;
    return Objects.equal(this.executable, other.executable)
        && Objects.equal(this.storage, other.storage);
  }

  public static final class Builder {
    private ContractExecutable executable;
    private SCMap storage;

    public Builder executable(ContractExecutable executable) {
      this.executable = executable;
      return this;
    }

    public Builder storage(SCMap storage) {
      this.storage = storage;
      return this;
    }

    public SCContractInstance build() {
      SCContractInstance val = new SCContractInstance();
      val.setExecutable(this.executable);
      val.setStorage(this.storage);
      return val;
    }
  }
}
