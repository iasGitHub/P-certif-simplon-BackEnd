package sn.ias.Kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ias.Kspace.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
