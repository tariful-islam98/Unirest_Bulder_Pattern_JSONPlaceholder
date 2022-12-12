package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class HttpDispatcher {

    private String jsonBody = null;


    public HttpResponse<JsonNode> send(GatewayRequest gatewayRequest) {

        HttpRequest request = null;
        HttpResponse response = null;

        final String url = gatewayRequest.getBody().getEndpointUrl();
        final HttpMethod method = gatewayRequest.getBody().getHttpMethod();


        try {
            request = new HttpRequestWithBody(method, url);
            request.headers(gatewayRequest.getHeaders().getHeaders());
            request.header("Content-Type", "application/json");

            //todo this is all messed up. Converting the JSONObject to String using GSON adds random parts to the Json

//            if (gatewayRequest.getBody() instanceof GetItems) {
//                jsonBody = ((GetItems) gatewayRequest.getBody()).toString();
//            }
//            else {
            jsonBody = new Gson().toJson(gatewayRequest.getBody());
//            }

            // todo import endpoint returns a String not json (bug) so have to handle that too

//            if (gatewayRequest.getBody() instanceof LoginReq) {
//                response = ((HttpRequestWithBody) request).body(jsonBody).asString();
//                LoginRes loginRes = new LoginRes();
//                try {
//                    loginRes.setMessage(response.getBody().toString());
//                    gatewayRequest.setSerializedResponse(loginRes);
//                } catch (Exception e) {
//                    //todo this is when we get back an Error - once response is in JSON we can get rid of this
//                }
//                gatewayRequest.setHttpResponse(response);
//            }
//           else {
            try {
                response = ((HttpRequestWithBody) request).body(jsonBody).asJson();
                gatewayRequest.setHttpResponse(response);
            } catch (Exception e) {
                response = ((HttpRequestWithBody) request).body(jsonBody).asString();
                gatewayRequest.setHttpResponse(response);
//                   Assert.fail("Invalid HTTP Response: " + response.getBody());
            }

            //todo this is just here because I can't be bothered to map the responses for basket as it's massive!
            try {
                if (gatewayRequest.getResponseObjectType() != null) {
                    gatewayRequest.setSerializedResponse(new Gson().fromJson(response.getBody().toString(), gatewayRequest.getResponseObjectType()));
                }
            } catch (Exception e) {

            }
//            }


        } catch (Exception e) {
            try {
                response = ((HttpRequestWithBody) request).body(jsonBody).asString();
            } catch (UnirestException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }

        logToReport(request, response);
        return response;
    }

    /**
     * This is just for the POC, once we know which direction we are going we can remove one of the two logging options.
     *
     * @param request
     * @param response
     */
    private void logToReport(HttpRequest request, HttpResponse response) {

        String reqLog = String.format("\nREQUEST\n-----------\nMETHOD: %s\nURL: %s\nHEADERS: %s\n", new Object[]{request.getHttpMethod(), request.getUrl(), request.getHeaders()});

        if (request.getBody() != null) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            try {
                request.getBody().getEntity().writeTo(os);
                reqLog = reqLog.concat(String.format("BODY: %s\n", os.toString()));

            } catch (IOException ex) {
            }
        }

        String respLog = String.format("\nRESPONSE\n-----------\nSTATUS_CODE: %d\nSTATUS_TEXT: %s\nHEADERS: %s\nBODY: %s\n",

                response.getStatus(), response.getStatusText(), response.getHeaders(), response.getBody());


        ExtentTest reporter = BaseTest.getTestReporter();
        reporter.info(MarkupHelper.createCodeBlock(reqLog));
        reporter.info(MarkupHelper.createCodeBlock(respLog));

    }
}
