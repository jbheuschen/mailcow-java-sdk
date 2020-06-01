package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.model.MailcowModel;

/**
 * Builder
 * (marker interface for model builders)
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface Builder<P extends MailcowModel> extends ValidatedCreatingBuilder<P> {

}
