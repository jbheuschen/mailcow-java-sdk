package de.fheuschen.mailcow.sdk.model;

import com.google.gson.annotations.SerializedName;
import de.fheuschen.mailcow.sdk.annotation.constraint.Min;
import de.fheuschen.mailcow.sdk.annotation.constraint.RequiredField;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.model.outward.OAlias;
import de.fheuschen.mailcow.sdk.model.outward.OMailcowModel;

/**
 * Alias
 * An alias is an alternative mail-address for a mailbox.
 * @see de.fheuschen.mailcow.sdk.builder.AliasBuilder
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Alias extends MailcowModel {

    public static final BaseClient.Endpoint<Alias> ENDPOINT = new BaseClient.Endpoint<Alias>() {
        @Override
        public String getEndpointUrl() {
            return "null";
        }

        @Override
        public String getEditEndpointUrl() {
            return "null";
        }

        @Override
        public String getDeleteEndpointUrl() {
            return "null";
        }

        @Override
        public String getAddEndpointUrl() {
            return "null";
        }
    };

    private String inPrimaryDomain;

    @RequiredField
    private String domain;

    @Min(min = 0)
    @RequiredField
    private int id;

    private String publicComment;

    private String privateComment;

    @RequiredField
    private String goTo;

    @RequiredField
    private String address;

    private int isCatchAll;

    @SerializedName("active_int")
    private int active;

    private String created;

    private String modified;

    /**
     * Marked as deprecated as no model should never be instantiated manually unless the resulting behavior is intended.
     * @see de.fheuschen.mailcow.sdk.builder.AliasBuilder
     */
    @Deprecated
    public Alias() {
        super(ENDPOINT);
    }

    public String getInPrimaryDomain() {
        return inPrimaryDomain;
    }

    public void setInPrimaryDomain(String inPrimaryDomain) {
        this.inPrimaryDomain = inPrimaryDomain;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublicComment() {
        return publicComment;
    }

    public void setPublicComment(String publicComment) {
        this.publicComment = publicComment;
    }

    public String getPrivateComment() {
        return privateComment;
    }

    public void setPrivateComment(String privateComment) {
        this.privateComment = privateComment;
    }

    public String getGoTo() {
        return goTo;
    }

    public void setGoTo(String goTo) {
        this.goTo = goTo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsCatchAll() {
        return isCatchAll;
    }

    public void setIsCatchAll(int isCatchAll) {
        this.isCatchAll = isCatchAll;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @Override
    public String getId() {
        return String.valueOf(id);
    }

    @Override
    public OAlias toOModel() {
        return new OAlias(this);
    }
}
