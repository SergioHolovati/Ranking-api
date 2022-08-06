package com.games.ranking.core.util;
import com.games.ranking.api.models.entity.ResumeEntity;
import com.games.ranking.api.models.response.ResumeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.modelmapper.Conditions.isNotNull;

@Component
public class GenericMapper {

    private static ModelMapper mapper;

    @Deprecated
    public <T> T convert(Object object, Class<T> clazz) {
        return mapper.map(object, clazz);
    }


    public static <T> List<T> converterCollection(List<?> objects, Class<T> clazz) {
        return objects.stream()
                .map(obj -> converter(obj, clazz))
                .collect(toList());
    }

    public static <T> T converter(Object object, Class<T> clazz) {
        return mapper().map(object, clazz);
    }

    @Deprecated
    public <T> List<T> convertCollection(List<?> objects, Class<T> clazz) {
        return objects.stream()
                .map(obj -> convert(obj, clazz))
                .collect(toList());
    }



    private static ModelMapper mapper() {
        if( mapper == null ){
            mapper = new ModelMapper();
            mapper.getConfiguration().setPropertyCondition(isNotNull());
        }

        return mapper;
    }

}