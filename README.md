# 🧵 Projet : Gestion des Threads avec DAO et Maven

Bienvenue dans le projet **Devoir_threads** ! Ce projet met en œuvre une gestion des threads combinée à des DAO (Data Access Object) pour manipuler efficacement les données. Une architecture modulaire et des outils modernes garantissent une performance et une maintenabilité optimales.

---

## 🗂️ **Table des Matières**

1. [✨ Principe du Projet](#-principe-du-projet)
2. [📂 Structure du Projet](#-structure-du-projet)
3. [💻 Technologies Utilisées](#-technologies-utilisées)
4. [⚙️ Installation et Configuration](#️-installation-et-configuration)
5. [🚀 Fonctionnalités](#-fonctionnalités)
6. [🏃‍♂️ Exécution du Projet](#-exécution-du-projet)
7. [📦 Structure des Packages](#-structure-des-packages)

---

## ✨ **Principe du Projet**

Le projet repose sur un système de gestion d'ordres à partir de fichiers JSON, intégrant la validation des clients et la gestion des erreurs :

1. **Fichiers JSON** : Trois fichiers sont utilisés : `input`, `output`, et `error`.
2. **Base de Données** :
   - Table _customer_ : Gère les clients (id, nom, email, téléphone).
   - Table _order_ : Gère les commandes (id, date, montant, customer_id).
3. **Processus** :
   - Toutes les heures, les données du fichier `input` sont transférées dans une liste de commandes (_orders_).
   - **Validation des Clients** :
     - Si le client existe dans la table _customer_, la commande est ajoutée dans la table _order_ et dans le fichier `output`.
     - Sinon, la commande est enregistrée dans le fichier `error`.

---

## 📂 **Structure du Projet**

```
Devoir_threads
├── src/main/java
│   ├── Dao
│   ├── DaoImp
│   ├── data
│   ├── DBManager
│   ├── MainPackage
│   ├── Model
│   └── ThreadManager
├── src/test/java
├── pom.xml
└── README.md
```

---

## 💻 **Technologies Utilisées**

- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) **Java 17** : Langage principal pour le développement.
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) **Maven** : Gestionnaire de dépendances.
- ![JSON](https://img.shields.io/badge/JSON-000000?style=for-the-badge&logo=json&logoColor=white) **JSON** : Format pour les données des fichiers.
- ![JDBC](https://img.shields.io/badge/JDBC-4479A1?style=for-the-badge&logo=java&logoColor=white) **JDBC** : Gestion des interactions avec la base de données.
- ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white) **JUnit** : Framework pour les tests unitaires.
- ![Multithreading](https://img.shields.io/badge/Multithreading-FFD700?style=for-the-badge&logo=java&logoColor=white) **Multithreading** : Gestion des tâches simultanées.

---

## ⚙️ **Installation et Configuration**

1. **Cloner le Projet** :

   ```bash
   git clone <url_du_repository>
   cd Devoir_threads
   ```

2. **Importer dans un IDE** :

   - Ouvrir IntelliJ IDEA ou Eclipse.
   - Importer le projet comme un projet Maven.

3. **Configurer la Base de Données** :

   - Mettre à jour les informations de connexion dans `DBManager`.
   - Créer les tables _customer_ et _order_ en exécutant le script SQL fourni.

4. **Installer les Dépendances** :
   ```bash
   mvn install
   ```

---

## 🚀 **Fonctionnalités**

- **Traitement Automatique** :

  - Validation des commandes toutes les heures via le fichier `input`.
  - Gestion des clients non existants avec un suivi dans le fichier `error`.

- **Gestion des Threads** :

  - Exécution parallèle pour améliorer la performance du traitement.

- **Connexion à la Base de Données** :
  - Opérations CRUD pour les clients et commandes.

---

## 🏃‍♂️ **Exécution du Projet**

1. Vérifiez que la base de données est configurée et accessible.
2. Exécutez la classe principale située dans `MainPackage`.
3. Suivez les logs pour visualiser le traitement des commandes.

---

## 📦 **Structure des Packages**

- **Dao** : Interfaces pour les opérations CRUD.
- **DaoImp** : Implémentations des interfaces avec des requêtes SQL.
- **data** : Gestion des fichiers JSON (`input`, `output`, `error`).
- **DBManager** : Classe utilitaire pour gérer les connexions à la base de données.
- **Model** : Représentation des entités (ex. : _Customer_, _Order_).
- **ThreadManager** : Gestion des threads pour l'automatisation des tâches.

---

## 📌 **Auteurs**

- **Nom** : Dadda Abdelghafour
- **Statut** : Étudiant en GI à l'ENSA Marrakech

---

🎉 Merci d'utiliser **Devoir_threads** ! N'hésitez pas à partager vos commentaires ou questions.
