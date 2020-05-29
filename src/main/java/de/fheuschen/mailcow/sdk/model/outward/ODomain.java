package de.fheuschen.mailcow.sdk.model.outward;

import de.fheuschen.mailcow.sdk.model.Domain;

import java.util.Arrays;

/**
 * ODomain
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class ODomain extends OMailcowModel<Domain> {

    String active, gal, relayhost, backupmx, description, maxquota;

    public ODomain(Domain m) {
        super(m);
        this.active = String.valueOf(m.getActiveInt());
        this.gal = String.valueOf(m.getGal());
        this.relayhost = String.valueOf(m.getRelayhost());
        this.backupmx = String.valueOf(m.getBackupmxInt());
        this.description = m.getDescription();
        this.maxquota = String.valueOf(m.getMaxQuotaForDomain());
    }

    @Override
    public OWrapper<? extends OMailcowModel<Domain>> wrap(String... items) {
        return new OWrapper<>(Arrays.asList(items), this);
    }


}
