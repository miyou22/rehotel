package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="faq")
@Getter
@Setter
@ToString
public class Faq {
    @Id
    @Column(nullable = false)
    private int faqSn;

    @Column(nullable = false,length = 20)
    private String faqTit;

    @Column(nullable = false)
    private String faqSub;

    private int faqCnt;

    @OneToOne
    @JoinColumn(name = "adminId")
    private Admin adminId;
}
