package blog_app_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog_app_api.helper.CategoryHelper;
import blog_app_api.request.CategoryRequest;
import blog_app_api.responce.CategoryResponce;
import blog_app_api.servicee.CategoryService;

@RestController
@RequestMapping("/api/cat")
public class CategoryController {

	@Autowired
	CategoryHelper categoryHelper;
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/save")
	public ResponseEntity<CategoryResponce> saveCategeory(@RequestBody CategoryRequest categoryRequest)
	{
		return new ResponseEntity<CategoryResponce>(categoryService.saveCategeory(categoryRequest), HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public List<CategoryResponce> getAll()
	{
	return categoryService.getAll();
	}
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<CategoryResponce> getById(@PathVariable Integer id)
	{
		return new ResponseEntity<CategoryResponce>(categoryService.getById(id), HttpStatus.OK);
	}
}
