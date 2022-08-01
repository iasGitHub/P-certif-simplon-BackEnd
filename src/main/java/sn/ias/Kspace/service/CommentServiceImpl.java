package sn.ias.Kspace.service;

import org.springframework.stereotype.Service;
import sn.ias.Kspace.entities.Comment;
import sn.ias.Kspace.entities.Publication;
import sn.ias.Kspace.repository.CommentRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment addComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    @Override
    public Set<Comment> getComments() {
        return new HashSet<>(this.commentRepository.findAll());
    }

    @Override
    public Comment getComment(Long id) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        Comment comment = new Comment();
        comment.setId(id);
        this.commentRepository.delete(comment);
    }

    @Override
    public Set<Comment> getCommentsOfPub(Publication publication) {
        return null;
    }
}
