import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification reqSpec;
    protected ResponseSpecification resSpec;

    @BeforeClass
    public void setUp() {
        reqSpec = new RequestSpecBuilder().setBaseUri("http://localhost:3000")
                                           .setBasePath("posts")
                                           .setContentType(ContentType.JSON)
                                           .build();
        resSpec = new ResponseSpecBuilder().expectStatusCode(200)
                                           .expectContentType(ContentType.JSON)
                                           .build();
        RequestLoggingFilter reqLog = new RequestLoggingFilter();
        ResponseLoggingFilter resLog = new ResponseLoggingFilter();
        RestAssured.filters(resLog, resLog);
    }
}
