create table book (
    book_id bigint primary key auto_increment,
    title varchar(100) not null,
    author varchar(100),
    year int,
    price decimal(10,2),
    description text,
    created_at datetime not null default current_timestamp,
    updated_at datetime not null default current_timestamp on update current_timestamp
);