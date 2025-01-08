# Brainwave_matrix_Intern
Code for ATM interface using Java
Documentation of the code 

ATM Interface Documentation

Overview
This program simulates a basic ATM interface that allows users to perform common banking operations such as balance inquiry, deposits, withdrawals, viewing transaction history, and changing their PIN. The application is implemented using Java and follows an object-oriented approach with features like account authentication and transaction tracking.

---

Key Components

1. `Account` Class
Represents an individual bank account and encapsulates all account-related operations and data.

Attributes:
- `accountNumber` (`String`): The unique identifier for the account.
- `pin` (`String`): The account's Personal Identification Number for authentication.
- `balance` (`double`): The current balance in the account.
- `transactionHistory` (`List<String>`): A list storing the transaction history.

#### Methods:
- `Account(String accountNumber, String pin, double balance)`  
  Constructor to initialize account details.

- `boolean authenticate(String pin)`  
  Verifies the provided PIN against the account's stored PIN.

- `double getBalance()`  
  Returns the current account balance.

- `void deposit(double amount)`  
  Adds the specified amount to the account balance and logs the transaction.

- `boolean withdraw(double amount)`  
  Deducts the specified amount from the account balance if sufficient funds are available and logs the transaction. Returns `false` if funds are insufficient.

- `List<String> getTransactionHistory()`  
  Returns the list of all recorded transactions.

- `void changePin(String newPin)`  
  Updates the account's PIN to the specified value.

---

### 2. `ATM` Class
Serves as the main entry point and handles user interactions and account operations.

#### Static Attributes:
- `scanner` (`Scanner`): Used for reading user input.
- `accounts` (`Map<String, Account>`): Stores the accounts, where the key is the account number and the value is an `Account` object.

#### Static Methods:
- `main(String[] args)`  
  The main method initializes the application, displays a welcome message with the current date and time, and manages user login and authentication.

- `performOperations(Account account)`  
  Provides a menu-driven interface for account operations:
  1. **Balance Inquiry:** Displays the current balance.
  2. **Deposit:** Allows the user to add funds to the account.
  3. **Withdraw:** Enables the user to withdraw funds.
  4. **Transaction History:** Displays the list of all past transactions.
  5. **Change PIN:** Updates the account's PIN.
  6. **Exit:** Logs the user out of the session.

---

## Features
1. Account Authentication:  
   Secure login using account number and PIN.

2. Dynamic Welcome Message: 
   Displays the current date and time along with a motivational message.

3. Banking Operations:  
   - Balance Inquiry
   - Deposits
   - Withdrawals (with insufficient balance check)
   - Transaction History
   - PIN Change

4. Transaction History:  
   Maintains a record of deposits and withdrawals for each account.

5. Error Handling:
   - Invalid account number or PIN prompts appropriate messages.
   - Prevents withdrawal if the balance is insufficient.
   - Invalid menu choices are handled gracefully.

---

## How to Run the Program
1. Compile the Code:
   ```bash
   javac ATM.java
   ```
2. Run the Program:
   ```bash
   java ATM
   ```

---

## Sample Flow
1. Launch the application.
2. Enter a valid account number and PIN.
3. Choose operations from the menu:
   - **Option 1:** View the account balance.
   - **Option 2:** Deposit an amount.
   - **Option 3:** Withdraw an amount (if sufficient balance exists).
   - **Option 4:** View the transaction history.
   - **Option 5:** Change the PIN.
   - **Option 6:** Exit the application.
4. On exiting, a goodbye message is displayed.

---

## Example Output

### Welcome Screen
```
Welcome to the ATM Interface!
Date and Time: 2025/01/08 15:30:25
Keep pushing forward!

Enter Account Number: 123456
Enter PIN: 1234

Login Successful!
```

### Menu Example
```
Select an Option:
1. Balance Inquiry
2. Deposit
3. Withdraw
4. Transaction History
5. Change PIN
6. Exit

Your choice: 1
Current Balance: $1000.0
```

---

## **Future Enhancements**
- Add support for account creation and deletion.
- Integrate with a database for persistent storage.
- Implement multi-threading for handling multiple users simultaneously.
- Enhance security features (e.g., account lock after multiple failed login attempts).
