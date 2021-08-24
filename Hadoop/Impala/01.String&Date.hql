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

