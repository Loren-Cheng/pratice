package com.pratice.codeWars.string;

import java.util.List;

public class Sum_mixed_array_02 {
    public int sum(List<?> mixed) {
        int sum = 0;

        for(Object element: mixed){
            if(element instanceof Integer){
                sum += (int) element;
            } else if(element instanceof String){
                sum += Integer.parseInt((String) element);
            }
        }
        return sum;
    }
}
