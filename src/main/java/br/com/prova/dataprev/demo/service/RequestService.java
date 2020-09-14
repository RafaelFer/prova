package br.com.prova.dataprev.demo.service;

import br.com.prova.dataprev.demo.dto.ProductDTO;
import br.com.prova.dataprev.demo.dto.RequestDTO;
import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.model.Request;
import br.com.prova.dataprev.demo.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request save(Request request){
        requestRepository.save(request);
        return request;
    }

    public Page<RequestDTO> listRequest(Pageable pagination){
        Page<Request> requests =  requestRepository.findAll(pagination);
        return RequestDTO.converter(requests);
    }
}
