package lyh7712.awswebservice.service;

import javafx.geometry.Pos;
import lyh7712.awswebservice.dto.PostsRequestDto;
import lyh7712.awswebservice.model.Posts;
import lyh7712.awswebservice.model.PostsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;


@SpringBootTest(webEnvironment = RANDOM_PORT)
class PostsServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    PostsRepository repository;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void 회원_등록() {
        //given
        String title = "테스트 제목";
        String content = "테스트 본문";

        String url = "http://localhost:" + port + "api/v1/posts";

        PostsRequestDto requestDto = PostsRequestDto.builder()
                .title(title)
                .content(content)
                .author("mmj2rv9")
                .build();

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> list = repository.findAll();
        assertThat(list.get(0).getTitle()).isEqualTo(title);
        assertThat(list.get(0).getContent()).isEqualTo(content);

    }
}