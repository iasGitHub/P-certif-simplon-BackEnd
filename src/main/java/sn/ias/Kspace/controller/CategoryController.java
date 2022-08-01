package sn.ias.Kspace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ias.Kspace.entities.Category;
import sn.ias.Kspace.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // add category
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    // get category
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return this.categoryService.getCategory(id);
    }

    // get all categories
    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    // update category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryService.updateCategory(category);
    }

    // delete category
    @DeleteMapping("/{id}")
    public void deleteCategoriy(@PathVariable("id") Long id) {
        this.categoryService.deleteCategory(id);
    }
}
