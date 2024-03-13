//package com.hotel.backend.controller;
//
//import com.hotel.backend.entity.Item;
//import com.hotel.backend.repository.ItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class ItemController {
//    @Autowired
//    ItemRepository itemRepository;
//
//    @GetMapping("/api/items")
//    public List<Item> getItems(){
//        List<Item> items = itemRepository.findAll();
//
//        return items;
//    }
//}
