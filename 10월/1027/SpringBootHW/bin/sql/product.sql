drop table product;

create table product(
    id          varchar(20) primary key,
    name        varchar(30) not null,
    price       int,
    description varchar(50)    
);