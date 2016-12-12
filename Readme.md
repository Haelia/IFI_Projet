# Pidgeon

Pidgeon est un mini réserau social, entièrement développé à l'aide de Spring MVC


# Lancement de l'application en mode test
Il faut avoir `mongoDB` installé sur la machine et `mongod` doit tourner sur le port par défaut

Pour executer l'application : 
* `git clone https://www.github.com/Haelia/IFI_Projet`
* `cd IFI_Projet`
* `mvn package`
* `java -jar target/projet-jee-1.0-SNAPSHOT.jar`
 
Vous pouvez ensuite lancer un navigateur sur localhost:8080/

# API REST

Voici quelques indications et exemples pour l'utilisation de l'API REST

Les URL pour les requetes REST commencent toutes par `/api`.
On a une API pour les utilisateurs et une API pour les messages.

## Utilisateurs

* `GET /api/user/` renvoie la liste de tous les utilisateurs
* `GET /api/user/name/[NOM]` renvoie l'utilisateur ayant pour nom [NOM]
* `PUT /api/user/` enregistre un nouvel utilisateur. Ses données doivent être dans le corps de la requête en JSON

## Messages

* `GET /api/message/` renvoie les 30 derniers messages
* `GET /api/message/byUser/[NOM]` renvoie les messages de l'utilisateur qui s'appelle [NOM] 


# Auteurs 
Agez Adrien, Bour Armand et Wissocq Sarah
