package com.wzp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wzp.controller.utils.R;
import com.wzp.domain.Book;
import com.wzp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @PostMapping
    public R save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    /*@GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize);
        if( currentPage > page.getPages()){
            page = bookService.getPage(1, pageSize);
        }
        return new R(true, page);
    }*/

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()) {
            page = bookService.getPage(1, pageSize, book);
        }
        return new R(true, page);
    }

}
