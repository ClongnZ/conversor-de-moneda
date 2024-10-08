import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda hacerConsulta(String codigoBase, String codigoDestino){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/efd9e079306fe9ed95813c67/pair/"+codigoBase+"/"+codigoDestino);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moneda.class);

        }catch (Exception e){
            throw  new RuntimeException("Moneda no encontrada.");
        }
    }
}
