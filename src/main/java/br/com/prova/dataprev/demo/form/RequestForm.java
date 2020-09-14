package br.com.prova.dataprev.demo.form;

import br.com.prova.dataprev.demo.dto.ProductDTO;
import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.model.Request;
import br.com.prova.dataprev.demo.service.ProductService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class RequestForm {

    @NotNull
    @NotEmpty
    private String description;
    private List<Integer> products = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> products) {
        this.products = products;
    }

    public Request converter(String description, List<Integer> products, ProductService productService) {

        Request request = new Request();
        List<Product> listProduct = new ArrayList<>();

        for (Integer product : products) {
            ProductDTO productDTO = productService.findById(product.longValue());
            listProduct.add(ProductDTO.converter(productDTO));
        }

        request.setDescription(description);
        request.setProducts(listProduct);
        return request;
    }

}
