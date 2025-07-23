CREATE TABLE movie (
    id serial PRIMARY KEY,
    title varchar(255) NOT NUll,
    description text,
    release_date date,
    rating numeric,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
