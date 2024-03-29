-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, CONCAT(CITY,' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) "전체주소	", CONCAT(LEFT(TLNO, 3), '-', MID(TLNO, 4, 4), '-', RIGHT(TLNO, 4)) "전화번호"
  FROM USED_GOODS_USER U
  JOIN USED_GOODS_BOARD B
    ON WRITER_ID = USER_ID
 GROUP BY WRITER_ID
HAVING COUNT(WRITER_ID) >= 3
 ORDER BY USER_ID DESC