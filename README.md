# Console-Based Banking System (Java)

A **console-based Banking System** built in **Java** using **Object-Oriented Programming (OOP)** and **File I/O**. This application allows users to create accounts, log in securely, and perform basic banking transactions with persistent data storage.

---

## Features

- Create bank accounts
- Auto-generated account numbers (date-based)
- Login system (username & password)
- Multiple account types:
  - Checking Account
  - Savings Account
  - Money Market Account
- Deposit and withdraw funds
- Balance tracking
- Persistent data storage using file I/O
- Account activation status

---

## OOP Concepts Used

- Classes & Objects
- Encapsulation
- Separation of Concerns
- Abstraction of responsibilities
- Helper class for ID generation

---

## Technologies Used

- Java  
- `Scanner` for user input  
- `ArrayList` for data storage  
- File I/O (`FileReader`, `FileWriter`, `BufferedReader`, `PrintWriter`)  
- `LocalDate` for account number generation  

---

## Account Number Format

Account numbers are automatically generated in the format: 
YYYY-MM-COUNTER

Example: 
2026-01-5

The counter continues even after restarting the program due to file-based persistence.

---

## How It Works

1. Users create a new bank account by providing account details.
2. Account data is saved to a file (`accounts.txt`).
3. Users log in using their username and password.
4. Logged-in users can:
   - View account details
   - Deposit money
   - Withdraw money (with balance validation)
5. All changes are saved automatically.

---

## File Persistence

- Account data is stored in:
  "accounts.txt"
- Accounts are loaded at program startup.
- The account number counter is restored to prevent duplication.

---

## Usage

1. **Clone the repository:**
 ```bash
 git clone https://github.com/John-0-6/Banking-System.git
