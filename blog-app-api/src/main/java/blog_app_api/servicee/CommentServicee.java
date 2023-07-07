package blog_app_api.servicee;

import java.util.List;

import blog_app_api.request.CommentRequest;
import blog_app_api.responce.CommentResponce;

public interface CommentServicee {

	CommentResponce saveComments(CommentRequest commentRequest);
	List<CommentResponce> getAll();
}
