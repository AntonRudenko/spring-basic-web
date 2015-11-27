package ru.teamlabs.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dark on 26.03.15.
 */
public class MaxSizeHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int maxSize;

    public MaxSizeHashMap(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }

    public static void main(String[] args) {
        MaxSizeHashMap<String, String> map = new MaxSizeHashMap<>(3);

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        System.out.println(map.get("1"));
        map.put("4", "4");
        System.out.println(map);
        System.out.println(map.get("1"));

    }
}
