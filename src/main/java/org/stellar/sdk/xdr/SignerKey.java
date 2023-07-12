// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  union SignerKey switch (SignerKeyType type)
//  {
//  case SIGNER_KEY_TYPE_ED25519:
//      uint256 ed25519;
//  case SIGNER_KEY_TYPE_PRE_AUTH_TX:
//      /* SHA-256 Hash of TransactionSignaturePayload structure */
//      uint256 preAuthTx;
//  case SIGNER_KEY_TYPE_HASH_X:
//      /* Hash of random 256 bit preimage X */
//      uint256 hashX;
//  case SIGNER_KEY_TYPE_ED25519_SIGNED_PAYLOAD:
//      struct
//      {
//          /* Public key that must sign the payload. */
//          uint256 ed25519;
//          /* Payload to be raw signed by ed25519. */
//          opaque payload<64>;
//      } ed25519SignedPayload;
//  };

//  ===========================================================================
public class SignerKey implements XdrElement {
  public SignerKey() {}

  SignerKeyType type;

  public SignerKeyType getDiscriminant() {
    return this.type;
  }

  public void setDiscriminant(SignerKeyType value) {
    this.type = value;
  }

  private Uint256 ed25519;

  public Uint256 getEd25519() {
    return this.ed25519;
  }

  public void setEd25519(Uint256 value) {
    this.ed25519 = value;
  }

  private Uint256 preAuthTx;

  public Uint256 getPreAuthTx() {
    return this.preAuthTx;
  }

  public void setPreAuthTx(Uint256 value) {
    this.preAuthTx = value;
  }

  private Uint256 hashX;

  public Uint256 getHashX() {
    return this.hashX;
  }

  public void setHashX(Uint256 value) {
    this.hashX = value;
  }

  private SignerKeyEd25519SignedPayload ed25519SignedPayload;

  public SignerKeyEd25519SignedPayload getEd25519SignedPayload() {
    return this.ed25519SignedPayload;
  }

  public void setEd25519SignedPayload(SignerKeyEd25519SignedPayload value) {
    this.ed25519SignedPayload = value;
  }

  public static final class Builder {
    private SignerKeyType discriminant;
    private Uint256 ed25519;
    private Uint256 preAuthTx;
    private Uint256 hashX;
    private SignerKeyEd25519SignedPayload ed25519SignedPayload;

