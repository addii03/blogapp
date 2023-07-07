package blog_app_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog_app_api.helper.CommentHelper;
import blog_app_api.request.CommentRequest;
import blog_app_api.responce.CommentResponce;
import blog_app_api.servicee.CommentServicee;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentHelper commentHelper;
	
	@Autowired
	CommentServicee commentServicee;
	
	@PostMapping("/save")
	public ResponseEntity<CommentResponce> saveComments(@RequestBody CommentRequest commentRequest)
	{
		return new ResponseEntity<CommentResponce>(commentServicee.saveComments(commentRequest), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public List<CommentResponce> getAll()
	{
		return commentServicee.getAll();
	}
}
