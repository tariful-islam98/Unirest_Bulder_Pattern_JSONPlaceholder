package dto.services.posts;

import base.AbstractHttpSpecification;
import base.Properties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mashape.unirest.http.HttpMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true)
@Getter
@Setter
public class CreatePostReq extends AbstractHttpSpecification {

    @SerializedName("userId")
    @Expose
    public int userId;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("body")
    @Expose
    public String body;

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getEndpointUrl() {
        return Properties.JSONPLACEHOLDER_API+"/posts";
    }
}
