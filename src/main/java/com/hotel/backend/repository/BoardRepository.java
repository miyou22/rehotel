package com.hotel.backend.repository;

import com.hotel.backend.entity.Board;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    //----------------------------------------
    // 조회수 증가
    //----------------------------------------
    @Modifying
    @Query("update Board b set b.boardCnt = b.boardCnt +1 where b.boardSn = :boardSn")
    int updateView(Long boardSn);


}
