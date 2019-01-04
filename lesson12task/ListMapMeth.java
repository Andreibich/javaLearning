package com.htp.lesson12task;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ListMapMeth {

    public static List checkListCrossing(List<? extends Object> list1, List<? extends Object> list2) {
        List<? extends Object> list3 = new LinkedList<>();
        for (Object element1 : list1) {
            for (Object element2 : list2) {
                if (element1.equals(element2)) {
                    System.out.println(element2.toString());
                    list3.add(element1);
                }
            }
        }
        return list3;
    }

    public static Map mapAddMethod(Map<? extends Object, ? extends Object> map1, Map<? extends Object, ? extends Object> map2) {
        Map<Object, Object> map3 = new LinkedHashMap<>();
        map3.putAll(map1);
        map3.putAll(map2);
        for (Iterator it = map3.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(me.getKey() + ": " + me.getValue());
        }
        return map3;
    }
}
