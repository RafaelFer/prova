package br.com.prova.dataprev.demo.form;




import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.repository.ProductRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductForm {

    private Long id;
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String description;
    @NotNull @NotEmpty
    private BigDecimal price;

    public Product update(Long id, ProductRepository productRepository) {
        Product product = productRepository.getOne(id);

        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        return product;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product converter() {
        return new Product(name, description, price);
    }
}
