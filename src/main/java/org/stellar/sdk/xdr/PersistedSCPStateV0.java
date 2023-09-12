// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

// === xdr source ============================================================

//  struct PersistedSCPStateV0
//  {
//  	SCPEnvelope scpEnvelopes<>;
//  	SCPQuorumSet quorumSets<>;
//  	StoredTransactionSet txSets<>;
//  };

//  ===========================================================================
public class PersistedSCPStateV0 implements XdrElement {
  public PersistedSCPStateV0() {}

  private SCPEnvelope[] scpEnvelopes;

  public SCPEnvelope[] getScpEnvelopes() {
    return this.scpEnvelopes;
  }

  public void setScpEnvelopes(SCPEnvelope[] value) {
    this.scpEnvelopes = value;
  }

  private SCPQuorumSet[] quorumSets;

  public SCPQuorumSet[] getQuorumSets() {
    return this.quorumSets;
  }

  public void setQuorumSets(SCPQuorumSet[] value) {
    this.quorumSets = value;
  }

  private StoredTransactionSet[] txSets;

  public StoredTransactionSet[] getTxSets() {
    return this.txSets;
  }

  public void setTxSets(StoredTransactionSet[] value) {
    this.txSets = value;
  }

  public static void encode(
      XdrDataOutputStream stream, PersistedSCPStateV0 encodedPersistedSCPStateV0)
      throws IOException {
    int scpEnvelopessize = encodedPersistedSCPStateV0.getScpEnvelopes().length;
    stream.writeInt(scpEnvelopessize);
    for (int i = 0; i < scpEnvelopessize; i++) {
      SCPEnvelope.encode(stream, encodedPersistedSCPStateV0.scpEnvelopes[i]);
    }
    int quorumSetssize = encodedPersistedSCPStateV0.getQuorumSets().length;
    stream.writeInt(quorumSetssize);
    for (int i = 0; i < quorumSetssize; i++) {
      SCPQuorumSet.encode(stream, encodedPersistedSCPStateV0.quorumSets[i]);
    }
    int txSetssize = encodedPersistedSCPStateV0.getTxSets().length;
    stream.writeInt(txSetssize);
    for (int i = 0; i < txSetssize; i++) {
      StoredTransactionSet.encode(stream, encodedPersistedSCPStateV0.txSets[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static PersistedSCPStateV0 decode(XdrDataInputStream stream) throws IOException {
    PersistedSCPStateV0 decodedPersistedSCPStateV0 = new PersistedSCPStateV0();
    int scpEnvelopessize = stream.readInt();
    decodedPersistedSCPStateV0.scpEnvelopes = new SCPEnvelope[scpEnvelopessize];
    for (int i = 0; i < scpEnvelopessize; i++) {
      decodedPersistedSCPStateV0.scpEnvelopes[i] = SCPEnvelope.decode(stream);
    }
    int quorumSetssize = stream.readInt();
    decodedPersistedSCPStateV0.quorumSets = new SCPQuorumSet[quorumSetssize];
    for (int i = 0; i < quorumSetssize; i++) {
      decodedPersistedSCPStateV0.quorumSets[i] = SCPQuorumSet.decode(stream);
    }
    int txSetssize = stream.readInt();
    decodedPersistedSCPStateV0.txSets = new StoredTransactionSet[txSetssize];
    for (int i = 0; i < txSetssize; i++) {
      decodedPersistedSCPStateV0.txSets[i] = StoredTransactionSet.decode(stream);
    }
    return decodedPersistedSCPStateV0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        Arrays.hashCode(this.scpEnvelopes),
        Arrays.hashCode(this.quorumSets),
        Arrays.hashCode(this.txSets));
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof PersistedSCPStateV0)) {
      return false;
    }

    PersistedSCPStateV0 other = (PersistedSCPStateV0) object;
    return Arrays.equals(this.scpEnvelopes, other.scpEnvelopes)
        && Arrays.equals(this.quorumSets, other.quorumSets)
        && Arrays.equals(this.txSets, other.txSets);
  }

  @Override
  public String toXdrBase64() throws IOException {
    return Base64.getEncoder().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static PersistedSCPStateV0 fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64.getDecoder().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static PersistedSCPStateV0 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private SCPEnvelope[] scpEnvelopes;
    private SCPQuorumSet[] quorumSets;
    private StoredTransactionSet[] txSets;

    public Builder scpEnvelopes(SCPEnvelope[] scpEnvelopes) {
      this.scpEnvelopes = scpEnvelopes;
      return this;
    }

    public Builder quorumSets(SCPQuorumSet[] quorumSets) {
      this.quorumSets = quorumSets;
      return this;
    }

    public Builder txSets(StoredTransactionSet[] txSets) {
      this.txSets = txSets;
      return this;
    }

    public PersistedSCPStateV0 build() {
      PersistedSCPStateV0 val = new PersistedSCPStateV0();
      val.setScpEnvelopes(this.scpEnvelopes);
      val.setQuorumSets(this.quorumSets);
      val.setTxSets(this.txSets);
      return val;
    }
  }
}
