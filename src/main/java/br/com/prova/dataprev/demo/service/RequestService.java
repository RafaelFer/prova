package br.com.prova.dataprev.demo.service;

import br.com.prova.dataprev.demo.model.Request;
import br.com.prova.dataprev.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request save(Request request){
        requestRepository.save(request);
        return request;
    }
}
