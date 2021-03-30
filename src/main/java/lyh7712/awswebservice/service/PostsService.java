package lyh7712.awswebservice.service;


import lombok.RequiredArgsConstructor;
import lyh7712.awswebservice.dto.PostsRequestDto;
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
}
