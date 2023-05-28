//package ProjectR2s.App.controller;
//
//import ProjectR2s.App.dto.ProductDTO;
//import ProjectR2s.App.entity.Product;
//import ProjectR2s.App.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//
////    Get API category theo Product & paging
//    @GetMapping("")
//
//    public ResponseEntity<List<ProductDTO>> getAllProductsByCategory(
//            @RequestParam("category") Long categoryId,
//            @RequestParam(value = "page", defaultValue = "0") int page,
//            @RequestParam(value = "size", defaultValue = "5") int size) {
//
//        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
//        List<ProductDTO> products = productService.getProductsByCategory(categoryId, pageable).getContent();
//
//        return ResponseEntity.ok(products);
//    }
////   Get API Product with ID
//    @GetMapping("/{productId}")
//    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
//        ProductDTO productDTO = productService.getProductById(productId);
//        if (productDTO != null) {
//            return ResponseEntity.ok(productDTO);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//
////    @PostMapping
////    public ResponseEntity<ProductDTO> createProduct(
////            @RequestBody ProductDTO productDTO,
////            @AuthenticationPrincipal UserDetails userDetails
////    ) {
////        if (userDetails != null && userDetails.getUsername().equals("admin")) {
////            ProductDTO createdProduct = productService.createProduct(productDTO);
////            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
////        }
////        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
////    }
////
////    @PutMapping("/{productId}")
////    public ResponseEntity<ProductDTO> updateProduct(
////            @PathVariable Long productId,
////            @RequestBody ProductDTO productDTO,
////            @AuthenticationPrincipal UserDetails userDetails
////    ) {
////        if (userDetails != null && userDetails.getUsername().equals("admin")) {
////            ProductDTO updatedProduct = productService.updateProduct(productId, productDTO);
////            if (updatedProduct != null) {
////                return ResponseEntity.ok(updatedProduct);
////            }
////            return ResponseEntity.notFound().build();
////        }
////        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
////    }
////
////    // Endpoint cho việc thêm/sửa Variant Product tương tự như Endpoint cho Product
////
////    @DeleteMapping("/{productId}")
////    public ResponseEntity<Void> deleteProduct(
////            @PathVariable Long productId,
////            @AuthenticationPrincipal UserDetails userDetails
////    ) {
////        if (userDetails != null && userDetails.getUsername().equals("admin")) {
////            productService.deleteProduct(productId);
////            return ResponseEntity.noContent().build();
////        }
////        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
////    }
//
//}