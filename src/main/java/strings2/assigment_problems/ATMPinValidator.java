package strings2.assigment_problems;

/**
 * Problem 1: ATM PIN Length Validator
 *
 * Checks that a PIN string is exactly 4 characters long using length().
 */
public class ATMPinValidator {

    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        checkPinLength("482");

        System.out.println("Test 2:");
        checkPinLength("4820");
    }
}
