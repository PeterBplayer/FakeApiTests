import Model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PatchPostTest extends BaseTest {
    @Test
    public void patchPost() {
        Post newPost = new Post("Zaktualizowany tytuł");

        Post createdPost = given()
                                .spec(reqSpec)
                                .pathParam("postId", 6)
                                .body(newPost).
                           when()
                                .patch("{postId}").
                           then()
                                .spec(resSpec)
                                .extract().body().as(Post.class);

        assertEquals(createdPost.getTitle(), "Zaktualizowany tytuł");
        assertEquals(createdPost.getAuthor(), "Kasia");
    }
}
