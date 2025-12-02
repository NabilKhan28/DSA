
package com.gs.dsa.math;

/**
 * Compute dot product of two equal-length integer arrays.
 * Edge cases: null inputs, length mismatch, overflow awareness.
 */
public final class DotProduct {
    private DotProduct() {}
    /** TODO: Validate inputs and sum products. */
    public static long dot(int[] a, int[] b) {
        if(a == null || b ==null){
            throw new IllegalArgumentException("cannot be null");
        }
        if(a.length != b.length){
            throw new IllegalArgumentException("Musthave the same length");
        }
        Long sum = 0L;
        for(int i=0; i<a.length; i++){
            sum += (long) a[i] *b[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        System.out.println(dot(a, b));
    }
}
