-- https://leetcode.com/problems/capital-gainloss/
SELECT stock_name , SUM(CASE WHEN operation = 'Buy' THEN -1 ELSE 1 end * price) capital_gain_loss FROM Stocks
GROUP BY stock_name