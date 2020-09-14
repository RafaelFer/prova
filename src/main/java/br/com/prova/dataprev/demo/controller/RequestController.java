package br.com.prova.dataprev.demo.controller;

import br.com.prova.dataprev.demo.dto.ProductDTO;
import br.com.prova.dataprev.demo.dto.RequestDTO;
import br.com.prova.dataprev.demo.form.RequestForm;
import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.model.Request;
import br.com.prova.dataprev.demo.repository.ClientRepository;
import br.com.prova.dataprev.demo.service.ProductService;
import br.com.prova.dataprev.demo.service.RequestService;
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
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<RequestDTO> register(@RequestBody @Valid RequestForm form, UriComponentsBuilder uriBuilder) {
        Request request = form.converter(form,productService,clientRepository);
        requestService.save(request);
        URI uri = uriBuilder.path("/request/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(new RequestDTO(request));
    }


    @GetMapping
    public Page<RequestDTO> findAll(@PageableDefault( direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pagination){
         return requestService.listRequest(pagination);
    }

}
