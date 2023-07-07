package blog_app_api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog_app_api.entity.Comment;
import blog_app_api.helper.CommentHelper;
import blog_app_api.repository.CommentRepository;
import blog_app_api.request.CommentRequest;
import blog_app_api.responce.CommentResponce;
import blog_app_api.servicee.CommentServicee;

@Service
public class CommentServiceimpl implements CommentServicee{
	@Autowired
	CommentHelper commentHelper;
	@Autowired
	CommentRepository commentRepository;
	@Override
	public CommentResponce saveComments(CommentRequest commentRequest) {
		Comment comment = commentHelper.toEntity(commentRequest);
		commentRepository.save(comment);
		return commentHelper.toDto(comment);
	}
	@Override
	public List<CommentResponce> getAll() {
		List<Comment> list = commentRepository.findAll();
		return list.stream().map(commentHelper::toDto).collect(Collectors.toList());
		
	}
	

}
