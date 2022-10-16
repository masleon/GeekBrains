DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, cost int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, cost) VALUES ('Milk', 12), ('Bread', 31), ('Potato', 64);
CREATE TABLE IF NOT EXISTS clients (name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO clients (name) VALUES ('John'), ('Bob'), ('Mike');
CREATE TABLE IF NOT EXISTS basket (product_id integer REFERENCES products(id), client_id integer REFERENCES clients(id), PRIMARY KEY (id));
INSERT INTO basket (product_id, client_id) VALUES (3,1), (2,1), (2,3);