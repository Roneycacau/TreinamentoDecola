import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        int a, b;
        InputStreamReader sReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(sReader);

        a = Integer.parseInt(buffer.readLine());
        b = Integer.parseInt(buffer.readLine());
        System.out.println("X = " + (a + b));
    }
}