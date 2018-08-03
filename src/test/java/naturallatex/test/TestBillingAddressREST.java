package naturallatex.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import naturallatex.boot.NaturalLatexApplication;
import naturallatex.entity.BillingAddress;

import org.json.JSONException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NaturalLatexApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestBillingAddressREST {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    public void findAll() throws JSONException {

        ResponseEntity<BillingAddress> response;
        response = restTemplate.getForEntity("/billingAddress", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson;
        responseJson = objectMapper.readTree(response.getBody());

        assertThat(responseJson.isMissingNode(), is(false));
        assertThat(responseJson.toString(), equalTo("[]"));
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/billingAddresses"),
//                HttpMethod.GET, entity, String.class);
//
//        String expected = "{}";
//
//        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void createBillingAddress() {

        BillingAddress address = new BillingAddress();
        address.setAddress("99 keyboard st");
        address.setCity("Sydney");
        address.setCompany("myCom");
        address.setCountry("Australia");
        address.setEmailAddress("samsam@hotmail.com");
        address.setFirstName("samsam");
        address.setLastName("www");
        address.setPhone("0433222333");
        address.setPostcode("2000");
        address.setState("ACT");

        HttpEntity<BillingAddress> entity = new HttpEntity<BillingAddress>(address, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/billingAddress"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        assertTrue(actual.contains("/billingAddress"));

    }
//
//    public static void main(String args[]) {
//        TestBillingAddressREST util = new TestBillingAddressREST();
//        //util.getArticleByIdDemo();
//        util.createBillingAddress();
//        //util.addArticleDemo();
////        util.updateArticleDemo();
//        //util.deleteArticleDemo();
//    }
}
