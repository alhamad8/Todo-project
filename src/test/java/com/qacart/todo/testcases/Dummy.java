package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.objects.User;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Dummy {
    public static void main (String [] args){
        /*
        Given: Every thing related to the request ( base url),headers , parammeters,Authrization , body
         */
        /*
        When: Type of the request (Post,Get,Put,Delete) + end point
         */
        /*
        Then:Every thing from the response
         */

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        System.out.println(registerApi.getAccessToken());
        System.out.println(registerApi.getUserId());
        System.out.println(registerApi.getFirstName());



    }
}
