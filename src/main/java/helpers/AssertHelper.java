package helpers;

import base.BaseTest;
import base.GatewayRequest;
import base.Serializer;
import com.aventstack.extentreports.Status;
import com.mashape.unirest.http.HttpResponse;
import dto.services.generic.ErrorMessage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertHelper {


    public static void assertResponseCode(GatewayRequest gateway, int actual) {

        assertThat("Unexpected HTTP Response Status Code", gateway.getHttpResponse().getStatus(), is(actual));
        BaseTest.getTestReporter().log(Status.PASS, "Validated HTTP Response Status Code is " + actual);
    }

    public static void assertResponseBodyContains(String fieldName, String actualValue, String expectedValue) {
        assertThat("Unexpected value in field " + fieldName, actualValue,is(expectedValue));
        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s] is [%s]", fieldName, expectedValue));
    }

    public static void assertResponseBodyContains(String fieldName, int actualValue, int expectedValue) {
        assertThat("Unexpected value in field " + fieldName,actualValue,is(expectedValue));
        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s] is [%d]", fieldName, expectedValue));
    }

    public static void assertResponseBodyContains(String fieldName, Boolean actualValue, boolean expectedValue) {
        assertThat("Unexpected value in field " + fieldName,actualValue,is(expectedValue));
        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s] is [%b]", fieldName, expectedValue));
    }

    public static void assertResponseBodyValueIsNotNull(String fieldName, int value) {
        assertThat("Unexpected value in field " + fieldName,value,is(notNullValue()));
        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s] is not null", fieldName));
    }

    public static void assertResponseBodyValueIsNotEmptyString(String fieldName, String value) {
        assertThat("Unexpected value in field " + fieldName, value,not(emptyOrNullString()));
        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s] is not empty or null", fieldName));
    }

    public static void assertMissingMandatoryHeadersErrorMessage(HttpResponse response) {

        ErrorMessage errorMessage = (ErrorMessage) Serializer.serialize(response, ErrorMessage.class);

        assertResponseBodyContains("Code",errorMessage.getCode(),400);
        assertResponseBodyContains("Reason",errorMessage.getReason(),"Please provide all the necessary and required http headers");
        assertResponseBodyContains("Message",errorMessage.getMessage(),"Required headers are missing, please verify and try again");
        assertResponseBodyContains("Status",errorMessage.getStatus(),400);
        assertResponseBodyContains("ReferenceError",errorMessage.getReferenceError(),"Please provide all the necessary and required http headers");
    }

//    public static void assertSessionInfoLogLine(SessionReq session, String actualLog) {
//
//        String expectedLog = String.format("Session Info: {Login Name: %s, Full Name: %s, Email: %s, Correlation ID: %s, xCorrelation ID: %s}", session.getLoginName(), session.getFullName(), session.getEmail(), session.getCorrelationId(), session.getXCorrelationId());
//        assertResponseBodyContains("trackingId", actualLog, expectedLog);
//    }

    public static void assertListContains(String fieldName, List<Integer> list, int value) {
        assertThat(fieldName + " does not contain value", list,hasItem(value));
        BaseTest.getTestReporter().log(Status.PASS, String.format("Validated field [%s] contains [%d]", fieldName, value));
    }

}
