import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {

        for (int i = 1; i <= 500; i++) {
            BigDecimal r = foo(i);
            System.out.printf("%d,%f \n", i, r);
            if (BigDecimal.valueOf(1).subtract(r).compareTo(BigDecimal.valueOf(0.5)) > 0) {
                System.out.println(r);
                System.out.println(i);
                break;
            }
        }
    }

    private static BigDecimal foo(int n) {
        if (n == 1) return new BigDecimal(1);

        MathContext mc = new MathContext(4, RoundingMode.HALF_DOWN);
        BigDecimal d = new BigDecimal(1);

        for (int i = 1; i < n; i++) {
            d = d.multiply(BigDecimal.valueOf(500 - i).divide(BigDecimal.valueOf(500), mc));
        }
        return d;
    }

}
