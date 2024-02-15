package StepDefination;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class API_G_Test
{
    @Test
    public void test_Genderize_Api()
    {
        given()
                .param("name", "peter")
                .when()
                .get("https://api.genderize.io")
                .then()
                .statusCode(200)
                .body("name", equalTo("peter"))
                .body("gender", equalTo("male"));
    }

    @Test
    public void test_Genderize_Api_With_Country()
    {
        given()
                .param("name", "kim")
                .param("country_id", "US")
                .when()
                .get("https://api.genderize.io")
                .then()
                .statusCode(200)
                .body("name", equalTo("kim"))
                .body("gender", equalTo("female"));
    }

    //https://api.genderize.io?name[]=peter&name[]=lois&name[]=stewie
    @Test
    public void test_Genderize_Api_multiple_names()
    {
        given()
                .param("name[]", "peter")
                .param("name[]", "lois")
                .param("name[]", "stewie")
                .when()
                .get("https://api.genderize.io")
                .then()
                .statusCode(200)
                .body("name[0]", equalTo("peter"))
                .body("gender[0]", equalTo("male"))
                .body("name[1]", equalTo("lois"))
                .body("gender[1]", equalTo("female"))
                .body("name[2]", equalTo("stewie"))
                .body("gender[2]", equalTo("male"));
    }
}
