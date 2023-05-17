drop database if exists wonder;
create database Wonder;
use wonder;

CREATE TABLE usuario (
    nomUsu VARCHAR(20) PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    contraseina VARCHAR(20) NOT NULL
);

CREATE TABLE quiere (
    nomUsuCli1 VARCHAR(20),
    nomUsuCli2 VARCHAR(20),
    like1 BOOLEAN,
    like2 BOOLEAN,
    PRIMARY KEY (nomUsuCli1 , nomUsuCli2)
);

CREATE TABLE cliente (
    nomUsuCli VARCHAR(20) PRIMARY KEY,
    genero VARCHAR(10) not null,
    fechaNac date,
   constraint fk_cliente FOREIGN KEY (nomUsuCli)
        REFERENCES usuario (nomUsu)
        on delete cascade on update cascade
);

CREATE TABLE relacion (
    codRela int PRIMARY KEY auto_increment,
    orienSex VARCHAR(20) NOT NULL,
    zodiaco VARCHAR(20),
    gustos VARCHAR(20) NOT NULL,
    queBuscas VARCHAR(20) NOT NULL,
    descrip VARCHAR(100),
    nomUsuCli VARCHAR(20),
   constraint fk_relacion FOREIGN KEY (nomUsuCli)
        REFERENCES cliente (nomUsuCli)
         on delete cascade on update cascade
);

CREATE TABLE administrador (
    nomUsuAd VARCHAR(20) PRIMARY KEY,
    salario float not null,
   constraint fk_admin FOREIGN KEY (nomUsuAd)
        REFERENCES usuario (nomUsu)
         on delete cascade on update cascade
);

CREATE TABLE ubicacion (
    codUbicacion INT PRIMARY KEY auto_increment,
    pais VARCHAR(20),
    ciudad VARCHAR(20),
    codPostal INT(5),
    nomUsuCli varchar(20),
    constraint fk_ubicacion foreign key (nomUsuCli)
    references cliente (nomUsuCli)
);

CREATE TABLE actividad (
    codactividad INT PRIMARY KEY auto_increment,
    nomActividad VARCHAR(20) not null,
    fecha varchar(20) not null,
    descripcion VARCHAR(50) not null,
    nomUsuCli varchar(29),
    constraint fk_actividad foreign key (nomUsuCli)
    references cliente (nomUsuCli)
);

CREATE TABLE inscribir (
    nomUsuCli VARCHAR(20),
    codactividad INT,
    PRIMARY KEY (codactividad , nomUsuCli),
   constraint fk_inscribir FOREIGN KEY (nomUsuCli)
        REFERENCES cliente (nomUsuCli),
    constraint fk_inscribir2 FOREIGN KEY (codactividad)
        REFERENCES actividad (codactividad)
         on delete cascade on update cascade
    
);

CREATE TABLE confirmar (
    nomUsuAd VARCHAR(50),
    nomUsuCli VARCHAR(50),
    PRIMARY KEY (nomUsuAd , nomUsuCli),
   constraint fk_gestion FOREIGN KEY (nomUsuCli)
        REFERENCES cliente (nomUsuCli),
   constraint fk_gestion2 FOREIGN KEY (nomUsuAd)
        REFERENCES administrador (nomUsuAd)
         on delete cascade on update cascade
);


insert into usuario values("alvaro","alvaro@wonder.com","wonder"),
("june","june@wonder.com","wonder"),
("odei","odei@wonder.com","wonder"),
("markel","markel@wonder.com","wonder"),
("naia","naia@gmail.com","1234"),
("paco","paco@gmail.com","paco12"),
("adrian","adrian@gmail.com","123"),
("ander","ander@gmail.com","123");
insert into administrador values("alvaro", 1400),
("june", 1500),
("odei", 1400),
("markel", 1500);
insert into cliente values
("adrian","hombre","2012/10/10"),
("ander","hombre","2012/10/10"),
("naia","mujer","2012/12/12"),
("paco","hombre","2012/12/12");
insert into relacion values
("4", "Heterosexual", "", "Musica", "Amistad", "Algo", "ander"),
("3", "Heterosexual", "", "Musica", "Amistad", "Algo", "adrian"),
("1", "Heterosexual", "Aries", "Natacion", "Amistad", "Algo", "naia"),
("2", "Homosexual", "", "Musica", "Relacion","Algo", "paco");


select * from actividad;
select * from cliente;
select nomActividad, fecha, descripcion from actividad;
/*Crear una funcion en la que cojamos el nombre de usuario de la base de datos y lo comparemos con el que esta intentando registrar*/
select * from cliente;
select * from relacion;
select * from cliente where nomUsuCli="paco";

select * from usuario u join cliente c on c.nomUsuCli=u.nomUsu