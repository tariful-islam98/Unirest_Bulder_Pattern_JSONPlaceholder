package controllers;

import base.GatewayRequest;
import dto.services.posts.*;

public class PostsService {
    private GatewayRequest gatewayRequest;

    public PostsService(GatewayRequest gatewayRequest){
        this.gatewayRequest = gatewayRequest;
    }

    public GatewayRequest getSinglePost(GetSinglePostReq getSinglePostReq){
        gatewayRequest.setBody(getSinglePostReq);
        gatewayRequest.setResponseObjectType(GetSinglePostResp.class);
        return gatewayRequest;
    }

    public GatewayRequest createPost(CreatePostReq createPostReq){
        gatewayRequest.setBody(createPostReq);
        gatewayRequest.setResponseObjectType(CreatePostResp.class);
        return gatewayRequest;
    }

    public GatewayRequest updatePost(UpdatePostReq updatePostReq){
        gatewayRequest.setBody(updatePostReq);
        gatewayRequest.setResponseObjectType(UpdatePostResp.class);
        return gatewayRequest;
    }
}
