/* Write your T-SQL query statement below */
SELECT product_id FROM Products WITH(NOLOCK) WHERE low_fats='Y' AND recyclable='Y'