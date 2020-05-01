insert into users(id,username,password) values
( '14b87eeb-c28c-4b5c-837a-85b9319bc1e5','admin@freelessons.org','$2a$10$f4h9Zp.6qcu5IaJXQ834euAWB0f7tXB5e6R1vXyXSek6TAc3yIErG' );

insert into role(id,name) values ( '99a5acc7-fb24-4b40-812f-c4aa974e266f','ROLE_ADMIN' ), ('378dfea4-a402-4d8d-b678-51b8d329701c','ROLE_USER');
insert into user_role(user_id,role_id) values ( '14b87eeb-c28c-4b5c-837a-85b9319bc1e5','99a5acc7-fb24-4b40-812f-c4aa974e266f' ), ('14b87eeb-c28c-4b5c-837a-85b9319bc1e5','378dfea4-a402-4d8d-b678-51b8d329701c');
