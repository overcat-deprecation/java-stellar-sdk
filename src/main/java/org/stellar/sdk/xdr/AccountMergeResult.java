// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;

// === xdr source ============================================================

//  union AccountMergeResult switch (AccountMergeResultCode code)
//  {
//  case ACCOUNT_MERGE_SUCCESS:
//      int64 sourceAccountBalance; // how much got transferred from source account
//  case ACCOUNT_MERGE_MALFORMED:
//  case ACCOUNT_MERGE_NO_ACCOUNT:
//  case ACCOUNT_MERGE_IMMUTABLE_SET:
//  case ACCOUNT_MERGE_HAS_SUB_ENTRIES:
//  case ACCOUNT_MERGE_SEQNUM_TOO_FAR:
//  case ACCOUNT_MERGE_DEST_FULL:
//  case ACCOUNT_MERGE_IS_SPONSOR:
//      void;
//  };

//  ===========================================================================
public class AccountMergeResult implements XdrElement {
  public AccountMergeResult() {}

  AccountMergeResultCode code;

  public AccountMergeResultCode getDiscriminant() {
    return this.code;
  }

  public void setDiscriminant(AccountMergeResultCode value) {
    this.code = value;
  }

  private Int64 sourceAccountBalance;

  public Int64 getSourceAccountBalance() {
    return this.sourceAccountBalance;
  }

  public void setSourceAccountBalance(Int64 value) {
    this.sourceAccountBalance = value;
  }

  public static final class Builder {
    private AccountMergeResultCode discriminant;
    private Int64 sourceAccountBalance;

    public Builder discriminant(AccountMergeResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder sourceAccountBalance(Int64 sourceAccountBalance) {
      this.sourceAccountBalance = sourceAccountBalance;
      return this;
    }

    public AccountMergeResult build() {
      AccountMergeResult val = new AccountMergeResult();
      val.setDiscriminant(discriminant);
      val.setSourceAccountBalance(this.sourceAccountBalance);
      return val;
    }
  }

  public static void encode(
      XdrDataOutputStream stream, AccountMergeResult encodedAccountMergeResult) throws IOException {
    // Xdrgen::AST::Identifier
    // AccountMergeResultCode
    stream.writeInt(encodedAccountMergeResult.getDiscriminant().getValue());
    switch (encodedAccountMergeResult.getDiscriminant()) {
      case ACCOUNT_MERGE_SUCCESS:
        Int64.encode(stream, encodedAccountMergeResult.sourceAccountBalance);
        break;
      case ACCOUNT_MERGE_MALFORMED:
      case ACCOUNT_MERGE_NO_ACCOUNT:
      case ACCOUNT_MERGE_IMMUTABLE_SET:
      case ACCOUNT_MERGE_HAS_SUB_ENTRIES:
      case ACCOUNT_MERGE_SEQNUM_TOO_FAR:
      case ACCOUNT_MERGE_DEST_FULL:
      case ACCOUNT_MERGE_IS_SPONSOR:
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static AccountMergeResult decode(XdrDataInputStream stream) throws IOException {
    AccountMergeResult decodedAccountMergeResult = new AccountMergeResult();
    AccountMergeResultCode discriminant = AccountMergeResultCode.decode(stream);
    decodedAccountMergeResult.setDiscriminant(discriminant);
    switch (decodedAccountMergeResult.getDiscriminant()) {
      case ACCOUNT_MERGE_SUCCESS:
        decodedAccountMergeResult.sourceAccountBalance = Int64.decode(stream);
        break;
      case ACCOUNT_MERGE_MALFORMED:
      case ACCOUNT_MERGE_NO_ACCOUNT:
      case ACCOUNT_MERGE_IMMUTABLE_SET:
      case ACCOUNT_MERGE_HAS_SUB_ENTRIES:
      case ACCOUNT_MERGE_SEQNUM_TOO_FAR:
      case ACCOUNT_MERGE_DEST_FULL:
      case ACCOUNT_MERGE_IS_SPONSOR:
        break;
    }
    return decodedAccountMergeResult;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.sourceAccountBalance, this.code);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof AccountMergeResult)) {
      return false;
    }

    AccountMergeResult other = (AccountMergeResult) object;
    return Objects.equal(this.sourceAccountBalance, other.sourceAccountBalance)
        && Objects.equal(this.code, other.code);
  }
}
