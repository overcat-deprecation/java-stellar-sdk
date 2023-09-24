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

//  union LiquidityPoolParameters switch (LiquidityPoolType type)
//  {
//  case LIQUIDITY_POOL_CONSTANT_PRODUCT:
//      LiquidityPoolConstantProductParameters constantProduct;
//  };

//  ===========================================================================
public class LiquidityPoolParameters implements XdrElement {
  public LiquidityPoolParameters() {}

  LiquidityPoolType type;

  public LiquidityPoolType getDiscriminant() {
    return this.type;
  }

  public void setDiscriminant(LiquidityPoolType value) {
    this.type = value;
  }

  private LiquidityPoolConstantProductParameters constantProduct;

  public LiquidityPoolConstantProductParameters getConstantProduct() {
    return this.constantProduct;
  }

  public void setConstantProduct(LiquidityPoolConstantProductParameters value) {
    this.constantProduct = value;
  }

  public static final class Builder {
    private LiquidityPoolType discriminant;
    private LiquidityPoolConstantProductParameters constantProduct;

    public Builder discriminant(LiquidityPoolType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder constantProduct(LiquidityPoolConstantProductParameters constantProduct) {
      this.constantProduct = constantProduct;
      return this;
    }

    public LiquidityPoolParameters build() {
      LiquidityPoolParameters val = new LiquidityPoolParameters();
      val.setDiscriminant(discriminant);
      val.setConstantProduct(this.constantProduct);
      return val;
    }
  }

  public static void encode(
      XdrDataOutputStream stream, LiquidityPoolParameters encodedLiquidityPoolParameters)
      throws IOException {
    // Xdrgen::AST::Identifier
    // LiquidityPoolType
    stream.writeInt(encodedLiquidityPoolParameters.getDiscriminant().getValue());
    switch (encodedLiquidityPoolParameters.getDiscriminant()) {
      case LIQUIDITY_POOL_CONSTANT_PRODUCT:
        LiquidityPoolConstantProductParameters.encode(
            stream, encodedLiquidityPoolParameters.constantProduct);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static LiquidityPoolParameters decode(XdrDataInputStream stream) throws IOException {
    LiquidityPoolParameters decodedLiquidityPoolParameters = new LiquidityPoolParameters();
    LiquidityPoolType discriminant = LiquidityPoolType.decode(stream);
    decodedLiquidityPoolParameters.setDiscriminant(discriminant);
    switch (decodedLiquidityPoolParameters.getDiscriminant()) {
      case LIQUIDITY_POOL_CONSTANT_PRODUCT:
        decodedLiquidityPoolParameters.constantProduct =
            LiquidityPoolConstantProductParameters.decode(stream);
        break;
    }
    return decodedLiquidityPoolParameters;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.constantProduct, this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LiquidityPoolParameters)) {
      return false;
    }

    LiquidityPoolParameters other = (LiquidityPoolParameters) object;
    return Objects.equals(this.constantProduct, other.constantProduct)
        && Objects.equals(this.type, other.type);
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

  public static LiquidityPoolParameters fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LiquidityPoolParameters fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
