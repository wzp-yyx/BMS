package com.wzp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wzp.domain.Book;

public interface IBookService extends IService<Book> {
    IPage<Book> getPage(Integer currentPage, Integer pageSize);

    /**
     * 查询页码
     *
     * @param currentPage 当前页
     * @param pageSize    一页多少条数据
     * @param book
     * @return
     */
    IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book);
}
