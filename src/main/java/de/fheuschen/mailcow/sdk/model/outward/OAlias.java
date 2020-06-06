package de.fheuschen.mailcow.sdk.model.outward;

import de.fheuschen.mailcow.sdk.model.Alias;

/**
 * OAlias
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class OAlias extends OMailcowModel<Alias> {
    public OAlias(Alias m) {
        super(m);
    }

    @Override
    public OWrapper<? extends OMailcowModel<Alias>> wrap(String... items) {
        return null;
    }
}
