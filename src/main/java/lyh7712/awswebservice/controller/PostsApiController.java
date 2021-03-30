package lyh7712.awswebservice.controller;

import lombok.RequiredArgsConstructor;
import lyh7712.awswebservice.dto.PostsRequestDto;
import lyh7712.awswebservice.service.PostsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @RequestMapping("/api/v1/posts")
    public Long save(@RequestBody PostsRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
