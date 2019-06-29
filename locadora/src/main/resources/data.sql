INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');
INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO `locadora_db`.`movies`(`director_name`,`number_of_copies_available`,`number_of_copies_max`,`title`)
VALUES('George Lucas',5,5,'Star Wars: Episode IV');

INSERT INTO `locadora_db`.`movies`(`director_name`,`number_of_copies_available`,`number_of_copies_max`,`title`)
VALUES('Irvin Kershner',3,3,'The Empire Strikes Back: Episode V');

INSERT INTO `locadora_db`.`movies`(`director_name`,`number_of_copies_available`,`number_of_copies_max`,`title`)
VALUES('Richard Marquand',7,7,'Return of the Jedi : Episode VI');