package blog_app_api.responce;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class PostResponce {

	Integer postId;
	String postTitle;
	String postContent;
	Date addedData;

	// cat
	Integer categoryId;
	String categoryTitle;
	String categroyDesciption;

	// cmt
	Integer comId;
	String comType;
}
