package com.hotel.backend.controller;

import com.hotel.backend.dto.BoardDto;
import com.hotel.backend.entity.Board;
import com.hotel.backend.repository.BoardRepository;
import com.hotel.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;


    //---------------------------------------------------------------------------------------------------------------------
    // faq 목록
    //---------------------------------------------------------------------------------------------------------------------
    @GetMapping("/faq")
    public List<Board> faqList(){
        System.out.println("Vue Gethering Test.....");
        List<Board> faqList = boardRepository.findByBoardCategoryAndBoardStatus("faq","N");
//        List<Board> faqList = boardRepository.findAll();
        System.out.println("faq 리스트 ==> " + faqList);
        return faqList;
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 공지사항 목록
    //---------------------------------------------------------------------------------------------------------------------
    @GetMapping("/notice")
    public List<Board> noticeList(){
        List<Board> noticeList = boardRepository.findByBoardCategoryAndBoardStatus("notice","N");
        System.out.println("잊지말고제발.." + noticeList);

        return noticeList;
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 문의사항 목록
    //---------------------------------------------------------------------------------------------------------------------
    @GetMapping("/inquiry")
    public List<Board> inquiryList(){
        List<Board> inquiryList = boardRepository.findByBoardCategoryAndBoardStatus("inquiry","N");
        return inquiryList;
    }


    //---------------------------------------------------------------------------------------------------------------------
    // 게시판 정보 수정
    //---------------------------------------------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @GetMapping("/{boardCategory}/{boardSn}")
    public Optional<Board> boardCategoryView(@PathVariable(name = "boardSn") Long boardSn, @PathVariable(name = "boardCategory") String boardCategory){

        System.out.println("게시판 리스트 ==> ");
        Optional<Board> board = boardRepository.findById(boardSn);

        System.out.println("게시판 리스트 ==> " + board);
        System.out.println(boardSn);

        return board;
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 게시판 검색  => RESTful Api,
    //---------------------------------------------------------------------------------------------------------------------
    @GetMapping("/admin/board/search")
    public ResponseEntity<List<Board>> search(@RequestParam(value="keyword") String keyword,
                                              @RequestParam(value = "boardCategory") String boardCategory){
        List<Board> searchList = boardService.search(keyword, boardCategory);
        return ResponseEntity.ok().body(searchList);
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 관리자 게시판 리스트 불러오기
    //---------------------------------------------------------------------------------------------------------------------
    @GetMapping("/admin/board")
    public List<Board> boardList(){
        List<Board> boardList = boardRepository.findByBoardStatus("N");
        return boardList;
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 관리자 게시판 글 작성
    //---------------------------------------------------------------------------------------------------------------------
    @PostMapping("/admin/board/write")
        public void saveWriter(@RequestBody Board board){
        System.out.println("게시판정보 ==> " + board);

        board.setCreatedAt(LocalDateTime.now());
        boardRepository.save(board);
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 관리자 게시판 상세보기
    //---------------------------------------------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @GetMapping("/admin/board/detail/{boardSn}")
    public Optional<Board> boardView(@PathVariable(name = "boardSn") Long boardSn, Model model){
        Optional<Board> board = boardRepository.findById(boardSn);

        System.out.println("게시판 리스트 ==> " + board);
        System.out.println(boardSn);

        return board;
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 관리자 게시판 정보 수정
    //---------------------------------------------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PutMapping("/admin/board/update/{boardSn}")
    // @PatchMapping("/item")
    public Board updateorChange(@RequestBody BoardDto boardDto) {
        System.out.println("수정 요청으로 받은 정보 : " + boardDto);
            return boardService.update(boardDto);

    }
    //---------------------------------------------------------------------------------------------------------------------
    // 관리자 삭제대기 리스트 불러오기
    //---------------------------------------------------------------------------------------------------------------------
    @GetMapping("/admin/deletePost")
    public List<Board> PutBoardList(){
        List<Board> boardList = boardRepository.findByBoardStatus("Y");
        return boardList;
    }

    //---------------------------------------------------------------------------------------------------------------------
    //관리자 게시판 글 삭제대기로 변환하기
    //---------------------------------------------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PutMapping("/admin/board/detail/{boardSn}")
    public Board change(@RequestBody BoardDto boardDto) {
        System.out.println("수정 요청으로 받은 정보 : " + boardDto);

        return boardService.change(boardDto);
    }

    //---------------------------------------------------------------------------------------------------------------------
    // 관리자 게시판 삭제 대기 글 삭제
    //---------------------------------------------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @DeleteMapping("/admin/deletePost/{boardSn}")
    public void deleteBoard(@RequestBody BoardDto boardDto) {
        System.out.println("삭제요청정보 : " + boardDto);
        boardService.deleteBoard(boardDto);
    }
}
