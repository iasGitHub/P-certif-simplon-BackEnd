package sn.ias.Kspace.service;

import org.springframework.stereotype.Service;
import sn.ias.Kspace.entities.Category;
import sn.ias.Kspace.repository.CategoryRepository;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategorieServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategorieServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = new Category();
        category.setId(id);
        this.categoryRepository.delete(category);
    }
}
