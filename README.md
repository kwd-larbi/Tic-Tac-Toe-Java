# Tic-Tac-Toe Game (Java)

A command-line implementation of the classic Tic-Tac-Toe game in Java, featuring a human player versus computer opponent.

**Author:** Kwadwo Larbi  
**Created:** July 2, 2026

---

## 📋 Overview

This is a fully functional Tic-Tac-Toe game where you play as **X** against the computer (playing as **O**). The human player always goes first, and the game continues until there's a winner or a tie.

---

## 🎮 Features

- **Interactive Gameplay**: Play against the computer with real-time board updates
- **Input Validation**: Robust coordinate validation to prevent invalid moves
- **Win Detection**: Automatically detects wins (rows, columns, diagonals) and ties
- **Computer AI**: Computer opponent makes random valid moves
- **Clear Board Display**: Visual 3x3 grid display after each move

---

## 🚀 How to Play

1. **Run the program:**
   ```bash
   javac TTTLarbi.java
   java TTTLarbi
   ```

2. **Enter moves** using row and column coordinates in the format: `row,col`
   - Example: `0,0` places your mark in the top-left corner
   - Coordinates range from `0` to `2` (0=top/left, 2=bottom/right)

3. **Game outcomes:**
   - **You win!** - You get three in a row
   - **You lost!** - Computer gets three in a row
   - **It's a tie!** - Board is full with no winner

---

## 📐 Game Rules

- The board is a 3×3 grid
- Human player is **X**, Computer is **O**
- Human always plays first
- Players alternate turns
- First to get 3 marks in a row (horizontally, vertically, or diagonally) wins
- If the board fills without a winner, it's a tie

---

## 💻 Technical Details

### Main Components

| Method | Purpose |
|--------|---------|
| `initBoard()` | Initializes empty 3×3 game board |
| `gameBoard()` | Displays current board state |
| `yourTurn()` | Handles human player input and validation |
| `machineTurn()` | Computer makes a random valid move |
| `checkWinner()` | Evaluates board state (returns 1, -1, 0, or 2) |
| `main()` | Main game loop and flow control |

### Return Values for `checkWinner()`
- `1` = Human wins
- `-1` = Computer wins
- `0` = Tie (board full)
- `2` = Game continues (no winner yet)

---

## 📝 Game Flow

```
Initialize empty board
   ↓
Human plays (X)
   ↓
Display board
   ↓
Check for winner?
   ├─ Yes → End game
   └─ No → Continue
   ↓
Computer plays (O)
   ↓
Display board
   ↓
Check for winner?
   └─ Loop back or End game
```

---

## 🔧 Requirements

- **Java 8** or higher
- **Terminal/Command Line** for running the program

---

## 📦 Files

- `TTTLarbi.java` - Main game implementation (single file)

---

## 🎯 Future Enhancements

- Improved AI strategy (currently uses random moves)
- Difficulty levels
- Game statistics tracking
- GUI interface using Swing or JavaFX

---

## 📄 License

This project is provided as-is for educational purposes.
