package com.wzp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wzp.domain.Book;

import java.util.List;

public interface BookService {
    /**
     * 添加
     * @param book
     * @return
     */
    Boolean save(Book book);

    /**
     * 修改
     * @param book
     * @return
     */
    Boolean update(Book book);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    Boolean delete(Integer id);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Book getById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<Book> getAll();

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 一页多少条数据
     * @return IPage对象
     */
    IPage<Book> getPage(int currentPage, int pageSize);

}
