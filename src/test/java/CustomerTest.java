import jakarta.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Test;

import java.net.http.HttpResponse;

public class CustomerTest {

    @Test
    public void customerNotFound() {

        String url = "http://localhost:8080/ezbudget-1.0-SNAPSHOT/api/customers/0";
        HttpResponse<String> response = Util.makeRequestAndGetResponse(url);

        Assert.assertEquals(Response.Status.NOT_FOUND.getStatusCode(), response.statusCode());
    }

    @Test
    public void listOfCustomers() {

        String url = "http://localhost:8080/ezbudget-1.0-SNAPSHOT/api/customers";
        HttpResponse<String> response = Util.makeRequestAndGetResponse(url);

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.statusCode());
    }

}
