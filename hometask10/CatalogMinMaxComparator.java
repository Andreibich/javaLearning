package com.htp.hometask10;

import java.util.Comparator;
import java.util.Map;


public class CatalogMinMaxComparator implements Comparator<Map .Entry<String,Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
    }
}

