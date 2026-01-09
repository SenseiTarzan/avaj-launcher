#!/bin/bash

# Script de compilation pour Avaj Launcher
# Utilise javac directement sans outils de build externes

echo "=== Compilation du projet Avaj Launcher ==="

# Créer le dossier pour les .class
mkdir -p build/classes

# Trouver tous les fichiers .java
echo "Recherche des fichiers source Java..."
find ./app -name "*.java" > sources.txt

# Compiler avec javac
echo "Compilation en cours..."
javac -d build/classes @sources.txt

# Vérifier si la compilation a réussi
if [ $? -eq 0 ]; then
    echo "✓ Compilation réussie !"
    echo "Les fichiers .class sont dans build/classes/"
else
    echo "✗ Erreur de compilation"
    exit 1
fi

# Nettoyer le fichier temporaire
rm sources.txt

echo "=== Compilation terminée ==="