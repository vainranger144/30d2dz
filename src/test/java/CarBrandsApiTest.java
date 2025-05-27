import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;

public class CarBrandsApiTest {

    @Test
    public void testCarBrandsResponse() {
        Response response = RestAssured
                .given()
                .baseUri("https://qauto.forstudy.space")
                .basePath("/api/cars/brands")
                .when()
                .get();

        // Проверка статус-кода
        response.then().statusCode(200);


        assertThat(response.jsonPath().getList("data"), hasItem(
                allOf(
                        (Matcher<? super Map<String, Object>>) hasEntry("id", 1),
                        (Matcher<? super Map<String, Object>>) hasEntry("title", "Audi")
                )
        ));
    }
}
