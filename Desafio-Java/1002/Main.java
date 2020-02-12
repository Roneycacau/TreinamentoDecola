import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader sReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(sReader);
        double pi, raio, area;
        pi = 3.14159;
        raio = Double.parseDouble(buffer.readLine());
        area = pi * (Math.pow(raio, 2));
        System.out.printf("A=%.4f\n", area);
    }
}