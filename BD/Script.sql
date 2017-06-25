/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     25/6/2017 16:56:31                           */
/*==============================================================*/
CREATE TABLE ALUMNO
(
   COD_ALUMNO           VARCHAR(10) NOT NULL COMMENT 'Clave primaria que corresponde al codigo del estudiante.',
   NOMBRE               VARCHAR(150) NOT NULL COMMENT 'Nombres y apellidos del estudiante.',
   DIRECCION            VARCHAR(200) NOT NULL COMMENT 'Direccion del estudiante.',
   TELEFONO             VARCHAR(15) NOT NULL COMMENT 'Numero de telefono del estudiante.',
   CORREO_ELECTRONICO   VARCHAR(128) NOT NULL COMMENT 'Correo electronico del estudiante.',
   FECHA_NACIMIENTO     DATE NOT NULL COMMENT 'Fecha de nacimiento del estudiante.',
   GENERO               VARCHAR(1) NOT NULL COMMENT 'Genero del alumno.',
   PRIMARY KEY (COD_ALUMNO)
);

ALTER TABLE ALUMNO COMMENT 'Entidad que almacena la informacion de los alumnos';

CREATE TABLE CAPACITACION
(
   COD_CAPACITACION     INT NOT NULL AUTO_INCREMENT COMMENT 'Codigo de identificacion asignado automaticamente.',
   COD_CURSO            VARCHAR(8) NOT NULL COMMENT 'Codigo heredado del curso que se esta impartiendo.',
   COD_DOCENTE          VARCHAR(10) COMMENT 'Clave forenea que corresponde a la cedula de identidad del docente encargado.',
   FECHA_INICIO         DATE NOT NULL COMMENT 'Fecha de inicio de la capacitacion.',
   FECHA_FIN            DATE NOT NULL COMMENT 'Fecha de inicio de la finalizacion de la capacitacion.',
   ESTADO               VARCHAR(3) NOT NULL DEFAULT 'DEF' COMMENT 'Informacion del estado en el que se encuentra la capacitacion',
   CAPACIDAD            NUMERIC(2) NOT NULL COMMENT 'Informacion de la maxima cantidad de personas que pueden inscribire en la capacitacion.',
   PRIMARY KEY (COD_CAPACITACION)
);


CREATE TABLE CAPACITACION_ALUMNO
(
   COD_CAPACITACION     INT NOT NULL COMMENT 'Codigo de la capacitacion que esta tomando el alumno.',
   COD_ALUMNO           VARCHAR(10) NOT NULL COMMENT 'Codigo del alumno que esta tomando la capacitacion.',
   NOTA_FINAL           NUMERIC(4,2) NOT NULL COMMENT 'Nota final del alumno para el final de cada capacitacio. Calificacion sobre 10.',
   ESTADO               VARCHAR(3) NOT NULL DEFAULT 'INS' COMMENT 'Estado que nos dara la informacion del alumno que mostrara si esta activo en el instituto tomando sus respectivas capacitaciones o caso contrario no esta tomando ninguna capacitacion.',
   PRIMARY KEY (COD_CAPACITACION, COD_ALUMNO)
);

ALTER TABLE CAPACITACION_ALUMNO COMMENT 'Entidad que tendra informacion relacionada a que capacitacio';


CREATE TABLE CURSO
(
   COD_CURSO            VARCHAR(8) NOT NULL COMMENT 'Clave primaria que corresponde al codigo del curso.',
   NOMBRE               VARCHAR(100) NOT NULL COMMENT 'Nombre del curso.',
   OBJETIVO             VARCHAR(4000) COMMENT 'Objetivo del curso.',
   DESCRIPCION          VARCHAR(4000) COMMENT 'Descripcion de lo que va a tratar el curso.',
   DURACION             NUMERIC(3) NOT NULL COMMENT 'duracion del curso en horas.',
   ESTADO               VARCHAR(3) NOT NULL DEFAULT 'ACT' COMMENT 'Estado activo o inactivo del curso.',
   PRIMARY KEY (COD_CURSO)
);

ALTER TABLE CURSO COMMENT 'Entidad que registra informacion referente a cada curso que ';


CREATE TABLE DOCENTE
(
   COD_DOCENTE          VARCHAR(10) NOT NULL COMMENT 'Clave primaria que corresponde a la cedula de identidad del docente.',
   NOMBRE               VARCHAR(150) NOT NULL COMMENT 'Clave primaria que corresponde a la cedula de identidad del docente.',
   DIRECCION            VARCHAR(200) NOT NULL COMMENT 'Direccion de domicilio del docente.',
   TELEFONO             VARCHAR(15) NOT NULL COMMENT 'Numero celular del docente.',
   CORREO_ELECTRONICO   VARCHAR(128) NOT NULL COMMENT 'Direcciin de correo electronico del docente.',
   PRIMARY KEY (COD_DOCENTE)
);

