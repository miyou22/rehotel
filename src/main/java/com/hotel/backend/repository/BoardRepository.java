package com.hotel.backend.repository;

import com.hotel.backend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByBoardCategory(String category);

}
