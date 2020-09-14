package br.com.prova.dataprev.demo.form;

import br.com.prova.dataprev.demo.dto.ProductDTO;
import br.com.prova.dataprev.demo.model.Client;
import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.model.Request;
import br.com.prova.dataprev.demo.repository.ClientRepository;
import br.com.prova.dataprev.demo.service.ProductService;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestForm {

    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @NotEmpty
    private List<Integer> products = new ArrayList<>();

    @NotNull
    @NotEmpty
    private Long client;

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

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Request converter(RequestForm form, ProductService productService, ClientRepository clientRepository) {

        Request request = new Request();
        List<Product> listProduct = new ArrayList<>();

        for (Integer product : form.getProducts()) {
            ProductDTO productDTO = productService.findById(product.longValue());
            listProduct.add(ProductDTO.converter(productDTO));
        }
        Optional<Client> clientID = clientRepository.findById(form.getClient());
        request.setClient(clientID.get());
        request.setDescription(form.getDescription());
        request.setProducts(listProduct);
        return request;
    }

}
