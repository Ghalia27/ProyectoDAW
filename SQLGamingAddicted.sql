-- Script GamingAddict
DROP DATABASE IF EXISTS gamingaddicted;
-- creamos la bd
CREATE DATABASE gamingaddicted;
-- activamos la bd
USE gamingaddicted;

create table perfiles(
	idperfil int auto_increment,
    nombre varchar(25),
    primary key (idperfil)
);

create table generos(
	idgenero int auto_increment,
    nombre varchar(25),
    primary key (idgenero)
);

create table plataformas(
	idplataforma int auto_increment,
    nombre varchar(100),
    descripcion varchar(100),
    primary key (idplataforma)
);

create table clasificaciones(
	idclasificacion int auto_increment,
    nombre varchar(50),
    descripcion varchar(100),
    primary key (idclasificacion)
);

create table ediciones(
	idediciones int auto_increment,
    nombre varchar(50),
    descripcion varchar(100),
    primary key (idediciones)
);

create table genero_juego(
	idgenerojuego int auto_increment,
    nombre varchar(50),
    descripcion varchar(100),
    primary key (idgenerojuego)
);

create table estado(
	idestado int auto_increment,
    nombre varchar(25),
    primary key(idestado)
);

create table usuarios(
	idusuario int auto_increment,
    nombres varchar(25),
    apellidos varchar(50),
    edad int,
    direccion varchar(100),
    email varchar(100),
    contrasenia varchar(25),
    estado varchar(2),
    idperfil int,
    idgenero int,
    dni int,
    nro_cuenta int,
    primary key (idusuario),
    constraint fk_perfil foreign key (idperfil) references perfiles(idperfil),
    constraint fk_genero foreign key (idgenero) references generos(idgenero)
);

create table juegos(
	idjuego int auto_increment,
    idgenerojuego int,
    idplataforma int,
    idclasificacion int,
    idedicion int,
    titulo varchar(100),
    descripcion varchar(100),
    fecha_publicacion date,
    stock int,
    precio double,
    idestado int,
    primary key (idjuego),
    constraint fk_generojuego foreign key (idgenerojuego) references genero_juego(idgenerojuego),
    constraint fk_plataforma foreign key (idplataforma) references plataformas(idplataforma),
    constraint fk_clasificaciones foreign key (idclasificacion) references clasificaciones(idclasificacion),
    constraint fk_edicion foreign key (idedicion) references ediciones(idediciones),
    constraint fk_estado foreign key (idestado) references estado(idestado)
);

create table vtacabecera(
	idvta int auto_increment,
    idusuario int,
    fecha_venta date,
    total_venta decimal(20,2),
	primary key (idvta),
	constraint fk_usuario foreign key (idusuario) references usuarios(idusuario)
);
drop table vtadetalle;
create table vtadetalle(
	idvta int not null,
    idjuego int,
    cantidad int,
    precio_unitario decimal(20,2),
    monto decimal(20,2),
	primary key (idvta,idjuego),
    constraint fk_juego foreign key (idjuego) references juegos(idjuego),
	constraint fk_vta foreign key (idvta) references vtacabecera(idvta)
);

-- inserts
insert into perfiles values (null, 'administrativo');
insert into perfiles values (null, 'cliente');

insert into generos values(null, 'Masculino');
insert into generos values(null, 'Femenino');
insert into generos values(null, 'Otro');

insert into plataformas values(null, 'PlayStation', 'PS4');
insert into plataformas values(null, 'XboX', 'Xbox One');
insert into plataformas values(null, 'Nintendo', 'Switch');
insert into plataformas values(null, 'PC', 'PC');

insert into clasificaciones values(null,'EC', 'Para niño entre 3 y 5 años');
insert into clasificaciones values(null,'E', 'Todo público');
insert into clasificaciones values(null,'E 10+', 'Mayores de 10 años');
insert into clasificaciones values(null,'T', 'Para jovenes de 13 años en adelante');
insert into clasificaciones values(null,'M', 'Para mayores de 17 años');
insert into clasificaciones values(null,'AO', 'Solo para adultos. +18');

insert into ediciones values(null,'1ra', 'Primera edición');
insert into ediciones values(null,'2da', 'Segunda edición');
insert into ediciones values(null,'3ra', 'Tercera edición');
insert into ediciones values(null,'4ta', 'Cuarta edición');
insert into ediciones values(null,'5ta', 'Quinta edición');

insert into genero_juego values(null,'FPS', 'Disparadores en primera persona');
insert into genero_juego values(null,'RTS', 'Estrategia en tiempo real');
insert into genero_juego values(null,'MOBA', 'Campo de batalla mutijugador online');
insert into genero_juego values(null,'RPG', 'Jueg de Rol');
insert into genero_juego values(null,'MMO', 'Multijuador masivo');
insert into genero_juego values(null,'Battle Royale', 'Battle Royale');
insert into genero_juego values(null,'Deportes', 'Deportes');
insert into genero_juego values(null,'Acción', 'Acción');
insert into genero_juego values(null,'Aventura', 'Aventura');
insert into genero_juego values(null,'Plataformas', 'Plataformas');
insert into genero_juego values(null,'Conduccion', 'Conduccion');
insert into genero_juego values(null,'Combate', 'Combate');

insert into estado values(null,'Disponible');
insert into estado values(null,'Agotado');

insert into usuarios values(null,'Admin', 'Admin',20,'Direccion 1','admin@gmail.com','admin','AC',1,1,74185296,789945622);
insert into usuarios values(null,'Pepe', 'Salazar',19,'Direccion 2','pepesalazar@gmail.com','15EE%GE85','AC',2,1,78945612,78994622);

insert into juegos values(null,6,4,2,4,'Fortnite','Descripcion juego 1','2020-05-02',50,40.00,1);
insert into juegos values(null,4,3,1,3,'Call of duty','Descripcion juego 2','2019-05-21',25,25.50,1);
insert into juegos values(null,5,1,2,2,'Plantas vs Zombies','Descripcion juego 3','2018-12-20',20,15.20,1);
insert into juegos values(null,6,4,3,1,'Carreritas','Descripcion juego 4','2019-09-25',40,17.00,1);

insert into vtacabecera values(null,2,'2021-05-15',65.50);

insert into vtadetalle values(1,1,1,40.00,40.00);
insert into vtadetalle values(1,2,1,25.50,25.50);

select * from usuarios;
select * from juegos;
select * from vtacabecera;
select * from vtadetalle;
