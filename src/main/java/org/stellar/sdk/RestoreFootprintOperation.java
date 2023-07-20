package org.stellar.sdk;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import org.stellar.sdk.xdr.ExtensionPoint;
import org.stellar.sdk.xdr.OperationType;
import org.stellar.sdk.xdr.RestoreFootprintOp;

/**
 * Represents <a
 * href="https://developers.stellar.org/docs/fundamentals-and-concepts/list-of-operations#restore-footprint"
 * target="_blank">BumpFootprintExpiration</a> operation.
 *
 * @see <a href="https://developers.stellar.org/docs/fundamentals-and-concepts/list-of-operations"
 *     target="_blank">List of Operations</a>
 */
public class RestoreFootprintOperation extends Operation {
  /** Constructs a new RestoreFootprintOperation object. */
  public RestoreFootprintOperation() {}

  /**
   * Constructs a new RestoreFootprintOperation object with the given source account.
   *
   * @param sourceAccount The operation's source account.
   */
  public RestoreFootprintOperation(String sourceAccount) {
    setSourceAccount(checkNotNull(sourceAccount, "sourceAccount cannot be null"));
  }

  @Override
  org.stellar.sdk.xdr.Operation.OperationBody toOperationBody(AccountConverter accountConverter) {
    RestoreFootprintOp op = new RestoreFootprintOp();
    op.setExt(new ExtensionPoint.Builder().discriminant(0).build());

    org.stellar.sdk.xdr.Operation.OperationBody body =
        new org.stellar.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.RESTORE_FOOTPRINT);
    body.setRestoreFootprintOp(op);
    return body;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.getSourceAccount());
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof RestoreFootprintOperation)) {
      return false;
    }

    RestoreFootprintOperation other = (RestoreFootprintOperation) object;
    return Objects.equal(this.getSourceAccount(), other.getSourceAccount());
  }
}
