package br.com.prova.dataprev.demo.controller;

import br.com.prova.dataprev.demo.dto.RequestDTO;
import br.com.prova.dataprev.demo.form.RequestForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/request")
public class RequestController {

    @PostMapping
    @Transactional
    public ResponseEntity<RequestDTO> register(@RequestBody @Valid RequestForm form, UriComponentsBuilder uriBuilder) {

        return null;
    }

}
