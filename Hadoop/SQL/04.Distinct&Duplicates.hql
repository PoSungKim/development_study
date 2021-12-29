CREATE TABLE temp_table LIKE real_table;

INSERT INTO temp_table
SELECT distinct * FROM real_table;

INSERT OVERWRITE temp_table
SELECT distinct col1, col2, col3 FROM real_table;
