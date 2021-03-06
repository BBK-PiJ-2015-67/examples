/**
 * @author lmignot
 */
public class Numbers {

    public static void main(String[] args) {
        System.out.println(toHex(16581375));
        System.out.println(toBinary(147));
    }

    /**
     * Convert a string representing a number to it's HEX counterpart.
     *
     * <cite>Original author assumed to be Keith Mannock, taken from provided notes</cite>
     *
     * @param num the number to convert to Hex
     * @return the hex counterpart to the provided number as a string
     */
    public static String toHex(int num) {
        StringBuilder str = new StringBuilder();

        // Digits in hexadecimal number system
        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while (num > 0) {
            str.append(hex[num % 16]);
            num = num / 16;
        }
        return str.reverse().toString();
    }

    /**
     * Convert a string representing a number to it's binary counterpart.
     *
     * Adapted from above toHex() method
     *
     * @param num the number to convert to Hex
     * @return the binary counterpart to the provided number as a string
     */
    public static String toBinary(int num) {
        StringBuilder sb = new StringBuilder();
        char bin[] = {'0', '1'};

        while (num > 0) {
            sb.append(bin[num % 2]);
            num = num / 2;
        }
        return sb.reverse().toString();
    }
}
