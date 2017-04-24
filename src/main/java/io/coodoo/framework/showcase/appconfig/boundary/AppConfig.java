package io.coodoo.framework.showcase.appconfig.boundary;

import io.coodoo.framework.appconfig.boundary.AppConfigKey;
import io.coodoo.framework.appconfig.boundary.ValueType;

public enum AppConfig implements AppConfigKey {

    IMPORTANT_THINGS_ACTIVE(ValueType.BOOLEAN),

    IMPORTANT_THINGS(ValueType.LONG_LIST),

    SECRET(ValueType.STRING_ENCRYPTED),

    ;

    private AppConfig(ValueType type) {
        this.type = type;
    }

    private ValueType type;

    @Override
    public String getId() {
        return name();
    }

    @Override
    public ValueType getType() {
        return type;
    }
}
