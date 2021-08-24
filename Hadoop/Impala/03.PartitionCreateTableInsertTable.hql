CREATE TABLE base.pskim_test (
  a STRING,
  b STRING,
  c STRING
 ) PARTITONED BY (c STRING);
 
DESCRIBE base.pskim_test;

SHOW PARTITIONS base.pskim_test;

TRUNCATE TABLE base.pskim_test;

INSERT OVERWRITE base.pskim_test(a, b, c) VALUES ('a1', 'a1', 'a'), ('b1', 'b1', 'b'), ('c1', 'c1', 'c'), ('d1', 'd1', 'd');

