INSERT into enduser(id,username,password,firstname,lastname,email) values (1, 'admin', '$2a$10$c2eUNs4Wga9tXygoNjolWelIop71cOzPwKPuUuY3wY.cTctt3tz6W', 'Admin','Administrator','admin@admin.com')
INSERT into enduser(id,username,password,firstname,lastname,email) values (2, 'user', '$2a$10$CPkH8.7ccgNWIbu9xNURR.OxSuT.VwRhOeTBO6zT3r//gfWWeC.Y6', 'User','User','user@user.com')



INSERT into role(id, name) values (1, 'ROLE_ADMIN')
insert into role(id,name) values (2,'ROLE_USER')


INSERT into user_role(user_id,role_id) values (1,1)
INSERT into user_role(user_id,role_id) values (2,2)