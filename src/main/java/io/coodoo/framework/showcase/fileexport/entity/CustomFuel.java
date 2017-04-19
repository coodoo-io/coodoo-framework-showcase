package io.coodoo.framework.showcase.fileexport.entity;

import io.coodoo.framework.export.boundary.ExportReadable;

/**
 * Enum to demonstrate the usage of <strong>coodoo-file-export</strong> with the implementation of the {@link ExportReadable} interface.
 * 
 * @author coodoo GmbH (coodoo.io)
 */
public enum CustomFuel implements ExportReadable {

    GAS, DIESEL, LPG;

    /*
     * Human readable representation of the enum value (in this case the German translation)
     */
    @Override
    public String toExportValue() {
        switch (this) {
            case GAS:
                return "Benzin";
            case DIESEL:
                return "Diesel";
            case LPG:
                return "Autogas";
            default:
                return null;
        }
    }
}
