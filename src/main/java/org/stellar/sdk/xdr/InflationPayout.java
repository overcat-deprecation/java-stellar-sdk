// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  struct InflationPayout // or use PaymentResultAtom to limit types?
//  {
//      AccountID destination;
//      int64 amount;
//  };

//  ===========================================================================
public class InflationPayout implements XdrElement {
  public InflationPayout() {}

  private AccountID destination;

  public AccountID getDestination() {
    return this.destination;
  }

  public void setDestination(AccountID value) {
    this.destination = value;
  }

  private Int64 amount;

  public Int64 getAmount() {
    return this.amount;
  }

  public void setAmount(Int64 value) {
    this.amount = value;
  }

  public static void encode(XdrDataOutputStream stream, InflationPayout encodedInflationPayout)
      throws IOException {
    AccountID.encode(stream, encodedInflationPayout.destination);
    Int64.encode(stream, encodedInflationPayout.amount);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static InflationPayout decode(XdrDataInputStream stream) throws IOException {
    InflationPayout decodedInflationPayout = new InflationPayout();
    decodedInflationPayout.destination = AccountID.decode(stream);
    decodedInflationPayout.amount = Int64.decode(stream);
    return decodedInflationPayout;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.destination, this.amount);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof InflationPayout)) {
      return false;
    }

    InflationPayout other = (InflationPayout) object;
    return Objects.equals(this.destination, other.destination)
        && Objects.equals(this.amount, other.amount);
  }

  @Override
  public String toXdrBase64() throws IOException {
    return Base64Factory.getInstance().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static InflationPayout fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static InflationPayout fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private AccountID destination;
    private Int64 amount;

    public Builder destination(AccountID destination) {
      this.destination = destination;
      return this;
    }

    public Builder amount(Int64 amount) {
      this.amount = amount;
      return this;
    }

    public InflationPayout build() {
      InflationPayout val = new InflationPayout();
      val.setDestination(this.destination);
      val.setAmount(this.amount);
      return val;
    }
  }
}
