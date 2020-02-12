import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader sReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(sReader);
        int k = Integer.parseInt(buffer.readLine());
        int l = Integer.parseInt(buffer.readLine());
        if ((k >= 9 && l <= 8) || (k <= 8 && l >= 9)) {
          System.out.println("final");
        } else {
          if ((k >= 5 && l <= 4) || (k <= 12 && l >= 13) || (l >= 5 && k <= 4) || (l <= 12 && k >= 13)) {
            System.out.println("semifinal");
          } else {
            if ((k % 2 == 0 && k - 1 == l) || (k % 2 == 1 && k + 1 == l)) {
              System.out.println("oitavas");
            } else {
              System.out.println("quartas");
            }
          }
        }
    }
}