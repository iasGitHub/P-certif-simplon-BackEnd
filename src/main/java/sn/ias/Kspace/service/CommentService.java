package sn.ias.Kspace.service;

import sn.ias.Kspace.entities.Comment;
import sn.ias.Kspace.entities.Publication;

import java.util.Set;

public interface CommentService {
    public Comment addComment(Comment comment);
    public Comment updateComment(Comment comment);
    public Set<Comment> getComments();

    public Comment getComment(Long id);

    public void deleteComment(Long id);

    public Set<Comment> getCommentsOfPub(Publication publication);
}
