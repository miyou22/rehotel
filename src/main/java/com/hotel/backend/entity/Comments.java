package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "comments")
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="modify_at")
    @LastModifiedDate
    private LocalDateTime modifyAt;

    @ManyToOne
    @JoinColumn(name="board_sn")
    private Board board;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Member member;


}
