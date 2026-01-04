package com.it.librarysystem.mapper;

import com.it.librarysystem.entity.Book;
import com.it.librarysystem.entity.BorrowRecord;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BookMapper {

    // --- 图书基础操作 ---
    @Select("SELECT * FROM sys_book WHERE name LIKE CONCAT('%',#{keyword},'%') OR author LIKE CONCAT('%',#{keyword},'%')")
    List<Book> findList(String keyword);

    @Insert("INSERT INTO sys_book(name, author, price, status) VALUES(#{name}, #{author}, #{price}, #{status})")
    int insert(Book book);

    @Update("UPDATE sys_book SET name=#{name}, author=#{author}, price=#{price} WHERE id=#{id}")
    int update(Book book);

    @Delete("DELETE FROM sys_book WHERE id=#{id}")
    int deleteById(Integer id);

    @Update("UPDATE sys_book SET status=#{status} WHERE id=#{id}")
    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    // --- 新增：借阅记录操作 ---

    // 1. 插入一条借阅记录
    @Insert("INSERT INTO sys_borrow_record(user_id, book_id, borrow_time) VALUES(#{userId}, #{bookId}, NOW())")
    int insertRecord(BorrowRecord record);

    // 2. 查找该书当前未归还的记录ID (用于还书时找到对应的记录)
    @Select("SELECT id FROM sys_borrow_record WHERE book_id = #{bookId} AND return_time IS NULL LIMIT 1")
    Integer findCurrentRecordId(Integer bookId);

    // 3. 更新归还时间
    @Update("UPDATE sys_borrow_record SET return_time = NOW() WHERE id = #{id}")
    int updateReturnTime(Integer id);
}