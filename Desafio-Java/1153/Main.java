import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader sReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(sReader);
        int n = Integer.parseInt(buffer.readLine());
        System.out.println(fatorial(n));
    }

    public static int fatorial(int n) {
        int fat = n;
        return n == 1 ? fat : (fat *= fatorial(n - 1));
    }
}