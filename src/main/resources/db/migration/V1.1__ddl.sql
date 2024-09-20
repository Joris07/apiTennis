CREATE TABLE classements (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(10) UNIQUE NOT NULL
);

CREATE TABLE typesSurface (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE typesTournoi (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE divisions (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(10) UNIQUE NOT NULL
);

CREATE TABLE clubs (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    adresse VARCHAR(255),
    ville VARCHAR(100),
    codePostal VARCHAR(20),
    pays VARCHAR(50)
);

CREATE TABLE joueurs (
    id SERIAL PRIMARY KEY,
    prenom VARCHAR(50) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    dateNaissance DATE,
    nationalite VARCHAR(50),
    genre VARCHAR(1) CHECK (genre IN ('H', 'F')),  -- H pour Homme, F pour Femme
    clubId INT,
    FOREIGN KEY (clubId) REFERENCES clubs(id)
);

CREATE TABLE classementsJoueurs (
    id SERIAL PRIMARY KEY,
    joueurId INT NOT NULL,
    classementId INT NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (joueurId) REFERENCES joueurs(id),
    FOREIGN KEY (classementId) REFERENCES classements(id),
    UNIQUE (joueurId, date)
);

CREATE TABLE tournois (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    clubId INT,
    dateDebut DATE,
    dateFin DATE,
    typeSurfaceId INT,
    typeTournoiId INT,
    montantInscription NUMERIC(12, 2),
    montantPrix NUMERIC(6, 2),
    FOREIGN KEY (clubId) REFERENCES clubs(id),
    FOREIGN KEY (typeSurfaceId) REFERENCES typesSurface(id),
    FOREIGN KEY (typeTournoiId) REFERENCES typesTournoi(id)
);

CREATE TABLE equipes (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    clubId INT,
    categorieId INT,
    divisionId INT,
    FOREIGN KEY (clubId) REFERENCES clubs(id),
    FOREIGN KEY (categorieId) REFERENCES categories(id),
    FOREIGN KEY (divisionId) REFERENCES divisions(id)
);

CREATE TABLE championnats (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    annee INT NOT NULL,
    categorieId INT,
    divisionId INT,
    FOREIGN KEY (categorieId) REFERENCES categories(id),
    FOREIGN KEY (divisionId) REFERENCES divisions(id)
);

CREATE TABLE poules (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(10) NOT NULL,  -- Exemples : "Poule A", "Poule B", etc.
    championnatId INT NOT NULL,  -- Lien avec le championnat
    FOREIGN KEY (championnatId) REFERENCES championnats(id)
);

CREATE TABLE rencontres (
    id SERIAL PRIMARY KEY,
    pouleId INT NOT NULL,  -- Lien avec la poule
    equipe1Id INT NOT NULL,
    equipe2Id INT NOT NULL,
    date DATE,
    score VARCHAR(20),  -- Exemple : 4-1
    gagnantId INT,  -- L'équipe gagnante
    FOREIGN KEY (pouleId) REFERENCES poules(id),
    FOREIGN KEY (equipe1Id) REFERENCES equipes(id),
    FOREIGN KEY (equipe2Id) REFERENCES equipes(id),
    FOREIGN KEY (gagnantId) REFERENCES equipes(id)
);

CREATE TABLE matchs (
    id SERIAL PRIMARY KEY,
    joueur1Id INT,
    joueur2Id INT,
    score VARCHAR(20),  -- Exemple : "6-3, 4-6, 7-6"
    gagnantId INT,

    rencontreId INT,  -- Lien avec une rencontre d'équipes (peut être NULL)
    tournoiId INT,    -- Lien avec un tournoi individuel (peut être NULL)

    -- Contrainte pour indiquer qu'un match doit appartenir à une rencontre ou à un tournoi, mais pas les deux.
    CHECK ((rencontreId IS NOT NULL AND tournoiId IS NULL) OR (tournoiId IS NOT NULL AND rencontreId IS NULL)),

    FOREIGN KEY (joueur1Id) REFERENCES joueurs(id),
    FOREIGN KEY (joueur2Id) REFERENCES joueurs(id),
    FOREIGN KEY (gagnantId) REFERENCES joueurs(id),
    FOREIGN KEY (rencontreId) REFERENCES rencontres(id),
    FOREIGN KEY (tournoiId) REFERENCES tournois(id)
);

CREATE TABLE rencontresMatchs (
    rencontreId INT,
    matchId INT,
    PRIMARY KEY (rencontreId, matchId),
    FOREIGN KEY (rencontreId) REFERENCES rencontres(id),
    FOREIGN KEY (matchId) REFERENCES matchs(id)
);

CREATE TABLE equipeJoueurs (
    joueurId INT,
    equipeId INT,
    PRIMARY KEY (joueurId, equipeId),
    FOREIGN KEY (joueurId) REFERENCES joueurs(id),
    FOREIGN KEY (equipeId) REFERENCES equipes(id)
);

CREATE TABLE championnatEquipes (
    championnatId INT,
    equipeId INT,
    PRIMARY KEY (championnatId, equipeId),
    FOREIGN KEY (championnatId) REFERENCES championnats(id),
    FOREIGN KEY (equipeId) REFERENCES equipes(id)
);

CREATE TABLE equipesPoule (
    id SERIAL PRIMARY KEY,
    equipeId INT NOT NULL,
    pouleId INT NOT NULL,
    FOREIGN KEY (equipeId) REFERENCES equipes(id),
    FOREIGN KEY (pouleId) REFERENCES poules(id),
    UNIQUE (equipeId, pouleId)  -- Une équipe ne peut être que dans une seule poule à la fois
);