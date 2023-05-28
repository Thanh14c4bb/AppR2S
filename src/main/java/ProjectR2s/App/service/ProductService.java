//package ProjectR2s.App.service;
//
//import ProjectR2s.App.dto.ProductDTO;
//import ProjectR2s.App.dto.VariantProductDTO;
//import ProjectR2s.App.entity.Product;
//import ProjectR2s.App.entity.VariantProduct;
//import ProjectR2s.App.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.*;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class ProductService {
//    @Autowired
//    private ProductRepository productRepository;
//    public ProductDTO getProductById(Long productId) {
//        Optional<Product> productOptional = productRepository.findById(productId);
//        if (productOptional.isPresent()) {
//            Product product = productOptional.get();
//            return convertToDTO(product);
//        }
//        return null;
//    }
//    private ProductDTO convertToDTO(Product product) {
//        return new ProductDTO(product.getId(), product.getName());
//    }
//
//    public Page<ProductDTO> getProductsByCategory(Long categoryId, Pageable pageable) {
//        Page<Product> productPage = productRepository.findByCategoryId(categoryId, pageable);
//        List<ProductDTO> productDTOs = productPage.getContent().stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//        return new PageImpl<>(productDTOs, pageable, productPage.getTotalElements());
//    }
//
//
//
//
////
////        private final ProductRepository productRepository;
////
////        public ProductService(ProductRepository productRepository) {
////            this.productRepository = productRepository;
////        }
////
////        public ProductDTO getProductById(Long productId) {
////            Optional<Product> productOptional = productRepository.findById(productId);
////            if (productOptional.isPresent()) {
////                Product product = productOptional.get();
////                return convertToDTO(product);
////            }
////            return null;
////        }
////
////        public Page<ProductDTO> getProductsByCategory(Long categoryId, Pageable pageable) {
////            Page<Product> productPage = productRepository.findByCategoryId(categoryId, pageable);
////            List<ProductDTO> productDTOs = productPage.getContent().stream()
////                    .map(this::convertToDTO)
////                    .collect(Collectors.toList());
////            return new PageImpl<>(productDTOs, pageable, productPage.getTotalElements());
////        }
////
////        public ProductDTO createProduct(ProductDTO productDTO) {
////            Product product = convertToEntity(productDTO);
////            Product savedProduct = productRepository.save(product);
////            return convertToDTO(savedProduct);
////        }
////
////        public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
////            Optional<Product> productOptional = productRepository.findById(productId);
////            if (productOptional.isPresent()) {
////                Product product = productOptional.get();
////                product.setName(productDTO.getName());
////                Product updatedProduct = productRepository.save(product);
////                return convertToDTO(updatedProduct);
////            }
////            return null;
////        }
////
////        public void deleteProduct(Long productId) {
////            productRepository.deleteById(productId);
////        }
////
////        private ProductDTO convertToDTO(Product product) {
////            return new ProductDTO(product.getId(), product.getName());
////        }
////
////        private Product convertToEntity(ProductDTO productDTO) {
////            Product product = new Product();
////            product.setName(productDTO.getName());
////            return product;
////        }
//    }
