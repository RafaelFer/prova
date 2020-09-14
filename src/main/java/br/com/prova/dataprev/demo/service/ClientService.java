package br.com.prova.dataprev.demo.service;

import br.com.prova.dataprev.demo.dto.ClientDTO;
import br.com.prova.dataprev.demo.model.Client;
import br.com.prova.dataprev.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<ClientDTO> listClients(Pageable pagination){
        Page<Client> clients =  clientRepository.findAll(pagination);
        return ClientDTO.converter(clients);
    }
}
