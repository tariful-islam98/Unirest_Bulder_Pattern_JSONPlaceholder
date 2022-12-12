package services.jsonplaceholder.posts;

import base.BaseTest;
import base.GatewayRequest;
import dto.services.posts.UpdatePostReq;
import dto.services.posts.UpdatePostResp;
import helpers.AssertHelper;
import helpers.MandatoryHeaders;
import org.testng.annotations.Test;

public class UpdatePosts extends BaseTest {
    @Test
    public void test_update_post(){
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .postsService()
                .updatePost(UpdatePostReq.builder()
                        .id(1)
                        .userId(1)
                        .title("abcd")
                        .body("asdfgh")
                        .build())
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 200);

        UpdatePostResp resp = (UpdatePostResp) gatewayRequest.getSerializedResponse();

        AssertHelper.assertResponseBodyContains("body", resp.getBody(), "asdfgh");
    }
}
