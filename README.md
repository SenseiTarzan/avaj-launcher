# Avaj Launcher

Un simulateur de trafic aérien en Java pur (sans bibliothèques externes).

## Contraintes respectées

- ✅ **Java LTS uniquement** : Utilise les fonctionnalités Java jusqu'à la version LTS actuelle
- ✅ **Pas de bibliothèques externes** : Aucun framework ou bibliothèque externe (Guava, JSpecify, etc.)
- ✅ **Pas d'outils de build** : Pas de Gradle, Maven, etc. - compilation directe avec `javac`
- ✅ **Packages appropriés** : Utilise des packages nommés selon les conventions Java
- ✅ **Pas de package par défaut** : Tous les classes sont dans des packages nommés
- ✅ **Compilation manuelle** : Les `.class` ne sont pas committés dans le repository

## Structure du projet

```
avaj-launcher/
├── src/
│   └── avaj/
│       └── launcher/
│           ├── AvajLauncher.java          # Point d'entrée principal
│           ├── Class/
│           │   ├── Coordinates.java       # Coordonnées (longitude, latitude, hauteur)
│           │   ├── Simulator.java         # Simulateur principal
│           │   ├── Tower/
│           │   │   ├── Tower.java         # Tour de contrôle
│           │   │   └── WeatherTower.java  # Tour météo
│           │   ├── Vehicle/
│           │   │   ├── Aircraft.java      # Classe de base pour les véhicules
│           │   │   ├── Baloon.java        # Ballon
│           │   │   ├── Flyable.java       # Interface pour les objets volants
│           │   │   ├── Helicopter.java    # Hélicoptère
│           │   │   └── JetPlane.java      # Avion à réaction
│           │   └── Weather/
│           │       └── WeatherProvider.java # Fournisseur météo
│           ├── Factory/
│           │   └── AircraftFactory.java   # Factory pour créer les véhicules
│           └── Parser/
│               └── ScenerioParser.java   # Parser pour les fichiers de scénario
├── scenario.txt                          # Fichier de scénario d'exemple
├── simulation.txt                         # Fichier de sortie (généré)
├── compile.sh                            # Script de compilation
└── run.sh                                # Script d'exécution
```

## Compilation

Pour compiler le projet :

```bash
./compile.sh
```

Ou manuellement :
```bash
find . -name "*.java" > sources.txt
javac -d build/classes @sources.txt
```

## Exécution

Pour exécuter l'application :

```bash
./run.sh [fichier_scenario]
```

Ou manuellement :
```bash
java -cp build/classes avaj.launcher.AvajLauncher scenario.txt
```

## Format du fichier de scénario

Le fichier de scénario doit contenir :
- Première ligne : nombre de simulations météorologiques
- Lignes suivantes : type nom longitude latitude hauteur

Exemple :
```
5
Baloon B1 2 3 20
JetPlane J1 1 2 10
Helicopter H1 0 0 5
```

## Fonctionnalités

- Simulation de trafic aérien avec différents types de véhicules
- Conditions météorologiques changeantes (SUN, RAIN, FOG, SNOW)
- Système d'observation (pattern Observer) entre les tours et les véhicules
- Logging des événements dans `simulation.txt`

## Nettoyage

Pour nettoyer les fichiers compilés :
```bash
rm -rf build/
```