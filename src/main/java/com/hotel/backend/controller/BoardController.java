package com.hotel.backend.controller;

import com.hotel.backend.dto.BoardDto;
import com.hotel.backend.entity.Board;
import com.hotel.backend.entity.Member;
import com.hotel.backend.repository.BoardRepository;
import com.hotel.backend.repository.MemberRepository;
import com.hotel.backend.service.BoardService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
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

    @Autowired
    private HttpSession session;

    @Autowired
    private MemberRepository memberRepository;
    //------------------------------------------------------------------------------------
    // faq 리스트
    // -----------------------------------------------------------------------------------
    @GetMapping("/faq")
    public List<Board> faqList(){
        List<Board> faqList = boardRepository.findByBoardCategoryAndBoardStatus("faq","N");
        return faqList;
    }
    //------------------------------------------------------------------------------------
    // 공지사항 리스트
    // -----------------------------------------------------------------------------------
    @GetMapping("/notice")
    public List<Board> noticeList(){
        List<Board> noticeList = boardRepository.findByBoardCategoryAndBoardStatus("notice","N");
        System.out.println("aaa:::" + noticeList);
        return noticeList;
    }
    //------------------------------------------------------------------------------------
    // 문의사항 리스트
    // -----------------------------------------------------------------------------------
    @GetMapping("/inquiry")
    public List<Board> inquiryList(){
        List<Board> inquiryList = boardRepository.findByBoardCategoryAndBoardStatus("inquiry","N");
        return inquiryList;
    }
    //------------------------------------------------------------------------------------
    // 게시판별 글 상세보기
    // -----------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @GetMapping("/{boardCategory}/{boardSn}")
    public Optional<Board> boardCategoryView(@PathVariable(name = "boardSn") Long boardSn, @PathVariable(name = "boardCategory") String boardCategory){
        Optional<Board> board = boardRepository.findById(boardSn);
        boardService.updateView(boardSn);
        System.out.println("board::::::시발" + board);
        return board;
    }
    //------------------------------------------------------------------------------------
    //  게시판 글 검색: RestFul Api
    // -----------------------------------------------------------------------------------
    @GetMapping("/admin/board/search")
    public ResponseEntity<List<Board>> search(@RequestParam(value="keyword") String keyword,
                                              @RequestParam(value = "boardCategory") String boardCategory){
        List<Board> searchList = boardService.search(keyword, boardCategory);
        return ResponseEntity.ok().body(searchList);
    }
    //------------------------------------------------------------------------------------
    // 관리자 게시판 리스트
    // -----------------------------------------------------------------------------------
    @GetMapping("/admin/board")
    public List<Board> boardList(){
        List<Board> boardList = boardRepository.findByBoardStatus("N");
        return boardList;
    }
    //------------------------------------------------------------------------------------
    // 관리자 게시판 글 작성
    // -----------------------------------------------------------------------------------
    @PostMapping("/admin/board/write")
    public void saveWriter(@RequestBody Board board,  HttpSession session){
        Optional<Member> optionalFindMember = memberRepository.findByUserId(board.getUserId());

        if (optionalFindMember.isPresent()) {
            Member findMember = optionalFindMember.get();
            board.setMember(findMember);
        }
        board.setCreatedAt(LocalDateTime.now());
        System.out.println("board::::" + board);
        boardRepository.save(board);

    }
    //------------------------------------------------------------------------------------
    // 관리자 게시판 글 상세보기
    // -----------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @GetMapping("/admin/board/detail/{boardSn}")
    public Optional<Board> boardView(@PathVariable(name = "boardSn") Long boardSn, Model model){
        Optional<Board> board = boardRepository.findById(boardSn);
        boardService.updateView(boardSn);
        return board;
    }
    //------------------------------------------------------------------------------------
    // 관리자 게시판 글 수정
    // -----------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PutMapping("/admin/board/update/{boardSn}")
    public Board updateorChange(@RequestBody BoardDto boardDto) {

        return boardService.update(boardDto);
    }
    //------------------------------------------------------------------------------------
    // 관리자 게시판 글 삭제대기 로 변환
    // -----------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PutMapping("/admin/board/detail/{boardSn}")
    public Board change(@RequestBody BoardDto boardDto) {
        return boardService.change(boardDto);
    }
    //------------------------------------------------------------------------------------
    // 관리자 게시판 글 삭제대기 리스트
    // -----------------------------------------------------------------------------------
    @GetMapping("/admin/deletePost")
    public List<Board> PutBoardList(){
        List<Board> boardList = boardRepository.findByBoardStatus("Y");
        return boardList;
    }
    //------------------------------------------------------------------------------------
    // 관리자 게시판 글 완전삭제
    // -----------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @DeleteMapping("/admin/deletePost/{boardSn}")
    public void deleteBoard(@RequestBody BoardDto boardDto) {
        boardService.deleteBoard(boardDto);
    }
}
