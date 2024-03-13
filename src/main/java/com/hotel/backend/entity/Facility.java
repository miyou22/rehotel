package com.hotel.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="facility")
@Getter
@Setter
@ToString
public class Facility {
    @Id
    @Column(nullable = false,length = 20)
    private String facType;

    @Column(nullable = false)
    private LocalDateTime facStart;

    @Column(nullable = false)
    private LocalDateTime facEnd;

    @Column(nullable = false)
    private int facPrice;
}
