package com.pratice.codeWars.string;

import java.util.List;

public class Sum_mixed_array_01 {
    public int sum(List<?> mixed) {
        int sum = 0;

        for(int i = 0; i <mixed.size(); i++){
            if(mixed.get(i).getClass().getName().equals("java.lang.String")){
                sum += Integer.valueOf((String) mixed.get(i));
            }else {
                sum += (int)mixed.get(i);
            }

        }
        return sum;
    }
}
