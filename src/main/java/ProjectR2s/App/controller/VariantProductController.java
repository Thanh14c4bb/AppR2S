package ProjectR2s.App.controller;

import ProjectR2s.App.dto.VariantProductDTO;
import ProjectR2s.App.service.VariantProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/variant")
public class VariantProductController {
    @Autowired
    private VariantProductService variantProductService;

    @GetMapping("/productId/{productId}")
    public ResponseEntity<List<VariantProductDTO>> getVariantProductsByProductId(
            @PathVariable Long productId) {
        List<VariantProductDTO> variantProducts =
                variantProductService.getVariantProductsByProductId(productId);
        return ResponseEntity.ok(variantProducts);
    }
}
