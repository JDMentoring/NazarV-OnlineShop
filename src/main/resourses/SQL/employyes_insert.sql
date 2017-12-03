INSERT INTO job_titles (title_name)
VALUES ('Менеджер'),('Консультант'),('Курєр'),('Постачальник');

SELECT * FROM job_titles;

INSERT INTO departments (short_name, full_name)
VALUES ('Продажі','Відділ продаж'),('Доставка','Відділ доставки'),('Підтримка','Відділ підтримки'),('Логістика','Відділ постачання');

SELECT * FROM departments;

INSERT INTO persons (f_name, l_name, born_date)
VALUES ('Nazar', 'Voichak','1997-12-29'),('Igor', 'Kupchak','1998-01-06'),('Igor', 'Voichak','1998-04-22'),
('Oleksandr','Baza','1998-12-15');

INSERT INTO users (login,password,status,email)
VALUES  ('nazar17','voichak17','New','nazar.voichak@gmail.com'),
('igor17','kupchak17','New','igor.kupchak@gmail.com'),
('igor16','voichak17','New','igor.voichak@gmail.com'),
('oleksandr17','baza17','New','oleksandr.baza@gmail.com');

SELECT * FROM users;

INSERT INTO employees (persons_id,users_id,departments_id,job_titles_id,salary,hire_date)
VALUES
((SELECT id FROM persons WHERE f_name = 'Nazar' AND l_name = 'Voichak'),
(SELECT id FROM users WHERE  login = 'nazar17'),
(SELECT id FROM departments WHERE short_name ='Продажі'),
(SELECT id FROM job_titles WHERE title_name = 'Менеджер'),10000, CURRENT_DATE),
((SELECT id FROM persons WHERE f_name = 'Igor' AND l_name = 'Kupchak'),
(SELECT id FROM users WHERE  login = 'igor17'),
(SELECT id FROM departments WHERE short_name ='Підтримка'),
(SELECT id FROM job_titles WHERE title_name = 'Консультант'),10000, CURRENT_DATE),
((SELECT id FROM persons WHERE f_name = 'Igor' AND l_name = 'Voichak'),
(SELECT id FROM users WHERE  login = 'igor16'),
(SELECT id FROM departments WHERE short_name ='Доставка'),
(SELECT id FROM job_titles WHERE title_name = 'Курєр'),10000, CURRENT_DATE),
((SELECT id FROM persons WHERE f_name = 'Oleksandr' AND l_name = 'Baza'),
(SELECT id FROM users WHERE  login = 'oleksandr17'),
(SELECT id FROM departments WHERE short_name ='Логістика'),
(SELECT id FROM job_titles WHERE title_name = 'Постачальник'),10000, CURRENT_DATE);


SELECT * FROM employees;


INSERT INTO persons (f_name,l_name,born_date)
VALUES ('Nazar','Voichak','1997-12-13'),
('Igor','Kupchak','1998-02-08'),
('Igor','Voichak','1998-04-14'),
('Oleksandr','Baza','1998-07-17');

