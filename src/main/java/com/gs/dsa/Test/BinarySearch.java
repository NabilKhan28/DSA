package com.gs.dsa.Test;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(getTheIndexOfTarget(new int[]{-1,0,3,5,9,12},9));
        System.out.println(getTheIndexOfTarget(new int[]{-1,0,3,5,9,12}, 2)); // -1

    }
    public static int getTheIndexOfTarget(int[] nums, int target){

        int left =0;
        int right = nums.length-1;
        //int mid =

        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}
