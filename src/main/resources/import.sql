DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, cost int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ('Milk', 12), ('Bread', 31), ('Potato', 64);
