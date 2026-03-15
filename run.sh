#!/bin/bash
echo "Compiling Student Record System..."
javac src/*.java
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Running program..."
    echo "------------------------"
    java -cp src Main
else
    echo "Compilation failed!"
fi
