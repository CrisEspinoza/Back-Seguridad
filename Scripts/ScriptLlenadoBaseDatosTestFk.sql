	INSERT INTO roles (id, name)
VALUES
	(1, 'ROLE_USER'),
	(2, 'ROLE_PM'),
	(3, 'ROLE_ADMIN');

INSERT INTO tipo_medicion (id, nombre, estado)
VALUES 	
	(1, 'PLIEGUES', true),
	(2, 'PERIMETROS', true),
	(3, 'DIAMETROS', true),
	(4, 'LONGITUDES', true);
	
INSERT INTO subtipo_medicion (id, tipo_medicion, nombre, estado)
VALUES
	(1, 1, 'Tríceps', true),
	(2, 1, 'Subescapular', true),
	(3, 1, 'Bíceps', true),
	(4, 1, 'Cresta Ilíaca', true),
	(5, 1, 'Supraespinal', true),
	(6, 1, 'Abdominal', true),
	(7, 1, 'Muslo Frontal', true),
	(8, 1, 'Pantorrilla', true),
	(9, 1, 'Pectoral', true),
	(10, 1, 'Axilar', true),
	(11, 2, 'Cabeza', true),
	(12, 2, 'Cuello', true),
	(13, 2, 'Brazo Relajado', true),
	(14, 2, 'Brazo Flex. Tensión', true),
	(15, 2, 'Antebrazo Máx.', true),
	(16, 2, 'Muñeca', true),
	(17, 2, 'Tórax (Mesoesternal)', true),
	(18, 2, 'Cintura (Mínimo)', true),
	(19, 2, 'Cadera (Máximo)', true),
	(20, 2, 'Muslo Medio', true),
	(21, 2, 'Pantorrilla', true),
	(22, 2, 'Tobillo', true),
	(23, 2, 'Muslo', true),
	(24, 3, 'Biacromial', true),
	(25, 3, 'Tórax Transverso', true),
	(26, 3, 'Tórax Anteropost.', true),
	(27, 3, 'Biiliocrestídeo', true),
	(28, 3, 'Humeral (Biepicond.)', true),
	(29, 3, 'Femoral (Biepicond.)', true),
	(30, 3, 'Muñeca (Biestiloidea)', true),
	(31, 3, 'Tobillo (Bimaleolar)', true),
	(32, 4, 'Acromial-Radial', true),
	(33, 4, 'Radial-Estiloidea', true),
	(34, 4, 'Med.-Estil.-Dactilar', true),
	(35, 4, 'Ilioespinal', true),
	(36, 4, 'Trocantérea', true),
	(37, 4, 'Trocantéra.-Tibial-Lateral', true),
	(38, 4, 'Tibial-Lateral', true),
	(39, 4, 'Tibial-Med.Maleolar-Med.', true),
	(40, 4, 'Pie', true);

INSERT INTO public.test
VALUES
	(1, 'Test Fraccionamiento Kineantropometrico (PFK)', NULL);


