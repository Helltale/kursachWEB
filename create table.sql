create table film(
	film_name text primary key 
);

create table place(
	place_id serial primary key,
	place_street text,
	place_area text,
	place_house text,
	unique(place_street, place_house)
);

create table cinema(
	cinema_id serial primary key,
	place_id int references place(place_id) on delete cascade on update cascade,
	cinema_name text,
	cinema_phone text unique
);

create table hall(
	hall_number int,
	cinema_id int references cinema(cinema_id) on delete cascade on update cascade,
	hall_sits int,
	primary key(hall_number, cinema_id)
);

	create table hall_film(
	film_name text references film(film_name) on delete cascade on update cascade,
	hall_number int,
	cinema_id int,
	hall_film_datetime timestamp,
	hall_film_ticket_price numeric(10, 2),
	hall_film_ticket_count int,
	foreign key(hall_number, cinema_id) references hall(hall_number, cinema_id) on delete cascade on update cascade,
	primary key(film_name, hall_number, cinema_id, hall_film_datetime)
);