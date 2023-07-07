package blog_app_api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog_app_api.entity.Category;
import blog_app_api.exception.CustomBlogException;
import blog_app_api.helper.CategoryHelper;
import blog_app_api.repository.CategoryRepository;
import blog_app_api.request.CategoryRequest;
import blog_app_api.responce.CategoryResponce;
import blog_app_api.servicee.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService{
	@Autowired
	CategoryHelper categoryHelper;
	@Autowired
	CategoryRepository categoryRepository;
	@Override
	public CategoryResponce saveCategeory(CategoryRequest categoryRequest) {
		Category category = categoryHelper.toEntity(categoryRequest);
		categoryRepository.save(category);
		return categoryHelper.toDto(category);
	}
	@Override
	public List<CategoryResponce> getAll() {
	List<Category> list = categoryRepository.findAll();
	return list.stream().map(categoryHelper::toDto).collect(Collectors.toList());
	}
	@Override
	public CategoryResponce getById(Integer id) {
		Category category = categoryRepository.findById(id).orElseThrow(()-> new CustomBlogException("categoory id not found"));
		return categoryHelper.toDto(category);
	}
	

}
