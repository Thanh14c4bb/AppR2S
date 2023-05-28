package ProjectR2s.App.dto;

import lombok.Data;

import java.util.List;


@Data
public class ProductDTO {
    private Long id;
    private String name;
//    private List<VariantProductDTO> variants;


    public ProductDTO() {
    }

    public ProductDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
