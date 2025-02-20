XDRS = xdr/Stellar-SCP.x \
xdr/Stellar-ledger-entries.x \
xdr/Stellar-ledger.x \
xdr/Stellar-overlay.x \
xdr/Stellar-transaction.x \
xdr/Stellar-types.x \
xdr/Stellar-contract-env-meta.x \
xdr/Stellar-contract-meta.x \
xdr/Stellar-contract-spec.x \
xdr/Stellar-contract.x \
xdr/Stellar-internal.x \
xdr/Stellar-contract-config-setting.x

XDRGEN_COMMIT=7c9349c62844e376bc637be678695387e88d125f
XDRNEXT_COMMIT=6a620d160aab22609c982d54578ff6a63bfcdc01

.PHONY: xdr xdr-clean xdr-update

xdr-generate: $(XDRS)
	docker run -it --rm -v $$PWD:/wd -w /wd ruby /bin/bash -c '\
		gem install specific_install -v 0.3.8 && \
		gem specific_install https://github.com/stellar/xdrgen.git -b $(XDRGEN_COMMIT) && \
		xdrgen \
			--language java \
			--namespace org.stellar.sdk.xdr \
			--output src/main/java/org/stellar/sdk/xdr/ \
			$(XDRS)'
	./gradlew :spotlessApply

xdr/%.x:
	curl -Lsf -o $@ https://raw.githubusercontent.com/stellar/stellar-xdr/$(XDRNEXT_COMMIT)/$(@F)

xdr-clean:
	rm xdr/*.x || true
	rm src/main/java/org/stellar/sdk/xdr/*.java || true

xdr-update: xdr-clean xdr-generate