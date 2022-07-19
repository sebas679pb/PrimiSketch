insert into users (name_user, passwrd, programa, tipo, username) VALUES ('Sebastian Piñeros', '12345', 'Sistemas', 'Estudiante', 'jhon.pineros');
insert into users (name_user, passwrd, programa, tipo, username) VALUES ('Juan baez', '12345', 'Sistemas', 'Estudiante', 'juan.baez');
insert into users (name_user, passwrd, programa, tipo, username) VALUES ('Nicolas Palacios', '12345', 'Sistemas', 'Estudiante', 'nicolas.palacios');
insert into users (name_user, passwrd, programa, tipo, username) VALUES ('admin', 'admin', NULL, 'Administrador', 'admin');

insert into schedules (nombre) VALUES ('schedule 1');
insert into schedules (nombre) VALUES ('schedule 2');
insert into schedules (nombre) VALUES ('schedule 3');

insert into subjects (group_sub, memo_sub, name_sub, professor) VALUES (1, 'ARSW', 'Arquitectura de sofware', 'Daniel Benavides');
insert into subjects (group_sub, memo_sub, name_sub, professor) VALUES (2, 'ARSW', 'Arquitectura de sofware', 'Daniel Benavides');
insert into subjects (group_sub, memo_sub, name_sub, professor) VALUES (1, 'RECO', 'Redes de computadores', 'Claudia Santiago');
insert into subjects (group_sub, memo_sub, name_sub, professor) VALUES (1, 'SPTI', 'Seguridad y privacidad de TI', 'Carlos Villalba');

insert into dates_subject (dia, end_time, start_time, id_subject) VALUES ('M', '10:00', '7:00', 1);
insert into dates_subject (dia, end_time, start_time, id_subject) VALUES ('J', '16:00', '13:00', 1);
insert into dates_subject (dia, end_time, start_time, id_subject) VALUES ('J', '10:00', '7:00', 2);
insert into dates_subject (dia, end_time, start_time, id_subject) VALUES ('V', '16:00', '13:00', 2);
insert into dates_subject (dia, end_time, start_time, id_subject) VALUES ('L', '10:00', '8:30', 3);
insert into dates_subject (dia, end_time, start_time, id_subject) VALUES ('M', '10:00', '8:30', 3);
insert into dates_subject (dia, end_time, start_time, id_subject) VALUES ('X', '10:00', '7:00', 3);
insert into dates_subjects (dia, end_time, start_time, id_subject) VALUES ('S', '13:00', '10:00', 4);
insert into dates_subjects (dia, end_time, start_time, id_subject) VALUES ('J', '19:00', '16:00', 4);

insert into schedulexsubject (id_subject,id_schedule) VALUES (2,1);
insert into schedulexsubject (id_subject,id_schedule) VALUES (3,1);

insert into userxschedule (id_user,id_schedule) VALUES (1,1);
