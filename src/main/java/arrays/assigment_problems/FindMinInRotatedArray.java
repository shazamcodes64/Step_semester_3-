package arrays.assigment_problems;

/**
 * A5: Find Minimum in Rotated Sorted Array
 *
 * Find the minimum element in an array that was originally sorted ascending
 * but has been rotated at an unknown pivot. All elements are distinct.
 * Solved using Modified Binary Search — O(log n) time, O(1) space.
 *
 * Decision rule at each step:
 *   Compare nums[mid] with nums[right]:
 *   • If nums[mid] > nums[right] → the minimum is in the RIGHT half (left..mid is sorted and higher)
 *   • If nums[mid] < nums[right] → the minimum is in the LEFT half including mid (right side is sorted higher)
 *   Loop ends when left == right, which is the minimum.
 */
public class FindMinInRotatedArray {

    public static int findMin(int[] nums) {
        int left  = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // avoids integer overflow vs (left+right)/2

            if (nums[mid] > nums[right]) {
                // Mid is in the larger (left) portion — minimum must be to the right of mid
                left = mid + 1;
            } else {
                // Mid is in the smaller (right) portion — minimum is at mid or to its left
                right = mid;
            }
        }

        return nums[left]; // left == right == index of minimum
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        // Expected: 1

        System.out.println("Test 2:");
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        // Expected: 0

        System.out.println("Test 3 (no rotation):");
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
        // Expected: 11
    }
}
