-- Drop old tables if they exist
BEGIN EXECUTE IMMEDIATE 'DROP TABLE accounts'; EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN EXECUTE IMMEDIATE 'DROP TABLE employees'; EXCEPTION WHEN OTHERS THEN NULL; END;
/

-- Create accounts table
CREATE TABLE accounts (
  account_id   NUMBER PRIMARY KEY,
  customer_id  NUMBER,
  account_type VARCHAR2(20),
  balance      NUMBER
);

-- Create employees table
CREATE TABLE employees (
  emp_id        NUMBER PRIMARY KEY,
  name          VARCHAR2(50),
  department_id NUMBER,
  salary        NUMBER
);

-- Insert sample accounts
INSERT INTO accounts VALUES (1001, 1, 'savings', 5000);
INSERT INTO accounts VALUES (1002, 1, 'savings', 7000);
INSERT INTO accounts VALUES (1003, 2, 'current', 12000);

-- Insert sample employees
INSERT INTO employees VALUES (1, 'Alice', 101, 50000);
INSERT INTO employees VALUES (2, 'Bob', 101, 45000);
INSERT INTO employees VALUES (3, 'Charlie', 102, 60000);

COMMIT;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  UPDATE accounts
  SET balance = balance + (balance * 0.01)
  WHERE account_type = 'savings';

  COMMIT;
END;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_department_id IN NUMBER,
  p_bonus_percent IN NUMBER
) AS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * p_bonus_percent / 100)
  WHERE department_id = p_department_id;

  COMMIT;
END;

CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_account IN NUMBER,
  p_to_account   IN NUMBER,
  p_amount       IN NUMBER
) AS
  v_balance NUMBER;
BEGIN
  -- Get current balance
  SELECT balance INTO v_balance
  FROM accounts
  WHERE account_id = p_from_account;

  -- Check if sufficient
  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance.');
  END IF;

  -- Deduct from sender
  UPDATE accounts
  SET balance = balance - p_amount
  WHERE account_id = p_from_account;

  -- Credit to receiver
  UPDATE accounts
  SET balance = balance + p_amount
  WHERE account_id = p_to_account;

  COMMIT;
END;