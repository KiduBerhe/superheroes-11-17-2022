create table superhero (id serial primary key, superhero_name varchar(50), super_power varchar(50), strength integer, weakness varchar(50), franchise char, world varchar(50));

-- insert/create, write default for id:
insert into superhero values(default, 'Spider-Man', 'Webs', 7, 'Gravity', 'M', 'Earth');
insert into superhero values (default, 'Raven', 'Magic', 9, 'Emotions', 'D', 'Azarath');
insert into superhero values(default, 'Batman’', 'Rich', 8, 'no-tech', 'D', 'Earth');
insert into superhero values(default, 'Jotora Kujo', 'stands', 18, 'vampire' ,'J', 'earth');
insert into superhero values(default, 'Repair-Man', 'Duct tape', 9, 'Change Orders', 'M', 'Garage');
insert into superhero values(default, 'chainsaw Man', 'turn his arms into chainsaws', 11, 'Anemia' ,'J', 'earth');

-- update/PUT
update superhero set superhero_name = 'Chainsaw Man', super_power = 'new super power' where id = 6;

-- delete
delete from superhero where id = 1;

-- select/retrieve/read
select * from superhero;
select * from superhero where id = 3;
select * from superhero where franchise = 'M';
select * from superhero where strength < 9;

-- optional, create an index