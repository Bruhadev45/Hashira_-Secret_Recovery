import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem {
    public static void main(String[] args) throws Exception {
        JSONObject testcase1 = new JSONObject(new JSONTokener(new FileReader("testcase1.json")));
        JSONObject testcase2 = new JSONObject(new JSONTokener(new FileReader("testcase2.json")));

        BigInteger secret1 = findSecret(testcase1);
        BigInteger secret2 = findSecret(testcase2);

        System.out.println("Secret for Test Case 1: " + secret1);
        System.out.println("Secret for Test Case 2: " + secret2);
    }

    static BigInteger findSecret(JSONObject data) {
        JSONObject keys = data.getJSONObject("keys");
        int k = keys.getInt("k");

        List<Point> points = new ArrayList<>();
        for (String key : data.keySet()) {
            if (key.equals("keys")) continue;

            int x = Integer.parseInt(key);
            JSONObject pointObj = data.getJSONObject(key);
            int base = Integer.parseInt(pointObj.getString("base"));
            String valueStr = pointObj.getString("value");

            BigInteger y = new BigInteger(valueStr, base);
            points.add(new Point(BigInteger.valueOf(x), y));
        }

        points.sort(Comparator.comparing(p -> p.x));

        List<Point> selected = points.subList(0, k);

        return lagrangeAtZero(selected);
    }

    static BigInteger lagrangeAtZero(List<Point> points) {
        BigInteger result = BigInteger.ZERO;

        for (int j = 0; j < points.size(); j++) {
            BigInteger xj = points.get(j).x;
            BigInteger yj = points.get(j).y;
            BigInteger numerator = BigInteger.ONE;
            BigInteger denominator = BigInteger.ONE;

            for (int m = 0; m < points.size(); m++) {
                if (m == j) continue;
                BigInteger xm = points.get(m).x;
                numerator = numerator.multiply(xm.negate());
                denominator = denominator.multiply(xj.subtract(xm));
            }

            BigInteger term = yj.multiply(numerator).divide(denominator);
            result = result.add(term);
        }

        return result;
    }

    static class Point {
        BigInteger x, y;

        Point(BigInteger x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }
}