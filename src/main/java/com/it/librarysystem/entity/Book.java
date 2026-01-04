package com.it.librarysystem.entity;

import lombok.Data; // 需要 Lombok 插件，如果没有手动生成 Getter/Setter
import java.math.BigDecimal;

@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
    private BigDecimal price;
    private Integer status;
}
