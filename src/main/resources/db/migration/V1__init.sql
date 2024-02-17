create table book (
    book_id int primary key auto_increment,
    title varchar(100) not null,
    author varchar(100),
    year int,
    price decimal(10,2),
    description text
);