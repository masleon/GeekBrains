create table if not exists books (id bigserial primary key, title varchar(255), price int);

insert into books (title, price)
values
    ('Bob', 100),
    ('Jack', 80),
    ('John', 90);