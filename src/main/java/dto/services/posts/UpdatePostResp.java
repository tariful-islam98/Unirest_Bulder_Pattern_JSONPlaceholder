package dto.services.posts;

import lombok.Getter;

@Getter
public class UpdatePostResp {
    private int userId;
    private String title;
    private String body;
    private int id;
}
