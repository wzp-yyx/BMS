package com.wzp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    void getAll() {
        bookDao.selectByMap(null);
    }

    @Test
    void insertOne() {
        Book book = new Book();
        book.setName("西游记");
        book.setDescription("西天取经");
        book.setType("文学");
        bookDao.insert(book);
    }

    @Test
    void testGetPage() {
        IPage<Book> page = new Page<>(1, 6);
        bookDao.selectPage(page, null);
        System.out.println("" + page.getRecords());
        System.out.println("总页数：" + page.getPages());
        System.out.println("当前页数：" + page.getCurrent());
        System.out.println("一页多少数据：" + page.getSize());
        System.out.println("一个多少数据：" + page.getTotal());
    }

    @Test
    void testBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testBy2() {
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Book::getName, name);
        bookDao.selectList(lqw);
    }
}
