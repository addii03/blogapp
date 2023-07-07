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

import blog_app_api.helper.PostHelper;
import blog_app_api.request.PostRequest;
import blog_app_api.responce.PostResponce;
import blog_app_api.servicee.PostServicee;

@RestController
@RequestMapping("/api/post")
public class PostCotroller {

	@Autowired
	PostHelper postHelper;
	@Autowired
	PostServicee postServicee;
	
	@PostMapping("/save")
	public ResponseEntity<PostResponce> savePost(@RequestBody PostRequest postRequest)
	{
		return new ResponseEntity<PostResponce>(postServicee.savePost(postRequest), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public List<PostResponce> getAll()
	{
		return postServicee.getAll();
	}
}
