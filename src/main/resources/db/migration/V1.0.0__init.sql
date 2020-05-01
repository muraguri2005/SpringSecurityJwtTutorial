create table if not exists users (
id uuid primary key,
username varchar (255) not null ,
password varchar (255) not null
);
create table if not exists role(
id uuid primary key,
name varchar (50) not null,
unique key unique_name(name)
);
create table if not exists user_role (
    user_id uuid not null ,
    role_id uuid not null ,
    primary key (user_id,role_id),
    constraint FK_USER_ID foreign key (user_id) references users (id),
    constraint FK_ROLE_ID foreign key (role_id) references role (id)
);
