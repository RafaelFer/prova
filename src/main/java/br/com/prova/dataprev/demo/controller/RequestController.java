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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

        System.out.println(form.getClient());
        return ResponseEntity.created(uri).body(new RequestDTO(request));
    }


}
