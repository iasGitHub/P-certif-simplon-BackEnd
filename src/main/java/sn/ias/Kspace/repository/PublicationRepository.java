package sn.ias.Kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.ias.Kspace.entities.Category;
import sn.ias.Kspace.entities.Publication;

import java.util.List;
@CrossOrigin("*")
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    public List<Publication> findByCategory(Category category);
    public List<Publication> findByActive(Boolean b);
    public List<Publication> findByCategoryAndActive(Category category, Boolean b);
}
