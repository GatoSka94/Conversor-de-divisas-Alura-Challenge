import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarConversion {
    public Dinero hacercoonversion(String base, String target, double cantidad) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/29824e65de0c0cc419a0a6e1/pair/" //Aqui el link integrado con su api key
                + base + "/" + target + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {

            HttpResponse<String> responseq = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(responseq.body(), Dinero.class);


        } catch (Exception e) {

            throw new RuntimeException("No se pudo hacer el cambio de moneda, " +
                    "por favor de colocar la moneda correctamente.");

        }
    }
}
