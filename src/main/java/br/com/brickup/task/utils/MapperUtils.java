package br.com.brickup.task.utils;

import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperUtils {

    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    public static <S, T> T convert(S source, Class<T> typeTarget) {
        return modelMapper.map(source, typeTarget);
    }

    public static <S, T> T merge(S source, T target) {
        modelMapper.getConfiguration()
                .setPropertyCondition(Conditions.isNotNull());

        modelMapper.map(source, target);


        modelMapper.getConfiguration()
                .setPropertyCondition(Conditions.isNotNull());

        return target;
    }

    public static <S, T> List<T> convertList(List<S> listSource, Class<T> typeTarget) {
        return listSource != null && !listSource.isEmpty() ?
                listSource
                        .stream()
                        .map(entity -> convert(entity, typeTarget))
                        .collect(Collectors.toList())
                : null;
    }
}
