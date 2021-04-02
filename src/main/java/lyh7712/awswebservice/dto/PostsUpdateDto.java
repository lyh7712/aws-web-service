package lyh7712.awswebservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsUpdateDto {

    private String title;
    private String content;

    @Builder
    public PostsUpdateDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
