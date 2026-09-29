package com.uregina.geometry.solids;

import com.uregina.geometry.utils.LengthUnit;
import com.uregina.geometry.utils.UnitConverter;

public final class VolumeConverter {

    private VolumeConverter() {
    }

    public static double convert(double value, LengthUnit from, LengthUnit to) {
        double factor = UnitConverter.convertLength(1, from, to);
        return value * factor * factor * factor;
    }
}
