create table actor
(
    id int not null,
    first_name varchar(64) null,
    last_name varchar(64) null,
    constraint actor_id_uindex
        unique (id)
);

alter table actor
    add primary key (id);

create table actor_films
(
    id int auto_increment
        primary key,
    actor_id int null,
    film_id int null
);

create table cinema
(
    id int auto_increment
        primary key,
    title varchar(64) null,
    address varchar(64) null,
    phone varchar(64) null,
    email varchar(64) null
);

create table discount
(
    id int auto_increment
        primary key,
    title varchar(64) null,
    description varchar(64) null,
    percent int null
);

create table film
(
    id int auto_increment
        primary key,
    title varchar(64) null,
    duration int null,
    description varchar(1024) null,
    year varchar(64) null,
    country varchar(64) null,
    restriction int null,
    start_from varchar(64) null
);

create table genre
(
    id int auto_increment
        primary key,
    title varchar(64) not null,
    description varchar(256) null,
    constraint genre_title_uindex
        unique (title)
);

create table genre_films
(
    id int auto_increment
        primary key,
    genre_id int null,
    film_id int null
);

create table hall
(
    id int auto_increment
        primary key,
    title varchar(64) null,
    description varchar(64) null,
    cinema_id int null
);

create table roww
(
    id int auto_increment
        primary key,
    row_index int null,
    seats int null,
    hall_id int null
);

create table ticket
(
    id int auto_increment
        primary key,
    row_id int null,
    seat int null,
    film_session_id int null,
    user_id int null,
    price int null
);

create table user
(
    id int auto_increment
        primary key,
    username varchar(64) null,
    first_name varchar(64) null,
    last_name varchar(64) null,
    phone varchar(64) null,
    password varchar(64) null,
    email varchar(64) null,
    discount_id int null
);

