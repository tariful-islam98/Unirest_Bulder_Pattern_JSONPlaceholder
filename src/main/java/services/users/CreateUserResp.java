package services.users;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class CreateUserResp {

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String username;

    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private GetSingleUserResp.Address address;

    @SerializedName("phone")
    private String phone;

    @SerializedName("website")
    private String website;

    @SerializedName("company")
    private GetSingleUserResp.Company company;

    @SerializedName("id")
    private int id;

    @Getter
    public class Address{

        @SerializedName("street")
        private String street;

        @SerializedName("suite")
        private String suite;

        @SerializedName("city")
        private String city;

        @SerializedName("zipcode")
        private String zipcode;

        @SerializedName("geo")
        private GetSingleUserResp.Geo geo;
    }

    @Getter
    public class Company{

        @SerializedName("name")
        private String name;

        @SerializedName("catchPhrase")
        private String catchPhrase;

        @SerializedName("bs")
        private String bs;
    }

    @Getter
    public class Geo{

        @SerializedName("lat")
        private String lat;

        @SerializedName("lng")
        private String lng;
    }
}
