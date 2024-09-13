-- Insertion des données dans la table classementsBase
INSERT INTO classements (id, nom) VALUES
(1, 'NC'),
(2, '40'),
(3, '30/5'),
(4, '30/4'),
(5, '30/3'),
(6, '30/2'),
(7, '30/1'),
(8, '15/5'),
(9, '15/4'),
(10, '15/3');

-- Insertion des données dans la table typesSurface
INSERT INTO typesSurface (id, nom) VALUES
(1, 'Terre battue'),
(2, 'Gazon'),
(3, 'Dur'),
(4, 'Synthétique');

-- Insertion des données dans la table typesTournoi
INSERT INTO typesTournoi (id, nom) VALUES
(1, 'Open'),
(2, 'Championnat'),
(3, 'Invité'),
(4, 'Amical');

-- Insertion des données dans la table categories
INSERT INTO categories (id, nom) VALUES
(1, 'Junior'),
(2, 'Senior'),
(3, 'Senior Plus'),
(4, 'Femmes');

-- Insertion des données dans la table divisions
INSERT INTO divisions (id, nom) VALUES
(1, 'D3'),
(2, 'D2'),
(3, 'D1'),
(4, 'Pré région'),
(5, 'R3'),
(6, 'R2'),
(7, 'R1'),
(8, 'N3'),
(9, 'N2'),
(10, 'N1');

-- Insertion des données dans la table clubs
INSERT INTO clubs (id, nom, adresse, ville, codePostal, pays) VALUES
(1, 'Club A', '123 Avenue des Sports', 'VilleA', '75001', 'France'),
(2, 'Club B', '456 Boulevard des Champions', 'VilleB', '69002', 'France'),
(3, 'Club C', '789 Rue des Joueurs', 'VilleC', '33003', 'France');

-- Insertion des données dans la table joueurs
INSERT INTO joueurs (id, prenom, nom, dateNaissance, nationalite, genre, clubId) VALUES
(1, 'Jean', 'Dupont', '1990-05-15', 'Française', 'H', 1),
(2, 'Marie', 'Dubois', '1988-07-22', 'Française', 'F', 2),
(3, 'Pierre', 'Martin', '1995-11-30', 'Française', 'H', 3),
(4, 'Sophie', 'Durand', '1992-04-20', 'Française', 'F', 1),
(5, 'Paul', 'Moreau', '1987-09-10', 'Française', 'H', 2);

-- Insertion des données dans la table classementsJoueurs
INSERT INTO classementsJoueurs (id, joueurId, classementId, date) VALUES
(1, 1, 2, '2024-01-01'),
(2, 2, 4, '2024-01-01'),
(3, 3, 5, '2024-01-01'),
(4, 4, 3, '2024-01-01'),
(5, 5, 6, '2024-01-01');

-- Insertion des données dans la table tournois
INSERT INTO tournois (id, nom, clubId, dateDebut, dateFin, typeSurfaceId, typeTournoiId, montantInscription, montantPrix) VALUES
(1, 'Tournoi jovial', 1, '2024-06-01', '2024-06-07', 1, 1, 5000.00, 18.00),
(2, 'Championnat de Noël', 2, '2024-12-01', '2024-12-05', 3, 2, 3000.00, 20.00),
(3, 'Open de Printemps', 3, '2024-03-01', '2024-03-10', 2, 3, 2000.00, 25.00);

-- Insertion des données dans la table equipes
INSERT INTO equipes (id, nom, clubId, categorieId, divisionId) VALUES
(1, 'Equipe A', 1, 2, 5),
(2, 'Equipe B', 1, 3, 6),
(3, 'Equipe C', 2, 1, 4),
(4, 'Equipe D', 3, 4, 7),
(5, 'Equipe E', 2, 2, 8);

-- Insertion des données dans la table championnats
INSERT INTO championnats (id, nom, annee, categorieId, divisionId) VALUES
(1, 'Championnat Régional', 2024, 2, 5),
(2, 'Championnat National', 2024, 3, 8);

-- Insertion des données dans la table poules
INSERT INTO poules (id, nom, championnatId) VALUES
(1, 'Poule A', 1),
(2, 'Poule B', 1),
(3, 'Poule C', 2);

-- Insertion des données dans la table rencontres
INSERT INTO rencontres (id, pouleId, equipe1Id, equipe2Id, date, score, gagnantId) VALUES
(1, 1, 1, 2, '2024-06-01', '4-1', 1),
(2, 1, 3, 4, '2024-06-02', '3-2', 3),
(3, 2, 5, 1, '2024-06-03', '2-2', NULL);

-- Insertion des données dans la table matchs
INSERT INTO matchs (id, joueur1Id, joueur2Id, score, gagnantId, rencontreId, tournoiId) VALUES
(1, 1, 2, '6-3, 4-6, 7-6', 1, 1, NULL),
(2, 3, 4, '6-4, 6-3', 3, 2, NULL),
(3, 1, 3, '6-2, 6-4', 1, NULL, 1);

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