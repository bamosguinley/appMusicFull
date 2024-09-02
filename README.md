### Membres: 
    - Jean-Marie SODOGANDJI
    - Bamos Guinley
    - Jean-Claude Tognibo
    - Esther Akissohe


Pour concevoir la structure de la base de données pour l'application API de musique (`apiApp music`), nous allons définir les tables `albums`, `musique`, et `user`, ainsi que leurs relations.

### Tables et Structures

1. **Table `albums`**

   ```sql
   CREATE TABLE albums (
       id INT AUTO_INCREMENT PRIMARY KEY,
       ref VARCHAR(255) UNIQUE NOT NULL,
       name VARCHAR(255) NOT NULL,
       title VARCHAR(255) NOT NULL,
       description TEXT,
       duration INT, -- Durée en secondes
       statut ENUM('active', 'inactive') NOT NULL DEFAULT 'active'
   );
   ```

2. **Table `musique`**

   ```sql
   CREATE TABLE musique (
       id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       album_id INT,
       FOREIGN KEY (album_id) REFERENCES albums(id) ON DELETE SET NULL
   );
   ```

3. **Table `user`**

   ```sql
   CREATE TABLE user (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(255) UNIQUE NOT NULL,
       password VARCHAR(255) NOT NULL
   );
   ```

### Relations

- **Relation entre `albums` et `musique`**:

  - Chaque musique appartient à un album, donc `album_id` dans la table `musique` est une clé étrangère référencée à `id` dans la table `albums`.
  - En cas de suppression d'un album, la colonne `album_id` dans la table `musique` est définie sur `NULL` (via `ON DELETE SET NULL`), ce qui signifie que les musiques associées ne seront pas supprimées mais simplement dissociées de l'album supprimé.

- **Pas de relation directe avec `user`** dans cette version de la base de données pour le moment.
