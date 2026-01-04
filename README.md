# 📚 Library Management System (图书管理系统)

> 基于 AI 辅助开发的 Spring Boot + Layui 图书管理系统。
> 本项目为《软件工程学》课程作业。
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Layui](https://img.shields.io/badge/Frontend-Layui-009688)

## 📖 项目介绍
本项目是一个前后端分离风格（但在同一工程中）的图书管理系统。主要服务于学校图书馆场景，支持图书的增删改查、用户登录、借阅与归还等核心业务流程。
项目采用了 **AI 辅助开发** 模式，利用大模型工具提高了编码效率和文档规范性。
## 🛠️ 技术栈

* **后端**: Spring Boot 3.x, MyBatis
* **前端**: Layui + jQuery + HTML5
* **数据库**: MySQL 8.0
* **开发工具**: IntelliJ IDEA, Maven, Git

## ✨ 功能特性

### 1. 基础数据管理
* **图书管理**: 支持图书的新增、修改、删除和查询。
* **模糊搜索**: 支持按书名或作者关键字进行检索。

### 2. 用户管理
* **登录认证**: 区分管理员与普通用户。
* **默认测试账号**: `zhangsan` / `123456`。

### 3. 借阅核心业务
* **借阅操作**: 实时校验库存，扣减库存，生成借阅记录。
* **归还操作**: 更新图书状态为“在库”，记录归还时间。
* **数据一致性**: 使用数据库事务（Transaction）保证高并发下的库存安全。

##  数据库设计

包含三张核心表：
1.  **sys_book**: 图书信息表（书名、作者、价格、状态）。
2.  **sys_user**: 用户表（用户名、密码、角色）。
3.  **sys_borrow_record**: 借阅记录表（关联用户ID、图书ID、借还时间）。

## 速开始

### 1. 环境准备
* JDK 1.8 或 17+
* MySQL 8.0+
* Maven 3.6+

### 2. 数据库初始化
请在 MySQL 中执行项目提供的 SQL 脚本（或根据实体类生成），创建 `library_db` 数据库及相关表结构。

### 3. 修改配置
打开 `src/main/resources/application.properties`，配置你的数据库账号密码：
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db?serverTimezone=Asia/Shanghai
spring.datasource.username=root
spring.datasource.password=你的密码
