// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;

// === xdr source ============================================================

//  union ManageBuyOfferResult switch (ManageBuyOfferResultCode code)
//  {
//  case MANAGE_BUY_OFFER_SUCCESS:
//      ManageOfferSuccessResult success;
//  case MANAGE_BUY_OFFER_MALFORMED:
//  case MANAGE_BUY_OFFER_SELL_NO_TRUST:
//  case MANAGE_BUY_OFFER_BUY_NO_TRUST:
//  case MANAGE_BUY_OFFER_SELL_NOT_AUTHORIZED:
//  case MANAGE_BUY_OFFER_BUY_NOT_AUTHORIZED:
//  case MANAGE_BUY_OFFER_LINE_FULL:
//  case MANAGE_BUY_OFFER_UNDERFUNDED:
//  case MANAGE_BUY_OFFER_CROSS_SELF:
//  case MANAGE_BUY_OFFER_SELL_NO_ISSUER:
//  case MANAGE_BUY_OFFER_BUY_NO_ISSUER:
//  case MANAGE_BUY_OFFER_NOT_FOUND:
//  case MANAGE_BUY_OFFER_LOW_RESERVE:
//      void;
//  };

//  ===========================================================================
public class ManageBuyOfferResult implements XdrElement {
  public ManageBuyOfferResult() {}

  ManageBuyOfferResultCode code;

  public ManageBuyOfferResultCode getDiscriminant() {
    return this.code;
  }

  public void setDiscriminant(ManageBuyOfferResultCode value) {
    this.code = value;
  }

  private ManageOfferSuccessResult success;

  public ManageOfferSuccessResult getSuccess() {
    return this.success;
  }

  public void setSuccess(ManageOfferSuccessResult value) {
    this.success = value;
  }

  public static final class Builder {
    private ManageBuyOfferResultCode discriminant;
    private ManageOfferSuccessResult success;

    public Builder discriminant(ManageBuyOfferResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder success(ManageOfferSuccessResult success) {
      this.success = success;
      return this;
    }

    public ManageBuyOfferResult build() {
      ManageBuyOfferResult val = new ManageBuyOfferResult();
      val.setDiscriminant(discriminant);
      val.setSuccess(this.success);
      return val;
    }
  }

  public static void encode(
      XdrDataOutputStream stream, ManageBuyOfferResult encodedManageBuyOfferResult)
      throws IOException {
    // Xdrgen::AST::Identifier
    // ManageBuyOfferResultCode
    stream.writeInt(encodedManageBuyOfferResult.getDiscriminant().getValue());
    switch (encodedManageBuyOfferResult.getDiscriminant()) {
      case MANAGE_BUY_OFFER_SUCCESS:
        ManageOfferSuccessResult.encode(stream, encodedManageBuyOfferResult.success);
        break;
      case MANAGE_BUY_OFFER_MALFORMED:
      case MANAGE_BUY_OFFER_SELL_NO_TRUST:
      case MANAGE_BUY_OFFER_BUY_NO_TRUST:
      case MANAGE_BUY_OFFER_SELL_NOT_AUTHORIZED:
      case MANAGE_BUY_OFFER_BUY_NOT_AUTHORIZED:
      case MANAGE_BUY_OFFER_LINE_FULL:
      case MANAGE_BUY_OFFER_UNDERFUNDED:
      case MANAGE_BUY_OFFER_CROSS_SELF:
      case MANAGE_BUY_OFFER_SELL_NO_ISSUER:
      case MANAGE_BUY_OFFER_BUY_NO_ISSUER:
      case MANAGE_BUY_OFFER_NOT_FOUND:
      case MANAGE_BUY_OFFER_LOW_RESERVE:
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ManageBuyOfferResult decode(XdrDataInputStream stream) throws IOException {
    ManageBuyOfferResult decodedManageBuyOfferResult = new ManageBuyOfferResult();
    ManageBuyOfferResultCode discriminant = ManageBuyOfferResultCode.decode(stream);
    decodedManageBuyOfferResult.setDiscriminant(discriminant);
    switch (decodedManageBuyOfferResult.getDiscriminant()) {
      case MANAGE_BUY_OFFER_SUCCESS:
        decodedManageBuyOfferResult.success = ManageOfferSuccessResult.decode(stream);
        break;
      case MANAGE_BUY_OFFER_MALFORMED:
      case MANAGE_BUY_OFFER_SELL_NO_TRUST:
      case MANAGE_BUY_OFFER_BUY_NO_TRUST:
      case MANAGE_BUY_OFFER_SELL_NOT_AUTHORIZED:
      case MANAGE_BUY_OFFER_BUY_NOT_AUTHORIZED:
      case MANAGE_BUY_OFFER_LINE_FULL:
      case MANAGE_BUY_OFFER_UNDERFUNDED:
      case MANAGE_BUY_OFFER_CROSS_SELF:
      case MANAGE_BUY_OFFER_SELL_NO_ISSUER:
      case MANAGE_BUY_OFFER_BUY_NO_ISSUER:
      case MANAGE_BUY_OFFER_NOT_FOUND:
      case MANAGE_BUY_OFFER_LOW_RESERVE:
        break;
    }
    return decodedManageBuyOfferResult;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.success, this.code);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ManageBuyOfferResult)) {
      return false;
    }

    ManageBuyOfferResult other = (ManageBuyOfferResult) object;
    return Objects.equal(this.success, other.success) && Objects.equal(this.code, other.code);
  }
}
