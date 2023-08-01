package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest extends TestBase {
    static ValidatableResponse response;

    public UserExtractionTest() {
        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Extract the All Ids
    @Test
    public void test001() {
        List<Integer> userIds = response.extract().path("id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + userIds );
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the all Names
    @Test
    public void test002() {
        List<String> allName = response.extract().path("name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allName );
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th object
    @Test
    public void test003() {
        String name = response.extract().path("[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + name );
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all object whose status = inactive
    @Test
    public void test004() {
        List<String> status = response.extract().path("findAll{it.status == 'inactive'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + status );
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the gender of all the object whose status = active
    @Test
    public void test005() {
        List<String> activeGender = response.extract().path("findAll{it.status == 'active'}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + activeGender );
        System.out.println("------------------End of Test---------------------------");
    }

    //6. Print the names of the object whose gender = female
    @Test
    public void test006() {
        List<String> femaleGender = response.extract().path("findAll{it.gender == 'female'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + femaleGender );
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the emails of the object where status = inactive
    @Test
    public void test007() {
        List<String> email = response.extract().path("findAll{it.status == 'inactive'}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + email );
        System.out.println("------------------End of Test---------------------------");
    }

    //8. Get the ids of the object where gender = male
    @Test
    public void test008() {
        List<String> ids = response.extract().path("findAll{it.gender == 'male'}.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + ids );
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the status
    @Test
    public void test009() {
        List<String> status = response.extract().path("status");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + status );
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get email of the object where name = Karthik Dubashi IV
    @Test
    public void test010() {
        List<String> emailName = response.extract().path("findAll{it.name == 'Bhupati Varrier VM'}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + emailName );
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get gender of id = 5471
    @Test
    public void test011() {
        List<String> genderId = response.extract().path("findAll{it.id == '4040679'}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + genderId );
        System.out.println("------------------End of Test---------------------------");
    }
}
