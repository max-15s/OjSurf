-- https://leetcode.com/problems/rearrange-products-table/
SELECT product_id, 'store1' store, store1 price FROM Products WHERE store1 is not null
UNION
SELECT product_id, 'store2' store, store2 price FROM Products WHERE store2 is not null
UNION
SELECT product_id, 'store3' store, store3 price FROM Products WHERE store3 is not null