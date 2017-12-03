# ID/NAME/SURNAME/LOGIN/STATUS/EMAIL/DEP_NAME/TITLE_NAME/SALARY/HIRE_DATE


SELECT em.id , p.f_name , p.l_name , usr.login, usr.status, usr.email, dep.short_name, jt.title_name, em.salary, em.hire_date
FROM employees AS em
JOIN persons AS p ON em.persons_id = p.id
JOIN users AS usr ON em.users_id = usr.id
JOIN departments AS dep ON em.departments_id = dep.id
JOIN job_titles AS jt ON em.job_titles_id = jt.id
WHERE MONTH(em.hire_date)=11 AND DAYOFMONTH(em.hire_date) =26
;

WHERE usr.login LIKE '%17%' AND p.f_name NOT LIKE '%Nazar%';