package arrays.assigment_problems;

/**
 * A2: Maximum Subarray
 *
 * Find the contiguous subarray with the largest sum.
 * Solved using Kadane's Algorithm — O(n) time, O(1) space.
 *
 * Core idea at each index i:
 *   currentSum = max(nums[i], currentSum + nums[i])
 *   — if currentSum has gone negative, it's better to start fresh from nums[i].
 *   maxSum is updated whenever currentSum beats it.
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum     = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Extend the current subarray or start fresh from this element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum     = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        // Expected: 6  (subarray [4, -1, 2, 1])

        System.out.println("Test 2:");
        System.out.println(maxSubArray(new int[]{-3, -1, -2}));
        // Expected: -1 (all negative — best single element)
    }
}
