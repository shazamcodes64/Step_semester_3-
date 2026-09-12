package arrays.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A3: 3Sum
 *
 * Find all unique triplets in the array that sum to zero.
 * Solved using Sort + Two-Pointer — O(n²) time, O(1) extra space.
 *
 * Approach:
 *   1. Sort the array.
 *   2. For each index i (the fixed left anchor), place two pointers:
 *      left = i + 1, right = n - 1.
 *   3. Move pointers inward based on whether the three-way sum is
 *      too small, too large, or exactly zero.
 *   4. Skip duplicate values at every level to avoid duplicate triplets.
 */
public class ThreeSum {

    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the anchor element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Early exit: if the smallest possible triplet is positive, no solution exists
            if (nums[i] > 0) {
                break;
            }

            int left  = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;   // need a larger sum
                } else {
                    right--;  // need a smaller sum
                }
            }
        }

        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        int[][] res1 = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (int[] triplet : res1) {
            System.out.println(Arrays.toString(triplet));
        }
        // Expected: [-1, -1, 2] and [-1, 0, 1]

        System.out.println("Test 2:");
        int[][] res2 = threeSum(new int[]{0, 0, 0});
        for (int[] triplet : res2) {
            System.out.println(Arrays.toString(triplet));
        }
        // Expected: [0, 0, 0]
    }
}
