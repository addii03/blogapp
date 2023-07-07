package blog_app_api.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog_app_api.entity.User;
import blog_app_api.exception.CustomBlogException;
import blog_app_api.repository.UserRepository;
import blog_app_api.request.UserRequest;
import blog_app_api.responce.UserResponce;

@Component
public class UserHelper {

	@Autowired
	UserRepository userRepository;

	public User toEntity(UserRequest userRequest) {
		User user = new User();

		if (userRequest.getId() != null) {
			user=userRepository.findById(userRequest.getId())
					.orElseThrow(() -> new CustomBlogException("user id not founded"));
		}
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setAbout(userRequest.getAbout());
		user.setPassword(userRequest.getPassword());
		return user;
	}

	public UserResponce toDto(User user) {
		UserResponce userResponce = new UserResponce();
		userResponce.setId(user.getId());
		userResponce.setName(user.getName());
		userResponce.setEmail(user.getEmail());
		userResponce.setAbout(user.getAbout());
		userResponce.setPassword(user.getPassword());
		return userResponce;
	}
}
