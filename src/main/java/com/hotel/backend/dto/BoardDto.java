//한개가 아닌 여러개의 자료를 옮길때 사용하는게 좋지 않을까?

package com.hotel.backend.dto;

import com.hotel.backend.constant.Role;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class BoardDto {
    private Long boardSn;
    private Role role;
//    private Member userId;
    private String boardCategory;
    private String boardTitle;
    private String boardContent;
    private int boardCnt;
    private LocalDateTime createdAt;
    private String boardStatus;
    //파일첨부 여부(첨부 1, 미첨부0)
    private int fileAttached;
    //AdminBoardWrite.vue -> Controller파일 담는 용도
    private MultipartFile boardFile;
    //원본파일이름
    private String originalFileName;
    //서버 저장용 이름
    private String storedFileName;


}