ALTER TABLE DOCENTE COMMENT 'Entidad que almacena la informacion de los docentes';


CREATE TABLE PROGRAMA
(
   COD_PROGRAMA         VARCHAR(8) NOT NULL COMMENT 'Codigo identificador de la entidad Programa, el cual es generado
            automaticamente',
   NOMBRE               VARCHAR(100) NOT NULL COMMENT 'Nombre del programa',
   DESCRIPCION          VARCHAR(4000) COMMENT 'Breve descripcion acerca de lo que va a tratar el programa',
   DURACION             NUMERIC(4) NOT NULL COMMENT 'Duracion en tiempo estimado de cada programa',
   FECHA_INICIO         DATE COMMENT 'Fecha de inicio del programa.',
   FECHA_FIN            DATE COMMENT 'Fecha de la finalizacion del programa.',
   PRIMARY KEY (COD_PROGRAMA)
);

ALTER TABLE PROGRAMA COMMENT 'Entidad que define un programa en el isntituto. Un programa ';


CREATE TABLE PROGRAMA_ALUMNO
(
   COD_PROGRAMA         VARCHAR(8) NOT NULL COMMENT 'Codigo del programa que esta tomando el alumno.',
   COD_ALUMNO           VARCHAR(10) NOT NULL COMMENT 'Codigo unico del alumno que le sirve de identificacion.',
   ESTADO               VARCHAR(3) NOT NULL COMMENT 'Estado que nos dara la informacion del alumno que mostrara si esta activo en el instituto tomando sus respectivos cursos o caso contrario no esta tomando ningun curso.',
   PRIMARY KEY (COD_PROGRAMA, COD_ALUMNO)
);

ALTER TABLE PROGRAMA_ALUMNO COMMENT 'Entidad que tendra informacion relacionada a que programas';


CREATE TABLE PROGRAMA_CURSO
(
   COD_PROGRAMA         VARCHAR(8) NOT NULL COMMENT 'Codigo unico de cada programa que se impartira.',
   COD_CURSO            VARCHAR(8) NOT NULL COMMENT 'Codigo unico de cada curso que habra dentro de cada programa.',
   ORDEN                NUMERIC(2) NOT NULL COMMENT 'Identificacion de cada orden que tendra el programa con su respectivo curso. ',
   ESTADO               VARCHAR(3) NOT NULL DEFAULT 'ACT' COMMENT 'Marcara el estado respectivo del curso si se aun no iniciado, o se esta impartiendo o si ya se lo realizo y ha finalizado. ',
   PRIMARY KEY (COD_PROGRAMA, COD_CURSO)
);

ALTER TABLE PROGRAMA_CURSO COMMENT 'Entidad que almacena los cursos que pertenecen a un programa';

ALTER TABLE CAPACITACION ADD CONSTRAINT FK_CAPACITACION_A_CURSO FOREIGN KEY (COD_CURSO)
      REFERENCES CURSO (COD_CURSO) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE CAPACITACION ADD CONSTRAINT FK_CAPACITACION_A_DOCENTE FOREIGN KEY (COD_DOCENTE)
      REFERENCES DOCENTE (COD_DOCENTE) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE CAPACITACION_ALUMNO ADD CONSTRAINT FK_CAPACALUMNO_A_ALUMNO FOREIGN KEY (COD_ALUMNO)
      REFERENCES ALUMNO (COD_ALUMNO) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE CAPACITACION_ALUMNO ADD CONSTRAINT FK_CAPACALUMNO_A_CAPACITAC FOREIGN KEY (COD_CAPACITACION)
      REFERENCES CAPACITACION (COD_CAPACITACION) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PROGRAMA_ALUMNO ADD CONSTRAINT FK_PROGRAMALUMN_A_ALUMNO FOREIGN KEY (COD_ALUMNO)
      REFERENCES ALUMNO (COD_ALUMNO) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PROGRAMA_ALUMNO ADD CONSTRAINT FK_PROGRAMALUMN_A_PROGRAMA FOREIGN KEY (COD_PROGRAMA)
      REFERENCES PROGRAMA (COD_PROGRAMA) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PROGRAMA_CURSO ADD CONSTRAINT FK_PROGRAMCURSO_A_CURSO FOREIGN KEY (COD_CURSO)
      REFERENCES CURSO (COD_CURSO) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PROGRAMA_CURSO ADD CONSTRAINT FK_PROGRAMCUR_A_PROGRAMA FOREIGN KEY (COD_PROGRAMA)
      REFERENCES PROGRAMA (COD_PROGRAMA) ON DELETE RESTRICT ON UPDATE RESTRICT;
