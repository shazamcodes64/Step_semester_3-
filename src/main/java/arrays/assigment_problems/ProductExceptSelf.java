package arrays.assigment_problems;

import java.util.Arrays;

/**
 * A1: Product of Array Except Self
 *
 * For every index i, answer[i] = product of all elements EXCEPT nums[i].
 * No division allowed. Solved in O(n) time with O(1) extra space
 * (the output array itself is not counted as extra space).
 *
 * Approach — two passes:
 *   Forward pass : answer[i] holds the product of everything to the LEFT of i.
 *   Backward pass: multiply in the running product of everything to the RIGHT of i.
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // --- Forward pass ---
        // answer[i] = product of nums[0..i-1]
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // --- Backward pass ---
        // rightProduct tracks the running product of nums[i+1..n-1]
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;   // combine left prefix already stored with right suffix
            rightProduct *= nums[i];     // extend the right running product
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        // Expected: [24, 12, 8, 6]

        System.out.println("Test 2:");
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        // Expected: [0, 0, 9, 0, 0]
    }
}
