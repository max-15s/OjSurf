-- https://leetcode.com/problems/bank-account-summary-ii/

SELECT U.name, T.balance FROM Users U
INNER JOIN (
    SELECT account, sum(amount) balance
    FROM Transactions
    GROUP BY account
) T ON U.account = T.account
WHERE T.balance > 10000