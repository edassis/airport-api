-- country table
INSERT INTO `country` VALUES (1,'','Brazil');

-- state table
INSERT INTO `state` VALUES (1,NULL,'DF',1);
INSERT INTO `state` VALUES (2,NULL,'SP',1);

-- category table
INSERT INTO `category` VALUES (1,NULL,'Basic');
INSERT INTO `category` VALUES (2,NULL,'Executive');

-- client
INSERT INTO mydb.client (addressComplement,name,street,telefone,category_id,state_id) VALUES ('','Paulo','Guará¡','12345678',1,1);
INSERT INTO mydb.client (addressComplement,name,street,telefone,category_id,state_id) VALUES ('','Eduardo','Sobradinho¡','987654321',1,1);

-- airport
INSERT INTO mydb.airport (description,name,street,state_id) VALUES ('Aeroporto Internacional de Brasília','Aeroporto Presidente Juscelino Kubitschek','Lago Sul',1);
INSERT INTO mydb.airport (description,name,street,state_id) VALUES ('Aeroporto Internacional de São Paulo','Aeroporto de Guarulhos','Guarulhos',2);

-- flight
INSERT INTO mydb.flight (name,destiny_id,origin_id) VALUES ('Passagem de BSB para SP',2,1);