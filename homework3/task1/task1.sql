CREATE DATABASE IF NOT EXISTS expenses_accounting DEFAULT CHARACTER SET utf8;
USE expenses_accounting;

CREATE TABLE IF NOT EXISTS expenses_accounting.contractors (
    id INT PRIMARY KEY,
    entity_name VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS expenses_accounting.expenses (
    payment_number INT PRIMARY KEY,
    payment_date DATE NOT NULL,
    recipient_id INT NOT NULL,
    CONSTRAINT recipient_id FOREIGN KEY (recipient_id)
        REFERENCES expenses_accounting.contractors (id),
    amount DECIMAL NOT NULL
);

INSERT INTO expenses_accounting.contractors VALUES (1, 'Интернет-провайдер "Соло"');
INSERT INTO expenses_accounting.contractors VALUES (2, 'Гипермаркет "Корона"');
INSERT INTO expenses_accounting.contractors VALUES (3, 'МТС');

INSERT INTO expenses_accounting.expenses VALUES (1, '2011.5.10', 1, 20000);
INSERT INTO expenses_accounting.expenses VALUES (2, '2011.5.10', 2, 94200);
INSERT INTO expenses_accounting.expenses VALUES (3, '2011.5.11', 3, 10000);
INSERT INTO expenses_accounting.expenses VALUES (4, '2011.5.11', 2, 12950);