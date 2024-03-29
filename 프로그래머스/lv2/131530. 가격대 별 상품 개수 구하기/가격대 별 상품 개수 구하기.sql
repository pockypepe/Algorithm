-- 코드를 입력하세요
SELECT (
  CASE 
  WHEN PRICE < 10000 THEN 0
  ELSE TRUNCATE(PRICE, -4)
  # WHEN PRICE >= 10000 AND PRICE < 20000 THEN 10000
  # WHEN PRICE >= 20000 AND PRICE < 30000 THEN 20000
  # WHEN PRICE >= 30000 AND PRICE < 40000 THEN 30000
   END) PRICE_GROUP, COUNT(PRODUCT_ID) PRODUCTS
  FROM PRODUCT
 GROUP BY PRICE_GROUP
 ORDER BY PRICE_GROUP