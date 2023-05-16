package ProjectR2s.App.service;

import ProjectR2s.App.dto.VariantProductDTO;
import ProjectR2s.App.entity.VariantProduct;
import ProjectR2s.App.repository.VariantProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VariantProductService {
    @Autowired
    private VariantProductRepository variantProductRepository;
    public List<VariantProductDTO> getVariantProductsByProductId(Long productId) {
        List<VariantProduct> variantProducts = variantProductRepository.findByProductId(productId);

        return variantProducts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private VariantProductDTO convertToDTO(VariantProduct variantProduct) {
        VariantProductDTO variantProductDTO = new VariantProductDTO();
        variantProductDTO.setId(variantProduct.getId());
        variantProductDTO.setName(variantProduct.getName());
        variantProductDTO.setSize(variantProduct.getSize());
        return variantProductDTO;
    }
    }