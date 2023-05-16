package ProjectR2s.App.service;

import ProjectR2s.App.dto.ProductDTO;
import ProjectR2s.App.entity.Product;
import ProjectR2s.App.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public ProductDTO getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return convertToDTO(product);
        }
        return null;
    }
    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName());
    }

    public Page<ProductDTO> getProductsByCategory(Long categoryId, Pageable pageable) {
        Page<Product> productPage = productRepository.findByCategoryId(categoryId, pageable);
        List<ProductDTO> productDTOs = productPage.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(productDTOs, pageable, productPage.getTotalElements());
    }
}
