package blog_app_api.responce;

import java.util.Date;

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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryResponce {
	Integer categoryId;
	String categoryTitle;
	String categroyDesciption;

	//post
	
	Integer postId;
	String postTitle;
	String postContent;
	Date addedData;
}
