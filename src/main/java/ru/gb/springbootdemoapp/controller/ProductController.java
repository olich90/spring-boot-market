package ru.gb.springbootdemoapp.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.springbootdemoapp.converter.ProductMapper;
import ru.gb.springbootdemoapp.dto.ProductDto;
import ru.gb.springbootdemoapp.service.ProductService;

@Controller
public class ProductController {

  private final ProductService productService;
  private final ProductMapper productMapper;

  public ProductController(ProductService productService, ProductMapper productMapper) {
    this.productService = productService;
    this.productMapper = productMapper;
  }

  @GetMapping
  public String getAllProducts(Model model) {
    List<ProductDto> products =  productService.getAll().stream()
        .map(productMapper::productToProductDto).collect(Collectors.toList());
    model.addAttribute("products", products);
    return "product_list";
  }

  @GetMapping("/info/{id}")
  public String getProductInfo(@PathVariable Long id, Model model) {
    model.addAttribute("product", productMapper.productToProductDto(productService.findById(id).orElse(null)));
    return "product_info";
  }
}
