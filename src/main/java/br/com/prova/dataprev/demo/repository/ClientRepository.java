package br.com.prova.dataprev.demo.repository;

import br.com.prova.dataprev.demo.model.Client;
import br.com.prova.dataprev.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
