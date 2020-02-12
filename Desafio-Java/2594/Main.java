import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader sReader = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(sReader);
        int textqtd = Integer.parseInt(buffer.readLine());
        for (int vrau = 0; vrau < textqtd; vrau++) {
            String text = buffer.readLine();
            List<String> campo = Arrays.asList(text.split(" "));
            String palavra = buffer.readLine();
            // List<String> termos = Arrays.asList(palavra.split(" "));

            // for (String buscado : termos) {
                int posicao = 0;
                String resposta = "";
                for (int i = 0; i < campo.size(); i++) {
                    if (campo.get(i).equals(palavra)) {
                        resposta += " " + posicao;
                    }
                    posicao += campo.get(i).length() + 1;
                }
                if (resposta.equals("")) {
                    System.out.println(-1);
                } else {
                    System.out.println(resposta.trim());
                }
            // }
        }
    }
}