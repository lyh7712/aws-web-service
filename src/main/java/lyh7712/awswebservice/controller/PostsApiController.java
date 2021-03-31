package lyh7712.awswebservice.controller;

import lombok.RequiredArgsConstructor;
import lyh7712.awswebservice.dto.PostsRequestDto;
import lyh7712.awswebservice.dto.PostsResponseDto;
import lyh7712.awswebservice.service.PostsService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PostsApiController {

    private final PostsService postsService;

    @RequestMapping("/posts")
    public Long save(@RequestBody PostsRequestDto requestDto) {
        return postsService.save(requestDto);
    }


    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findPosts(id);
    }
}
