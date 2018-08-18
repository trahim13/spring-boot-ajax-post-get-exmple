package org.trahim.sprig.ajax.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trahim.sprig.ajax.dto.Book;
import org.trahim.sprig.ajax.dto.ServiceResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    List<Book> bookStore = new ArrayList<>();

    @PostMapping("/saveBook")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        bookStore.add(book);
        ServiceResponse<Book> response = new ServiceResponse<>("success", book);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }


    @GetMapping("/getBooks")
    public ResponseEntity<Object> getAllBook() {
        ServiceResponse<List<Book>> response = new ServiceResponse<>("success", bookStore);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
