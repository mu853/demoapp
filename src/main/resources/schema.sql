DROP TABLE IF EXISTS messages;

CREATE TABLE messages (
    id SERIAL NOT NULL,
    text VARCHAR(255) NOT NULL
);
