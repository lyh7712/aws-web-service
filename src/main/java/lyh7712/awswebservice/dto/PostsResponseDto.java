package lyh7712.awswebservice.dto;

import lombok.Builder;
import lombok.Getter;
import lyh7712.awswebservice.model.Posts;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
