CREATE SEQUENCE IF NOT EXISTS idUser;
CREATE SEQUENCE IF NOT EXISTS idSchedule;
CREATE SEQUENCE IF NOT EXISTS idSubject;
CREATE SEQUENCE IF NOT EXISTS idDate;

CREATE TABLE IF NOT EXISTS Users(
    idUser INT NOT NULL DEFAULT nextval('idUser'),
    username VARCHAR(50) NOT NULL UNIQUE,
    passw VARCHAR(30) NOT NULL,
    nameUser VARCHAR(30) NOT NULL,
    programa VARCHAR(20),
    tipo VARCHAR(15) NOT NULL,
    PRIMARY KEY (idUser))
;

CREATE TABLE IF NOT EXISTS Schedules(
    idSchedule INT NOT NULL DEFAULT nextval('idSchedule'),
    creationDate TIMESTAMP NOT NULL,
    PRIMARY KEY (idSchedule))
;

CREATE TABLE IF NOT EXISTS Subjects(
    idSubject INT NOT NULL DEFAULT nextval('idSubject'),
    memoSub VARCHAR(10) NOT NULL,
    nameSub VARCHAR(20) NOT NULL,
    groupSub INT NOT NULL,
    professor VARCHAR(30) NOT NULL,
    PRIMARY KEY (idSubject))
;

CREATE TABLE IF NOT EXISTS DatesSubject(
    idDate INT NOT NULL DEFAULT nextval('idDate'),
    startTime TIMESTAMP NOT NULL,
    endTime TIMESTAMP NOT NULL,
    dia INT NOT NULL,
    idSubject INT NOT NULL,
    PRIMARY KEY (idDate),
    FOREIGN KEY(idSubject) REFERENCES Subjects(idSubject))
;

CREATE TABLE IF NOT EXISTS ScheduleXSubject(
    idSchedule INT NOT NULL,
    idSubject INT NOT NULL,
    PRIMARY KEY (idSchedule,idSubject),
    FOREIGN KEY(idSchedule) REFERENCES Schedules(idSchedule),
    FOREIGN KEY(idSubject) REFERENCES Subjects(idSubject))
;

CREATE TABLE IF NOT EXISTS UserXSchedule(
    idUser INT NOT NULL,
    idSchedule INT NOT NULL,
    PRIMARY KEY (idUser,idSchedule),
    FOREIGN KEY(idUser) REFERENCES Users(idUser),
    FOREIGN KEY(idSchedule) REFERENCES Schedules(idSchedule))
;