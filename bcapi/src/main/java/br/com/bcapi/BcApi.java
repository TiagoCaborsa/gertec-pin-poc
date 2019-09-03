package br.com.bcapi;

import java.util.Map;

public abstract class BcApi {

    protected final Map<String, Object> properties;

    public BcApi(Map<String, Object> properties) {
        this.properties = properties;
    }

    public abstract int goOnChip(final String tags);
}
