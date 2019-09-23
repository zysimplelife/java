import java.math.BigInteger;
import java.util.*;

public class App {

    private static Map<Integer, Integer> map;
    private static Map<Integer, Integer> numbers;

    public static void main(String args[]) {
        numbers = new HashMap<>();

        numbers.put(0,0);
        numbers.put(1,1);
        numbers.put(2,2);
        numbers.put(5,5);
        numbers.put(6,9);
        numbers.put(8,8);
        numbers.put(9,6);

        map = new HashMap<>();

        map.put(0,0);
        map.put(1,1);
        map.put(2,2);
        map.put(5,3);
        map.put(6,4);
        map.put(8,5);
        map.put(9,6);

        Scanner in = new Scanner(System.in);
        String current = in.next();
        String number = in.next();


        List<Integer> cur = toIntList(current);
        List<Integer> my = toIntList(number);


        Collections.reverse(my);

        toReal7Values(cur);
        revertValue(my);
        toReal7Values(my);

        BigInteger value = calclulateDecValue(my).subtract(calclulateDecValue(cur));
        System.out.print(value);
    }

    private static List<Integer> toIntList(String value) {
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < value.length(); i++) {
            values.add(Character.getNumericValue(value.charAt(i)));
        }
        return values;
    }

    private static void toReal7Values(List<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            values.set(i,map.get(values.get(i)));
        }
    }

    private static void revertValue(List<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            values.set(i,numbers.get(values.get(i)));
        }
    }

    private static BigInteger calclulateDecValue(List<Integer> values) {
        Collections.reverse(values);
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < values.size(); i++) {
            sum = sum.add(BigInteger.valueOf(values.get(i)).multiply(BigInteger.valueOf(7).pow(i)));
        }
        return sum;
    }

}
