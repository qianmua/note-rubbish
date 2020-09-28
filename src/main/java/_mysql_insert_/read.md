


# MySql如何快速插入千万条数据

    创建一个数据库并创建一个带自增索引的表，一个固定字长words char(1)。然后通过自拷贝将数据条目增长到16K。
    
```mysql
DROP DATABASE
IF EXISTS pillow;

CREATE DATABASE pillow DEFAULT charset utf8mb4 COLLATE utf8mb4_general_ci;

DROP TABLE
IF EXISTS pow;

CREATE TABLE pow(
	id INT (11) auto_increment COMMENT 'id',
	words CHAR (1) NOT NULL COMMENT 'words',
	PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT charset = utf8mb4;

-- 先写入一条基础数据 
insert into pow(words) values('p');
-- 自拷贝，1<<24 = 16777216
-- 所以自拷贝24次即可。
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
insert into pow(words) select words from pow;
-- 到这里生成的就是16K条数据
-- 不过，因为是拷贝，所有数据都一样，仅仅是占位符而已。
```