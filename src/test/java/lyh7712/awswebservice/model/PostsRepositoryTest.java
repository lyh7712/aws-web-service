package lyh7712.awswebservice.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void clear() {
        postsRepository.deleteAll();

    }

    @Test
    void 회원_저장_불러오기() {
        //given
        String title = "테스트 제목";
        String content = "테스트 내용";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("테스트 저자")
                .build());

        //when
        List<Posts> list = postsRepository.findAll();

        //then
        Assertions.assertThat(title).isEqualTo(list.get(0).getTitle());
        Assertions.assertThat(content).isEqualTo(list.get(0).getContent());

    }

    @Test
    void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2021,4,5,0,0,0);

        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println("생성 시간 : " + posts.getCreateDate());
        System.out.println("수정 시간 : " + posts.getCreateDate());

        Assertions.assertThat(posts.getCreateDate()).isAfter(now);
        Assertions.assertThat(posts.getModifiedDate()).isAfter(now);
    }
}