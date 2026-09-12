package strings2.assigment_problems;

/**
 * Problem 4: Library ISBN Normalizer & Validator
 *
 * Normalizes a raw code string (trim + uppercase first 3 chars) then validates:
 *   - Exactly 13 characters
 *   - First 3 characters are letters (publisher code)
 *   - Remaining 10 characters are digits (year 4 + catalog 6)
 *
 * If valid, formats as: [PUBCODE] YEAR: 20XX | CATALOG: 123456
 * If invalid, prints the specific reason.
 */
public class LibraryISBNValidator {

    /**
     * Trims whitespace and uppercases the first 3 characters only.
     */
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed; // too short to normalize — validation will catch it
        }
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest    = trimmed.substring(3);
        return pubCode + rest;
    }

    /**
     * Validates the normalized code and returns a formatted string or an error message.
     */
    public static String validateAndFormat(String code) {
        // 1. Length check
        if (code.length() != 13) {
            return "Invalid: wrong length (expected 13, got " + code.length() + ")";
        }

        // 2. First 3 chars must be letters (publisher code)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // 3. Remaining 10 chars must be digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body characters must be digits";
            }
        }

        // Valid — build formatted output using StringBuilder
        String pubCode  = code.substring(0, 3);   // e.g. PEN
        String year     = code.substring(3, 7);   // e.g. 2026
        String catalog  = code.substring(7, 13);  // e.g. 004251

        StringBuilder display = new StringBuilder();
        display.append("[").append(pubCode).append("]")
               .append(" YEAR: ").append(year)
               .append(" | CATALOG: ").append(catalog);

        return display.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        String code1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(code1));

        System.out.println("Test 2:");
        String code2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(code2));

        System.out.println("Test 3 (wrong length):");
        String code3 = normalizeCode("PEN20260042");
        System.out.println(validateAndFormat(code3));
    }
}
