package org.stellar.sdk.responses.effects;

import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * @deprecated As of release 0.24.0, replaced by {@link TrustlineFlagsUpdatedEffectResponse}
 *     <p>Represents trustline_authorized effect response.
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect
 *     documentation</a>
 * @see org.stellar.sdk.requests.EffectsRequestBuilder
 * @see org.stellar.sdk.Server#effects()
 */
@Value
@EqualsAndHashCode(callSuper = true)
public class TrustlineAuthorizedEffectResponse extends TrustlineAuthorizationResponse {
  TrustlineAuthorizedEffectResponse(String trustor, String assetType, String assetCode) {
    super(trustor, assetType, assetCode);
  }
}
