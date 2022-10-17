create table if not exists products (id bigserial primary key, title varchar(255), cost int);

insert into products (title, cost)
values
    ('Milk', 100),
    ('TV set', 80),
    ('Table', 60),
    ('Chair', 70),
    ('Cup', 44),
    ('Pensil', 12),
    ('Lamp', 54),
    ('Wire', 32),
    ('Keyboard', 85),
    ('Carpet', 62),
    ('Button', 28),
    ('Flower', 48),
    ('Tree', 32),
    ('Notebook', 59),
    ('Paint marker', 36),
    ('Pen', 33),
    ('Window', 55),
    ('Glass', 23),
    ('Cheese', 76);