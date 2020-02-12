import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader sReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(sReader);
        int t = Integer.parseInt(buffer.readLine());
        int pa = 0, pb = 0;
        double g1 = 0, g2 = 0;
        for (int i = 0; i < t; i++) {
            String caso = buffer.readLine();
            List<String> items = Arrays.asList(caso.split(" "));
            pa = Integer.parseInt(items.get(0));
            pb = Integer.parseInt(items.get(1));
            g1 = Double.parseDouble(items.get(2)) / 100;
            g2 = Double.parseDouble(items.get(3)) / 100;
            int years = 0;
            while (pa <= pb) {
                pa += (pa * g1);
                pb += (pb * g2);
                years++;
                if (years > 100) {
                    break;
                }
            }
            if (years <= 100) {
                System.out.println(years + " anos.");
            } else {
                System.out.println("Mais de 1 seculo.");
            }
        }
    }
}