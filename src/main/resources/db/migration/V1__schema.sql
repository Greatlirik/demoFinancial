CREATE TABLE account (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR (255) NOT NULL,
    active BOOLEAN NOT NULL,
    CONSTRAINT pk_account_id PRIMARY KEY (id)
);

CREATE TABLE coin (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    value DECIMAL NOT NULL,
    CONSTRAINT pk_coin_id PRIMARY KEY (id)
);

CREATE TABLE record (
    id SERIAL,
    account_id INTEGER NOT NULL,
    coin_name VARCHAR(255) NOT NULL,
    price_usd DECIMAL NOT NULL,
    cur_time TIMESTAMP NOT NULL,
    CONSTRAINT pk_record_id PRIMARY KEY (id),
    CONSTRAINT fk_record_account_id FOREIGN KEY (account_id) REFERENCES account (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE SEQUENCE records_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE role (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_role_id PRIMARY KEY (id),
    CONSTRAINT uk_role_name UNIQUE (name)
);

CREATE TABLE account_role (
    id SERIAL,
    account_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT pk_account_role_id PRIMARY KEY (id),
    CONSTRAINT fk_account_role_account_id FOREIGN KEY (account_id) REFERENCES account (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_account_role_role_id FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE account_record (
    id SERIAL,
    account_id INTEGER NOT NULL,
    record_id INTEGER NOT NULL,
    CONSTRAINT pk_account_record_id PRIMARY KEY (id),
    CONSTRAINT fk_account_record_account_id FOREIGN KEY (account_id) REFERENCES account (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_account_record_record_id FOREIGN KEY (record_id) REFERENCES record (id) ON DELETE CASCADE ON UPDATE CASCADE
);


