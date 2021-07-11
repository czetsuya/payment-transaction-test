CREATE TABLE payment_transaction
(
    id           bigint NOT NULL AUTO_INCREMENT,
    version      int,
    sender       varchar(255),
    receiver     varchar(255),
    total_amount decimal(23, 12),
    primary key (id)
);

CREATE TABLE payment_transaction_line
(
    id          bigint NOT NULL AUTO_INCREMENT,
    version     int,
    parent_id   bigint,
    paid_amount decimal(23, 12),
    primary key (id)
);