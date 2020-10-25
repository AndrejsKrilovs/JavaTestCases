import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    public PerformOperation isPrime() {
        return a -> {
            if (a <= 1)
                return Boolean.FALSE;
            if (a <= 3)
                return Boolean.TRUE;

            if (a % 2 == 0 || a % 3 == 0)
                return Boolean.FALSE;

            for (int i = 5; i * i <= a; i += 6)
                if (a % i == 0 || a % (i + 2) == 0)
                    return Boolean.FALSE;

            return Boolean.TRUE;
        };
    }

    public PerformOperation isPalindrome() {
        return a -> {
            String value = String.valueOf(a);
            int i = 0;
            int j = value.length() - 1;

            while (i < j) {
                if (value.charAt(i) != value.charAt(j))
                    return Boolean.FALSE;
                i++;
                j--;
            }

            return Boolean.TRUE;
        };
    }
}

public class JavaLambdaExpressions {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int string = Integer.parseInt(br.readLine());

        PerformOperation op;
        boolean ret;
        String ans = null;

        while (string-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
