# CookWay
- Une application par Majuran Murugananthan
## Presentation
Application android codé en Java utilisant une architecture MVC

Cette affiche application est une simulation d'un shop de nourriture qui nous permet de choisir un repas parmis une liste de repas , Elle va chercher les informations concernant les repas dans une API github crée par moi même.

## Prérequis
- Installation d'Android Studio
- Lien github de l'API : https://github.com/MjuM/ProjectAndroid/blob/master/dataFinal.json

## Consignes respectées
- Ecran avec une liste d'élément
- Ecran avec le detail d'un élément
- Appel WebService à une API Rest
- Stockage de données en cache
- Fonctions supplémentaires :
  - Architecture MVC
  - Singleton
  - Affichage de plusieurs activités dont 2 avec des listes dans un Recycler View
  - 3 Boutons 
    - Pour Ajouter un element dans notre panier
    - Pour montrer notre panier
    - pour vider notre panier
    
 ## Fonctionnalités
 ### Ecran Principal
 
  - Ecran affichant la liste des repas disponible et leurs prix avec un Recycle View
  
  ![Image of Home](https://github.com/MjuM/ProjectAndroid/blob/master/Home.jpg)
  
### Ecran Detail

  - Ecran qui Affiche la liste d'ingrédients composant le repas avec 3 Boutons
  
  ![Image of detail](https://github.com/MjuM/ProjectAndroid/blob/master/Detail.jpg)
  
 ### Ecran du Panier
  - Lorsqu'on appuie sur montrer votre panier alors qu'on a toujours pas ajouté de Repas celui ci affiche une liste vide :
  ![Image of empty](https://github.com/MjuM/ProjectAndroid/blob/master/PanierVide.jpg)
  
  - Lorsqu'on ajoute plusieurs éléments dans le panier il affiche la liste d'éléments qu'on a choisis et le prix total
  ![Image of full](https://github.com/MjuM/ProjectAndroid/blob/master/PanierPlein.jpg)
  
  - Lorsqu'on appuie sur vider mon panier on retourne sur une liste vide
  ![Image of remove](https://github.com/MjuM/ProjectAndroid/blob/master/PanierRemov.jpg)
