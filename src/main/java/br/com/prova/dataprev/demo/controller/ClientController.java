package br.com.prova.dataprev.demo.controller;

import br.com.prova.dataprev.demo.dto.ClientDTO;
import br.com.prova.dataprev.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public Page<ClientDTO> findAll(@PageableDefault(direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pagination){
        return clientService.listClients(pagination);
    }
}
