// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  typedef AccountID* SponsorshipDescriptor;

//  ===========================================================================
public class SponsorshipDescriptor implements XdrElement {
  private AccountID SponsorshipDescriptor;
  public AccountID getSponsorshipDescriptor() {
    return this.SponsorshipDescriptor;
  }
  public void setSponsorshipDescriptor(AccountID value) {
    this.SponsorshipDescriptor = value;
  }
  public static void encode(XdrDataOutputStream stream, SponsorshipDescriptor  encodedSponsorshipDescriptor) throws IOException {
  if (encodedSponsorshipDescriptor.SponsorshipDescriptor != null) {
  stream.writeInt(1);
  AccountID.encode(stream, encodedSponsorshipDescriptor.SponsorshipDescriptor);
  } else {
  stream.writeInt(0);
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static SponsorshipDescriptor decode(XdrDataInputStream stream) throws IOException {
    SponsorshipDescriptor decodedSponsorshipDescriptor = new SponsorshipDescriptor();
  int SponsorshipDescriptorPresent = stream.readInt();
  if (SponsorshipDescriptorPresent != 0) {
  decodedSponsorshipDescriptor.SponsorshipDescriptor = AccountID.decode(stream);
  }
    return decodedSponsorshipDescriptor;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.SponsorshipDescriptor);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof SponsorshipDescriptor)) {
      return false;
    }

    SponsorshipDescriptor other = (SponsorshipDescriptor) object;
    return Objects.equal(this.SponsorshipDescriptor, other.SponsorshipDescriptor);
  }
}
