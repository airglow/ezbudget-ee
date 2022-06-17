import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Util {

    public static HttpResponse<String> makeRequestAndGetResponse(String url) {

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static HttpResponse<String> makePostRequestAndGetResponse(String url, String requestBody) {

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
