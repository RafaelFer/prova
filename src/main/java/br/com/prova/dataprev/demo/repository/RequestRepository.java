package br.com.prova.dataprev.demo.repository;

import br.com.prova.dataprev.demo.dto.RequestDTO;
import br.com.prova.dataprev.demo.form.RequestForm;
import br.com.prova.dataprev.demo.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

public interface RequestRepository extends JpaRepository<Request, Long> {


}
