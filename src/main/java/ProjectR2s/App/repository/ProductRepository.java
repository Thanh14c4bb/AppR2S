//package ProjectR2s.App.repository;
//
//import ProjectR2s.App.dto.ProductDTO;
//import ProjectR2s.App.entity.Product;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ProductRepository extends JpaRepository<Product, Long> {
//    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);
//
//    void delete(ProductDTO existingProduct);
//}
