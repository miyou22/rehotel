package com.hotel.backend.service;

import com.hotel.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardService {

    @Autowired
    BoardRepository boardRepository;

}
