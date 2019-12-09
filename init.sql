CREATE TABLE shoe (
    shoe_id SERIAL PRIMARY KEY,
    name VARCHAR (100) UNIQUE
);

CREATE TABLE true_to_size (
    true_to_size_id SERIAL PRIMARY KEY,
    true_to_size_value INTEGER NOT NULL,
    shoe_id INTEGER REFERENCES shoe(shoe_id)
);

