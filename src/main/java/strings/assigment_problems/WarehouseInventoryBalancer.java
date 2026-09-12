package strings.assigment_problems;

/**
 * Problem 4: The Warehouse Inventory Balancer
 *
 * Compares total quantities of two equal-length inventory arrays,
 * reports balance status, and finds the highest quantity item across both.
 */
public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        int maxValue   = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex   = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];

            if (sectionA[i] > maxValue) {
                maxValue   = sectionA[i];
                maxSection = "Section A";
                maxIndex   = i + 1; // 1-based item number
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];

            if (sectionB[i] > maxValue) {
                maxValue   = sectionB[i];
                maxSection = "Section B";
                maxIndex   = i + 1; // 1-based item number
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + maxValue
                + " (" + maxSection + ", Item " + maxIndex + ")");
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});

        System.out.println("\nTest 2:");
        analyzeInventory(new int[]{10, 50, 20}, new int[]{30, 40, 10});
    }
}
