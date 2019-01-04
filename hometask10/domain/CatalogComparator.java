package com.htp.hometask10.domain;

import java.util.Comparator;
import java.util.Map;

public class CatalogComparator implements Comparator<Map.Entry> {
    @Override
    public int compare(Map.Entry o1, Map.Entry o2) {
        return ((Comparable) o1.getValue()).compareTo(o2.getValue());
    }
}
