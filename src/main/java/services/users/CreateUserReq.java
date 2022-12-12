package services.users;

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
public class CreateUserReq extends AbstractHttpSpecification {

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("username")
    @Expose
    public String username;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("address")
    @Expose
    public GetSingleUserResp.Address address;

    @SerializedName("phone")
    @Expose
    public String phone;

    @SerializedName("website")
    @Expose
    public String website;

    @SerializedName("company")
    @Expose
    public GetSingleUserResp.Company company;

    @Setter
    public class Address{

        @SerializedName("street")
        @Expose
        public String street;

        @SerializedName("suite")
        @Expose
        public String suite;

        @SerializedName("city")
        @Expose
        public String city;

        @SerializedName("zipcode")
        @Expose
        public String zipcode;

        @SerializedName("geo")
        @Expose
        public GetSingleUserResp.Geo geo;
    }

    @Setter
    public class Company{

        @SerializedName("name")
        @Expose
        public String name;

        @SerializedName("catchPhrase")
        @Expose
        public String catchPhrase;

        @SerializedName("bs")
        @Expose
        public String bs;
    }

    @Setter
    public class Geo{

        @SerializedName("lat")
        @Expose
        public String lat;

        @SerializedName("lng")
        @Expose
        public String lng;
    }

    @Override
    protected HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    protected String getEndpointUrl() {
        return Properties.JSONPLACEHOLDER_API + "/users";
    }
}
