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
        System.out.println("Vue Gethering Test.....");
        List<Board> faqList = boardRepository.findByBoardCategoryAndBoardStatus("faq","N");
        System.out.println("faq 리스트 ==> " + faqList);
        return faqList;
    }
    //------------------------------------------------------------------------------------
    // 공지사항 리스트
    // -----------------------------------------------------------------------------------
    @GetMapping("/notice")
    public List<Board> noticeList(){
        List<Board> noticeList = boardRepository.findByBoardCategoryAndBoardStatus("notice","N");
        System.out.println("잊지말고제발.." + noticeList);
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
        System.out.println("게시판 리스트 ==> ");
        Optional<Board> board = boardRepository.findById(boardSn);
        System.out.println("게시판 리스트 ==> " + board);
        System.out.println(boardSn);
        boardService.updateView(boardSn);

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
        System.out.println("게시판정보 ==> " + board);

        Optional<Member> optionalFindMember = memberRepository.findByUserId(board.getUserId());

        if (optionalFindMember.isPresent()) {
            Member findMember = optionalFindMember.get();
            board.setMember(findMember);
        }

        board.setCreatedAt(LocalDateTime.now());
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
        System.out.println("게시판 리스트 ==> " + board);
        return board;
    }
    //------------------------------------------------------------------------------------
    // 관리자 게시판 글 수정
    // -----------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PutMapping("/admin/board/update/{boardSn}")
    public Board updateorChange(@RequestBody BoardDto boardDto) {
        System.out.println("수정 요청으로 받은 정보 : " + boardDto);
        return boardService.update(boardDto);
    }
    //------------------------------------------------------------------------------------
    // 관리자 게시판 글 삭제대기 로 변환
    // -----------------------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PutMapping("/admin/board/detail/{boardSn}")
    public Board change(@RequestBody BoardDto boardDto) {
        System.out.println("수정 요청으로 받은 정보 : " + boardDto);
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
        System.out.println("삭제요청정보 : " + boardDto);
        boardService.deleteBoard(boardDto);
    }
}


//------------------------------------------------------------------------------------
// 관리자 게시판 글 작성
// -----------------------------------------------------------------------------------
//@PostMapping("/admin/board/write")
//public void saveWriter(@RequestBody Board board,  HttpSession session){
//    System.out.println("게시판정보 ==> " + board);
//    String userId = (String) session.getAttribute("userId");
////        System.out.println("유저아이디 ==> " + userId);
//    // 세션에서 userId를 이용하여 Member 엔티티를 조회
//
//    Member member = memberRepository.findByUserId(userId)
//            .orElseThrow(() -> new RuntimeException("User not found"));
//    // 조회된 Member를 Board 엔티티의 userId에 설정
//    board.setUserId(member);
//
//    board.setCreatedAt(LocalDateTime.now());
//    boardRepository.save(board);

//------------------------------------------------------------------------------------
// 관리자 게시판 글 작성
// -----------------------------------------------------------------------------------
//@PostMapping("/admin/board/write")
//public void saveWriter(@RequestBody Board board,  HttpSession session){
//    System.out.println("게시판정보 ==> " + board);
//
////        board.setUserId(board.getUserId());
////        System.out.println("세션값...?: " +  board.getUserId());
//
////        String userId = board.getUserId(); // 프론트엔드에서 전달한 userId 값을 가져옴
////        board.setUserId(userId); // Board 객체에 userId 설정
////
////        System.out.println("프론트엔드에서 전달한 userId 값: " + userId);
//    // 프론트엔드에서 전달받은 user_id 값
//    String userId = board.getUserId();
//
//    // Member 테이블에서 user_id 값을 사용하여 회원 정보를 조회
//    Optional<Member> memberOptional = memberRepository.findByUserId(userId);
//
//    if (memberOptional.isEmpty()) {
//        System.out.println("회원 정보를 찾을 수 없습니다.");
//        // 필요한 작업을 수행하거나 예외 처리를 합니다.
//    } else {
//        // 조회된 회원 정보를 사용하여 Board 객체를 생성하고 저장하거나 필요한 작업을 수행합니다.
//        Member member = memberOptional.get();
//        board.setUser(member);
//        System.out.println("board 정보값:" + board);
//        board.setCreatedAt(LocalDateTime.now());
//        boardRepository.save(board);
//    }
//
//
//
////        board.setCreatedAt(LocalDateTime.now());
////        boardRepository.save(board);
//}