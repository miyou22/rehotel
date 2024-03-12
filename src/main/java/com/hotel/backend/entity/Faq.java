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
    private int faq_sn;

    @Column(nullable = false,length = 20)
    private String faq_tit;

    @Column(nullable = false)
    private String faq_sub;

    private int faq_cnt;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private String admin_id;
}
