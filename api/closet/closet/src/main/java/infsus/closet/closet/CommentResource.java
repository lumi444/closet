package infsus.closet.closet;


import infsus.closet.closet.model.Comment;
import infsus.closet.closet.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentResource {

    private final CommentService commentService;

    @Autowired
    public CommentResource(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        if (comment.isPresent()) {
            return ResponseEntity.ok(comment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.saveComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable("id") Long id,@RequestBody Comment comment) {
        Optional<Comment> existingComment = commentService.getCommentById(id);
        if (existingComment.isPresent()) {
            Comment updatedComment = commentService.saveComment(comment);
            return ResponseEntity.ok(updatedComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("id") Long id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        if (comment.isPresent()) {
            commentService.deleteCommentById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

