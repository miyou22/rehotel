package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="qna")
@Getter
@Setter
@ToString
public class Qna {
    @Id
    @Column(nullable = false)
    private int qna_sn;

    @Column(nullable = false,length = 50)
    private String qna_tit;

    @Column(nullable = false)
    private String qna_sub;

    private int qna_cnt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private String user_id;

}
