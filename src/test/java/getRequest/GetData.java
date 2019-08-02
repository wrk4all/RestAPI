package getRequest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author UCF
 */
public class GetData {

    @Test
    public void testResponsecode() {
        Response resp = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
        int code = resp.getStatusCode();
        System.out.println("Status code is " + code);

        Assert.assertEquals(code, HttpStatus.SC_OK);
    }

    @Test
    public void testResponsecode1() {
        Response resp = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
        int code = resp.getStatusCode();
        System.out.println("Status code is " + code);

        Assert.assertEquals(code, HttpStatus.SC_FORBIDDEN);
    }

}
