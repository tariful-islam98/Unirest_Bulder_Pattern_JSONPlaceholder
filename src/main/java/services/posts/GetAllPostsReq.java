package services.posts;

import base.AbstractHttpSpecification;
import base.Properties;
import com.mashape.unirest.http.HttpMethod;
import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true)
public class GetAllPostsReq extends AbstractHttpSpecification {
    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    protected String getEndpointUrl() {
        return Properties.JSONPLACEHOLDER_API + "/posts";
    }
}
