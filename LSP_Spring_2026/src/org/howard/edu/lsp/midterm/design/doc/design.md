# Redesigned OrderProcessor - CRC Cards

---

Class: Order
Responsibilities:
  - Store order data (orderId, items, orderType)
  - Provide access to order details
Collaborators:
  - None

---

Class: OrderValidator
Responsibilities:
  - Validate that an order has a non-null, non-empty ID
  - Validate that the order contains at least one item
Collaborators:
  - Order

---

Class: DiscountStrategy (interface)
Responsibilities:
  - Define a contract for calculating a discounted total
Collaborators:
  - None

---

Class: StandardDiscount
Responsibilities:
  - Apply no discount (regular orders)
Collaborators:
  - DiscountStrategy

---

Class: PriorityDiscount
Responsibilities:
  - Apply a 10% discount to the order total
Collaborators:
  - DiscountStrategy

---

Class: OrderLogger
Responsibilities:
  - Log when an order has been processed
  - Record the time stamp of processing
Collaborators:
  - None

---

Class: OrderProcessor
Responsibilities:
  - Coordinate the processing of an order
  - Delegate validation to OrderValidator
  - Delegate discount calculation to DiscountStrategy
  - Delegate logging to OrderLogger
Collaborators:
  - Order
  - OrderValidator
  - DiscountStrategy
  - OrderLogger