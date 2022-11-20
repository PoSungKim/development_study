-- Stored as, partioned by 등의 세부 사항이 자동 적용 >> 매우 유용
CREATE TABLE temp_table LIKE real_table;

INSERT INTO temp_table
SELECT distinct * FROM real_table;

INSERT OVERWRITE temp_table
SELECT distinct col1, col2, col3 FROM real_table;
