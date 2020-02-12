import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader sReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(sReader);
        int n = Integer.parseInt(buffer.readLine());
        for (int i = 0; i < n; i++) {
            String resposta = "";
            String caso = buffer.readLine().trim();
            List<String> items = Arrays.asList(caso.split(" "));
            for (String string : items) {
                if (string.length() > 0)
                    resposta += string.charAt(0);
            }
            System.out.println(resposta);
        }
    }
}