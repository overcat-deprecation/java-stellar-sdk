package org.stellar.sdk;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import org.stellar.sdk.xdr.BumpFootprintExpirationOp;
import org.stellar.sdk.xdr.ExtensionPoint;
import org.stellar.sdk.xdr.OperationType;
import org.stellar.sdk.xdr.Uint32;

/**
 * Represents <a
 * href="https://developers.stellar.org/docs/fundamentals-and-concepts/list-of-operations#bump-footprint-expiration"
 * target="_blank">BumpFootprintExpiration</a> operation.
 *
 * <p>Bump the expiration of a footprint (read and written ledger keys).
 *
 * @see <a href="https://developers.stellar.org/docs/fundamentals-and-concepts/list-of-operations"
 *     target="_blank">List of Operations</a>
 */
public class BumpFootprintExpirationOperation extends Operation {
  private final int ledgersToExpire;

  private BumpFootprintExpirationOperation(int ledgersToExpire) {
    this.ledgersToExpire = ledgersToExpire;
  }

  public long getLedgersToExpire() {
    return ledgersToExpire;
  }

  @Override
  org.stellar.sdk.xdr.Operation.OperationBody toOperationBody(AccountConverter accountConverter) {
    BumpFootprintExpirationOp op = new BumpFootprintExpirationOp();
    op.setExt(new ExtensionPoint.Builder().discriminant(0).build());
    op.setLedgersToExpire(new Uint32(ledgersToExpire));

    org.stellar.sdk.xdr.Operation.OperationBody body =
        new org.stellar.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.BUMP_FOOTPRINT_EXPIRATION);
    body.setBumpFootprintExpirationOp(op);
    return body;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.getSourceAccount(), this.ledgersToExpire);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof BumpFootprintExpirationOperation)) {
      return false;
    }

    BumpFootprintExpirationOperation o = (BumpFootprintExpirationOperation) object;
    return Objects.equal(this.getLedgersToExpire(), o.getLedgersToExpire())
        && Objects.equal(this.getSourceAccount(), o.getSourceAccount());
  }

  public static class Builder {
    private final int ledgersToExpire;

    private String mSourceAccount;

    /**
     * Creates a new BumpFootprintExpiration builder using the specified parameters.
     *
     * @param op the XDR representation of the {@link BumpFootprintExpirationOp}.
     */
    Builder(BumpFootprintExpirationOp op) {
      ledgersToExpire = op.getLedgersToExpire().getUint32();
    }

    /**
     * Creates a new BumpFootprintExpiration builder using the specified parameters.
     *
     * @param ledgersToExpire the number of ledgers past the LCL (last closed ledger) by which to
     *     extend the validity of the ledger keys in this transaction
     */
    public Builder(int ledgersToExpire) {
      this.ledgersToExpire = ledgersToExpire;
    }

    /**
     * Sets the source account for this operation.
     *
     * @param sourceAccount The operation's source account.
     * @return Builder object so you can chain methods.
     */
    public Builder setSourceAccount(String sourceAccount) {
      mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
      return this;
    }

    /** Builds an operation */
    public BumpFootprintExpirationOperation build() {
      BumpFootprintExpirationOperation operation =
          new BumpFootprintExpirationOperation(this.ledgersToExpire);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }
}
