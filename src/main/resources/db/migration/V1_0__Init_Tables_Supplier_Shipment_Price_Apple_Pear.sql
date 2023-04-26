CREATE TABLE IF NOT EXISTS "supplier"
(
    id   bigserial
        constraint supplier_pk
            primary key,
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS "apple"
(
    id         bigserial
        constraint apple_pk
            primary key,
    apple_type varchar(255)
);
CREATE TABLE IF NOT EXISTS "pear"
(
    id        bigserial
        constraint pear_pk
            primary key,
    pear_type varchar(255)
);


CREATE TABLE IF NOT EXISTS "price"
(
    id          bigserial
        constraint price_pk
            primary key,
    expiration  date,
    price       bigint,
    apple_id    bigint,
    foreign key (apple_id) references "apple",
    pear_id     bigint,
    foreign key (pear_id) references "pear",
    supplier_id bigint,
    foreign key (supplier_id) references "supplier"
);

CREATE TABLE IF NOT EXISTS "shipment"
(
    id          bigserial
        constraint shipment_pk
            primary key,
    date        date,
    weight      bigint,
    cost        bigint,
    apple_id    bigint,
    foreign key (apple_id) references "apple",
    pear_id     bigint,
    foreign key (pear_id) references "pear",
    supplier_id bigint,
    foreign key (supplier_id) references "supplier"
);
