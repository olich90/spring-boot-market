package ru.gb.springbootdemoapp.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import ru.gb.springbootdemoapp.model.Category;
import ru.gb.springbootdemoapp.repository.CategoryRepository;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<String> getAllTitles() {
    return categoryRepository.findAll().stream().map(Category::getTitle).collect(Collectors.toList());
  }
}
