import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetAllPostsTest extends BaseTest{

    @Test
    public void getPost() {
        given()
                .spec(reqSpec).
        when()
                .get().
        then()
                .spec(resSpec)
                .assertThat().body("title[0]", equalTo("Pierwszy"))
                .assertThat().body("author[0]", equalTo("Bartek")).
        and()
                .assertThat().body("title[1]", equalTo("Drugi"))
                .assertThat().body("author[1]", equalTo("Tomek")).
        and()
                .assertThat().body("title[2]", equalTo("Trzeci"))
                .assertThat().body("author[2]", equalTo("Kasia"));
    }
}
