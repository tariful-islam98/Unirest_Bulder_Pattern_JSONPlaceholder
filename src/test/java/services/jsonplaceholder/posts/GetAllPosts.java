package services.jsonplaceholder.posts;

import base.BaseTest;
import base.GatewayRequest;
import services.posts.GetAllPostsReq;
import services.posts.GetAllPostsResp;
import helpers.AssertHelper;
import helpers.MandatoryHeaders;
import org.testng.annotations.Test;

public class GetAllPosts extends BaseTest {
    @Test
    public void test_get_all_posts() {
        GatewayRequest gatewayRequest = new GatewayRequest()
                .usingHeaders(MandatoryHeaders.getHeaders())
                .forService()
                .postsService()
                .getAllPosts(GetAllPostsReq.builder().build())
                .send();

        AssertHelper.assertResponseCode(gatewayRequest, 200);

        System.out.println(gatewayRequest.getHttpResponse().getBody());
    }
}
