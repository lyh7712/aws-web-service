package lyh7712.awswebservice.service;


import lombok.RequiredArgsConstructor;
import lyh7712.awswebservice.dto.PostsRequestDto;
import lyh7712.awswebservice.dto.PostsResponseDto;
import lyh7712.awswebservice.dto.PostsUpdateDto;
import lyh7712.awswebservice.model.Posts;
import lyh7712.awswebservice.model.PostsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository repository;

    @Transactional
    public Long save(PostsRequestDto requestDto) {
        return repository.save(requestDto.toEntity()).getId();
    }


    //게시글 수정
    public Long update(Long id, PostsUpdateDto updateDto) {
        Posts entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 입니다. id = " + id));

        entity.update(updateDto.getTitle(), updateDto.getContent());

        return id;
    }

    //게시글 조회
    public PostsResponseDto findPosts(Long id) {
        Posts entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 입니다. id = " + id));

        return new PostsResponseDto(entity);
    }
}
