package services.jsonplaceholder.posts;

import base.BaseTest;
import base.GatewayRequest;
import dto.services.posts.GetSinglePostReq;
import dto.services.posts.GetSinglePostResp;
import helpers.AssertHelper;
import helpers.MandatoryHeaders;
import org.testng.annotations.Test;

public class GetSinglePost extends BaseTest {

    @Test
    public void test_get_single_post(){
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .getSinglePost(GetSinglePostReq
                        .builder()
                        .id(1)
                        .build())
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 200);
        GetSinglePostResp resp = (GetSinglePostResp) gatewayRequest.getSerializedResponse();
        AssertHelper.assertResponseBodyContains("userId", resp.getUserId(), 1);
    }
}
