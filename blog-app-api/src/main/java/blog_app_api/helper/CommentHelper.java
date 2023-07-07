package blog_app_api.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog_app_api.entity.Comment;
import blog_app_api.entity.Post;
import blog_app_api.entity.User;
import blog_app_api.exception.CustomBlogException;
import blog_app_api.repository.CommentRepository;
import blog_app_api.repository.PostRepository;
import blog_app_api.repository.UserRepository;
import blog_app_api.request.CommentRequest;
import blog_app_api.responce.CommentResponce;

@Component
public class CommentHelper {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Comment toEntity(CommentRequest commentRequest) {
		Comment comment = new Comment();
		if (commentRequest.getComId() != null) {
			comment = commentRepository.findById(commentRequest.getComId())
					.orElseThrow(() -> new CustomBlogException("id not found"));
		}
		comment.setComType(commentRequest.getComType());
		
		//post
		Post post= postRepository.findById(commentRequest.getPostId()).orElseThrow(()-> new CustomBlogException("post not found"));
		comment.setPost(post);
		
		//user
		User user=userRepository.findById(commentRequest.getId()).orElseThrow(()-> new CustomBlogException("user not found"));
		comment.setUser(user);
		return comment;
	}

	public CommentResponce toDto(Comment comment) {
		CommentResponce commentResponce = new CommentResponce();
		commentResponce.setComId(comment.getComId());
		commentResponce.setComType(comment.getComType());
		
		//post
		commentResponce.setPostId(comment.getPost().getPostId());
		commentResponce.setPostTitle(comment.getPost().getPostTitle());
		commentResponce.setPostContent(comment.getPost().getPostContent());
		commentResponce.setAddedData(comment.getPost().getAddedData());
		
		//user
		commentResponce.setId(comment.getUser().getId());
		commentResponce.setName(comment.getUser().getName());
		commentResponce.setEmail(comment.getUser().getEmail());
		commentResponce.setPassword(comment.getUser().getPassword());
		commentResponce.setAbout(comment.getUser().getAbout());
		return commentResponce;
	}
}
