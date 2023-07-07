package blog_app_api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog_app_api.entity.Post;
import blog_app_api.helper.PostHelper;
import blog_app_api.repository.PostRepository;
import blog_app_api.request.PostRequest;
import blog_app_api.responce.PostResponce;
import blog_app_api.servicee.PostServicee;

@Service
public class PostServiceImpl implements PostServicee {

	@Autowired
	PostHelper postHelper;

	@Autowired
	PostRepository postRepository;

	@Override
	public PostResponce savePost(PostRequest postRequest) {
		Post post = postHelper.toEntity(postRequest);
		postRepository.save(post);
		return postHelper.toDto(post);
	}

	@Override
	public List<PostResponce> getAll() {
		List<Post> list = postRepository.findAll();
		return list.stream().map(postHelper::toDto).collect(Collectors.toList());
	}

}
