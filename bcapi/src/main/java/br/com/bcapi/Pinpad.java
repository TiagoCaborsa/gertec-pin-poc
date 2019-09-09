package br.com.bcapi;

import java.util.Map;

public abstract class Pinpad {

    protected final Map<String, Object> properties;
    protected final Map<String, Object> runtimeProperties;

    public Pinpad(Map<String, Object> properties, Map<String, Object> runtimeProperties) {
        this.properties = properties;
        this.runtimeProperties = runtimeProperties;
    }

    public abstract int goOnChip(final String tags);
}
