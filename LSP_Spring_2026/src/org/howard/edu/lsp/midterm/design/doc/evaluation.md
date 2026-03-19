# OrderProcessor Design Evaluation

## Design Issues

### 1. Too Many Responsibilities
The class handles validation, discount calculation, and logging all in one method.
A well-designed class should focus on one responsibility. Changes to any one concern
risk breaking the others.

### 2. Hard coded Discount Logic
The if/else chain checking `orderType` is buried inside `processOrder()`. Adding a
new order type requires modifying this class directly, making it fragile and hard to extend.

### 3. Validation Mixed with Business Logic
The null/empty checks and item count validation are tangled with pricing logic.
Validation should be a separate concern so it can be tested and reused independently.

### 4. Hard coded Logging
`System.out.println` with `new Date()` is tightly coupled to the class. There is no
way to change or suppress logging without modifying the class itself.