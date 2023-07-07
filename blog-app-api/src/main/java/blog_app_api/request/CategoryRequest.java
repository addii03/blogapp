package blog_app_api.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class CategoryRequest {
	Integer categoryId;
	String categoryTitle;
	String categroyDesciption;
	
	//post
	Integer postId;
}
