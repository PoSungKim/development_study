-- https://impala.apache.org/docs/build/html/topics/impala_string_functions.html
-- https://impala.apache.org/docs/build/html/topics/impala_datetime_functions.html
-- .hql, .q, or .ql extensions are possible

-- CONCAT_WS(STRING sep, STRING a, STRING b...)
-- Purpose: Returns a single string representing the second and following argument values joined together, delimited by a specified separator.
-- Return type: STRING

SELECT CONCAT_WS('-', substr('20210817', 1, 4), substr('20210817', 4, 2), substr('20210817', 7)) ;; 
-- <2021-08-21>

SELECT CAST(CONCAT_WS('-', substr('20210817', 1, 4), substr('20210817', 4, 2), substr('20210817', 7)) AS timestamp) ;; 
-- <2021-08-21 00:00:00>

SELECT DATE_SUB(CAST(CONCAT_WS('-', substr('20210817', 1, 4), substr('20210817', 4, 2), substr('20210817', 7)) AS timestamp), INTERVAL 3 MONTHS) ;;
-- <2021-05-21 00:00:00>
-- INTERVAL Expression allows you to utilize the shorthand expression of various dates such as YEARS, MONTHS, WEEKS, HOURS, SECONDS

-- FROM_TIMESTAMP(TIMESTAMP datetime, STRING pattern), FROM_TIMESTAMP(STRING datetime, STRING pattern)
-- Purpose: Converts a TIMESTAMP value into a string representing the same value.
-- Return type: STRING

SELECT FROM_TIMESTAMP(DATE_SUB(CAST(CONCAT_WS('-', substr('20210817', 1, 4), substr('20210817', 4, 2), substr('20210817', 7)) AS timestamp), INTERVAL 3 MONTHS), 'yyyyMMdd') ;;

-- 위의 HiveQL문은 아래의 HiveQL문으로 줄여질 수 있다. Cast() 함수는 날짜 타입의 형태로 맞춰줘야 하기에 

SELECT FROM_TIMESTAMP(DATE_SUB(TO_TIMESTAMP('20210817', 'yyyyMMdd'), INTERVAL 3 MONTHS), 'yyyyMMdd');

SELECT CAST('2021-09-13' as TIMESTAMP);
SELECT TO_DATE('2021-09-13 12:00:00'); -- 2021-09-13

-- 다양한 형태의 String 값을 Timestamp로 변경 가능
SELECT TO_TIMESTAMP('2021-09-13 12:00:00', 'yyyy-MM-dd HH:mm:ss');
SELECT TO_TIMESTAMP('20210913', 'yyyyMMdd');

-- TIMESTAMP 값 혹은 String 값에 대해서 지정한 자리수 이하를 버림
-- Parameter : (timestamp date, string date-format);
-- Return    : timestamp modified_date
SELECT date_trunc('day', loaded_at);      SELECT date_trunc('month', loaded_at);       SELECT date_trunc('year', loaded_at);
