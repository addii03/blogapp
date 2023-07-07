package blog_app_api.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog_app_api.entity.Category;
import blog_app_api.entity.Post;
import blog_app_api.exception.CustomBlogException;
import blog_app_api.repository.CategoryRepository;
import blog_app_api.repository.PostRepository;
import blog_app_api.request.CategoryRequest;
import blog_app_api.responce.CategoryResponce;

@Component
public class CategoryHelper {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	PostRepository postRepository;

	public Category toEntity(CategoryRequest categoryRequest) {
		Category category = new Category();
		if (categoryRequest.getCategoryId() != null) {
			category = categoryRepository.findById(categoryRequest.getCategoryId())
					.orElseThrow(() -> new CustomBlogException("id not found "));
		}
		category.setCategoryTitle(categoryRequest.getCategoryTitle());
		category.setCategroyDesciption(categoryRequest.getCategroyDesciption());

		// post
		Post post = postRepository.findById(categoryRequest.getPostId()).orElseThrow(()-> new CustomBlogException("post id  ot found"));
		category.setPost(post);
		return category;
	}

	public CategoryResponce toDto(Category category) {
		CategoryResponce categoryResponce = new CategoryResponce();
		categoryResponce.setCategoryId(category.getCategoryId());
		categoryResponce.setCategoryTitle(category.getCategoryTitle());
		categoryResponce.setCategroyDesciption(category.getCategroyDesciption());
		
		//post
		categoryResponce.setPostId(category.getPost().getPostId());
		categoryResponce.setPostContent(category.getPost().getPostContent());
		categoryResponce.setPostTitle(category.getPost().getPostTitle());
		categoryResponce.setAddedData(category.getPost().getAddedData());
		return categoryResponce;
	}
}
