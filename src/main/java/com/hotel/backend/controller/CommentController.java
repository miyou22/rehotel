package com.hotel.backend.controller;

import com.hotel.backend.entity.Board;
import com.hotel.backend.entity.Comments;
import com.hotel.backend.entity.Member;
import com.hotel.backend.repository.BoardRepository;
import com.hotel.backend.repository.CommentRepository;
import com.hotel.backend.repository.MemberRepository;
import com.hotel.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository boardRepository;

    //-------------------------------------------------------------------
    // 댓글 작성하기
    //-------------------------------------------------------------------
    @PostMapping("/{boardCategory}/{boardSn}")
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    public String writeComment(@PathVariable(name = "boardSn") Long boardSn, @PathVariable(name = "boardCategory") String boardCategory,  @RequestBody Comments comments){
        System.out.println("댓글정보 ==> " + comments.toString());
        String userId = comments.getUserId();

        commentService.writeComment(comments, boardSn, userId);

        return "댓글이 성공적으로 작성되었습니다.";
    }
    //-------------------------------------------------------------------
    // 댓글 불러오기
    //-------------------------------------------------------------------
    @GetMapping("/{boardCategory}/{boardSn}/comments")
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    public List<Comments> commentsList(@PathVariable Long boardSn){
        System.out.println("boardSn::::" + boardSn);

        Board board = boardRepository.findById(boardSn).orElseThrow(()->new IllegalArgumentException("게시물을 찾을수 없습니다."));
        List<Comments> comments = commentRepository.findByboardSnAndCommentStatus(board.getBoardSn(),"N");

        return comments;
    }
    //-------------------------------------------------------------------
    // 댓글 수정하기
    //-------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PutMapping("/update/{boardCategory}/{boardSn}")
    public Comments updateComment( @RequestBody Comments updatedComment){
        System.out.println("수정정보::::" + updatedComment);

        Comments modifyComment = commentRepository.findById(updatedComment.getId())
                .orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));
        modifyComment.setContent(updatedComment.getContent());

        return commentRepository.save(modifyComment);
    }

    //-------------------------------------------------------------------
    // 댓글 삭제하기
    //-------------------------------------------------------------------
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    @PutMapping("/modiDelete/{boardCategory}/{boardSn}")
    public Comments deleteComment( @RequestBody Comments comments){
        System.out.println("삭제정보::::" + comments);

        System.out.println("삭제 요청으로 받은 정보 : " + comments);
        return commentService.modiDelete(comments);
    }

    //-------------------------------------------------------------------
    // 댓글 삭제 대기 불러오기
    //-------------------------------------------------------------------
    @GetMapping("/admin/comments")
    @CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
    public List<Comments> commentsDeleteList(){

        List<Comments> comments = commentRepository.findBycommentStatus("Y");

        return comments;
    }
}
