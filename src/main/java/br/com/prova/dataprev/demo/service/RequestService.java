package br.com.prova.dataprev.demo.service;

import br.com.prova.dataprev.demo.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestService requestService;

    public Request save(Request request){
        requestService.save(request);
        return request;
    }
}
