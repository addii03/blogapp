package blog_app_api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer categoryId;
	String categoryTitle;
	String categroyDesciption;
	
	@OneToOne(mappedBy = "category",cascade = CascadeType.ALL)
	Post post;
}
