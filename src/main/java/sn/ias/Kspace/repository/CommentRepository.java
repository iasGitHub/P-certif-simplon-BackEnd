package sn.ias.Kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.ias.Kspace.entities.Comment;
@CrossOrigin("*")
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
