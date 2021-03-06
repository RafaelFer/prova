package br.com.prova.dataprev.demo.dto;

import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.model.Request;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RequestDTO {

    private Long id;
    private String description;
    private LocalDateTime created = LocalDateTime.now();

    public RequestDTO(Request request) {
        this.id = request.getId();
        this.description = request.getDescription();
        this.created = request.getCreated();
        this.products = request.getProducts();
    }

    private List<Product> products = new ArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static Page<RequestDTO> converter(Page<Request> requests) {
        return requests.map(RequestDTO::new);
    }
}
