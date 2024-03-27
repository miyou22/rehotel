package com.hotel.backend.service;

import com.hotel.backend.dto.BoardDto;
import com.hotel.backend.entity.Board;
import com.hotel.backend.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//DTO -> Entity  (entity class)
//Entity -> DTO  (dto class)


@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

//    public void save(BoardDto boardDto){
//        Board board = board.save(boardDto);
//        boardRepository.save(board);
//    }


    //---------------------------------------------------------------------------------------------------------------------
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
        Board board = boardRepository.findById(boardSn).orElseThrow(()-> new RuntimeException(boardSn + "에 해당하는 글이 존재하지 않습니다."));
        board.setBoardStatus("Y");

        return boardRepository.save(board);
    }



}
