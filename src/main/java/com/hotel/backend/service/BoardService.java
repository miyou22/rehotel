package com.hotel.backend.service;

import com.hotel.backend.dto.BoardDto;
import com.hotel.backend.entity.Board;
import com.hotel.backend.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DTO -> Entity  (entity class)
//Entity -> DTO  (dto class)


@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

//    public void write(BoardDto boardDto){
//        Board board = Board.toWriteEntity(boardDto);
//        boardRepository.save(board);
//    }

}
