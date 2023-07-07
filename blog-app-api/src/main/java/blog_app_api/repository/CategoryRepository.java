package blog_app_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog_app_api.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
