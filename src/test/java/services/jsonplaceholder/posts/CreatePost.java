package services.jsonplaceholder.posts;

import base.BaseTest;
import base.GatewayRequest;
import dto.services.posts.CreatePostReq;
import dto.services.posts.CreatePostResp;
import helpers.AssertHelper;
import helpers.MandatoryHeaders;
import org.testng.annotations.Test;

public class CreatePost extends BaseTest {

    @Test
    public void test_create_post(){
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .postsService()
                .createPost(
                        CreatePostReq
                                .builder()
                                .userId(1)
                                .title("abcd")
                                .body("acbdkalfs")
                                .build())
                .send();

        CreatePostResp resp = (CreatePostResp) gatewayRequest.getSerializedResponse();

        AssertHelper.assertResponseCode(gatewayRequest, 201);
        AssertHelper.assertResponseBodyContains("title", resp.getTitle(), "abcd");
    }
}
