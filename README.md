# CookWay version Kotlin mode Affichage seulement
- Une application par Majuran Murugananthan
## Presentation
Application android codé en Kotlin utilisant une architecture MVVM

Cette affiche application est une simulation d'un shop de nourriture qui nous permet de afficher une liste de repas , Elle va chercher les informations concernant les repas dans une API github crée par moi même.

## Prérequis
- Installation d'Android Studio
- Lien github de l'API : https://github.com/MjuM/ProjectAndroid/blob/master/dataFinal.json

## Consignes respectées
- Ecran avec une liste d'élément
- Appel WebService à une API Rest
- Stockage de données en cache
- Fonctions supplémentaires :
  - Architecture MVVM
  - Creation de compte
    
 ## Fonctionnalités
 ### Ecran Acceuil
 
  - Ecran affichant un login Screen
  ![Image of Home](https://github.com/MjuM/ProjectAndroid/blob/master/HOME_SCREENY.PNG)
  
### Login name

  - Voici le login name qu'on va utiliser
  
  ![Image of detail](https://github.com/MjuM/ProjectAndroid/blob/master/LOG_NAME.PNG)
  
 ### Test de connexion
  - Lorsqu'on essaye de se connecter sans avoir créer un compte au préalable
  
  ![Image of empty](https://github.com/MjuM/ProjectAndroid/blob/master/LOGERROR.PNG)
  
  - On crée un compte pour palier à ce problème
  
  ![Image of full](https://github.com/MjuM/ProjectAndroid/blob/master/CREATE_ACCOUNTY.PNG)
  
  - On voit bien dans la database la présence de l'identifiant
  
  ![Image of remove](https://github.com/MjuM/ProjectAndroid/blob/master/DATABASE_INSPECTOR.PNG)

   - On arrive bien à se connecter maintenant
   
  ![Image of detail1](https://github.com/MjuM/ProjectAndroid/blob/master/LOG_SUCCESS.PNG)
  
  - Affichage de la liste suite à la connection
  
  ![Image of remove1](https://github.com/MjuM/ProjectAndroid/blob/master/LIST.PNG)
  
  - Affichage de la liste suite à la connection mais cette fois ci en mode avion ( stockage en cache )
  
  ![Image of remove2](https://github.com/MjuM/ProjectAndroid/blob/master/MODEAVION.PNG)
  
  
  
  
