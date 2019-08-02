package getRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import io.restassured.response.Response;
import java.util.List;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author UCF
 */
public class GetData {

    String token = "00D4B0000000iK2!AQ4AQJL5AlALALX72TFov9M5ii63UnyZk_PeL5Jaf.tOVk.ZIsUgGxRm7cgm2Qdn8QTwl3W4f58gD9lnE.Iwn2CkRTHtf4cS";

    String instanceUrl = "https://cs20.salesforce.com";

    @Test
    public void testShipToAddr() {
        Response resp = given().header("access_token", token).header("instance_url", instanceUrl).
                when().
                contentType("application/json").
                get("https://api.rootscan.app/v1/mobile/c1/sobjects/rstk__sohdr__c/action/new/rstk__solines__r/rstk__soline_oshiptoaddr__c");

        int code = resp.getStatusCode();
        String responseBody = resp.asString();
        System.out.println("======= \n Status code is " + code);
        System.out.println("======= \n Response body is " + responseBody);
        System.out.println("\n=======");

        Assert.assertEquals(code, HttpStatus.SC_OK);
    }

    @Test
    public void testSohdrContact() {
        Response resp = given().header("access_token", token).header("instance_url", instanceUrl).
                when().
                contentType("application/json").
                get("https://api.rootscan.app/v1/mobile/c1/sobjects/rstk__sohdr__c/action/new/rstk__sohdr_contact__c");
        int code = resp.getStatusCode();
        String responseBody = resp.asString();
        System.out.println("======= \n Status code is " + code);
        System.out.println("======= \n Response body is " + responseBody);
        System.out.println("\n=======");

        Assert.assertEquals(resp.jsonPath().getString("status"), HttpStatus.SC_OK);
    }
}
