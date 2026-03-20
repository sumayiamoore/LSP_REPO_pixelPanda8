# Redesigned OrderProcessor - CRC Cards

---

Class: Order
Responsibilities:
  - Store order data (customerName, email, item, price)
  - Provide access to order details
Collaborators:
  - None

---

Class: TaxCalculator
Responsibilities:
  - Calculate tax on an order price
  - Calculate final total including tax
Collaborators:
  - Order

---

Class: DiscountCalculator
Responsibilities:
  - Apply discount rules based on order price
  - Return discounted total
Collaborators:
  - Order

---

Class: ReceiptPrinter
Responsibilities:
  - Print customer name, item, and total to console
Collaborators:
  - Order

---

Class: OrderFileWriter
Responsibilities:
  - Save order details to a file
Collaborators:
  - Order

---

Class: EmailService
Responsibilities:
  - Send confirmation email to customer
Collaborators:
  - Order

---

Class: OrderLogger
Responsibilities:
  - Log the timestamp when an order is processed
Collaborators:
  - None

---

Class: OrderProcessor
Responsibilities:
  - Coordinate the full order processing workflow
  - Delegate tax calculation to TaxCalculator
  - Delegate discount to DiscountCalculator
  - Delegate receipt printing to ReceiptPrinter
  - Delegate file saving to OrderFileWriter
  - Delegate email confirmation to EmailService
  - Delegate logging to OrderLogger
Collaborators:
  - Order
  - TaxCalculator
  - DiscountCalculator
  - ReceiptPrinter
  - OrderFileWriter
  - EmailService
  - OrderLogger
```

---
