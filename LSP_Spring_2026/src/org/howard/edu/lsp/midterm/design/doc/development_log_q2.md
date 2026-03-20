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
URL: https://claude.ai/chat/555dfacd-2da7-4b2d-9cb2-1a814627306b