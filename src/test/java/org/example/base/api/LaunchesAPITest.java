package org.example.base.api;

import io.restassured.RestAssured;
import org.example.dto.Attribute;
import org.example.dto.BulkInfoUpdateRequest;
import org.example.dto.BulkInfoUpdateResponse;
import org.example.dto.CreateClusterResponse;
import org.example.dto.CreateClustersRequest;
import org.example.dto.Description;
import org.example.dto.Error;
import org.example.dto.Launch;
import org.example.dto.LaunchList;
import org.example.dto.Page;
import org.example.dto.Pair;
import org.example.dto.Statistics;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class LaunchesAPITest {
    @Test
    void getListOfProjectLaunches() {
        String bearerToken = "985a0930-464f-421a-985f-4fb4b755b195";
        String existingProjectName = "superadmin_personal";

        LaunchList launchList = RestAssured.given()
                .pathParam("projectName", existingProjectName)
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get("http://localhost:8080/api/v1/{projectName}/launch")
                .as(LaunchList.class);

        Page expectedPage = new Page(1, 20, 3, 1);
        Launch launch = Launch.builder()
                .owner("superadmin")
                .share(false)
                .id(11)
                .uuid("73d15411-1056-42de-9a30-01f5b85b8da2")
                .name("doc for launcher")
                .number(1)
                .startTime(1686195489255L)
                .lastModified(1686195489266L)
                .status("INTERRUPTED")
                .statistics(Statistics.builder().defects(new Object()).executions(new Object()).build())
                .attributes(new ArrayList<>())
                .mode("DEFAULT")
                .analysing(new ArrayList<>())
                .approximateDuration(0)
                .hasRetries(false)
                .rerun(false)
                .build();

        assertThat(launchList.getPage(), equalTo(expectedPage));
        assertThat(launchList.getContent(), hasSize(3));
        assertThat(launchList.getContent().stream().filter(x -> x.getId() == 11).findAny().get(), equalTo(launch));
    }

    @Test
    void getListOfProjectLaunchesWithInvalidProjectName() {
        String bearerToken = "985a0930-464f-421a-985f-4fb4b755b195";
        String existingProjectName = "superadmin_personal1";

        Error expectedError = new Error(4003, "You do not have enough permissions. Please check the list of your available projects.");

        Error error = RestAssured.given()
                .pathParam("projectName", existingProjectName)
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get("http://localhost:8080/api/v1/{projectName}/launch")
                .as(Error.class);

        assertThat(error, equalTo(expectedError));
    }

    //positive -->
    @Test
    void createLaunchClusters() {
        String bearerToken = "985a0930-464f-421a-985f-4fb4b755b195";
        String existingProjectName = "superadmin_personal";

        CreateClustersRequest createClustersRequest = new CreateClustersRequest(13, true);
        CreateClusterResponse expectedResponse = new CreateClusterResponse("Clusters generation for launch with ID='13' started.");

        CreateClusterResponse createClusterResponse = RestAssured.given()
                .pathParam("projectName", existingProjectName)
                .header("Authorization", "Bearer " + bearerToken)
                .and()
                .header("Content-type", "application/json")
                .body(createClustersRequest)
                .when()
                .post("http://localhost:8080/api/v1/{projectName}/launch/cluster")
                .as(CreateClusterResponse.class);


        assertThat(createClusterResponse, equalTo(expectedResponse));
    }

    @Test
    void startLaunchAutoAnalyzerOnDemandWithNotExistingId() {
        String bearerToken = "985a0930-464f-421a-985f-4fb4b755b195";
        String existingProjectName = "superadmin_personal";

        RestAssured.given()
                .pathParam("projectName", existingProjectName)
                .and()
                .header("Authorization", "Bearer " + bearerToken)
                .and()
                .header("Content-type", "application/json")
                .body("{\n" +
                        "  \"analyzeItemsMode\": [\n" +
                        "    \"TO_INVESTIGATE\"\n" +
                        "  ],\n" +
                        "  \"analyzerMode\": \"ALL\",\n" +
                        "  \"analyzerTypeName\": \"autoAnalyzer\",\n" +
                        "  \"launchId\": 0\n" +
                        "}")
                .when()
                .post("http://localhost:8080/api/v1/{projectName}/launch/analyze")
                .then()
                .statusCode(404);
    }

    //put
    @Test
    void bulkUpdateAttributesAndDescription() {
        String bearerToken = "985a0930-464f-421a-985f-4fb4b755b195";
        String existingProjectName = "superadmin_personal";

        List<Attribute> attributes = new ArrayList<>();
        Pair from = new Pair("string", "string");
        Pair to = new Pair("string", "string");
        Attribute attribute = new Attribute("DELETE", from, to);
        attributes.add(attribute);

        Description description = new Description("DELETE", "string");

        List<Integer> ids = new ArrayList<>();
        ids.add(0);

        BulkInfoUpdateRequest bulkInfoUpdateRequest = new BulkInfoUpdateRequest(attributes, description, ids);

        BulkInfoUpdateResponse bulkInfoUpdateResponseExpected = new BulkInfoUpdateResponse("Attributes successfully updated");

        BulkInfoUpdateResponse bulkInfoUpdateResponse = RestAssured.given()
                .pathParam("projectName", existingProjectName)
                .and()
                .header("Authorization", "Bearer " + bearerToken)
                .and()
                .header("Content-type", "application/json")
                .body(bulkInfoUpdateRequest)
                .when()
                .put("http://localhost:8080/api/v1/{projectName}/launch/info")
                .then()
                .statusCode(200)
                .extract()
                .as(BulkInfoUpdateResponse.class);


        assertThat(bulkInfoUpdateResponse, equalTo(bulkInfoUpdateResponseExpected));
    }

    //delete
    @Test
    void deleteSpecifiedLaunchByID() {
        String bearerToken = "985a0930-464f-421a-985f-4fb4b755b195";
        String existingProjectName = "superadmin_personal";
        int launchID = 13;
        Error expectedError = new Error(4041, "Launch '13' not found. Did you use correct Launch ID?");

        Error errorDelete = RestAssured.given()
                .pathParam("projectName", existingProjectName)
                .pathParam("launchID", launchID)
                .and()
                .header("Authorization", "Bearer " + bearerToken)
                .and()
                .header("Content-type", "application/json")
                .when()
                .delete("http://localhost:8080/api/v1/{projectName}/launch/{launchID}")
                .then()
                .statusCode(404)
                .extract()
                .as(Error.class);

        assertThat(errorDelete, equalTo(expectedError));
    }
}
