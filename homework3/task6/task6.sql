-- Вывести список получателей платежей и сумму платежей по каждому из них.
SELECT 
    entity_name AS 'Получатель платежа',
    (SELECT 
            SUM(amount)
        FROM
            expenses
        WHERE
            recipient_id = c.id) AS 'Сумма платежей'
FROM
    contractors c
;

-- Вывести сумму платежей за тот день, когда был наибольший платеж.
SELECT 
    payment_date AS 'Дата наибольшего платежа',
    SUM(amount) AS 'Сумма платежей'
FROM
    expenses
WHERE
    payment_date = (SELECT 
            payment_date
        FROM
            expenses
        WHERE
            (SELECT DISTINCT
                    MAX(amount)
                FROM
                    expenses) = amount)
;

-- Вывести наибольший платеж за тот день, когда сумма платежей была наибольшей.

SELECT 
    payment_number AS 'Номер платежа',
    payment_date AS 'Дата',
    entity_name AS 'Получатель',
    MAX(amount) AS 'Сумма'
FROM
    expenses,
    contractors
WHERE
    recipient_id = contractors.id
        AND payment_date = (SELECT 
            p_date
        FROM
            (SELECT 
                MAX(d_sum), p_date
            FROM
                (SELECT 
                SUM(amount) AS d_sum, payment_date AS p_date
            FROM
                expenses
            GROUP BY payment_date) d_sums) d_day)
;