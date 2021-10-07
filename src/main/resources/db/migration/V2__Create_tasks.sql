CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    status BOOLEAN NOT NULL,
    title VARCHAR(100) NOT NULL,
    timelimit date,
    memberId INTEGER NOT NULL
);
