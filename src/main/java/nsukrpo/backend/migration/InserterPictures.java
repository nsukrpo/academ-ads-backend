package nsukrpo.backend.migration;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class InserterPictures {
    private final HttpClient client = HttpClient.newBuilder().build();;
    private final String path = "src/main/resources/assets/";
    private final String jpg = ".jpg";
    private String token;

    @EventListener(ApplicationReadyEvent.class)
    public void insertPhotos() throws IOException, URISyntaxException, InterruptedException {
        token = getAuthToken();
        insertPhoto("cow", 1L);
        insertPhoto("orange", 2L);
        insertPhoto("matanaliz", 3L);
        insertPhoto("terver", 4L);
        insertPhoto("pushkin", 5L);
        insertPhoto("grundig", 6L);
        insertPhoto("antidemidovich", 7L);
        insertPhoto("dollars", 8L);
        insertPhoto("kartofel", 9L);
    }

    private void insertPhoto(String photoName, Long ads) throws IOException, URISyntaxException, InterruptedException {
        File file = new File(path + photoName + jpg);
        String req = String.format("http://localhost:8080/media/photos?ads_id=%s", ads);
        HttpRequest request = HttpRequest.newBuilder(new URI(req))
                .POST(HttpRequest.BodyPublishers.ofFile(file.toPath()))
                .header("Content-Type", "image/jpg")
                .header("Authorization", token)
                .build();
        client.send(request, HttpResponse.BodyHandlers.discarding());
    }

    private String getAuthToken() throws URISyntaxException, IOException, InterruptedException {
        String jsonBody = "{\"login\": \"loginAdmin\", \"password\": \"password\"}";
        HttpRequest authRequest = HttpRequest.newBuilder(new URI("http://localhost:8080/login"))
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .header("Content-Type", "application/json").build();
        HttpResponse<String> response = client.send(authRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
