
CREATE TABLE `airport` (
  `idairport` int(11) NOT NULL unique auto_increment,
  `Name` varchar(45) NOT NULL unique ,
  PRIMARY KEY (`idairport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;--

insert into airport values (1,'Borispol');
insert into airport values (2,'Zhulyany');
insert into airport values (3,'someAirport');

 CREATE TABLE `operator` (
  `idoperator` int(11) NOT NULL unique auto_increment,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`idoperator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into operator values (0,'Ivanov', 'Ivan',29);
insert into operator values (1,'Petrov', 'Petr',29);
insert into operator values (2,'Sidorov', 'Stepan',27);

CREATE TABLE `pilot` (
  `idpilot` int(11) NOT NULL unique auto_increment,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`idpilot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into pilot values (0,'Ivanov1', 'Ivan1',30);
insert into pilot values (1,'Petrov1', 'Petr1',31);
insert into pilot values (2,'Sidorov1', 'Stepan1',33);

CREATE TABLE `pilot_have_team` (
  `pilot_idpilot` int(11) NOT NULL a,
  `team_idteam` int(11) NOT NULL,
  PRIMARY KEY (`pilot_idpilot`,`team_idteam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into pilot_have_team values (0,0);
insert into pilot_have_team values (0,1);
insert into pilot_have_team values (1,1);
insert into pilot_have_team values (2,2);
insert into pilot_have_team values (2,1);

CREATE TABLE `request` (
  `idrequest` int(11) NOT NULL unique auto_increment,
  `idteam` int(11) NOT NULL,
  `status` tinyint(1) NULL,
  PRIMARY KEY (`idrequest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into request values(0,1,0);



CREATE TABLE `request_user` (
  `iduser` int(11) NOT NULL ,
  `idrequest` int(11) NOT NULL ,
  PRIMARY KEY (`iduser`,`idrequest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into request_user values(1,1);

CREATE TABLE `roles` (
  `idroles` int(11) NOT NULL  unique auto_increment,
  `Name` varchar(45) NOT NULL unique,
  PRIMARY KEY (`idroles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into roles values (0,'Admin');
insert into roles values (2,'Dispetcher');
insert into roles values (3,'Guest');


CREATE TABLE `stewardess` (
  `idstewardess` int(11) NOT NULL unique auto_increment,
  `frist_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`idstewardess`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into stewardess values(0,'Ivanova', 'Anna', 24);
insert into stewardess values(1,'Sidorova', 'Svetlana', 26);
insert into stewardess values(2,'Petrova', 'Irina', 36);

CREATE TABLE `team` (
  `idteam` int(11) NOT NULL  unique auto_increment,
  `idnavigator` int(11) NOT NULL,
  `idoperator` int(11) NOT NULL,
  PRIMARY KEY (`idteam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into team values(0,0,0);
insert into team values(1,0,1);
insert into team values(2,1,0);

CREATE TABLE `stewardess_have_team` (
  `stewardess_idstewardess` int(11) NOT NULL,
  `team_idteam` int(11) NOT NULL,
  PRIMARY KEY (`stewardess_idstewardess`,`team_idteam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into stewardess_have_team values (0,0);
insert into stewardess_have_team values (0,1);
insert into stewardess_have_team values (1,0);
insert into stewardess_have_team values (1,1);
insert into stewardess_have_team values (2,2);

CREATE TABLE `users` (
  `idUsers` int(11) NOT NULL  unique auto_increment,
  `idAirport` int(11) NOT NULL,
  `Login` varchar(45) NOT NULL unique,
  `Password` varchar(45) NOT NULL,
  `First_Name` varchar(45) NOT NULL,
  `Last_Name` varchar(45) NOT NULL,
  `idRole` int(11) NOT NULL,
  PRIMARY KEY (`idUsers`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into users values (0, 0,'Admin','password1','Ivanov2', 'Ivan2',0);
insert into users values (1, 0,'Dispetcher','password2','Ivanov3', 'Ivan3',1);
insert into users values (2, 0,'Guest','Guest','Ivanov4','Ivan4',2);
insert into users values (3, 1,'AnotherAdmin','anotherPassword1','Ivanov5', 'Ivan5',0);
insert into users values (4, 1,'AnotherDispetcher','anotherPassword2','Ivanov6', 'Ivan6',1);
insert into users values (5, 1,'Guest','Guest','Ivanov7','Ivan7',2);


CREATE TABLE `voyage` (
  `idvoyage` int(11) NOT NULL  unique auto_increment,
  `idairport` int(11) NOT NULL,
  `idteam` int(11) NOT NULL,
  `place_of_sending` varchar(45) NOT NULL,
  `place_of_arriving` varchar(45) NOT NULL,
  `time_of_arriving` datetime NOT NULL,
  `time_of_sending` datetime NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`idvoyage`),
  KEY `team_fk_idx` (`idteam`),
  CONSTRAINT `team_fk` FOREIGN KEY (`idteam`) REFERENCES `team` (`idteam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into voyage values(0,1,1,'Kiev','Praga','2020-06-18 10:34:09','2020-06-18 10:35:09',1);
insert into voyage values(1,1,2,'Kiev','Varshava','2020-06-18 10:14:09','2020-06-18 10:15:09',1);
insert into voyage values(2,2,1,'Kharkov','Paris','2020-06-18 10:24:09','2020-06-18 10:25:09',1);


CREATE TABLE `navigator` (
  `idnavigator` int(11) NOT NULL unique auto_increment,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`idnavigator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into navigator values(0,'Ivanov8','Ivan8',45);
insert into navigator values(1,'Ivanov9','Ivan9',41);
insert into navigator values(2,'Ivanov10','Ivan10',49);






