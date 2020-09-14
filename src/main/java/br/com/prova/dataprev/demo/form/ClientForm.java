package br.com.prova.dataprev.demo.form;

import br.com.prova.dataprev.demo.model.Client;
import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.repository.ClientRepository;
import br.com.prova.dataprev.demo.repository.ProductRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientForm {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull @NotEmpty
    private Long taxid;

    public Client update(Long id, ClientRepository clientRepository) {
        Client client = clientRepository.getOne(id);

        client.setName(this.name);
        client.setTaxid(this.taxid);

        return client;
    }
}
