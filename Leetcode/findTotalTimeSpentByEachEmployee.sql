/* Write your T-SQL query statement below */
SELECT event_day day, emp_id emp_id, SUM(out_time - in_time) total_time
FROM Employees WITH(NOLOCK)
GROUP BY event_day, emp_id