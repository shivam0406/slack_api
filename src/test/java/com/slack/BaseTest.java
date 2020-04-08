package com.slack;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BaseTest {

    public CloseableHttpClient client;
    public CloseableHttpResponse response;
    public static LinkedHashMap<String, String> slack = new LinkedHashMap<>();

    protected static final String BASE_ENDPOINT_SLACK = "https://slack.com/api/";



    @BeforeMethod
    public void setup(Method method) {
        System.out.println("Before Test of" + method.getName());
        client = HttpClientBuilder.create().build();
    }


    @BeforeTest
    public void beforeTest() {
        System.out.println("Setting up env variable");
    }

    @AfterMethod
    public void closeResources(ITestResult iTestResult) throws IOException {
        client.close();
        response.close();
        int status = iTestResult.getStatus();

        switch (status) {
            case ITestResult.SUCCESS:
                System.out.println("After Test of Method :::  " + iTestResult.getMethod().getMethodName() + " And Result is PASS");
                break;
            case ITestResult.FAILURE:
                System.out.println("After Test of Method :::  " + iTestResult.getMethod().getMethodName() + " And Result is FAIL");
                break;
            case ITestResult.SKIP:
                System.out.println("After Test of Method :::  " + iTestResult.getMethod().getMethodName() + " And Result is SKIPPED");
                break;
            default:
                throw new RuntimeException("Invalid status");
        }

    }
}
