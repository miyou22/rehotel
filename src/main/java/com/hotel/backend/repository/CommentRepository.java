package com.hotel.backend.repository;

import com.hotel.backend.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Long> {}
