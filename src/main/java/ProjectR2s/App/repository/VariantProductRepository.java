package ProjectR2s.App.repository;

import ProjectR2s.App.entity.VariantProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VariantProductRepository extends JpaRepository<VariantProduct, Integer> {

    List<VariantProduct> getVariantProductsByProductId(Long productId);

    List<VariantProduct> findByProductId(Long productId);
}
