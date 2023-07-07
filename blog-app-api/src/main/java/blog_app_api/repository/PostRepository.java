package blog_app_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog_app_api.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
