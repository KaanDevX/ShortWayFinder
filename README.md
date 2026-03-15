# ShortWayFinder
 # City Navigator & Pathfinding System

A robust Java application designed to solve the "Shortest Path" problem. The system reads a map configuration from a text file, validates the routes, and uses a Depth-First Search (DFS) with backtracking to find the most time-efficient path between a starting city and a target destination.

## 🚀 Features
- **File Parsing:** Dynamically reads city counts, names, routes, and travel times from custom text files.
- **Data Validation:** Ensures all routes and cities are properly defined before processing.
- **Optimal Pathfinding:** Implements a recursive backtracking algorithm to explore all possible routes and identify the one with the minimum total time.
- **Formatted Output:** Generates a detailed `output.txt` including the fastest path and the total travel time.

## 🛠️ Project Structure
- `City.java`: The main entry point that coordinates file reading, processing, and output generation.
- `CountryMap.java`: Handles the extraction and parsing of geographical data from input files.
- `WayFinder.java`: The core logic engine that performs pathfinding and validation.
