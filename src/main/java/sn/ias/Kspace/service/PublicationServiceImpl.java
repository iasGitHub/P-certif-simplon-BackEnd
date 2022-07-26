package sn.ias.Kspace.service;

import org.springframework.stereotype.Service;
import sn.ias.Kspace.entities.Category;
import sn.ias.Kspace.entities.Publication;
import sn.ias.Kspace.entities.User;
import sn.ias.Kspace.repository.PublicationRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepository publicationRepository;

    public PublicationServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public Publication addPublication(Publication publication) {
        return this.publicationRepository.save(publication);
    }

    @Override
    public Publication updatePublication(Publication publication) {
        return this.publicationRepository.save(publication);
    }

    @Override
    public Set<Publication> getPublications() {
        return new HashSet<>(this.publicationRepository.findAll());
    }

    @Override
    public Publication getPublication(Long id) {
        return this.publicationRepository.findById(id).get();
    }

    @Override
    public void deletePublication(Long id) {

        this.publicationRepository.deleteById(id);
    }

    @Override
    public List<Publication> getPublicationsOfCategory(Category category) {
        return this.publicationRepository.findByCategory(category);
    }

    // les publications qui sont actives
    @Override
    public List<Publication> getActivePublications() {
        return this.publicationRepository.findByActive(true);
    }

    // les publications actives d'une catégories spécifiques
    @Override
    public List<Publication> getActivePublicationsOfCategory(Category category) {
        return this.publicationRepository.findByCategoryAndActive(category, true);
    }
}
