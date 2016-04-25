import java.util.*;

/**
 * Example class to illustrate the uses of {@code java.util.Optional}
 * in the Java 8 streams API
 *
 * @author lmignot
 */
public class StreamExamples {

    public static void main(String[] args) {
        String[] arr = {"dog", "cow", "hog", "cat", "duck", "bee", "bat", "badger", "horse", "frog"};
        List<String> data = Arrays.asList(arr);

        Optional fourLetterWord = optionalGetAnyWordOfLength(data, 4);
        if (fourLetterWord.isPresent()) System.out.println("Random 4-letter word: " + fourLetterWord.get());

        String threeLetterWord = getAnyWordOfLength(data, 3);
        System.out.println("Random 3-letter word: " + threeLetterWord);

        // this is fine, we KNOW there is a 5-letter word, but it's bad practice
        // see the next attempt
        String ok = getWhatever(data, 5);
        System.out.println("Random 5-letter word: " + ok);

        // this will throw an exception as there are no 2-letter words in the list
        // you can make it work as below with a try/catch, but it's ugly
        // optional just makes it easier to work with
        String bad;
        try {
            bad = getWhatever(data, 2);
            System.out.println("Random 2-letter word: " + bad);
        } catch (NoSuchElementException ex) {
            // print a stack track or do something
        }

        String maybeNull = getWordThatMightBeNullOfLength(data, 2);
        // prints null, yuck. Also if you try to work with the
        // string, you'll get a NullPointerException
        System.out.println("Random 2-letter word: " + maybeNull);

        // uncomment below to throw an NPE
        // System.out.println(maybeNull.length());
    }

    private static String getWordThatMightBeNullOfLength(List<String> data, int l) {
        return data.stream().filter(i -> i.length() == l).findAny().orElse(null);
    }

    private static Optional<String> optionalGetAnyWordOfLength(List<String> data, int l) {
        return data.stream().filter(i -> i.length() == l).findAny();
    }

    private static String getAnyWordOfLength(List<String> data, int l) {
        return data.stream().filter(i -> i.length() == l).findAny().orElse(null);
    }

    private static String getWhatever(List<String> data, int l) {
        return data.stream().filter(i -> i.length() == l).findAny().get();
    }
}
