use ssafydb;

select * from employees;
select * from departments;
select * from jobs;
-- 1)
select e.employee_id, e.first_name, e.job_id, e.department_id, d.department_name
from employees e join departments d
on e.department_id = d.department_id
where job_id = (select job_id from employees where upper(first_name) = upper('Diana'));

-- 2)
select e.employee_id, e.first_name, j.job_title, d.department_name
from employees e join (select manager_id
	  from employees
      where upper(first_name) = upper('Bruce')) m
on e.manager_id = m.manager_id
join jobs j
on e.job_id = j.job_id
join departments d
on e.department_id = d.department_id;

-- 3)
select employee_id, first_name, hire_date
from employees
order by hire_date limit 5, 5;