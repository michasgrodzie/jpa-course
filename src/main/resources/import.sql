INSERT INTO COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) VALUES(1001,'Programowanie',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) VALUES(1002,'Ksiegowosc',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) VALUES(1003,'Czyszczenie Kuwety',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP	());
INSERT INTO COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) VALUES(1004,'Wakacje nad morzem',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
INSERT INTO COURSE(ID,NAME,CREATED_DATE,LAST_UPDATED_DATE) VALUES(1005,'Praca w firmie',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());



INSERT INTO PASSPORT(ID,NUMBER) VALUES(3001,'E1234');
INSERT INTO PASSPORT(ID,NUMBER) VALUES(3002,'E5678');
INSERT INTO PASSPORT(ID,NUMBER) VALUES(3003,'E9012');
INSERT INTO PASSPORT(ID,NUMBER) VALUES(3004,'E6543');



INSERT INTO STUDENT(ID,NAME,PASSPORT_ID) VALUES(2001,'Michal',3001);
INSERT INTO STUDENT(ID,NAME,PASSPORT_ID) VALUES(2002,'Kasia',3002);
INSERT INTO STUDENT(ID,NAME,PASSPORT_ID) VALUES(2003,'Hania',3003);
INSERT INTO STUDENT(ID,NAME,PASSPORT_ID) VALUES(2004,'Gabrynia',3004);




INSERT INTO REVIEW(ID,RATING,DESCRIPTION,COURSE_ID) VALUES(4001,'4','Bardzo Dobry',1001);
INSERT INTO REVIEW(ID,RATING,DESCRIPTION,COURSE_ID) VALUES(4002,'3','Dobry',1002);
INSERT INTO REVIEW(ID,RATING,DESCRIPTION,COURSE_ID) VALUES(4003,'2','Przecietny',1003);
INSERT INTO REVIEW(ID,RATING,DESCRIPTION,COURSE_ID) VALUES(4004,'1','Słaby',1004);
INSERT INTO REVIEW(ID,RATING,DESCRIPTION,COURSE_ID) VALUES(4005,'0','BardzoSłaby',1004);

INSERT INTO STUDENT_COURSE(STUDENT_ID,COURSE_ID) VALUES(2001,1001);
INSERT INTO STUDENT_COURSE(STUDENT_ID,COURSE_ID) VALUES(2002,1002);
INSERT INTO STUDENT_COURSE(STUDENT_ID,COURSE_ID) VALUES(2004,1003);
