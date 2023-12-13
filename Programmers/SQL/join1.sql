/*
PRODUCT_CODE별 매출액(PRICE*SALES_AMOUNT) 합계를 출력하라.
매출액을 기준으로 내림차순 정렬하고, 매출액이 같을 경우 상품코드를 기준으로 오름차순 정렬하라.

PRODUCT TABLE
PRODUCT_ID, PRODUCT_CODE, PRICE

OFFLINE_SALE TABLE
OFFLINE_SALE_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE
*/

SELECT a.product_code, a.price * b.amounts as sales
from PRODUCT as a
inner join
(select product_id,sum(sales_amount) as amounts from OFFLINE_SALE as b group by product_id) 
b on a.PRODUCT_ID=b.PRODUCT_ID
order by sales desc, product_code asc;