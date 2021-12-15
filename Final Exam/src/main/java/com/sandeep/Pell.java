package com.sandeep;

import java.util.HashMap;
import java.util.Map;

public class Pell {
    Map<Integer,Long> map;
    public Pell() {
        map = new HashMap<>();
    }

    public long get(int n) {
        if (n < 0) throw new UnsupportedOperationException("Pell.get is not supported for negative n");
        if (n<=2)
            return n;
        if (map.containsKey(n)) return map.get(n);

        long result = 2*get(n-1)+get(n-2);
        map.put(n,result);
        return result;
    }

}
