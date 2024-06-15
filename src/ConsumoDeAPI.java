import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoDeAPI {
    public String obtenerURL(String monedaBase, String monedaFinal, double monto){

        String key = "0a74bef745ccd8d94d2c87f7";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" +key
                +"/pair/"+monedaBase
                +"/"+monedaFinal
                +"/"+monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }
}
