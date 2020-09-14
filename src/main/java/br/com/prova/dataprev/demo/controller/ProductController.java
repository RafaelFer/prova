package br.com.prova.dataprev.demo.controller;

import br.com.prova.dataprev.demo.dto.ProductDTO;
import br.com.prova.dataprev.demo.form.ProductForm;
import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductDTO> findAll(@RequestParam(required = false) String productName, @PageableDefault(sort = "created", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pagination){
        System.out.println(productName);
        if (productName != null) {
            return productService.listaProduct(productName,pagination);
        }else{
            return productService.listaProduct(pagination);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductDTO> register(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder) {
        Product product = form.converter();
        productService.save(product);
        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDTO(product));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(productService.delete(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<?> findById(@PathVariable Long id) {
        ProductDTO productDTO = productService.findById(id);
        if(productDTO != null){
            return ResponseEntity.ok(productDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody @Valid ProductForm form) {
        ProductDTO productDTO = productService.update(id, form);
        if(productDTO != null){
            return ResponseEntity.ok(productDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
