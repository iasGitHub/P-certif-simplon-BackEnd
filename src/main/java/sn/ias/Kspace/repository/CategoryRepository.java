package sn.ias.Kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ias.Kspace.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
