# 1068 - https://leetcode.com/problems/product-sales-analysis-i/description/
SELECT P.product_name product_name, S.year year, S.price price  FROM Sales S
INNER JOIN Product P ON S.product_id = P.product_id