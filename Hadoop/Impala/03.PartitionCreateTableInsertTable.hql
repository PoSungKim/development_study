CREATE TABLE base.pskim_test (
  a STRING,
  b STRING,
  c STRING
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

-- CASE : INSERT OVERWRITE partition_yes SELECT * FROM partition_no;
INSERT OVERWRITE base.pskim_test PARTITION (c)
SELECT * FROM base.pskim_test2;

DROP TABLE base.pskim_test2;

CREATE TABLE base.pskim_test2 (
  a STRING,
  b STRING
)
PARTITIONED BY (c STRING);

-- 모두 같은 결과
INSERT OVERWRITE base.pskim_test2(a, b, c) VALUES ('a1', 'a1', 'a'), ('a2', 'a2', 'a'), ('a3', 'a3', 'a'), ('b1', 'b1', 'b'), ('b2', 'b2', 'b'), ('b3', 'b3', 'b'), ('c1', 'c1', 'c'), ('c2', 'c2', 'c'), ('c3', 'c3', 'c'), ('d1', 'd1', 'd');
INSERT OVERWRITE base.pskim_test2(a, b)    PARTITION (c) VALUES ('a1', 'a1', 'a'), ('a2', 'a2', 'a'), ('a3', 'a3', 'a'), ('b1', 'b1', 'b'), ('b2', 'b2', 'b'), ('b3', 'b3', 'b'), ('c1', 'c1', 'c'), ('c2', 'c2', 'c'), ('c3', 'c3', 'c'), ('d1', 'd1', 'd');
INSERT OVERWRITE base.pskim_test2          PARTITION (c) VALUES ('a1', 'a1', 'a'), ('a2', 'a2', 'a'), ('a3', 'a3', 'a'), ('b1', 'b1', 'b'), ('b2', 'b2', 'b'), ('b3', 'b3', 'b'), ('c1', 'c1', 'c'), ('c2', 'c2', 'c'), ('c3', 'c3', 'c'), ('d1', 'd1', 'd');

// CASE : INSERT OVERWRITE partition_yes SELECT * FROM partition_yes;
INSERT OVERWRITE base.pskim_test PARTITION (c)
SELECT * FROM base.pskim_test2;
