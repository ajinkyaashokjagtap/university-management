DROP SEQUENCE IF EXISTS hibernate_sequence;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Department;
DROP Table IF EXISTS Professor;
DROP Table IF EXISTS Schedule;

CREATE SEQUENCE hibernate_sequence
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

CREATE TABLE Course
(
	id integer NOT NULL,
  	name character varying(255),
  	departmentid integer,
  	credits integer,
  	CONSTRAINT Course_pkey PRIMARY KEY (id),
    CONSTRAINT FK_DepartmentIdInCourse FOREIGN KEY (departmentid)
        REFERENCES Department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE Department
(
	id integer NOT NULL,
	name character varying(255),
	CONSTRAINT Department_pkey PRIMARY KEY (id)
);

CREATE TABLE Professor
(
    id integer NOT NULL,
	name character varying(255),
    departmentid integer,
    CONSTRAINT Professor_pkey PRIMARY KEY (id),
    CONSTRAINT FK_DepartmentIdInProfessor FOREIGN KEY (departmentid)
        REFERENCES Department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
	
CREATE TABLE Schedule
(
    id integer NOT NULL,
    professorid integer,
    courseid integer,
    semester integer,
    year integer,
    CONSTRAINT Schedule_pkey PRIMARY KEY (id),
    CONSTRAINT FK_ProfessorIdInSchedule FOREIGN KEY (professorid)
        REFERENCES Professor (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT FK_CourseIdInSchedule FOREIGN KEY (courseid)
        REFERENCES Course (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);