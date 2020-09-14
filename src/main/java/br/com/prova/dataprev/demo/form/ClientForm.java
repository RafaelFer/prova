package br.com.prova.dataprev.demo.form;

import br.com.prova.dataprev.demo.model.Client;
import br.com.prova.dataprev.demo.repository.ClientRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientForm {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull @NotEmpty
    private Long taxid;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTaxid() {
        return taxid;
    }

    public void setTaxid(Long taxid) {
        this.taxid = taxid;
    }

    public Client update(Long id, ClientRepository clientRepository) {
        Client client = clientRepository.getOne(id);

        client.setName(this.name);
        client.setTaxid(this.taxid);

        return client;
    }

    public Client converter() {
        return new Client(name, taxid);
    }
}
