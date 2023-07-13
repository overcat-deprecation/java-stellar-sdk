package org.stellar.sdk;

import com.google.common.base.Objects;
import org.stellar.sdk.xdr.Hash;
import org.stellar.sdk.xdr.SCAddress;
import org.stellar.sdk.xdr.SCVal;
import org.stellar.sdk.xdr.SCValType;

/**
 * Represents a single address in the Stellar network. An address can represent an account or a
 * contract.
 */
public class Address {

  /** String representation of the address, ex. "G..." or "C..." */
  private final String address;

  /** The type of the address. */
  private final AddressType type;

  /**
   * Creates a new {@link Address} from a Stellar public key or contract ID.
   *
   * @param address the Stellar public key or contract ID.
   */
  public Address(String address) {
    this.address = address;
    if (StrKey.isValidStellarAccountId(address)) {
      this.type = AddressType.ACCOUNT;
    } else if (StrKey.isValidContractId(address)) {
      this.type = AddressType.CONTRACT;
    } else {
      throw new IllegalArgumentException("Unsupported address type");
    }
  }

  private Address(String address, AddressType type) {
    this.address = address;
    this.type = type;
  }

  /**
   * Creates a new {@link Address} from a Stellar public key.
   *
   * @param accountId the Stellar public key.
   * @return a new {@link Address} object from the given Stellar public key.
   */
  public static Address fromAccount(String accountId) {
    if (!StrKey.isValidStellarAccountId(accountId)) {
      throw new IllegalArgumentException("accountId is invalid");
    }
    return new Address(accountId, AddressType.ACCOUNT);
  }

  /**
   * Creates a new {@link Address} from a Stellar public key.
   *
   * @param contractId the byte array of the Stellar public key.
   * @return a new {@link Address} object from the given Stellar public key.
   */
  public static Address fromAccount(byte[] contractId) {
    return new Address(StrKey.encodeStellarAccountId(contractId), AddressType.ACCOUNT);
  }

  /**
   * Creates a new {@link Address} from a Stellar Contract ID.
   *
   * @param contractId the Stellar Contract ID.
   * @return a new {@link Address} object from the given Stellar Contract ID.
   */
  public static Address fromContract(String contractId) {
    if (!StrKey.isValidContractId(contractId)) {
      throw new IllegalArgumentException("contractId is invalid");
    }
    return new Address(contractId, AddressType.CONTRACT);
  }

  /**
   * Creates a new {@link Address} from a Stellar Contract ID.
   *
   * @param contractId the byte array of the Stellar Contract ID.
   * @return a new {@link Address} object from the given Stellar Contract ID.
   */
  public static Address fromContract(byte[] contractId) {
    return new Address(StrKey.encodeContractId(contractId), AddressType.CONTRACT);
  }

  /**
   * Creates a new {@link Address} from a {@link SCAddress} XDR object.
   *
   * @param scAddress the {@link SCAddress} object to convert
   * @return a new {@link Address} object from the given XDR object
   */
  public static Address fromSCAddress(SCAddress scAddress) {
    switch (scAddress.getDiscriminant()) {
      case SC_ADDRESS_TYPE_ACCOUNT:
        return new Address(StrKey.encodeStellarAccountId(scAddress.getAccountId()));
      case SC_ADDRESS_TYPE_CONTRACT:
        return new Address(StrKey.encodeContractId(scAddress.getContractId().getHash()));
      default:
        throw new IllegalArgumentException("Unsupported address type");
    }
  }

  /**
   * Converts this object to its {@link SCAddress} XDR object representation.
   *
   * @return a new {@link SCAddress} object from this object
   */
  public SCAddress toSCAddress() {
    SCAddress scAddress = new SCAddress();
    switch (this.type) {
      case ACCOUNT:
        scAddress.setDiscriminant(org.stellar.sdk.xdr.SCAddressType.SC_ADDRESS_TYPE_ACCOUNT);
        scAddress.setAccountId(KeyPair.fromAccountId(address).getXdrAccountId());
        break;
      case CONTRACT:
        scAddress.setDiscriminant(org.stellar.sdk.xdr.SCAddressType.SC_ADDRESS_TYPE_CONTRACT);
        scAddress.setContractId(new Hash(StrKey.decodeContractId(this.address)));
        break;
      default:
        throw new IllegalArgumentException("Unsupported address type");
    }
    return scAddress;
  }

  /**
   * Converts this object to its {@link SCVal} XDR object representation.
   *
   * @return a new {@link SCVal} object from this object
   */
  public SCVal toSCVal() {
    SCVal scVal = new SCVal();
    scVal.setDiscriminant(SCValType.SCV_ADDRESS);
    scVal.setAddress(this.toSCAddress());
    return scVal;
  }

  /**
   * Creates a new {@link Address} from a {@link SCVal} XDR object.
   *
   * @param scVal the {@link SCVal} object to convert
   * @return a new {@link Address} object from the given XDR object
   */
  public static Address fromSCVal(SCVal scVal) {
    if (!SCValType.SCV_ADDRESS.equals(scVal.getDiscriminant())) {
      throw new IllegalArgumentException("SCVal is not of type SCV_ADDRESS");
    }
    return Address.fromSCAddress(scVal.getAddress());
  }

  public String getAddress() {
    return address;
  }

  public AddressType getType() {
    return type;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.address, this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Address)) {
      return false;
    }

    Address other = (Address) object;
    return Objects.equal(this.address, other.address) && Objects.equal(this.type, other.type);
  }

  @Override
  public String toString() {
    return this.address;
  }

  public enum AddressType {
    ACCOUNT,
    CONTRACT
  }
}
