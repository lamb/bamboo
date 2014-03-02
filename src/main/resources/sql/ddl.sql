create table project (
id int(11) not null primary key auto_increment,
name varchar(2000) not null,
repository int(200) not null,
create_by int(11),
create_date date,
update_by int(11),
update_date date
);

create table feature (
id int(11) not null primary key auto_increment,
project_id int(11) not null,
name varchar(50) not null,
create_by int(11),
create_date date,
update_by int(11),
update_date date
);

create table code (
id int(11) not null primary key auto_increment,
feature_id int(11) not null,
path varchar(1000) not null,
create_by int(11),
create_date date,
update_by int(11),
update_date date
);

create table version (
id int(11) not null primary key auto_increment,
project_id int(11) not null,
name varchar(1000) not null,
create_by int(11),
create_date date,
update_by int(11),
update_date date
);

create table release (
id int(11) not null primary key auto_increment,
version_id varchar(11) not null,
feature_id varchar(11) not null,
create_by int(11),
create_date date,
update_by int(11),
update_date date
);
