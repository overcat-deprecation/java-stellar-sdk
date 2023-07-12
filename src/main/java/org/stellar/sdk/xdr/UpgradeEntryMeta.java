// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import java.io.IOException;

// === xdr source ============================================================

//  struct UpgradeEntryMeta
//  {
//      LedgerUpgrade upgrade;
//      LedgerEntryChanges changes;
//  };

//  ===========================================================================
public class UpgradeEntryMeta implements XdrElement {
  public UpgradeEntryMeta() {}

  private LedgerUpgrade upgrade;

  public LedgerUpgrade getUpgrade() {
    return this.upgrade;
  }

  public void setUpgrade(LedgerUpgrade value) {
    this.upgrade = value;
  }

  private LedgerEntryChanges changes;

  public LedgerEntryChanges getChanges() {
    return this.changes;
  }

  public void setChanges(LedgerEntryChanges value) {
    this.changes = value;
  }

  public static void encode(XdrDataOutputStream stream, UpgradeEntryMeta encodedUpgradeEntryMeta)
      throws IOException {
    LedgerUpgrade.encode(stream, encodedUpgradeEntryMeta.upgrade);
    LedgerEntryChanges.encode(stream, encodedUpgradeEntryMeta.changes);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static UpgradeEntryMeta decode(XdrDataInputStream stream) throws IOException {
    UpgradeEntryMeta decodedUpgradeEntryMeta = new UpgradeEntryMeta();
    decodedUpgradeEntryMeta.upgrade = LedgerUpgrade.decode(stream);
    decodedUpgradeEntryMeta.changes = LedgerEntryChanges.decode(stream);
    return decodedUpgradeEntryMeta;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.upgrade, this.changes);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof UpgradeEntryMeta)) {
      return false;
    }

    UpgradeEntryMeta other = (UpgradeEntryMeta) object;
    return Objects.equal(this.upgrade, other.upgrade) && Objects.equal(this.changes, other.changes);
  }

  public static final class Builder {
    private LedgerUpgrade upgrade;
    private LedgerEntryChanges changes;

    public Builder upgrade(LedgerUpgrade upgrade) {
      this.upgrade = upgrade;
      return this;
    }

    public Builder changes(LedgerEntryChanges changes) {
      this.changes = changes;
      return this;
    }

    public UpgradeEntryMeta build() {
      UpgradeEntryMeta val = new UpgradeEntryMeta();
      val.setUpgrade(this.upgrade);
      val.setChanges(this.changes);
      return val;
    }
  }
}
