package main;

import annotations.CustomStringSerializable;
import annotations.SkipSerialization;
import annotations.Validator;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectTuCustomStringConverter {


    public static String convert(Object object) throws CustomStringSerializationException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        Map<String, String> objectElementsMap = new HashMap<>();
        if (!clazz.isAnnotationPresent(CustomStringSerializable.class)){
            throw new CustomStringSerializationException("კლასი "
                    + clazz.getSimpleName()
                    + "-ს გადაყავანა შეუძლებელია სპეციალურ სტრიქონში!");
        }
        if (object instanceof Figure){
            if(!((Figure) object).isValid()){
                throw new CustomStringSerializationException("კლასს "
                        + clazz.getSimpleName()
                        + "-ს ობიექტი არაა ვალიდური და შეუძლებელია მისი სპეციალურ სტრიქონში გადაყვანა!");
            }
        }
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(SkipSerialization.class)) {
                continue;
            }
            if (field.isAnnotationPresent(Validator.class)) {
                if(field.getAnnotation(Validator.class).min()!=1||
                        field.getAnnotation(Validator.class).max()!=Integer.MAX_VALUE) {
                    if ((double) field.get(object) < field.getAnnotation(Validator.class).min() ||
                            (double) field.get(object) > field.getAnnotation(Validator.class).max()) {
                        continue;
                    }
                }
            }
            objectElementsMap.put(field.getName(), field.get(object).toString());
        }
        String customString;
        customString = "[" + objectElementsMap.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "="
                        + entry.getValue())
                .collect(Collectors.joining(";")) + "]";
        return customString;
    }
}
