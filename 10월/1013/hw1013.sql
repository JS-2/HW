use ssafybd;

select * from emp;
select * from departments;
select * from locations;
select * from salgrades;

-- #1
select e.ename, e.empno, e.deptno, d.department_name
from emp e natural join departments d
where e.deptno = 30;

-- #2
select e.job, l.city
from emp e join departments d
on e.deptno = d.department_id
join locations l
on d.location_id = l.location_id
where e.deptno = 30;

-- #3
select e.ename, d.department_name, l.city
from emp e join departments d
on e.deptno = d.department_id
join locations l
on d.location_id = l.location_id
where e.comm is not null;

-- #4
select e.ename, d.department_name
from emp e join departments d
on e.deptno = d.department_id
where e.ename like '%A%';

-- #5
select e.ename, e.job, d.department_id, d.department_name
from emp e join departments d
on e.deptno = d.department_id
join locations l
on d.location_id = l.location_id
where l.city = 'Dallas';

-- #6
select e.ename employee, e.empno 'emp#', m.ename manager, e.mgr 'mgr#'
from emp e join emp m
on e.mgr = m.empno;

-- #7
select e.ename, e.job, d.department_name, e.sal, g.grade
from emp e left join departments d
on e.DEPTNO = d.department_id
left join salgrades g
on e.sal >= g.losal and e.sal <= g.hisal;

-- #8
select ename hiredate
from emp
where hiredate > (select hiredate from emp where ename = 'smith');

-- #9
select e.ename Employee, e.hiredate EmpHiredate, m.ename Manager, m.hiredate MgrHiredate
from emp e join emp m
on e.mgr = m.empno
where e.hiredate < m.hiredate;

-- #10
select ename, hiredate
from emp
where ename != 'smith' and deptno = (select deptno from emp where ename = 'smith');

-- #11
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;

-- #12
select deptno, ename
from emp
where deptno = any (select deptno from emp where ename like '%T%');