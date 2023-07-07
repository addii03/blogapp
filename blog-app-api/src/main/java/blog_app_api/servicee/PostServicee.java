package blog_app_api.servicee;

import java.util.List;

import blog_app_api.request.PostRequest;
import blog_app_api.responce.PostResponce;

public interface PostServicee {

	PostResponce savePost(PostRequest postRequest);
	List<PostResponce> getAll();
	
}
