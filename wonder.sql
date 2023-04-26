drop database if exists wonder;
create database Wonder;
use wonder;

CREATE TABLE usuario (
    nomUsu VARCHAR(20) PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    contraseina VARCHAR(20) NOT NULL
);



CREATE TABLE cliente (
    nomUsuCli VARCHAR(20) PRIMARY KEY,
    genero VARCHAR(10),
    edad INT,
    FOREIGN KEY (nomUsuCli)
        REFERENCES usuario (nomUsu)
    
);
CREATE TABLE relacion (
    codRela VARCHAR(20) PRIMARY KEY,
    orienSex VARCHAR(20) NOT NULL,
    zodiaco VARCHAR(20),
    gustos VARCHAR(20) NOT NULL,
    queBuscas VARCHAR(20) NOT NULL,
    descrip VARCHAR(100),
    nomUsuCli VARCHAR(20),
    FOREIGN KEY (nomUsuCli)
        REFERENCES cliente (nomUsuCli)
);

CREATE TABLE administrador (
    nomUsuAd VARCHAR(20) PRIMARY KEY,
    salario float,
    FOREIGN KEY (nomUsuAd)
        REFERENCES usuario (nomUsu)
);

CREATE TABLE ubicacion (
    codUbicacion INT PRIMARY KEY,
    pais VARCHAR(20),
    ciudad VARCHAR(20),
    codPostal INT(5)
);

CREATE TABLE vive (
    codubicacion INT,
    nomUsu VARCHAR(20),
    PRIMARY KEY (codUbicacion , nomUsu),
    FOREIGN KEY (nomUsu)
        REFERENCES usuario (nomUsu),
    FOREIGN KEY (codUbicacion)
        REFERENCES ubicacion (codUbicacion)
);

CREATE TABLE actividad (
    codactividad INT PRIMARY KEY,
    nomActividad VARCHAR(20),
    descripcion VARCHAR(50),
    fecha DATE,
    nomUsuCli VARCHAR(20)
);

CREATE TABLE crear (
    nomUsuCli VARCHAR(20),
    codactividad INT,
    PRIMARY KEY (codactividad , nomUsuCli),
    FOREIGN KEY (nomUsuCli)
        REFERENCES cliente (nomUsuCli),
    FOREIGN KEY (codactividad)
        REFERENCES actividad (codactividad)
    
);

CREATE TABLE inscribir (
    nomUsuCli VARCHAR(20),
    codactividad INT,
    PRIMARY KEY (codactividad , nomUsuCli),
    FOREIGN KEY (nomUsuCli)
        REFERENCES cliente (nomUsuCli),
    FOREIGN KEY (codactividad)
        REFERENCES actividad (codactividad)
    
);




CREATE TABLE gestion (
    nomUsuAd VARCHAR(50),
    nomUsuCli VARCHAR(50),
    PRIMARY KEY (nomUsuAd , nomUsuCli),
    FOREIGN KEY (nomUsuCli)
        REFERENCES cliente (nomUsuCli),
    FOREIGN KEY (nomUsuAd)
        REFERENCES administrador (nomUsuAd)
);

insert into usuario values("alvaro","alvaro@wonder.com","wonder"),
("june","june@wonder.com","wonder"),
("odei","odei@wonder.com","wonder"),
("markel","markel@wonder.com","wonder"),
("gentzane","gentzane@wonder.com","wonder"),
("raquel","raquel@wonder.com","wonder"),
("naia","naia@gmail.com","1234"),
("paco","paco@gmail.com","paco12");
insert into administrador values("alvaro", 1400),
("june", 1500),
("odei", 1400),
("markel", 1500),
("gentzane",1100),
("raquel",1000);
insert into cliente values("naia","mujer","28"),
("paco","hombre","50");
insert into relacion values("01", "hgvf","bd","jfg", "wsdvfds","efawe","naia"),
("02", "hgfgedrtertevf","hhhh","fhhhhhh", "fffff","fgdg","paco");
select * from cliente;
select * from relacion;
select * from usuario;

