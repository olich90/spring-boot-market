package ru.gb.springbootdemoapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.gb.springbootdemoapp.aop.Profiling;
import ru.gb.springbootdemoapp.model.Product;
import ru.gb.springbootdemoapp.repository.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Profiling
  public List<Product> getAll() {
    return productRepository.findAll();
  }

  @Profiling
  public void save(Product product) {
    productRepository.save(product);
  }

  @Profiling
  public Product findById(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  @Profiling
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }
}
