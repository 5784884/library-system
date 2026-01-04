package com.it.librarysystem.entity;

import lombok.Data;
import java.util.Date;

@Data
public class BorrowRecord {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Date borrowTime;
    private Date returnTime;
}