package com.it.librarysystem.controller;

import com.it.librarysystem.entity.Book;
import com.it.librarysystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // 查询列表 (支持搜索)
    @GetMapping("/list")
    public Map<String, Object> list(@RequestParam(required = false, defaultValue = "") String keyword) {
        List<Book> books = bookService.getBooks(keyword);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", books.size());
        result.put("data", books);
        return result;
    }

    // 新增
    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Book book) {
        bookService.addBook(book);
        return Map.of("code", 200, "msg", "添加成功");
    }

    // 更新
    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody Book book) {
        bookService.updateBook(book);
        return Map.of("code", 200, "msg", "修改成功");
    }

    // 删除
    @PostMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return Map.of("code", 200, "msg", "删除成功");
    }

    // 借书
    @PostMapping("/borrow/{id}")
    public Map<String, Object> borrow(@PathVariable Integer id) {
        bookService.borrowBook(id);
        return Map.of("code", 200, "msg", "借阅成功");
    }

    // 还书
    @PostMapping("/return/{id}")
    public Map<String, Object> returnBook(@PathVariable Integer id) {
        bookService.returnBook(id);
        return Map.of("code", 200, "msg", "归还成功");
    }
}