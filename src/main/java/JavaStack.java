import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaStack {

    public static void main(String []argh) {
        try(Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String input=sc.next();
                Map<Character,Integer> frequencies = new HashMap<>();
                for (char ch : input.toCharArray()) {
                    frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
                }

                boolean bracketsIndexes = input.indexOf('(') <= input.indexOf(')');
                boolean squareIndexes = input.indexOf('[') <= input.indexOf(']');
                boolean figureIndexes = input.indexOf('{') <= input.indexOf('}');

                boolean brackets = frequencies.getOrDefault('(', 0)
                        .equals(frequencies.getOrDefault(')', 0));
                boolean square = frequencies.getOrDefault('[', 0)
                        .equals(frequencies.getOrDefault(']', 0));
                boolean figure = frequencies.getOrDefault('{', 0)
                        .equals(frequencies.getOrDefault('}', 0));

                if(brackets && square && figure && bracketsIndexes && squareIndexes && figureIndexes) {
                    System.out.println(Boolean.TRUE);
                } else {
                    System.out.println(Boolean.FALSE);
                }
            }
        }
    }
}