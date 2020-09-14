package br.com.prova.dataprev.demo.form;

import br.com.prova.dataprev.demo.model.Client;
import br.com.prova.dataprev.demo.model.Request;
import br.com.prova.dataprev.demo.repository.ClientRepository;
import br.com.prova.dataprev.demo.repository.RequestRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RequestForm {

    @NotNull
    @NotEmpty
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
