SELECT 
    payment_number AS 'Номер платежа',
    payment_date AS 'Дата',
    entity_name AS 'Получатель',
    amount AS 'Сумма'
FROM
    expenses,
    contractors
WHERE
    amount > 10000
        AND recipient_id = contractors.id
;