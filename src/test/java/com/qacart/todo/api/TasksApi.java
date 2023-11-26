package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Task;
import com.qacart.todo.utils.configUtil;
import io.opentelemetry.api.internal.ConfigUtil;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TasksApi {



    public void addTask (String token){
        Task task = new Task(false,"Learn testing");
    Response response = given().baseUri(configUtil.getInstance().getBaseUrl())
                .header("Content-Type","application/json")
                .body(task)
                .auth().oauth2(token)
        .when().post(EndPoint.API_TASK_ENDPOINT)
        .then().log().all().extract().response();
    if (response.statusCode() != 201){
        throw new RuntimeException ("Something went wrong while adding the task");
    }

    }
}
