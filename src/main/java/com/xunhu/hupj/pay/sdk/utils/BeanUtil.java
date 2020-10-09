package com.xunhu.hupj.pay.sdk.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 实体操作工具类
 *
 * @author wuhb
 */
public class BeanUtil {

    static final String FIELD_SIGN = "sign";

    public static Map<String, String> objectToMap(Object obj) {
        try {
            Map<String, String> map = new HashMap<>();

            if (obj instanceof Map) {
                Map objMap = (Map) obj;
                mapToMap(objMap, map);
            } else {
                Class<?> clazz = obj.getClass();

                objectToMap(obj, clazz, map);
            }
            return map;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void mapToMap(Map obj, Map<String, String> map) {

        for (Object k : obj.keySet()) {
            Object value = obj.get(k);
            String strValue = "";
            if (isBaseType(value)) {
                strValue = baseTypeToString(value);
            } else if (value instanceof Collection) {
                strValue = "[";
                Collection collection = (Collection) value;
                for (Object child : collection) {
                    if (isBaseType(child)) {
                        strValue += child.toString() + ",";
                    } else {
                        strValue += "{" + objectToSignString(child) + "},";
                    }
                }
                if (strValue.endsWith(",")) strValue = strValue.substring(0, strValue.length() - 1);
                strValue += "]";

            } else {
                strValue = "{" + objectToSignString(value) + "}";
            }
            map.put(k.toString(), strValue);
        }
    }

    public static void objectToMap(Object obj, Class<?> clazz, Map<String, String> map) {
        try {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(obj) == null) continue;
                String fieldName = field.getName();
                String value = "";

                Object val = field.get(obj);

                if (isBaseType(val)) {
                    value = baseTypeToString(val);
                } else if (field.getType().equals(List.class)) {
                    List lst = (List) val;
                    value = "[";
                    for (Object child : lst) {
                        if (isBaseType(child)) {
                            value += child.toString() + ",";
                        } else {
                            value += "{" + objectToSignString(child) + "},";
                        }
                    }
                    if (value.endsWith(",")) value = value.substring(0, value.length() - 1);
                    value += "]";
                } else {
                    value = "{" + objectToSignString(val) + "}";
                }
                map.put(fieldName, value);
            }
            if (!clazz.getSuperclass().equals(Object.class)) {
                objectToMap(obj, clazz.getSuperclass(), map);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String objectToSignString(Object obj) {
        if (obj == null) return "";
        if (isBaseType(obj)) return obj.toString();
        Map<String, String> map = objectToMap(obj);
        Set<String> keySet = map.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals(FIELD_SIGN)) {
                continue;
            }
            if (map.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(map.get(k).trim()).append("&");
        }
        String result = sb.toString();
//        if(result.endsWith("&"))result=result.substring(0,result.length()-1);
        return result;
    }

    public static boolean isBaseType(Class cls) {
        if (cls.equals(Integer.class) ||
                cls.equals(Byte.class) ||
                cls.equals(Long.class) ||
                cls.equals(Double.class) ||
                cls.equals(Float.class) ||
                cls.equals(Character.class) ||
                cls.equals(Short.class) ||
                cls.equals(Boolean.class) ||
                cls.equals(String.class) ||
                cls.equals(Date.class)) {
            return true;
        }
        return false;
    }

    public static boolean isBaseType(Object object) {
        Class cls = object.getClass();
        return isBaseType(cls);
    }

    public static String baseTypeToString(Object obj) {
        Class cls = obj.getClass();
        if (cls.equals(Integer.class)) {
            return Integer.toString((int) obj);
        } else if (cls.equals(Byte.class)) {
            return Byte.toString((byte) obj);
        } else if (cls.equals(Long.class)) {
            return Long.toString((long) obj);
        } else if (cls.equals(Double.class)) {
            return Double.toString((double) obj);
        } else if (cls.equals(Float.class)) {
            return Float.toString((float) obj);
        } else if (cls.equals(Character.class)) {
            return Character.toString((char) obj);
        } else if (cls.equals(Short.class)) {
            return Short.toString((short) obj);
        } else if (cls.equals(Boolean.class)) {
            return Boolean.toString((boolean) obj);
        } else if (cls.equals(String.class)) {
            return obj.toString();
        } else if (cls.equals(Date.class)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            return sdf.format((Date) obj);
        } else {
            return "";
        }
    }
}
