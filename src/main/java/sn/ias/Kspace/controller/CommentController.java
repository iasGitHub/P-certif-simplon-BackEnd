package sn.ias.Kspace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ias.Kspace.entities.Comment;
import sn.ias.Kspace.entities.Publication;
import sn.ias.Kspace.service.CommentService;
import sn.ias.Kspace.service.PublicationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    private PublicationService publicationService;

    public CommentController(CommentService commentService, PublicationService publicationService) {
        this.commentService = commentService;
        this.publicationService = publicationService;

    }

    // add comment
    @PostMapping("/")
    public ResponseEntity<Comment> add(@RequestBody Comment comment) {
        return ResponseEntity.ok(this.commentService.addComment(comment));
    }

    // update comment
    @PutMapping("/")
    public ResponseEntity<Comment> update(@RequestBody Comment comment) {
        return ResponseEntity.ok(this.commentService.updateComment(comment));
    }

    // get all comments of an id
    @GetMapping("/publication/{id}")
    public ResponseEntity<?> getCommentsOfPub(@PathVariable("id") Long id) {

        Publication publication = this.publicationService.getPublication(id);
        Set<Comment> comments = publication.getComments();
        List list = new ArrayList(comments);
        if (list.size() > publication.getNbreOfViews()) {
            list = list.subList(0, publication.getNbreOfViews() +1);
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    // get single pub by id
    @GetMapping("/{id}")
    public Comment get(@PathVariable("id") Long id) {
        return this.commentService.getComment(id);
    }

    // delete pub
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.commentService.deleteComment(id);
    }

}
