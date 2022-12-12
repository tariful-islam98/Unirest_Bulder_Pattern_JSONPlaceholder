package services.posts;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class GetAllPostsResp {
    private List<Posts> posts;

    @Getter
    public class Posts{

        @SerializedName("id")
        private int id;

        @SerializedName("title")
        private String title;

        @SerializedName("body")
        private String body;

        @SerializedName("userId")
        private int userId;
    }
}
