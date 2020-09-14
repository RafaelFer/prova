package br.com.prova.dataprev.demo.service;

import br.com.prova.dataprev.demo.dto.ClientDTO;
import br.com.prova.dataprev.demo.model.Client;
import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<ClientDTO> listClients(Pageable pagination){
        Page<Client> clients =  clientRepository.findAll(pagination);
        return ClientDTO.converter(clients);
    }

    public Client save(Client client){
        clientRepository.save(client);
        return client;
    }

    public boolean delete(Long id){
        Optional<Client> product = clientRepository.findById(id);
        if (product.isPresent()) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }




}
