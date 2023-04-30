package infsus.closet.closet.service;

import infsus.closet.closet.model.Comment;
import infsus.closet.closet.repo.CommentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepo commentRepository;

    @Autowired
    public CommentService(CommentRepo commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}

