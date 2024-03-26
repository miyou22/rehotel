package com.hotel.backend.controller;

import com.hotel.backend.dto.BoardDto;
import com.hotel.backend.entity.Board;
import com.hotel.backend.repository.BoardRepository;
import com.hotel.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;
    private BoardService boardService;



    //faq 게시글 목록
    @GetMapping("/faq")
    public List<Board> faqList(){
        System.out.println("Vue Gethering Test.....");
        List<Board> faqList = boardRepository.findByBoardCategory("faq");
//        List<Board> faqList = boardRepository.findAll();
        System.out.println("faq 리스트 ==> " + faqList);

        return faqList;
    }

    //공지사항 목록
    @GetMapping("/notice")
    public List<Board> noticeList(){
        List<Board> noticeList = boardRepository.findByBoardCategory("공지사항");
        return noticeList;
    }

    //문의사항 목록
    @GetMapping("/inquiry")
    public List<Board> inquiryList(){
        List<Board> inquiryList = boardRepository.findByBoardCategory("문의사항");
        return inquiryList;
    }

    //게시판 전체 목록
    @GetMapping("/board")
    public List<Board> boardList(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    //게시판 글 작성
    @PostMapping("/board/write")
        public void saveWriter(@RequestBody Board board){
        System.out.println("게시판정보 ==> " + board);
        board.setBoardSn(board.getBoardSn());
        board.setBoardCategory(board.getBoardCategory());
        board.setBoardTitle(board.getBoardTitle());
        board.setCreatedAt(LocalDateTime.now());

        boardRepository.save(board);
    }

    //게시판 글 상세보기
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @GetMapping("/board/detail/{boardSn}")
    public Optional<Board> boardView(@PathVariable(name = "boardSn") Long boardSn, Model model){
        Optional<Board> board = boardRepository.findById(boardSn);

        System.out.println("게시판 리스트 ==> " + board);

        return board;

    }

}
