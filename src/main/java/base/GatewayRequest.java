package base;

import controllers.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.request.HttpRequest;
import dto.services.posts.GetSinglePostReq;
import dto.services.posts.GetSinglePostResp;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class GatewayRequest {

    @Getter(AccessLevel.PUBLIC)
    private HttpHeader headers = new HttpHeader();
    @Setter
    @Getter(AccessLevel.PROTECTED)
    private AbstractHttpSpecification body;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private HttpRequest httpRequest;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private HttpResponse httpResponse;
    @Getter
    @Setter(AccessLevel.PROTECTED)
    private Object serializedResponse;
    @Setter
    @Getter(AccessLevel.PROTECTED)
    private Class responseObjectType;


    public GatewayRequest forService() {
        return this;
    }

    public GatewayRequest usingHeaders(final HttpHeader httpHeader) {
        this.headers = httpHeader;
        return this;
    }

    public GatewayRequest getSinglePost(final GetSinglePostReq singlePostReq) {
        body = singlePostReq;
        responseObjectType = GetSinglePostResp.class;
        return this;
    }

    public PostsService postsService() {
        return new PostsService(this);
    }

    public GatewayRequest send() {
        new HttpDispatcher().send(this);
        return this;
    }
}
