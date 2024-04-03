package com.hotel.backend.service;

import com.hotel.backend.entity.Board;
import com.hotel.backend.entity.Comments;
import com.hotel.backend.entity.Member;
import com.hotel.backend.repository.BoardRepository;
import com.hotel.backend.repository.CommentRepository;
import com.hotel.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BoardRepository boardRepository;
    //-------------------------------------------------------------------
    // 댓글 작성
    //-------------------------------------------------------------------
    public Long writeComment(Comments comments, Long boardSn, String userId){

        Board board = boardRepository.findById(boardSn).orElseThrow(()->new IllegalArgumentException("게시물을 찾을수 없습니다."));

        Optional<Member> optionalFindMember = memberRepository.findByUserId(comments.getUserId());
        if (optionalFindMember.isPresent() && board != null) {

            Member findMember = optionalFindMember.get();
            comments.setCreatedAt(LocalDateTime.now());
            comments.setMember(findMember);
            comments.setContent(comments.getContent());
            comments.setBoard(board);
            System.out.println("comment정보:" + comments);
        }
        commentRepository.save(comments);
        return comments.getId(); // 저장된 댓글의 ID 반환
    }
    //-------------------------------------------------------------------
    // 댓글 삭제 대기상태
    //-------------------------------------------------------------------
    public Comments modiDelete(Comments comments){
        Long id = comments.getId();
        String commentStatus = comments.getCommentStatus();
        Comments comment = commentRepository.findById(id).orElseThrow(()-> new RuntimeException(id + "에 해당하는 댓글이 존재하지 않습니다."));

        if ("N".equals(commentStatus)) {
            // 상태를 "Y"로 변경합니다.
            comment.setCommentStatus("Y");
            System.out.println("삭제호ㅓ인" + commentStatus);

        } else if ("Y".equals(commentStatus)) {
            //   "N"으로 변경합니다.
            comment.setCommentStatus("N");
            System.out.println("삭제 여부" + commentStatus);

        }else {
            // 예외 처리: 유효하지 않은 action 값이 들어온 경우
            System.out.println("commentStatus" + commentStatus);
            throw new IllegalArgumentException("유효하지 않은 액션 값입니다.");
        }
        return commentRepository.save(comment);

    }
}
