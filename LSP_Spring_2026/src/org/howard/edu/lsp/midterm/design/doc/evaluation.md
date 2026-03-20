# OrderProcessor Design Evaluation

## Design Issues

### 1. Poor Encapsulation
All fields (customerName, email, item, price) are public. They should be
private with controlled access. Exposing fields directly violates basic
encapsulation principles.

### 2. Too Many Responsibilities
The processOrder() method does five unrelated things: calculates tax,
prints a receipt, saves to a file, sends a confirmation email, and logs
activity. Each of these should belong to its own class.

### 3. Discount Logic Applied Too Late
The discount is applied after the receipt is already printed and the order
is saved to file, meaning the stored and printed totals are incorrect.
This is a logical error caused by poor separation of concerns.

### 4. Hard coded File and Email Logic
Writing directly to orders.txt and printing email confirmations via
System.out.println are tightly coupled to this class. These cannot be
swapped out or tested independently.

### 5. Not Extensible
Any change to tax rates, discount rules, file format, or email behavior
requires modifying this single class, making it fragile and hard to maintain.