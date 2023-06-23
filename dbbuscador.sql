CREATE DATABASE dbbuscador;

USE dbbuscador;

CREATE TABLE GENEROS(ID INT(10) NOT NULL auto_increment,
					GENERO VARCHAR(60) NOT NULL,
                    PRIMARY KEY (ID)
					);
                    
CREATE TABLE PELICULAS (ID INT(10) NOT NULL AUTO_INCREMENT, 
						NOMBRE_PELICULA VARCHAR(50), 
						SINOPSIS VARCHAR(600), 
						FECHA_LANZAMIENTO DATE, 
                        POSTER VARCHAR(50),
                        TRAILER VARCHAR(50),
                        DIRECTOR VARCHAR(50),
						DURACION INT(5),
						PRIMARY KEY (ID));    
                        
CREATE TABLE GENERO_PELICULA(
							ID_PELICULA INT(10) NOT NULL,
							IDGENERO INT(10) NOT NULL,
							FOREIGN KEY (ID_PELICULA) REFERENCES PELICULAS(ID) ON DELETE CASCADE,
                            FOREIGN KEY (IDGENERO) REFERENCES GENEROS(ID)
                            
);


INSERT INTO GENEROS VALUES (1,'ACCION');
INSERT INTO GENEROS VALUES (2,'COMEDIA');
INSERT INTO GENEROS VALUES (3,'ROMANCE');
INSERT INTO GENEROS VALUES (4,'INTRIGA');
INSERT INTO GENEROS VALUES (5,'SUPER HEROES');

INSERT INTO peliculas VALUES (1, 'Star Wars', 'La nave en la que viaja la princesa Leia es capturada por las tropas imperiales al mando del temible Darth Vader. Antes de ser atrapada, Leia consigue introducir un mensaje en su robot R2-D2, quien acompañado de su inseparable C-3PO logran escapar. Tras aterrizar en el planeta Tattooine son capturados y vendidos al joven Luke Skywalker, quien descubrirá el mensaje oculto que va destinado a Obi Wan Kenobi, maestro Jedi a quien Luke debe encontrar para salvar a la princesa.',
'1977-12-25', 'Imagen.jpg','http://youtube.starwars.com','George Lucas',140);
INSERT INTO peliculas VALUES (2, 'Spider-Man', 'Luego de sufrir la picadura de una araña genéticamente modificada, un estudiante de secundaria tímido y torpe adquiere increíbles capacidades como arácnido. Pronto comprenderá que su misión es utilizarlas para luchar contra el mal y defender a sus vecinos.',
'2002-03-31', 'Imagen2.jpg','http://youtube.spiderman.com','stiven spilber',150);
INSERT INTO peliculas VALUES (3, 'Batman', 'En su segundo año luchando contra el crimen, Batman explora la corrupción existente en la ciudad de Gotham y el vínculo de esta con su propia familia. Además, entrará en conflicto con un asesino en serie conocido como "el Acertijo".',
'2022-03-04', 'Imagen3.jpg','http://youtube.batman.com','gregorio Lucas',140);
INSERT INTO peliculas VALUES (4, 'algo mas', 'En su segundo año luchando contra el crimen, Batman explora la corrupción existente en la ciudad de Gotham y el vínculo de esta con su propia familia. Además, entrará en conflicto con un asesino en serie conocido como "el Acertijo".',
'2022-03-04', 'Imagen3.jpg','http://youtube.batman.com','gregorio Lucas',140);
INSERT INTO peliculas VALUES (5, 'ella', 'En su segundo año luchando contra el crimen, Batman explora la corrupción existente en la ciudad de Gotham y el vínculo de esta con su propia familia. Además, entrará en conflicto con un asesino en serie conocido como "el Acertijo".',
'2022-03-04', 'Imagen3.jpg','http://youtube.batman.com','gregorio Lucas',140);
INSERT INTO peliculas VALUES (6, 'antman', 'En su segundo año luchando contra el crimen, Batman explora la corrupción existente en la ciudad de Gotham y el vínculo de esta con su propia familia. Además, entrará en conflicto con un asesino en serie conocido como "el Acertijo".',
'2022-03-04', 'Imagen3.jpg','http://youtube.batman.com','gregorio Lucas',140);

INSERT INTO GENERO_PELICULA VALUES ( 1, 1);
INSERT INTO GENERO_PELICULA VALUES ( 1, 2);
INSERT INTO GENERO_PELICULA VALUES ( 2, 3);
INSERT INTO GENERO_PELICULA VALUES ( 3, 4);
INSERT INTO GENERO_PELICULA VALUES ( 4, 5);
INSERT INTO GENERO_PELICULA VALUES ( 4, 1);
INSERT INTO GENERO_PELICULA VALUES ( 5, 5);
INSERT INTO GENERO_PELICULA VALUES ( 6, 5);

##drop table GENERO_PELICULA;
#drop table peliculas;
#drop table GENEROS;

