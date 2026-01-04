package com.it.librarysystem.service;

import com.it.librarysystem.entity.Book;
import com.it.librarysystem.entity.BorrowRecord;
import com.it.librarysystem.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> getBooks(String keyword) {
        if (keyword == null) keyword = "";
        return bookMapper.findList(keyword);
    }

    public void addBook(Book book) {
        book.setStatus(1);
        bookMapper.insert(book);
    }

    public void updateBook(Book book) {
        bookMapper.update(book);
    }

    public void deleteBook(Integer id) {
        bookMapper.deleteById(id);
    }

    /**
     * 借书业务 (加了事务控制 @Transactional)
     * 1. 修改图书状态为 0 (借出)
     * 2. 插入借阅记录表
     */
    @Transactional
    public void borrowBook(Integer bookId) {
        // 1. 改状态
        bookMapper.updateStatus(bookId, 0);

        // 2. 记记录
        BorrowRecord record = new BorrowRecord();
        record.setBookId(bookId);
        record.setUserId(1); // 【注意】暂时写死 ID=1 (张三)，下一步做完登录功能后这里会改成动态获取
        bookMapper.insertRecord(record);
    }
    // 修改方法签名，增加 userId 参数
    @Transactional
    public void borrowBook(Integer bookId, Integer userId) {
        // 1. 改状态
        bookMapper.updateStatus(bookId, 0);

        // 2. 记记录
        BorrowRecord record = new BorrowRecord();
        record.setBookId(bookId);
        record.setUserId(userId); // ✅ 使用传入的 userId，不再写死
        bookMapper.insertRecord(record);
    }
    /**
     * 还书业务
     * 1. 修改图书状态为 1 (在库)
     * 2. 找到借阅记录，更新归还时间
     */
    @Transactional
    public void returnBook(Integer bookId) {
        // 1. 改状态
        bookMapper.updateStatus(bookId, 1);

        // 2. 找记录并结束
        Integer recordId = bookMapper.findCurrentRecordId(bookId);
        if (recordId != null) {
            bookMapper.updateReturnTime(recordId);
        }

    }
}