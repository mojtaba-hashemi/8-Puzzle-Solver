# 8-Puzzle Solver Using BFS (Java)

This repository contains a Java implementation of the classic **8-Puzzle** problem, solved using the **Breadth-First Search (BFS)** algorithm. The program explores states level-by-level, guaranteeing the shortest solution path from the initial configuration to the goal state.

## Features
- Uses **Breadth-First Search (BFS)** to find the optimal (shortest) solution
- **State visualization** with `_` representing the blank tile
- Tracks moves using: `U`, `D`, `L`, `R`
- Prints each **generated child state** during BFS
- **Full solution path reconstruction**
- Displays both board states and the final move sequence
- Clean and simple Java implementation suitable for AI learning

## How It Works

### State Representation
Each puzzle state is stored as a 9-character string such as:
123405678

`0` represents the blank tile.

### Neighbor Generation
All valid moves of the blank tile are generated along with:
- The resulting new state  
- The direction of the move (`U`, `D`, `L`, `R`)

### BFS Search Process
The BFS algorithm:
1. Uses a queue to explore states in breadth-first order  
2. Records parent links for backtracking  
3. Records the direction taken to reach each state  
4. Stops immediately when the goal state is found  

### Solution Reconstruction
Once BFS finds the goal:
- The path from start to goal is reconstructed  
- All intermediate states are printed  
- The full sequence of moves is displayed  

## Example Output
Initial (9 digits 0-8): 103425786
Goal (9 digits 0-8): 123456780

=== BFS Started ===
...
=== Solution Path ===
Move: D
1 _ 3
4 2 5
7 8 6

...

## How to Run

### Compile
javac EightPuzzleSolver.java

### Run
java EightPuzzleSolver


The program will prompt for:
- Initial state (e.g., `103425786`)
- Goal state (e.g., `123456780`)

## Code Structure

| Method | Description |
|--------|-------------|
| `show()` | Prints a 3×3 puzzle board |
| `neighbors()` | Generates valid successor states and their directions |
| `bfs()` | Performs BFS and prints expanded/discovered states |
| `main()` | Handles input and reconstructs the full solution |

## Move Notation

| Move | Meaning |
|------|----------|
| `U` | Blank moves Up |
| `D` | Blank moves Down |
| `L` | Blank moves Left |
| `R` | Blank moves Right |

## Notes
- BFS guarantees optimal solutions but may explore many states.
- Good for learning **AI**, **state-space search**, and **uninformed search algorithms**.
