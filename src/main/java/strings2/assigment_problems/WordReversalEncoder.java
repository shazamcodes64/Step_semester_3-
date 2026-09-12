package strings2.assigment_problems;

/**
 * Problem 2: Word Reversal Encoder
 *
 * Reverses each word individually in a sentence while keeping word order intact.
 * e.g. "hello club" -> "olleh bulc"
 */
public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Reverse the current word using StringBuilder
            StringBuilder reversed = new StringBuilder(words[i]).reverse();
            result.append(reversed);

            // Add a space between words, but not after the last one
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        System.out.println(reverseEachWord("hello club"));

        System.out.println("Test 2:");
        System.out.println(reverseEachWord("java is fun"));
    }
}