    public Builder discriminant(SignerKeyType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder ed25519(Uint256 ed25519) {
      this.ed25519 = ed25519;
      return this;
    }

    public Builder preAuthTx(Uint256 preAuthTx) {
      this.preAuthTx = preAuthTx;
      return this;
    }

    public Builder hashX(Uint256 hashX) {
      this.hashX = hashX;
      return this;
    }

    public Builder ed25519SignedPayload(SignerKeyEd25519SignedPayload ed25519SignedPayload) {
      this.ed25519SignedPayload = ed25519SignedPayload;
      return this;
    }

    public SignerKey build() {
      SignerKey val = new SignerKey();
      val.setDiscriminant(discriminant);
      val.setEd25519(this.ed25519);
      val.setPreAuthTx(this.preAuthTx);
      val.setHashX(this.hashX);
      val.setEd25519SignedPayload(this.ed25519SignedPayload);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, SignerKey encodedSignerKey)
      throws IOException {
    // Xdrgen::AST::Identifier
    // SignerKeyType
    stream.writeInt(encodedSignerKey.getDiscriminant().getValue());
    switch (encodedSignerKey.getDiscriminant()) {
      case SIGNER_KEY_TYPE_ED25519:
        Uint256.encode(stream, encodedSignerKey.ed25519);
        break;
      case SIGNER_KEY_TYPE_PRE_AUTH_TX:
        Uint256.encode(stream, encodedSignerKey.preAuthTx);
        break;
      case SIGNER_KEY_TYPE_HASH_X:
        Uint256.encode(stream, encodedSignerKey.hashX);
        break;
      case SIGNER_KEY_TYPE_ED25519_SIGNED_PAYLOAD:
        SignerKeyEd25519SignedPayload.encode(stream, encodedSignerKey.ed25519SignedPayload);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SignerKey decode(XdrDataInputStream stream) throws IOException {
    SignerKey decodedSignerKey = new SignerKey();
    SignerKeyType discriminant = SignerKeyType.decode(stream);
    decodedSignerKey.setDiscriminant(discriminant);
    switch (decodedSignerKey.getDiscriminant()) {
      case SIGNER_KEY_TYPE_ED25519:
        decodedSignerKey.ed25519 = Uint256.decode(stream);
        break;
      case SIGNER_KEY_TYPE_PRE_AUTH_TX:
        decodedSignerKey.preAuthTx = Uint256.decode(stream);
        break;
      case SIGNER_KEY_TYPE_HASH_X:
        decodedSignerKey.hashX = Uint256.decode(stream);
        break;
      case SIGNER_KEY_TYPE_ED25519_SIGNED_PAYLOAD:
        decodedSignerKey.ed25519SignedPayload = SignerKeyEd25519SignedPayload.decode(stream);
        break;
    }
    return decodedSignerKey;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        this.ed25519, this.preAuthTx, this.hashX, this.ed25519SignedPayload, this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SignerKey)) {
      return false;
    }

    SignerKey other = (SignerKey) object;
    return Objects.equal(this.ed25519, other.ed25519)
        && Objects.equal(this.preAuthTx, other.preAuthTx)
        && Objects.equal(this.hashX, other.hashX)
        && Objects.equal(this.ed25519SignedPayload, other.ed25519SignedPayload)
        && Objects.equal(this.type, other.type);
  }

  public static class SignerKeyEd25519SignedPayload {
    public SignerKeyEd25519SignedPayload() {}

    private Uint256 ed25519;

    public Uint256 getEd25519() {
      return this.ed25519;
    }

    public void setEd25519(Uint256 value) {
      this.ed25519 = value;
    }

    private byte[] payload;

    public byte[] getPayload() {
      return this.payload;
    }

    public void setPayload(byte[] value) {
      this.payload = value;
    }

    public static void encode(
        XdrDataOutputStream stream,
        SignerKeyEd25519SignedPayload encodedSignerKeyEd25519SignedPayload)
        throws IOException {
      Uint256.encode(stream, encodedSignerKeyEd25519SignedPayload.ed25519);
      int payloadsize = encodedSignerKeyEd25519SignedPayload.payload.length;
      stream.writeInt(payloadsize);
      stream.write(encodedSignerKeyEd25519SignedPayload.getPayload(), 0, payloadsize);
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static SignerKeyEd25519SignedPayload decode(XdrDataInputStream stream)
        throws IOException {
      SignerKeyEd25519SignedPayload decodedSignerKeyEd25519SignedPayload =
          new SignerKeyEd25519SignedPayload();
      decodedSignerKeyEd25519SignedPayload.ed25519 = Uint256.decode(stream);
      int payloadsize = stream.readInt();
      decodedSignerKeyEd25519SignedPayload.payload = new byte[payloadsize];
      stream.read(decodedSignerKeyEd25519SignedPayload.payload, 0, payloadsize);
      return decodedSignerKeyEd25519SignedPayload;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(this.ed25519, Arrays.hashCode(this.payload));
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof SignerKeyEd25519SignedPayload)) {
        return false;
      }

      SignerKeyEd25519SignedPayload other = (SignerKeyEd25519SignedPayload) object;
      return Objects.equal(this.ed25519, other.ed25519)
          && Arrays.equals(this.payload, other.payload);
    }

    public static final class Builder {
      private Uint256 ed25519;
      private byte[] payload;

      public Builder ed25519(Uint256 ed25519) {
        this.ed25519 = ed25519;
        return this;
      }

      public Builder payload(byte[] payload) {
        this.payload = payload;
        return this;
      }

      public SignerKeyEd25519SignedPayload build() {
        SignerKeyEd25519SignedPayload val = new SignerKeyEd25519SignedPayload();
        val.setEd25519(this.ed25519);
        val.setPayload(this.payload);
        return val;
      }
    }
  }
}
