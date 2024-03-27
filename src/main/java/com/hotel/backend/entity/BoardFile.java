//package com.hotel.backend.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.ToString;
//
//@Entity
//@Getter
//@ToString
//@Table(name="boardFile")
//public class BoardFile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    //어떤게시글에 작성된 것인지
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "boardId", nullable = false)
//    private Long boardId;
//
//    //원본파일명
//    @Column(name = "orginal_fileName")
//    private String originalFileName;
//
//    //저장용파일명
//    @Column(name = "ostored_fileName")
//    private String storedFileName;
//}
