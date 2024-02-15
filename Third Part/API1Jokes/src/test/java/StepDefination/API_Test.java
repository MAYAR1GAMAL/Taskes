package StepDefination;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class API_Test
{
    @Test
    public Void RandomJoke()
    {
        System.out.println("**RandomJoke**");
        given().
                when()
                .get("https://official-joke-api.appspot.com/random_joke").
                then()
                .statusCode(200);
        return null;
    }
    @Test
    public Void RandomTenJoke()
    {
        System.out.println("**RandomTenJoke**");
        given()
                . when()
                .get("https://official-joke-api.appspot.com/random_ten")
                .then()
                .statusCode(200)
                .body("size()",equalTo(10));
        return null;
    }

    @Test
    public void JokeById()
    {
        System.out.println("**JokeById**");

        Response response = given()
                .when()
                .get("https://official-joke-api.appspot.com/jokes/random")
                .then()
                .statusCode(200)
                .extract().response();

        String jokeId = response.jsonPath().getString("id");

        given()
                .pathParam("id", jokeId)
                .when()
                .get("https://official-joke-api.appspot.com/jokes/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    public Void RandomJokeByType()
    {
        System.out.println("**RandomJokeByType**");
        given()
                .when()
                .pathParam("type", "programming")
                .when()
                .get("https://official-joke-api.appspot.com/jokes/{type}/random")
                .then()
                .statusCode(200)
                .body("type", equalTo("programming"));
        return null;
    }

    @Test
    public void JokeById2()
    {
        System.out.println("**JokeById2**");
        given()
                .pathParam("id", 20)
                .when()
                .get("https://official-joke-api.appspot.com/jokes/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(20));
    }
    @Test
    public void InvalidJoke()
    {
        System.out.println("**InvalidJoke**");
        given()
                .when()
                .get("https://official-joke-api.appspot.com/jokes/0")
                .then()
                .statusCode(404);
        //jokes is not defined the "Expected message"  or joke not found
    }
}
