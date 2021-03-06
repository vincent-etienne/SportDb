# SportDb
Simple projet utilisant l'api SportsDb pour afficher la liste d'équipes sportives ainsi que la liste des joueurs.

### Stack Technique

Kotlin, Okhttp, Retrofit, Koin, Glide, Mockkk

### Presentation Project

Le but de se projet est de démontrer mes compétences en réalisant un projet avec une architecture MVP.
J'ai passé environ 7h sur ce projet, je n'avais pas plus de temps à accorder à ce projet.

Clean Architecture : 
Projet séparé en trois couches : Présentation, Domain, Data
La couche domain est indépendante des autres couches.
Le projet comporte un seul module App car je ne voyais pas d'intérêt spécial à faire du multi modules sur un projet aussi petit.

Il y a un mapping des données de Data vers Domain mais le Presenter envoie directement les entity à la vue, un mapping peut également se faire sur ce point pour donner un model spécifique à la vue (mais je ne voyait pas l’utilité sur ce projet)
Le repository fait passe-plat du dataSource car je n’utilise pas de données en local, mais si c’est le cas il implémenterait cette logique

Concernant le point de reconnaissance faciale et de centrer sur le visage j'ai essayé cette librairie qui n'a pas fonctionné (elle semble obsolète et j'ai pu tester sur Android 10 uniquement) 
https://github.com/aryarohit07/GlideFaceDetectionTransformation

Il faudrait voir de ce côté : https://developers.google.com/vision/face-detection-concepts mais je n'ai pas eu le temps de creuser par manque de temps.
J'ai implémenté des Tests Unitaires uniquement sur les 3 UseCases et 1 méthode RemoteDataSource (avec tous les cas possible pour cette méthode) mais il suffit d'appliquer la même logique de test sur l'ensemble de l'application.
Les TU ont été implémentés après, mais la méthode TDD aurait pû être appliquée.

Il y a une branche en remplacant les Coroutines par des Callback, car je n'étais pas sûr d'avoir le droit de les utiliser étant donné que RxJava était interdit.

Côté UI, je n’ai pas créer de styles xml ou étendu les éléments natifs. Les layouts sont réalisés avec ConstraintLayout.
J'ai laissé le hint et la couleur en dur dans le xml mais normalement ces élements sont dans les fichiers xml associés


Voici quelques screenshots de l'application :
<br/>
<br/>
<img src="https://github.com/vincent-etienne/SportDb/blob/develop-coroutines/pictures/img_auto_completion.jpg" width="280" height="600">
<img src="https://github.com/vincent-etienne/SportDb/blob/develop-coroutines/pictures/img_equipes.jpg" width="280" height="600">
<img src="https://github.com/vincent-etienne/SportDb/blob/develop-coroutines/pictures/img_cas_full.jpg" width="280" height="600">
<img src="https://github.com/vincent-etienne/SportDb/blob/develop-coroutines/pictures/img_cas_empty.jpg" width="280" height="600">
