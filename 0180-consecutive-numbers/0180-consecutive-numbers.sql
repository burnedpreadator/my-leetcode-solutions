# Write your MySQL query statement below
WITH xyz As(
    SELECT num,
    LEAD(num, 1) OVER (ORDER BY id) AS num_1,
    LEAD(num, 2) OVER (ORDER BY id) AS num_2
    FROM Logs
)
SELECT DISTINCT num as ConsecutiveNums
from xyz
where num=num_1 and num=num_2;