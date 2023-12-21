package org.prog;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONArray;
import org.prog.web.dto.PersonDto;
import org.prog.web.dto.SearchResultsDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;

public class RestTests {

    //якщо треба простий тест, який запрошує данні
    @Test
    public void simpleRestTest() {
        RestAssured.get("https://randomuser.me/api/?inc=gender,name,nat,location&noinfo").body().prettyPrint();
    }

    @Test
    public void basicRestTest() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc", "gender,name,nat,location"); //added location parameter
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results", "5");
        requestSpecification.basePath("/api/");
        requestSpecification.baseUri("https://randomuser.me/");

        Response response = requestSpecification.get();
        response.body().prettyPrint();
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);

        SearchResultsDto dto = response.as(SearchResultsDto.class);
        System.out.println(dto.getResults().size());
        List<PersonDto> persons = dto.getResults();

        for (PersonDto person : persons) {
            System.out.println(person.getName().getFirst() + " " + person.getName().getLast());
        }

        Assert.assertTrue(
                persons.stream().anyMatch(person -> person.getGender().equalsIgnoreCase("male")),
                "no male users generated!"
        );


//коли нам треба отримати якісь дані по одному параметру, коли решта параметрів нам невідомі

//        LinkedHashMap<String, String> userData0 =
//                JsonPath.parse(response.body().asString()).read("$.results[0]");
//        LinkedHashMap<String, String> userData1 =
//                JsonPath.parse(response.body().asString()).read("$.results[1]");
//        JSONArray userDataSpecific =
//                JsonPath.parse(response.body().asString()).read("$.results[?(@.gender=='female')]");
//        JSONArray mrsUserData =
//                JsonPath.parse(response.body().asString()).read("$..name[?(@.title=='Mrs')]");
//        System.out.println("1");
    }

}
