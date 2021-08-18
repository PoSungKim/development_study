-- https://impala.apache.org/docs/build/html/topics/impala_string_functions.html
-- https://impala.apache.org/docs/build/html/topics/impala_datetime_functions.html
-- .hql, .q, or .ql extensions are possible

-- CONCAT_WS(STRING sep, STRING a, STRING b...)
-- Purpose: Returns a single string representing the second and following argument values joined together, delimited by a specified separator.
-- Return type: STRING

-- Usage notes: concat() and concat_ws() are appropriate for concatenating the values of multiple columns within the same row, while group_concat() joins together values from different rows.

SELECT CONCAT_WS('-', substr('20210817', 1, 4), substr('20210817', 4, 2), substr('20210817', 7)) ;; 
-- <2021-08-21>

SELECT CAST(CONCAT_WS('-', substr('20210817', 1, 4), substr('20210817', 4, 2), substr('20210817', 7)) AS timestamp) ;; 
-- <2021-08-21 00:00:00>

SELECT DATE_SUB(CAST(CONCAT_WS('-', substr('20210817', 1, 4), substr('20210817', 4, 2), substr('20210817', 7)) AS timestamp), INTERVAL 3 MONTHS) ;;
-- <>
-- INTERVAL Expression allows you to utilize the shorthand expression of various dates such as YEARS, MONTHS, WEEKS, HOURS, SECONDS
