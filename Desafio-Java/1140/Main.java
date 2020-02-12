import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader sReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(sReader);
        String bla = "";
        boolean flag;
        while (!bla.equals("*")) {
            flag = true;
            bla = buffer.readLine().toLowerCase();
            char base = bla.charAt(0);
            List<String> items = Arrays.asList(bla.split(" "));
            for (String string : items) {
                char teste = string.charAt(0);
                if (base != teste) {
                    flag = false;
                }
            }
            if (bla.equals("*")) {
                break;
            }
            if (flag) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }
}