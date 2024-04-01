package com.hotel.backend.service;

import com.hotel.backend.dto.BoardDto;
import com.hotel.backend.entity.Board;
import com.hotel.backend.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//DTO -> Entity  (entity class)
//Entity -> DTO  (dto class)


@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    //---------------------------------------------------------------------------------------------------------------------
    // 게시글 검색
    //---------------------------------------------------------------------------------------------------------------------
    @Transactional
    public List<Board> search(String keyword, String boardCategory){
        if ("inquiry".equalsIgnoreCase(boardCategory)) {
            return boardRepository.findByBoardCategoryAndBoardTitleContaining(boardCategory, keyword);
        } else if ("notice".equalsIgnoreCase(boardCategory)) {
            return boardRepository.findByBoardCategoryAndBoardTitleContaining(boardCategory, keyword);
        }
        List<Board> boardList = boardRepository.findByBoardTitleContaining(keyword);
        return boardList;
    }
    // ---------------------------------------------------------------------------------------------------------------------
    // 게시글 수정
    //---------------------------------------------------------------------------------------------------------------------
    public Board update(BoardDto boardDto) {
        System.out.println("게시글번호 : " + boardDto.getBoardSn());
        System.out.println("게시판제목 : " + boardDto.getBoardTitle());
        Long boardSn = boardDto.getBoardSn();
        Board board = boardRepository.findById(boardSn).orElseThrow(()-> new RuntimeException(boardSn + "에 해당하는 글이 존재하지 않습니다."));
        board.setBoardCategory(boardDto.getBoardCategory());
        board.setBoardTitle(boardDto.getBoardTitle());
        board.setBoardContent(boardDto.getBoardContent());

        return boardRepository.save(board);
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 게시판 글 삭제대기
    //---------------------------------------------------------------------------------------------------------------------
    public Board change(BoardDto boardDto) {
        Long boardSn = boardDto.getBoardSn();
        String boardStatus = boardDto.getBoardStatus();
        Board board = boardRepository.findById(boardSn).orElseThrow(()-> new RuntimeException(boardSn + "에 해당하는 글이 존재하지 않습니다."));

        if ("N".equals(boardStatus)) {
            // 상태를 "Y"로 변경합니다.
            board.setBoardStatus("Y");
        } else if ("Y".equals(boardStatus)) {
            //   "N"으로 변경합니다.
            board.setBoardStatus("N");
        }else {
            // 예외 처리: 유효하지 않은 action 값이 들어온 경우
            System.out.println("board" + boardStatus);
            throw new IllegalArgumentException("유효하지 않은 액션 값입니다.");
        }
//        board.setBoardStatus("Y");
        return boardRepository.save(board);
    }
    //---------------------------------------------------------------------------------------------------------------------
    // 게시판 삭제 대기 글 삭제
    //---------------------------------------------------------------------------------------------------------------------
    @Transactional
    public void deleteBoard(BoardDto boardDto) {
        Long boardSn = boardDto.getBoardSn();
        Board board = boardRepository.findById(boardSn)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다: " + boardSn));
        boardRepository.delete(board);
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 게시판 조회수 증가
    //---------------------------------------------------------------------------------------------------------------------
    @Transactional
    public int updateView(Long boardSn){
        System.out.println("조회asdfsdafasdfsadfasdfdasf  " + boardSn);
        System.out.println("이거 나와야됨");

        return boardRepository.updateView(boardSn);
    }

}
