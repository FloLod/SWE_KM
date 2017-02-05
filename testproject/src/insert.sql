INSERT INTO `users` VALUES (1,'test@test.com','Max','2017-01-30 00:00:00','Mustermann','Geheim'),(2,'blocked@education-siemens.com','Timo','2017-01-30 00:00:00','Böse','Geheim'),(3,'short@short.com','Short','2017-01-30 00:00:00','Short','Geheim'),(4,'admin@education-siemens.com','Armin','2017-01-30 00:00:00','Admin','Geheim');

INSERT INTO `studentclass` VALUES (1,'FS','2014-01-30 00:00:00'),(2,'FI','2014-01-30 00:00:00');

INSERT INTO `admins` VALUES (1,4);

INSERT INTO `contenttype` VALUES (1,10,'Nachweiß',1),(2,5,'Termin',1),(3,50,'Stundenplan',1),(4,15,'Frage',1),(5,20,'Antwort',1);

INSERT INTO `content` VALUES (1,'2017-01-30 00:00:00','2017-02-05 00:00:00',1,1),(2,'2017-02-11 00:00:00','2017-02-11 00:00:00',2,1),(3,'2015-02-11 00:00:00','2017-02-11 00:00:00',3,1),(4,'2017-02-11 00:00:00','2017-02-11 00:00:00',4,1),(5,'2017-02-11 00:00:00','2017-02-11 00:00:00',5,1);

INSERT INTO `files` VALUES (1,'Stundenplan Klasse1',3,2);

INSERT INTO `student` VALUES (1,1,100,0,1,1),(2,1,3200,0,1,2),(3,0,10,0,1,3);

INSERT INTO `text` VALUES (1,'SWE','Erstellung einer Webapp'),(2,'Studenplan','Stundenplan im ersten Ausbildungsjahr in der Berufsschule'),(3,'Webentwicklung','Java Webentwicklung'),(4,'Sollte Java Properties unterstützen?','Die Alternative C# besitzt Properties, diese gibt es jedoch nicht in Java, wie fändet ihr eine Umsetzung diese Konzeptes?'),(5,'Troll','STRG + F'),(6,'Du bis mit dem nächstne Nachweiß dran','Bitte schreibe den nächsten Nachweiß und lade ihn hoch');

INSERT INTO `activity` VALUES (1,'tag1',2),(2,'tag2',2),(3,'tag3',2),(4,'tag4',2),(5,'tag5',2);

INSERT INTO `blocklist` VALUES (1,'2017-03-31 00:00:00','trolling',2);

INSERT INTO `category` VALUES (1,3);

INSERT INTO `appointmenttype` VALUES (1,'Veranstalungen rund ums Studium','Studienveranstaltung');

INSERT INTO `appointment` VALUES (1,'2017-02-13 16:45:00','2017-02-13 13:30:00',1,2,1);

INSERT INTO `educationdiary` VALUES (1,'2017-01-30 00:00:00','2017-02-05 00:00:00',2,1,1,1);

INSERT INTO `educationdiaryday` VALUES (1,1),(2,1),(3,1),(4,1),(5,1);

INSERT INTO `educationdiarylist` VALUES (1,1,1);

INSERT INTO `notificationtype` VALUES (1,'Nachweiß fällig');

INSERT INTO `notification` VALUES (1,1,1,6);

INSERT INTO `question` VALUES (1,1,4,4);

INSERT INTO `reply` VALUES (1,5,1,5);

INSERT INTO `studentappointment` VALUES (1,1,1,1);

INSERT INTO `timetable` VALUES (1,'2017-08-31 00:00:00','2016-09-01 00:00:00',1,1);

INSERT INTO `likes` VALUES (1,1,1);

insert into educationdiaryday_activity values(1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5);
