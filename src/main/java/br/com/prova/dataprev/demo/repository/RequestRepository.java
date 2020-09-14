package br.com.prova.dataprev.demo.repository;

import br.com.prova.dataprev.demo.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {


}
