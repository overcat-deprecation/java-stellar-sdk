package org.stellar.sdk;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.stellar.sdk.xdr.*;

/**
 * Represents <a
 * href="https://developers.stellar.org/docs/fundamentals-and-concepts/list-of-operations#invoke-host-function"
 * target="_blank">InvokeHostFunction</a> operation.
 *
 * @see <a href="https://developers.stellar.org/docs/fundamentals-and-concepts/list-of-operations"
 *     target="_blank">List of Operations</a>
 */
public class InvokeHostFunctionOperation extends Operation {

  private final HostFunction hostFunction;
  private SorobanAuthorizationEntry[] auth;

  /**
   * Constructs a new InvokeHostFunctionOperation object using the specified parameters.
   *
   * @param hostFunction host function to execute (with its wrapped parameters)
   * @param auth the authorizations required to execute the host function
   */
  private InvokeHostFunctionOperation(HostFunction hostFunction, SorobanAuthorizationEntry[] auth) {
    this.hostFunction = hostFunction;
    this.auth = auth;
  }

  /**
   * Returns host function to execute (with its wrapped parameters).
   *
   * @return The host function to execute.
   */
  public HostFunction getHostFunction() {
    return hostFunction;
  }

  /**
   * Returns the authorizations required to execute the host function.
   *
   * @return The authorizations.
   */
  public SorobanAuthorizationEntry[] getAuth() {
    return auth;
  }

  /**
   * Sets the authorizations required to execute the host function.
   *
   * @param auth The authorizations.
   */
  public void setAuth(SorobanAuthorizationEntry[] auth) {
    this.auth = auth;
  }

  @Override
  org.stellar.sdk.xdr.Operation.OperationBody toOperationBody(AccountConverter accountConverter) {
    InvokeHostFunctionOp op = new InvokeHostFunctionOp();
    op.setHostFunction(this.hostFunction);
    op.setAuth(this.auth);

    org.stellar.sdk.xdr.Operation.OperationBody body =
        new org.stellar.sdk.xdr.Operation.OperationBody();
    body.setDiscriminant(OperationType.INVOKE_HOST_FUNCTION);
    body.setInvokeHostFunctionOp(op);

    return body;
  }

  /**
   * Builds InvokeHostFunction operation.
   *
   * @see InvokeHostFunctionOperation
   */
  public static class Builder {
    private final HostFunction hostFunction;
    private final SorobanAuthorizationEntry[] auth;

    private String mSourceAccount;

    /**
     * Creates a new InvokeHostFunction builder using the specified parameters.
     *
     * @param op the XDR representation of the {@link InvokeHostFunctionOperation}.
     */
    Builder(InvokeHostFunctionOp op) {
      this.hostFunction = op.getHostFunction();
      this.auth = op.getAuth();
    }

    /**
     * Creates a new InvokeHostFunction builder using the specified parameters.
     *
     * @param hostFunction host function to execute (with its wrapped parameters)
     * @param auth the authorizations required to execute the host function
     */
    public Builder(HostFunction hostFunction, SorobanAuthorizationEntry[] auth) {
      this.hostFunction = checkNotNull(hostFunction, "hostFunction cannot be null");
      this.auth = checkNotNull(auth, "auth cannot be null");
    }

    /**
     * Creates a new InvokeHostFunction builder using the specified parameters.
     *
     * @param hostFunction host function to execute (with its wrapped parameters)
     */
    public Builder(HostFunction hostFunction) {
      this.hostFunction = checkNotNull(hostFunction, "hostFunction cannot be null");
      this.auth = new SorobanAuthorizationEntry[] {};
    }

    /**
     * Set source account of this operation
     *
     * @param sourceAccount Source account
     * @return Builder object so you can chain methods.
     */
    public Builder setSourceAccount(String sourceAccount) {
      mSourceAccount = checkNotNull(sourceAccount, "sourceAccount cannot be null");
      return this;
    }

    /** Builds an operation */
    public InvokeHostFunctionOperation build() {
      InvokeHostFunctionOperation operation =
          new InvokeHostFunctionOperation(this.hostFunction, this.auth);
      if (mSourceAccount != null) {
        operation.setSourceAccount(mSourceAccount);
      }
      return operation;
    }
  }

  public int hashCode() {
    return Objects.hashCode(this.getSourceAccount(), hostFunction, Arrays.hashCode(auth));
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof InvokeHostFunctionOperation)) {
      return false;
    }

    InvokeHostFunctionOperation o = (InvokeHostFunctionOperation) object;
    return Objects.equal(this.getHostFunction(), o.getHostFunction())
        && Arrays.equals(this.getAuth(), o.getAuth())
        && Objects.equal(this.getSourceAccount(), o.getSourceAccount());
  }
}
