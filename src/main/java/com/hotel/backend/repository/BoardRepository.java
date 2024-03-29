package com.hotel.backend.repository;

import com.hotel.backend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByBoardCategory(String category);

    List<Board> findByBoardStatus(String boardStatus);

    List<Board> findByBoardCategoryAndBoardStatus(String boardCategory, String boardStatus);

    //----------------------------------------
    // 검색기능: Containing을 붙여주면 Like 검색이 가능해진다. 즉, %{keyword}%가 가능하다
    //----------------------------------------
    List<Board> findByBoardTitleContaining(String keyword);

    List<Board> findByBoardCategoryAndBoardTitleContaining(String keyword, String boardCategory);

}
