# Development Log - Question 2

## External Resources Used

### AI Tool: Claude (Anthropic)

Used Claude to help identify design issues in the OrderProcessor class and to
structure the CRC card redesign.

**Prompts and Responses:**

**Me:** Asked Claude to evaluate the OrderProcessor class design and produce
evaluation.md and design.md for Question 2.

**Claude:** Identified four design issues (too many responsibilities, hardcoded
discount logic, validation mixed with business logic, hardcoded logging) and
produced a CRC-based redesign splitting responsibilities across Order,
OrderValidator, DiscountStrategy, StandardDiscount, PriorityDiscount,
OrderLogger, and OrderProcessor.

## Outcome
Markdown files produced and placed in org.howard.edu.lsp.midterm.design.doc.
```

---

Paste those in, push with commit message:
```
Midterm Q2 complete - evaluation.md, design.md, development_log_q2.md