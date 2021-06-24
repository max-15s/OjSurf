-- Section1
SELECT MAX(salary) salary from employees
-- Section2
SELECT T.name team, OE.name employee, OE.salary FROM employees AS OE
INNER JOIN (
    SELECT MAX(salary) salary, team_id
    from employees E
    GROUP BY team_id
) AS RE ON OE.team_id=RE.team_id AND OE.salary=RE.salary
INNER JOIN teams T ON OE.team_id=T.id
ORDER BY OE.salary DESC , OE.id, OE.team_id
