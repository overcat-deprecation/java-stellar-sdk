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

//  struct LiquidityPoolDepositOp
//  {
//      PoolID liquidityPoolID;
//      int64 maxAmountA; // maximum amount of first asset to deposit
//      int64 maxAmountB; // maximum amount of second asset to deposit
//      Price minPrice;   // minimum depositA/depositB
//      Price maxPrice;   // maximum depositA/depositB
//  };

//  ===========================================================================
public class LiquidityPoolDepositOp implements XdrElement {
  public LiquidityPoolDepositOp() {}

  private PoolID liquidityPoolID;

  public PoolID getLiquidityPoolID() {
    return this.liquidityPoolID;
  }

  public void setLiquidityPoolID(PoolID value) {
    this.liquidityPoolID = value;
  }

  private Int64 maxAmountA;

  public Int64 getMaxAmountA() {
    return this.maxAmountA;
  }

  public void setMaxAmountA(Int64 value) {
    this.maxAmountA = value;
  }

  private Int64 maxAmountB;

  public Int64 getMaxAmountB() {
    return this.maxAmountB;
  }

  public void setMaxAmountB(Int64 value) {
    this.maxAmountB = value;
  }

  private Price minPrice;

  public Price getMinPrice() {
    return this.minPrice;
  }

  public void setMinPrice(Price value) {
    this.minPrice = value;
  }

  private Price maxPrice;

  public Price getMaxPrice() {
    return this.maxPrice;
  }

  public void setMaxPrice(Price value) {
    this.maxPrice = value;
  }

  public static void encode(
      XdrDataOutputStream stream, LiquidityPoolDepositOp encodedLiquidityPoolDepositOp)
      throws IOException {
    PoolID.encode(stream, encodedLiquidityPoolDepositOp.liquidityPoolID);
    Int64.encode(stream, encodedLiquidityPoolDepositOp.maxAmountA);
    Int64.encode(stream, encodedLiquidityPoolDepositOp.maxAmountB);
    Price.encode(stream, encodedLiquidityPoolDepositOp.minPrice);
    Price.encode(stream, encodedLiquidityPoolDepositOp.maxPrice);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static LiquidityPoolDepositOp decode(XdrDataInputStream stream) throws IOException {
    LiquidityPoolDepositOp decodedLiquidityPoolDepositOp = new LiquidityPoolDepositOp();
    decodedLiquidityPoolDepositOp.liquidityPoolID = PoolID.decode(stream);
    decodedLiquidityPoolDepositOp.maxAmountA = Int64.decode(stream);
    decodedLiquidityPoolDepositOp.maxAmountB = Int64.decode(stream);
    decodedLiquidityPoolDepositOp.minPrice = Price.decode(stream);
    decodedLiquidityPoolDepositOp.maxPrice = Price.decode(stream);
    return decodedLiquidityPoolDepositOp;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.liquidityPoolID, this.maxAmountA, this.maxAmountB, this.minPrice, this.maxPrice);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LiquidityPoolDepositOp)) {
      return false;
    }

    LiquidityPoolDepositOp other = (LiquidityPoolDepositOp) object;
    return Objects.equals(this.liquidityPoolID, other.liquidityPoolID)
        && Objects.equals(this.maxAmountA, other.maxAmountA)
        && Objects.equals(this.maxAmountB, other.maxAmountB)
        && Objects.equals(this.minPrice, other.minPrice)
        && Objects.equals(this.maxPrice, other.maxPrice);
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

  public static LiquidityPoolDepositOp fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LiquidityPoolDepositOp fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private PoolID liquidityPoolID;
    private Int64 maxAmountA;
    private Int64 maxAmountB;
    private Price minPrice;
    private Price maxPrice;

    public Builder liquidityPoolID(PoolID liquidityPoolID) {
      this.liquidityPoolID = liquidityPoolID;
      return this;
    }

    public Builder maxAmountA(Int64 maxAmountA) {
      this.maxAmountA = maxAmountA;
      return this;
    }

    public Builder maxAmountB(Int64 maxAmountB) {
      this.maxAmountB = maxAmountB;
      return this;
    }

    public Builder minPrice(Price minPrice) {
      this.minPrice = minPrice;
      return this;
    }

    public Builder maxPrice(Price maxPrice) {
      this.maxPrice = maxPrice;
      return this;
    }

    public LiquidityPoolDepositOp build() {
      LiquidityPoolDepositOp val = new LiquidityPoolDepositOp();
      val.setLiquidityPoolID(this.liquidityPoolID);
      val.setMaxAmountA(this.maxAmountA);
      val.setMaxAmountB(this.maxAmountB);
      val.setMinPrice(this.minPrice);
      val.setMaxPrice(this.maxPrice);
      return val;
    }
  }
}
