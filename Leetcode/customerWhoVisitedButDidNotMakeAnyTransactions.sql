-- https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
SELECT customer_id, COUNT(1) count_no_trans FROM (
                                                     SELECT V.customer_id, T.amount
                                                     FROM Visits V
                                                              LEFT JOIN Transactions T ON V.visit_id = T.visit_id
                                                     WHERE T.amount IS NULL
                                                 ) TS
GROUP BY customer_id