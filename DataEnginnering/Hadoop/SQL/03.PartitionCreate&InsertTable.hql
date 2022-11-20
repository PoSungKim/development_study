CREATE TABLE base.pskim_test (
  a STRING,
  b STRING
 ) 
 PARTITONED BY (c STRING)
 STORED AS PARQUET;
 
DESCRIBE base.pskim_test;
SHOW PARTITIONS base.pskim_test;
SHOW CREATE TABLE base.pskim_test;

TRUNCATE TABLE base.pskim_test;

INSERT OVERWRITE base.pskim_test(a, b, c) VALUES ('a1', 'a1', 'a'), ('b1', 'b1', 'b'), ('c1', 'c1', 'c'), ('d1', 'd1', 'd');

CREATE TABLE base.pskim_test2 (
  a STRING,
  b STRING,
  c STRING
);

-- 모두 같은 결과
INSERT OVERWRITE base.pskim_test2(a, b, c) VALUES ('a1', 'a1', 'a'), ('a2', 'a2', 'a'), ('a3', 'a3', 'a'), ('b1', 'b1', 'b'), ('b2', 'b2', 'b'), ('b3', 'b3', 'b'), ('c1', 'c1', 'c'), ('c2', 'c2', 'c'), ('c3', 'c3', 'c'), ('d1', 'd1', 'd');

-- CASE : INSERT OVERWRITE partition_yes SELECT * FROM partition_no; 항상 PARTITION을 명시해주는 것이 필요
INSERT OVERWRITE base.pskim_test PARTITION (c)
SELECT * FROM base.pskim_test2;

DROP TABLE base.pskim_test2;

CREATE TABLE base.pskim_test2 (
  a STRING,
  b STRING
)
PARTITIONED BY (c STRING)
STORED AS PARQUET;

-- 모두 같은 결과
INSERT OVERWRITE base.pskim_test2(a, b, c) VALUES ('a1', 'a1', 'a'), ('a2', 'a2', 'a'), ('a3', 'a3', 'a'), ('b1', 'b1', 'b'), ('b2', 'b2', 'b'), ('b3', 'b3', 'b'), ('c1', 'c1', 'c'), ('c2', 'c2', 'c'), ('c3', 'c3', 'c'), ('d1', 'd1', 'd');
INSERT OVERWRITE base.pskim_test2(a, b)    PARTITION (c) VALUES ('a1', 'a1', 'a'), ('a2', 'a2', 'a'), ('a3', 'a3', 'a'), ('b1', 'b1', 'b'), ('b2', 'b2', 'b'), ('b3', 'b3', 'b'), ('c1', 'c1', 'c'), ('c2', 'c2', 'c'), ('c3', 'c3', 'c'), ('d1', 'd1', 'd');
INSERT OVERWRITE base.pskim_test2          PARTITION (c) VALUES ('a1', 'a1', 'a'), ('a2', 'a2', 'a'), ('a3', 'a3', 'a'), ('b1', 'b1', 'b'), ('b2', 'b2', 'b'), ('b3', 'b3', 'b'), ('c1', 'c1', 'c'), ('c2', 'c2', 'c'), ('c3', 'c3', 'c'), ('d1', 'd1', 'd');

-- CASE : INSERT OVERWRITE partition_yes SELECT * FROM partition_yes; 항상 PARTITION을 명시해주는 것이 필요
INSERT OVERWRITE base.pskim_test PARTITION (c)
SELECT * FROM base.pskim_test2; 

-- CREATE TABLE AS SELECT에서 PARTITIONED BY (c)는 From_Table 기준 --> 이미 From_Table에서 정의가 되어있기 때문에 칼럼명만 기입해줘도 됌
CREATE TABLE base.pskim_test3
PARTITIONED BY (c)
STORED AS PARQUET
AS 
SELECT * FROM base.pskim_test;

CREATE TABLE base.pskim_test4
LIKE base.pskim_test;
