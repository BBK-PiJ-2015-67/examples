import java.util.Optional;

/**
 * Example class to illustrate the uses of {@code java.util.Optional}
 *
 * @author lmignot
 */
public class OptionalExample {

    private static String someAvailableData = "This is a test string";

    public static void main(String... args) {
        // this is rather useless since we KNOW the field contains a string
        Optional a = getData(someAvailableData);
        if(a.isPresent()) System.out.println("a: " + a.get()); // output: "a: This is a test string"

        // Next 2 are better example usees of Optional,
        // test if a condition is true and get a value

        Optional b = getIfConditionIsMet(false, "Doesn't matter");
        // this never runs since b.isPresent() == false
        if(b.isPresent()) System.out.println("b: " + b.get()); // output: nothing

        Optional c = getIfConditionIsMet(true, "My optional value");
        if(c.isPresent()) System.out.println("c: " + c.get()); // output: "c: My optional value"
    }

    private static Optional getData(String s) {
        return Optional.of(s);
    }

    private static Optional getIfConditionIsMet(boolean condition, String value) {
        return condition ? Optional.of(value) : Optional.empty();
    }
}
