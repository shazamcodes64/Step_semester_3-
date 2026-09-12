package arrays.assigment_problems;

import java.util.HashMap;

/**
 * A4: Subarray Sum Equals K
 *
 * Count the number of contiguous subarrays whose elements sum to exactly k.
 * Solved using Prefix Sums + HashMap — O(n) time, O(n) space.
 *
 * Key insight:
 *   prefixSum[j] - prefixSum[i] = k  →  prefixSum[i] = prefixSum[j] - k
 *   So at each index j, we ask: how many earlier prefix sums equal (currentSum - k)?
 *   The HashMap stores (prefixSum → how many times it has been seen so far).
 *
 * Base case: seed the map with (0 → 1) to handle subarrays that start at index 0.
 *
 * Why sliding window doesn't work here:
 *   Sliding window relies on monotonic growth of the window sum.
 *   Negative numbers break that monotonicity — shrinking the window can increase
 *   or decrease the sum unpredictably, so there's no clean condition to move the
 *   left pointer.
 */
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix: sum 0 seen once

        int currentSum = 0;
        int count      = 0;

        for (int num : nums) {
            currentSum += num;

            // How many earlier prefixes, when removed, leave a subarray summing to k?
            int complement = currentSum - k;
            count += prefixCount.getOrDefault(complement, 0);

            // Record this prefix sum
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        // Expected: 2

        System.out.println("Test 2:");
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
        // Expected: 3
    }
}
