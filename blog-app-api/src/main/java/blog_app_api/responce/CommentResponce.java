package blog_app_api.responce;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class CommentResponce {
	Integer comId;
	String comType;
	
	//post
	Integer postId;
	String postTitle;
	String postContent;
	Date addedData;
	
	//user
	Integer id;
	String name;
	String email;
	String password;
	String about;
}
