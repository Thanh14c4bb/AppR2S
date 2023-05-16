package ProjectR2s.App.controller;

import ProjectR2s.App.dto.ProductDTO;
import ProjectR2s.App.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

//    Get API category theo Product & paging
    @GetMapping("")

    public ResponseEntity<List<ProductDTO>> getAllProductsByCategory(
            @RequestParam("category") Long categoryId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<ProductDTO> products = productService.getProductsByCategory(categoryId, pageable).getContent();

        return ResponseEntity.ok(products);
    }
//   Get API Product with ID
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {
        ProductDTO productDTO = productService.getProductById(productId);
        if (productDTO != null) {
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }

}