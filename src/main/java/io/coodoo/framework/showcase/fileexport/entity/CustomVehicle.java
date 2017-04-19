package io.coodoo.framework.showcase.fileexport.entity;

import io.coodoo.framework.export.boundary.ExportReadable;

/**
 * Enum to demonstrate the usage of <strong>coodoo-file-export</strong> with the implementation of the {@link ExportReadable} interface.
 * 
 * @author coodoo GmbH (coodoo.io)
 */
public enum CustomVehicle implements ExportReadable {

    LIMOUSINE("Limousine"),

    STATION_WAGON("Kombi"),

    COUPE("Coupé"),

    CONVERTIBLE("Cabriolet"),

    SUV("Geländewagen"),

    VAN("Van"),

    MINIBUS("Minibus"),

    BOXTYPE_LORRY("Kastenwagen"),

    PLATFORM_LORRY("Pritschenwagen"),

    PICKUP("");

    private String exportValue;

    /**
     * @param exportValue Human readable representation of the enum value (in this case the German translation)
     */
    private CustomVehicle(String exportValue) {
        this.exportValue = exportValue;
    }

    @Override
    public String toExportValue() {
        return exportValue;
    }
}
