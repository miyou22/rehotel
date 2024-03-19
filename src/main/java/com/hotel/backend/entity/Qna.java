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
    private int qnaSn;

    @Column(nullable = false,length = 50)
    private String qnaTit;

    @Column(nullable = false)
    private String qnaSub;

    private int qnaCnt;

    @OneToOne
    @JoinColumn(name = "userId")
    private Member userId;

}
