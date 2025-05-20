insert into Course (id, title, credits)
values ('INT1', 'Introductions', 10),
('MAT1', 'Mathematiques II', 3),
('CAI1', 'Anglais I', 2),
('DEV1', 'Developpement I', 10),
('DEV2', 'Developpement II', 10),
('WEBG2', 'Developpement Web I', 5);

insert into Student (matricule, nom, gender, section)
values (0, 'ibrahim', 0 ,0),
(1, 'YASSINE',0,2),
(2, 'soukaina',1,1);


INSERT INTO My_User(username,password,enabled) values('ibrahim','{bcrypt}$2a$12$OXJuF6alvWnzcjsfdVqvqegt/ovneprWfgg.pfr8Awoy.sPH8MhMq',true);
INSERT INTO Authority(id,username,authority) values(1,'ibrahim','SECRETARIAT');

