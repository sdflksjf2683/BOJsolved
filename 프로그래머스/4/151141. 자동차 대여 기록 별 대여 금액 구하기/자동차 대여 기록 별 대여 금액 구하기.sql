WITH CAR_PRICE AS (
    SELECT C.DAILY_FEE, C.CAR_TYPE, H.HISTORY_ID,DATEDIFF(END_DATE,START_DATE)+1 AS 'DUR',
    CASE
        WHEN DATEDIFF(END_DATE,START_DATE)+1 >= 90 THEN '90일 이상'
        WHEN DATEDIFF(END_DATE,START_DATE)+1 >= 30 THEN '30일 이상'
        WHEN DATEDIFF(END_DATE,START_DATE)+1 >= 7 THEN '7일 이상'
        ELSE 'N'
    END AS 'TYPE'
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H 
    JOIN CAR_RENTAL_COMPANY_CAR C
    ON C.CAR_ID = H.CAR_ID
    WHERE C.CAR_TYPE = '트럭'
)

SELECT CP.HISTORY_ID, ROUND(CP.DAILY_FEE * CP.DUR * (100-IFNULL(P.DISCOUNT_RATE, 0))/100) AS 'FEE'
FROM CAR_PRICE CP LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P
ON CP.TYPE = P.DURATION_TYPE AND CP.CAR_TYPE = P.CAR_TYPE
ORDER BY FEE DESC, CP.HISTORY_ID DESC;