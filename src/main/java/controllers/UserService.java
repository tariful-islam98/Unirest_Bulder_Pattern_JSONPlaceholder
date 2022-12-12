package controllers;

import base.GatewayRequest;
import services.users.CreateUserReq;
import services.users.CreateUserResp;
import services.users.GetSingleUserReq;
import services.users.GetSingleUserResp;

public class UserService {

    private GatewayRequest gatewayRequest;

    public UserService(GatewayRequest gatewayRequest){
        this.gatewayRequest = gatewayRequest;
    }

    public GatewayRequest getSingleUser(GetSingleUserReq singleUserReq){
        gatewayRequest.setBody(singleUserReq);
        gatewayRequest.setResponseObjectType(GetSingleUserResp.class);
        return gatewayRequest;
    }

    public GatewayRequest createUser(CreateUserReq createUserReq){
        gatewayRequest.setBody(createUserReq);
        gatewayRequest.setResponseObjectType(CreateUserResp.class);
        return gatewayRequest;
    }
}
