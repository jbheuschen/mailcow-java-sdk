package de.fheuschen.mailcow.sdk.model.outward;

import de.fheuschen.mailcow.sdk.model.MailcowModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ODeletePacket
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class ODeletePacket implements Packet, Wrapper<String[]> {

    private final transient List<String> items;

    public ODeletePacket(String... items) {
        this.items = Arrays.asList(items);
    }

    @Override
    public String[] getObjectForSerialization() {
        return items.toArray(new String[0]);
    }

    public ODeletePacket mergeWith(ODeletePacket other) {
        for(String s : other.getObjectForSerialization())
            if(!items.contains(s))
                items.add(s);
        return this;
    }
}
