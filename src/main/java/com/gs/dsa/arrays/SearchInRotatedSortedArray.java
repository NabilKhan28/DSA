
package com.gs.dsa.arrays;

/**
 * Search target in a rotated sorted array (may contain duplicates).
 * Expected: O(log n) average using binary search; degrade gracefully on duplicates.
 * Edge cases: empty, single-element, ambiguous boundaries (l==mid==r), pivot near ends, negatives.
 */
public final class SearchInRotatedSortedArray {
    private SearchInRotatedSortedArray() {}
    /** TODO: Implement rotated binary search with duplicate handling. */
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target) return mid;

            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left ++;
                right --;
            }else if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else{
                if(nums[right] >= target && target > nums[mid]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }

        }

        return -1; // placeholder to force test failure

    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums1, 0)); // 4

        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(search(nums2, 0)); // 3 or 4

        int[] nums3 = {1, 0, 1, 1, 1};
        System.out.println(search(nums3, 0)); // 1

        int[] nums4 = {1, 3};
        System.out.println(search(nums4, 3)); // 1
    }
}
