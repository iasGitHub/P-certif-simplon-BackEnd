package sn.ias.Kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ias.Kspace.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}
