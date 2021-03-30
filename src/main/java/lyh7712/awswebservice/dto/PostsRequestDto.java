package lyh7712.awswebservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lyh7712.awswebservice.model.Posts;

@Getter
@NoArgsConstructor
public class PostsRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
