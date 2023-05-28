package org.example.utility;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Converter {

    public static String integerToString(Integer value) {
        return value == null ? null : String.valueOf(value);
    }
}
