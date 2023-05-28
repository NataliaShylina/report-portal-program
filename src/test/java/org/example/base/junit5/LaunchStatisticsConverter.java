package org.example.base.junit5;

import org.example.domain.LaunchStatistics;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class LaunchStatisticsConverter implements ArgumentConverter {
    @Override
    public Object convert(Object o, ParameterContext parameterContext) throws ArgumentConversionException {
        if (!(o instanceof String)) {
            throw new ArgumentConversionException("Is not supported type for conversion");
        }

        try {
            String[] sources = ((String) o).split("/");

            return LaunchStatistics.builder()
                    .id(parseIntField(sources[0]))
                    .total(parseIntField(sources[1]))
                    .passed(parseIntField(sources[2]))
                    .failed(parseIntField(sources[3]))
                    .skipped(parseIntField(sources[4]))
                    .build();
        } catch (Exception e) {
            throw new ArgumentConversionException("Exceptions with parsing source", e);
        }
    }

    private static Integer parseIntField(String source) {
        return source == null || source.equals("null") ? null : Integer.parseInt(source);
    }
}
