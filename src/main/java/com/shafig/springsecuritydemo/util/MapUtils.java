package com.shafig.springsecuritydemo.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static <K,V> Map<K,V> generatePair(K key, V value) {
        var map = new HashMap<K,V>();
        map.put(key, value);
        return map;
    }
}
