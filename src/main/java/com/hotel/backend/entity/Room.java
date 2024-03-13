package com.hotel.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
import java.io.File;

@Entity
@Table(name ="room")
@Getter
@Setter
@ToString
public class Room {
    @Id
    @Column(nullable = false)
    private int roomNum;

    @Column(nullable = false)
    private int roomPrice;

    @Column(nullable = false)
    private int roomPerson;

    @Column(nullable = false,length = 20)
    private String roomName;

    @Column(nullable = false,length = 1)
    private int roomResCheck;
}
