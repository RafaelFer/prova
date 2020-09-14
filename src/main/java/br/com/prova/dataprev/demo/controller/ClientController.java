package br.com.prova.dataprev.demo.controller;

import br.com.prova.dataprev.demo.dto.ClientDTO;
import br.com.prova.dataprev.demo.dto.ProductDTO;
import br.com.prova.dataprev.demo.form.ClientForm;
import br.com.prova.dataprev.demo.form.ProductForm;
import br.com.prova.dataprev.demo.model.Client;
import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public Page<ClientDTO> findAll(@PageableDefault(direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pagination){
        return clientService.listClients(pagination);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClientDTO> register(@RequestBody @Valid ClientForm form, UriComponentsBuilder uriBuilder) {
        Client client = form.converter();
        clientService.save(client);
        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDTO(client));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(clientService.delete(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
