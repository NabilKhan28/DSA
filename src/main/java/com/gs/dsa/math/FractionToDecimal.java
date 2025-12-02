
package com.gs.dsa.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert fraction to decimal; enclose repeating part in parentheses.
 * Edge cases: sign handling, long division remainder cycles, denominator=0.
 */
public final class FractionToDecimal {
    private FractionToDecimal() {}
    /** TODO: Implement long division with remainder-position map. */
    public static String fractionToDecimal(long numerator, long denominator) {

        if(denominator ==0) throw new IllegalArgumentException("Denominator should positive");
        if(numerator ==0 ) return "0";

        StringBuilder result = new StringBuilder();

        long remainder = numerator%denominator;
        System.out.println("remainder "+remainder);
        result.append(numerator/denominator);
        //System.out.println("eevu "+numerator/denominator);

        if(remainder ==0 ){
            return result.toString();
        }
        result.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while(remainder!=0){
            if(map.containsKey(remainder)){
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }
            map.put(remainder,result.length());

            remainder *= 10;
            result.append(remainder/denominator);

            remainder %= denominator;
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(fractionToDecimal(4,333));
    }
}
