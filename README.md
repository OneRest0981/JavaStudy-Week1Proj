# 人事管理系统（HRMS）- Java学习第一周检验

## 📌 项目简介
一个用于管理员工、教师等人员信息的小型管理系统，使用 Java OOP 构建。

## ✨ 功能
- 查看所有人员
- 添加人员（员工 / 老师）
- 删除人员
- 搜索人员
- 更新人员信息
- 安全输入（防止用户输入错误）

## 🗂 项目结构
hrms/
├── hrms.model/    # 实体类 定义 Person、Employee、Teacher
├── hrms.service/  # 人事相关的增删改查逻辑 增删改查、统一管理人员
├── hrms.util/     # 工具类 输入、检查等
└── hrms.app/      # 程序入口（MainApp）菜单、调用 service

## 🚀 运行方式
进入 MainApp.java 运行 main 方法即可。

## 👨‍💻 作者
RestaDay

## 🕒 更新时间
2025-11-21 