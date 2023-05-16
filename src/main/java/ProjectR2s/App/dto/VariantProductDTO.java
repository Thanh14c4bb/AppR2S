package ProjectR2s.App.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VariantProductDTO {
    private int id;
    private String name;

    private String size;

    private Float price;

}