import jakarta.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Test;

import java.net.http.HttpResponse;

public class CityTest {

    @Test
    public void listOfCities() {

        String url = "http://localhost:8080/ezbudget-1.0-SNAPSHOT/api/cities";
        HttpResponse<String> response = Util.makeRequestAndGetResponse(url);

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.statusCode());
    }

}
