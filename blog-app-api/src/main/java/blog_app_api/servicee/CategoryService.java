package blog_app_api.servicee;

import java.util.List;

import blog_app_api.request.CategoryRequest;
import blog_app_api.responce.CategoryResponce;

public interface CategoryService {

	CategoryResponce saveCategeory(CategoryRequest categoryRequest);
	List<CategoryResponce> getAll();
	CategoryResponce getById(Integer id);
}
