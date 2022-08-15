package com.wzp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wzp.domain.Book;
import com.wzp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService bookService;

    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.removeById(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        return bookService.getPage(currentPage, pageSize, null);
    }

}
