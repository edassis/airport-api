package org.eduardo.airport.service;

import org.eduardo.airport.entity.Category;
import org.eduardo.airport.repository.CategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@ApplicationScoped
public class CategoryService {
    @Inject
    CategoryRepository categoryRepository;

    @Transactional
    public Category get(Long id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    public List<Category> getAll() {
        return categoryRepository.listAll();
    }

    @Transactional
    public Category save(Category category) {
        category.setId(null);
        categoryRepository.persist(category);

        return category;
    }

    @Transactional
    public Category update(Category category) {
        if(categoryRepository.findById(category.getId()) == null) {
            throw new NotFoundException();
        }
        categoryRepository.persist(category);
        return category;
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
