package dto.services.posts;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class GetSinglePostResp {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    @SerializedName("userId")
    private int userId;
}
