# PriceCalculator Design Evaluation

## Design Issues

### 1. Hard coded Discount Logic
All discount rules are hard coded as if statements inside a single method.
Adding a new customer type requires modifying the existing class, which
risks breaking existing behavior.

### 2. No Extensibility
There is no way to add new pricing rules without editing calculatePrice().
The design is closed to extension and open to modification, which is the
opposite of good OO design.

### 3. Single Method Does Too Much
The method is responsible for knowing every customer type and every discount
rule. These are separate concerns that should be handled by separate classes.