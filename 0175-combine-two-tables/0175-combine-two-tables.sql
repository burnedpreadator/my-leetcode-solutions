# Write your MySQL query statement below
SELECT p.firstName,
p.lastName,
A.city,
A.state
FROM Person p LEFT JOIN Address A ON A.personId = p.personId;