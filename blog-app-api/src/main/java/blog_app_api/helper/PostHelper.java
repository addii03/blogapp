package blog_app_api.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog_app_api.entity.Category;

import blog_app_api.entity.Post;
import blog_app_api.exception.CustomBlogException;
import blog_app_api.repository.CategoryRepository;
import blog_app_api.repository.CommentRepository;
import blog_app_api.repository.PostRepository;
import blog_app_api.request.PostRequest;
import blog_app_api.responce.PostResponce;

@Component
public class PostHelper {

	@Autowired
	PostRepository postRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CommentRepository commentRepository;

	public Post toEntity(PostRequest postRequest) {
		Post post = new Post();
		if (postRequest.getPostId() != null) {
			post = postRepository.findById(postRequest.getPostId())
					.orElseThrow(() -> new CustomBlogException("id nahi hai ismeee"));
		}
		post.setPostTitle(postRequest.getPostTitle());
		post.setPostContent(postRequest.getPostContent());
		post.setAddedData(postRequest.getAddedData());

		// cat
		Category category = categoryRepository.findById(postRequest.getCategoryId())
				.orElseThrow(() -> new CustomBlogException("cat id not found"));
		post.setCategory(category);

		// cmt
//		Comment comment= commentRepository.findById(postRequest.getComId()).orElseThrow(()->new CustomBlogException("comment id not found"));
//		post.setComments(list < comment >);
		return post;
	}

	public PostResponce toDto(Post post) {
		PostResponce postResponce = new PostResponce();
		postResponce.setPostId(post.getPostId());
		postResponce.setPostTitle(post.getPostTitle());
		postResponce.setPostContent(post.getPostContent());
		postResponce.setAddedData(post.getAddedData());

		// cat
		postResponce.setCategoryId(post.getCategory().getCategoryId());
		postResponce.setCategoryTitle(post.getCategory().getCategoryTitle());
		postResponce.setCategroyDesciption(post.getCategory().getCategroyDesciption());

		return postResponce;
	}
}
