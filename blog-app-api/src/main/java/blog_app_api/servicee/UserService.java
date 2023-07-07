package blog_app_api.servicee;

import java.util.List;

import blog_app_api.request.UserRequest;
import blog_app_api.responce.UserResponce;

public interface UserService {

	UserResponce saveUsers(UserRequest userRequest);

	UserResponce getById(Integer id);

	List<UserResponce> getAll();
	
	void deleteUser(Integer id);
}
