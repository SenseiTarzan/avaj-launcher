#!/bin/bash

# Script d'exécution pour Avaj Launcher
# Utilise java directement

echo "=== Exécution d'Avaj Launcher ==="

# Vérifier si les .class existent
if [ ! -d "build/classes" ]; then
    echo "Erreur: Les fichiers compilés n'existent pas."
    echo "Veuillez d'abord exécuter ./compile.sh"
    exit 1
fi

# Fichier de scénario par défaut
SCENARIO_FILE="scenario.txt"

# Si un argument est fourni, l'utiliser comme fichier de scénario
if [ $# -eq 1 ]; then
    SCENARIO_FILE="$1"
fi

# Vérifier si le fichier de scénario existe
if [ ! -f "$SCENARIO_FILE" ]; then
    echo "Erreur: Le fichier de scénario '$SCENARIO_FILE' n'existe pas."
    exit 1
fi

echo "Utilisation du fichier de scénario: $SCENARIO_FILE"

# Exécuter l'application
java -cp build/classes avaj.launcher.AvajLauncher "$SCENARIO_FILE"

echo "=== Exécution terminée ==="