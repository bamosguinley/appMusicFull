
## Etape pour determiner si une réponse saisie est valide ou non 

### Étape 1: Récupérer les réponses
- recupérer la reponse de l'utilisateur et recuperer les informations de la question en base de données

### Étape 2: Calculer la similarité des textes
 Comparer la réponse de l'utilisateur avec la réponse attendue pour déterminer leur similarité :
    - *Fonction à utiliser* : `similar_text()` pour calculer un pourcentage de similarité entre deux chaînes de caractères. 

### Étape 3: Extraire les mots-clés
 les mots-clés importants dans la réponse attendue :
    - *Fonction à utiliser* : `explode()` pour diviser la réponse attendue et la réponse de l'utilisateur en mots.

### Étape 4: Vérifier la correspondance des mots-clés
 Vérifier combien de mots-clés de la réponse attendue apparaissent dans la réponse de l'utilisateur.
- *Fonction à utiliser* :  `in_array()`  pour comparer les mots des deux réponses.

### Étape 5: Calculer le score basé sur la similarité et les mots-clés
 Combiner la similarité des textes et le nombre de mots-clés correspondants pour obtenir un score final.
- *Fonction à utiliser* : Utilisez des calculs arithmétiques pour pondérer le score: `(similarité  * 0.5) + (correspondance_mots_clés * 0.5)`.

