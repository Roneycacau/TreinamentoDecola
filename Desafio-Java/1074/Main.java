import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader sReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(sReader);
        int nCasosTeste, casoTeste;
        nCasosTeste = Integer.parseInt(buffer.readLine());
        for (int i = 0; i < nCasosTeste; i++) {
            String evenOdd = "", posiNeg = "";
            casoTeste = Integer.parseInt(buffer.readLine());
            if (casoTeste == 0) {
                System.out.println("NULL");
            } else {
                if (casoTeste % 2 == 0) {
                    evenOdd += "EVEN";
                } else {
                    evenOdd += "ODD";
                }
                if (casoTeste > 0) {
                    posiNeg += "POSITIVE";
                } else {
                    posiNeg += "NEGATIVE";
                }
                System.out.println(evenOdd + " " + posiNeg);
            }
        }
    }
}