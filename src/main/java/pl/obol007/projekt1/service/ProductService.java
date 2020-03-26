package pl.obol007.projekt1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.Product;
import pl.obol007.projekt1.domain.repositories.BusinessRepository;
import pl.obol007.projekt1.domain.repositories.ProductRepository;
import pl.obol007.projekt1.dto.ProductDTO;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProductService {

    BusinessRepository businessRepository;
    ProductRepository productRepository;

    public ProductService(BusinessRepository businessRepository, ProductRepository productRepository) {
        this.businessRepository = businessRepository;
        this.productRepository = productRepository;
    }

    public void addProduct(ProductDTO productDTO) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Business business = businessRepository.findByUsername(username);

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setQuantity(productDTO.getQuantity());
        product.setDescription(productDTO.getDescription());
        product.setBusiness(business);
        productRepository.save(product);

//
   //     business.addProduct(product);
//
//        businessRepository.save(business);
    }

    public ProductDTO findProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(productId);
            productDTO.setName(product.getName());
            productDTO.setCategory(product.getCategory());
            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            productDTO.setQuantity(product.getQuantity());
            return productDTO;
        } else return new ProductDTO();
//        return optionalProduct.orElseGet(Product::new);
    }

    public void update(ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(productDTO.getId());
        //TODO: why get is highlighted?
        Product product = optionalProduct.get();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setQuantity(productDTO.getQuantity());
        product.setDescription(productDTO.getDescription());
        productRepository.save(product);


    }

    public void remove(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);
        }
    }
}

