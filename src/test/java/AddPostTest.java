import Model.Post;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class AddPostTest extends BaseTest {
    @Test
    public void addPost() {
        Post newPost = new Post("Nowy", "Nieznany");

        Post createdPost = given()
                                .spec(reqSpec)
                                .body(newPost).
                           when()
                                .post().
                           then()
                                .statusCode(201)
                                .contentType(ContentType.JSON)
                                .extract().body().as(Post.class);

        assertEquals(createdPost, newPost);
    }
}
