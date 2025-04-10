class BankAccount {
    constructor(accountNumber, accountHolder, balance = 0) {
      this.accountNumber = accountNumber;
      this.accountHolder = accountHolder;
      this.balance = balance;
    }
  
    // Method to check balance
    checkBalance() {
      console.log(`Account Number: ${this.accountNumber}`);
      console.log(`Account Holder: ${this.accountHolder}`);
      console.log(`Current Balance: $${this.balance}`);
    }
  
    // Method to deposit money
    deposit(amount) {
      if (amount > 0) {
        this.balance += amount;
        console.log(`Deposited $${amount} successfully.`);
      } else {
        console.log("Deposit amount must be greater than zero.");
      }
    }
  
    // Method to withdraw money
    withdraw(amount) {
      if (amount > 0 && amount <= this.balance) {
        this.balance -= amount;
        console.log(`Withdrew $${amount} successfully.`);
      } else if (amount > this.balance) {
        console.log("Insufficient balance.");
      } else {
        console.log("Withdrawal amount must be greater than zero.");
      }
    }
  }
  
  // Class for the bank to manage multiple accounts
  class Bank {
    constructor() {
      this.accounts = [];
    }
  
    // Method to create a new account
    createAccount(accountNumber, accountHolder, initialDeposit) {
      const account = new BankAccount(accountNumber, accountHolder, initialDeposit);
      this.accounts.push(account);
      console.log("Account created successfully!");
    }
  
    // Method to find an account by account number
    findAccount(accountNumber) {
      return this.accounts.find(account => account.accountNumber === accountNumber);
    }
  
    // Method to display all accounts
    displayAccounts() {
      console.log("Bank Accounts:");
      this.accounts.forEach(account => {
        account.checkBalance();
        console.log("----------------------");
      });
    }
  }
  
  // Example usage
  const myBank = new Bank();
  
  // Create accounts
  myBank.createAccount(101, "John Doe", 500);
  myBank.createAccount(102, "Jane Smith", 1000);
  
  // Deposit money
  const johnAccount = myBank.findAccount(101);
  if (johnAccount) johnAccount.deposit(200);
  
  // Withdraw money
  if (johnAccount) johnAccount.withdraw(100);
  
  // Check balance
  if (johnAccount) johnAccount.checkBalance();
  
  // Display all accounts
  myBank.displayAccounts();