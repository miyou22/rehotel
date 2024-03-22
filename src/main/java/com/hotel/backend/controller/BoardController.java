package com.hotel.backend.controller;

import com.hotel.backend.entity.Board;
import com.hotel.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

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
    @GetMapping("/admin/board")
    public List<Board> boardList(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }


}
