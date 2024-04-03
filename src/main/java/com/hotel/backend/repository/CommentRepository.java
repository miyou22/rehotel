package com.hotel.backend.repository;

import com.hotel.backend.entity.Board;
import com.hotel.backend.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comments, Long> {
    List<Comments> findByboardSnAndCommentStatus(Long boardSn, String commentStatus);
    List<Comments> findBycommentStatus(String commentStatus);

}
