package sn.ias.Kspace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ias.Kspace.entities.Category;
import sn.ias.Kspace.entities.Publication;
import sn.ias.Kspace.entities.User;
import sn.ias.Kspace.service.PublicationService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/publication")
public class PublicationController {

    private PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    // add pub
    @PostMapping("/")
    public ResponseEntity<Publication> add(@RequestBody Publication publication) {
        return ResponseEntity.ok(this.publicationService.addPublication(publication));
    }

    // update pub
    @PutMapping("/")
    public ResponseEntity<Publication> update(@RequestBody Publication publication) {
        return ResponseEntity.ok(this.publicationService.updatePublication(publication));
    }

    // get all pub
    @GetMapping("/")
    public ResponseEntity<?> publications() {
        return ResponseEntity.ok(this.publicationService.getPublications());
    }

    // get single pub by id
    @GetMapping("/{id}")
    public Publication publication(
            @PathVariable("id") Long id) {
         return this.publicationService.getPublication(id);
    }

    // delete pub
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.publicationService.deletePublication(id);
    }

    @GetMapping("/category/{id}")
    public List<Publication> getPublicationsOfCategory(@PathVariable("id") Long id) {
        Category category = new Category();
        category.setId(id);
        return this.publicationService.getPublicationsOfCategory(category);
    }

    @GetMapping("/active")
    public List<Publication> getActivePublications() {
        return this.publicationService.getActivePublications();
    }
    @GetMapping("/category/active/{id}")
    public List<Publication> getActivePublicationOfCategory(@PathVariable("id") Long id) {
        Category category = new Category();
        category.setId(id);
        return this.publicationService.getActivePublicationsOfCategory(category);
    }

}
