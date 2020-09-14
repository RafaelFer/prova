package br.com.prova.dataprev.demo.service;

import br.com.prova.dataprev.demo.dto.ProductDTO;
import br.com.prova.dataprev.demo.form.ProductForm;
import br.com.prova.dataprev.demo.model.Product;
import br.com.prova.dataprev.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<ProductDTO> listaProduct(Pageable pagination){
        Page<Product> products =  productRepository.findAll(pagination);
        return ProductDTO.converter(products);
    }

    public Page<ProductDTO> listaProduct(String productName, Pageable pagination){
        Page<Product> products =  productRepository.findProductByName(productName,pagination);
        return ProductDTO.converter(products);
    }

    public Product save(Product product){
        productRepository.save(product);
        return product;
    }

    public ProductDTO findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ProductDTO.converter(product.get());
        }
        return null;
    }

    public boolean delete(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ProductDTO update(Long id, ProductForm productNew){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setName(productNew.getName());
            product.get().setDescription(productNew.getDescription());
            product.get().setPrice(productNew.getPrice());
            return ProductDTO.converter(product.get());
        }else{
            return null;
        }
    }


}
