package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="guest")
@Getter
@Setter
@ToString
public class Guest {
    @Id
    @Column(nullable = false, length = 50)
    private String guestEmail;

    @Column(nullable = false)
    private int guestTel;

    @Column(nullable = false,length = 1)
    private int userFlag;
}
