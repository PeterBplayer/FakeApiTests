import Model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdatePostTest extends BaseTest {
    @Test
    public void updatePost() {
        Post newPost = new Post("Nowy tytuł", "Nowy autor");

        Post createdPost = given()
                                .spec(reqSpec)
                                .pathParam("postId", 2)
                                .body(newPost).
                           when()
                                .put("{postId}").
                           then()
                                .spec(resSpec)
                                .extract().body().as(Post.class);

        assertEquals(createdPost, newPost);
    }
}
