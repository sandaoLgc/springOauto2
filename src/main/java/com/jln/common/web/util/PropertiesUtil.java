package com.jln.common.web.util;

/**
 * @author 86180
 * @version : PropertiesUtil, v 0.1 2019/12/10 17:38
 */

import com.google.common.collect.Maps;

import java.util.Map;

public class PropertiesUtil {

    private static Map<String, String> map = Maps.newHashMap();
    private static PropertiesLoader loader = new PropertiesLoader(new String[]{"application-dev.properties"});

    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null) {
            value = loader.getProperty(key);
            map.put(key, value != null ? value : "");
        }
        return value;
    }

    public static Boolean isDebug() {
        String debug = getConfig("web.debug");
        return "true".equals(debug);
    }
}

