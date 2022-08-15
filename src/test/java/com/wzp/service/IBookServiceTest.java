package com.wzp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzp.controller.utils.R;
import com.wzp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTest {
    @Autowired
    private IBookService bookService;

    @Test
    void testGetById() {
        bookService.getById(3);
    }

    @Test
    void testGetAll() {
        bookService.list();
    }

    @Test
    void testDelete() {
        bookService.removeById(2);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        bookService.update(book,null);
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(1, 3);
        bookService.page(page);
    }
}
