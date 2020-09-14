package br.com.prova.dataprev.demo.dto;

import br.com.prova.dataprev.demo.model.Client;
import br.com.prova.dataprev.demo.model.Product;
import org.springframework.data.domain.Page;

public class ClientDTO {

    private Long id;
    private String name;
    private long taxid;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.taxid = client.getTaxid();
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

    public long getTaxid() {
        return taxid;
    }

    public void setTaxid(long taxid) {
        this.taxid = taxid;
    }

    public static Page<ClientDTO> converter(Page<Client> client) {
        return client.map(ClientDTO::new);
    }

}
