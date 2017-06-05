package com.salenko.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//Convert obj to K-V map
public class ObjToMapConverter {

    public static Map getKeyValueMap(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        Map fieldsMap = new HashMap<String, String>();

        for (Field field : fields) {
            field.setAccessible(true);
            fieldsMap.put(field.getName(), field.get(obj));
        }

        return fieldsMap;
    }
}
