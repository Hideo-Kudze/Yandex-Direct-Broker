package com.HideoKuzeGits.YndexDirectAutobroker.utm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 16.09.14.
 */
public class OrderedMap extends HashMap<Object, Integer> {

    private  Integer position = 0;



    public Integer put(Object key) {


        if (containsKey(key))
            return get(key);

        Integer currentPosition = position;
        put(key, currentPosition);
        position++;

        return currentPosition;
    }
}
