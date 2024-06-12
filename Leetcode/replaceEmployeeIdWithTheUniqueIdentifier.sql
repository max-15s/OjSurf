-- 1378 - https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/submissions/1286459295/
SELECT EU.unique_id unique_id, E.name name FROM Employees AS E
LEFT JOIN EmployeeUNI AS EU ON E.id = EU.id
