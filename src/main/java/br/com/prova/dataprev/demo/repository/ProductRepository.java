package br.com.prova.dataprev.demo.repository;

import br.com.prova.dataprev.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findProductByName(String productName, Pageable pagination);

}
