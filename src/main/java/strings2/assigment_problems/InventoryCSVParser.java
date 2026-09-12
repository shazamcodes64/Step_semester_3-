package strings2.assigment_problems;

/**
 * Problem 3: Product Inventory CSV Parser
 *
 * Splits a CSV line of the form "ProductName,SKU,Quantity" into fields
 * and prints a formatted record. Rejects lines that don't have exactly 3 fields.
 */
public class InventoryCSVParser {

    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0];
        String sku         = fields[1];
        String quantity    = fields[2];

        System.out.println("Product: " + productName
                + " | SKU: " + sku
                + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        System.out.println("Test 2:");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
