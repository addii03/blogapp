package blog_app_api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog_app_api.entity.User;
import blog_app_api.exception.CustomBlogException;
import blog_app_api.helper.UserHelper;
import blog_app_api.repository.UserRepository;
import blog_app_api.request.UserRequest;
import blog_app_api.responce.UserResponce;
import blog_app_api.servicee.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserHelper userHelper;
	@Override
	public UserResponce saveUsers(UserRequest userRequest) {
		User user = userHelper.toEntity(userRequest);
		userRepository.save(user);
		return userHelper.toDto(user);
	}
	@Override
	public UserResponce getById(Integer id) throws CustomBlogException {
		User user = userRepository.findById(id).orElseThrow(()-> new CustomBlogException("user id not found"));
		return userHelper.toDto(user);
	}
	@Override
	public List<UserResponce>getAll() {
		List<User> list = userRepository.findAll();
		return list.stream().map(userHelper::toDto).collect(Collectors.toList());
	}
	@Override
	public void deleteUser(Integer id) {
	User user = userRepository.findById(id).orElseThrow(()->new CustomBlogException("user not found"));
	userRepository.delete(user);
		
	}
}
