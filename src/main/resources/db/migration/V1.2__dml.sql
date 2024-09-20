-- Insertion des données dans la table classements
INSERT INTO classements (nom) VALUES
('NC'),
('40'),
('30/5'),
('30/4'),
('30/3'),
('30/2'),
('30/1'),
('15/5'),
('15/4'),
('15/3');

-- Insertion des données dans la table typesSurface
INSERT INTO typesSurface (nom) VALUES
('Terre battue'),
('Gazon'),
('Dur'),
('Synthétique');

-- Insertion des données dans la table typesTournoi
INSERT INTO typesTournoi (nom) VALUES
('Open'),
('Championnat'),
('Invité'),
('Amical');

-- Insertion des données dans la table categories
INSERT INTO categories (nom) VALUES
('Junior'),
('Senior'),
('Senior Plus'),
('Femmes');

-- Insertion des données dans la table divisions
INSERT INTO divisions (nom) VALUES
('D3'),
('D2'),
('D1'),
('Pré région'),
('R3'),
('R2'),
('R1'),
('N3'),
('N2'),
('N1');

-- Insertion des données dans la table clubs
INSERT INTO clubs (nom, adresse, ville, codePostal, pays) VALUES
('Club A', '123 Avenue des Sports', 'VilleA', '75001', 'France'),
('Club B', '456 Boulevard des Champions', 'VilleB', '69002', 'France'),
('Club C', '789 Rue des Joueurs', 'VilleC', '33003', 'France');

-- Insertion des données dans la table joueurs
INSERT INTO joueurs (prenom, nom, dateNaissance, nationalite, genre, clubId) VALUES
('Jean', 'Dupont', '1990-05-15', 'Française', 'H', 1),
('Marie', 'Dubois', '1988-07-22', 'Française', 'F', 2),
('Pierre', 'Martin', '1995-11-30', 'Française', 'H', 3),
('Sophie', 'Durand', '1992-04-20', 'Française', 'F', 1),
('Paul', 'Moreau', '1987-09-10', 'Française', 'H', 2);

-- Insertion des données dans la table classementsJoueurs
INSERT INTO classementsJoueurs (joueurId, classementId, date) VALUES
(1, 2, '2024-01-01'),
(2, 4, '2024-01-01'),
(3, 5, '2024-01-01'),
(4, 3, '2024-01-01'),
(5, 6, '2024-01-01');

-- Insertion des données dans la table tournois
INSERT INTO tournois (nom, clubId, dateDebut, dateFin, typeSurfaceId, typeTournoiId, montantInscription, montantPrix) VALUES
('Tournoi jovial', 1, '2024-06-01', '2024-06-07', 1, 1, 5000.00, 18.00),
('Championnat de Noël', 2, '2024-12-01', '2024-12-05', 3, 2, 3000.00, 20.00),
('Open de Printemps', 3, '2024-03-01', '2024-03-10', 2, 3, 2000.00, 25.00);

-- Insertion des données dans la table equipes
INSERT INTO equipes (nom, clubId, categorieId, divisionId) VALUES
('Equipe A', 1, 2, 5),
('Equipe B', 1, 3, 6),
('Equipe C', 2, 1, 4),
('Equipe D', 3, 4, 7),
('Equipe E', 2, 2, 8);

-- Insertion des données dans la table championnats
INSERT INTO championnats (nom, annee, categorieId, divisionId) VALUES
('Championnat Régional', 2024, 2, 5),
('Championnat National', 2024, 3, 8);

-- Insertion des données dans la table poules
INSERT INTO poules (nom, championnatId) VALUES
('Poule A', 1),
('Poule B', 1),
('Poule C', 2);

-- Insertion des données dans la table rencontres
INSERT INTO rencontres (pouleId, equipe1Id, equipe2Id, date, score, gagnantId) VALUES
(1, 1, 2, '2024-06-01', '4-1', 1),
(1, 3, 4, '2024-06-02', '3-2', 3),
(2, 5, 1, '2024-06-03', '2-2', NULL);

-- Insertion des données dans la table matchs
INSERT INTO matchs (joueur1Id, joueur2Id, score, gagnantId, rencontreId, tournoiId) VALUES
(1, 2, '6-3, 4-6, 7-6', 1, 1, NULL),
(3, 4, '6-4, 6-3', 3, 2, NULL),
(1, 3, '6-2, 6-4', 1, NULL, 1);

-- Insertion des données dans la table rencontresMatchs
INSERT INTO rencontresMatchs (rencontreId, matchId) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Insertion des données dans la table equipeJoueurs
INSERT INTO equipeJoueurs (joueurId, equipeId) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(5, 4);

-- Insertion des données dans la table championnatEquipes
INSERT INTO championnatEquipes (championnatId, equipeId) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4);

-- Insertion des données dans la table equipesPoule
INSERT INTO equipesPoule (equipeId, pouleId) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3);