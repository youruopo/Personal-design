## 基于javaEE的宿舍管理系统的的设计与实现

数据库：ssgl

学生表（student）:

| 列              | 类型    | 描述                          |
| --------------- | ------- | ----------------------------- |
| id              | int     |                               |
| hid             | int     | 宿舍id                        |
| username        | varchar |                               |
| password        | varchar |                               |
| nickname        | varchar | 昵称                          |
| clock_in_status | int     | 考勤打卡：1、待打卡 2、已打卡 |
| leave_status    | int     | 是否请假 ：1、 正常 2、请假   |
| class           | varchar | 班级                          |
| phone           | varchar |                               |
| email           | varchar |                               |

管理员（admin）：

| 列       | 类型    | 描述 |
| -------- | ------- | ---- |
| username | varchar |      |
| password | varchar |      |
| nickname | varchar |      |
| phone    | varchar |      |
| email    | varchar |      |

宿舍表（hostel）：

| 列   | 类型    | 描述 |
| ---- | ------- | ---- |
| id   | int     |      |
| name | varchar |      |

申报表（declare）：

| 列         | 类型    | 描述                                    |
| ---------- | ------- | --------------------------------------- |
| id         | int     |                                         |
| hid        | int     | 宿舍id                                  |
| status     | varchar | 申报状态：1、已申报 2、未处理 3、已处理 |
| describe   | varchar | 申报原因                                |
| createTime | varchar | 申报时间                                |

leave (请假表):

| 列         | 类型 | 描述                            |
| ---------- | ---- | ------------------------------- |
| id         |      |                                 |
| sid        |      | 学生id                          |
| createTime |      | 请假时间                        |
| describe   |      | 请假原因                        |
| status     |      | 请假状态：1、待审核 2、审核通过 |



