# Development Log - Question 3

## External Resources Used

### AI Tool: Claude (Anthropic)

Used Claude to evaluate the PriceCalculator design and refactor it using
the Strategy Pattern.

**Prompts and Responses:**

**Me:** Asked Claude to handle Question 3 and explain - evaluate PriceCalculator
and refactor using Strategy Pattern.

**Claude:** Identified hard coded discount logic, lack of extensibility, and single
method doing too much as design issues. Refactored into PricingStrategy interface
with RegularDiscount, MemberDiscount, VIPDiscount, and HolidayDiscount classes.
PriceCalculator updated to accept a strategy via constructor. Driver produces
required output.

## Outcome
Driver output matches required output exactly.
```

---

Expected output when you run Driver:
```
REGULAR: 100.0
MEMBER: 90.0
VIP: 80.0
HOLIDAY: 85.0

URL: https://claude.ai/chat/555dfacd-2da7-4b2d-9cb2-1a814627306b