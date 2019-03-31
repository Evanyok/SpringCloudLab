package cn.ice.cloud.repo;

import cn.ice.cloud.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {
    List<ProductComment> findByProductIdOrderByCreated(Long id);
}
