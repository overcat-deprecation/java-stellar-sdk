// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;

// === xdr source ============================================================

//  union TrustLineAsset switch (AssetType type)
//  {
//  case ASSET_TYPE_NATIVE: // Not credit
//      void;
//
//  case ASSET_TYPE_CREDIT_ALPHANUM4:
//      AlphaNum4 alphaNum4;
//
//  case ASSET_TYPE_CREDIT_ALPHANUM12:
//      AlphaNum12 alphaNum12;
//
//  case ASSET_TYPE_POOL_SHARE:
//      PoolID liquidityPoolID;
//
//      // add other asset types here in the future
//  };

//  ===========================================================================
public class TrustLineAsset implements XdrElement {
  public TrustLineAsset() {}

  AssetType type;

  public AssetType getDiscriminant() {
    return this.type;
  }

  public void setDiscriminant(AssetType value) {
    this.type = value;
  }

  private AlphaNum4 alphaNum4;

  public AlphaNum4 getAlphaNum4() {
    return this.alphaNum4;
  }

  public void setAlphaNum4(AlphaNum4 value) {
    this.alphaNum4 = value;
  }

  private AlphaNum12 alphaNum12;

  public AlphaNum12 getAlphaNum12() {
    return this.alphaNum12;
  }

  public void setAlphaNum12(AlphaNum12 value) {
    this.alphaNum12 = value;
  }

  private PoolID liquidityPoolID;

  public PoolID getLiquidityPoolID() {
    return this.liquidityPoolID;
  }

  public void setLiquidityPoolID(PoolID value) {
    this.liquidityPoolID = value;
  }

  public static final class Builder {
    private AssetType discriminant;
    private AlphaNum4 alphaNum4;
    private AlphaNum12 alphaNum12;
    private PoolID liquidityPoolID;

    public Builder discriminant(AssetType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder alphaNum4(AlphaNum4 alphaNum4) {
      this.alphaNum4 = alphaNum4;
      return this;
    }

    public Builder alphaNum12(AlphaNum12 alphaNum12) {
      this.alphaNum12 = alphaNum12;
      return this;
    }

    public Builder liquidityPoolID(PoolID liquidityPoolID) {
      this.liquidityPoolID = liquidityPoolID;
      return this;
    }

    public TrustLineAsset build() {
      TrustLineAsset val = new TrustLineAsset();
      val.setDiscriminant(discriminant);
      val.setAlphaNum4(this.alphaNum4);
      val.setAlphaNum12(this.alphaNum12);
      val.setLiquidityPoolID(this.liquidityPoolID);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, TrustLineAsset encodedTrustLineAsset)
      throws IOException {
    // Xdrgen::AST::Identifier
    // AssetType
    stream.writeInt(encodedTrustLineAsset.getDiscriminant().getValue());
    switch (encodedTrustLineAsset.getDiscriminant()) {
      case ASSET_TYPE_NATIVE:
        break;
      case ASSET_TYPE_CREDIT_ALPHANUM4:
        AlphaNum4.encode(stream, encodedTrustLineAsset.alphaNum4);
        break;
      case ASSET_TYPE_CREDIT_ALPHANUM12:
        AlphaNum12.encode(stream, encodedTrustLineAsset.alphaNum12);
        break;
      case ASSET_TYPE_POOL_SHARE:
        PoolID.encode(stream, encodedTrustLineAsset.liquidityPoolID);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static TrustLineAsset decode(XdrDataInputStream stream) throws IOException {
    TrustLineAsset decodedTrustLineAsset = new TrustLineAsset();
    AssetType discriminant = AssetType.decode(stream);
    decodedTrustLineAsset.setDiscriminant(discriminant);
    switch (decodedTrustLineAsset.getDiscriminant()) {
      case ASSET_TYPE_NATIVE:
        break;
      case ASSET_TYPE_CREDIT_ALPHANUM4:
        decodedTrustLineAsset.alphaNum4 = AlphaNum4.decode(stream);
        break;
      case ASSET_TYPE_CREDIT_ALPHANUM12:
        decodedTrustLineAsset.alphaNum12 = AlphaNum12.decode(stream);
        break;
      case ASSET_TYPE_POOL_SHARE:
        decodedTrustLineAsset.liquidityPoolID = PoolID.decode(stream);
        break;
    }
    return decodedTrustLineAsset;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.alphaNum4, this.alphaNum12, this.liquidityPoolID, this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof TrustLineAsset)) {
      return false;
    }

    TrustLineAsset other = (TrustLineAsset) object;
    return Objects.equal(this.alphaNum4, other.alphaNum4)
        && Objects.equal(this.alphaNum12, other.alphaNum12)
        && Objects.equal(this.liquidityPoolID, other.liquidityPoolID)
        && Objects.equal(this.type, other.type);
  }
}
