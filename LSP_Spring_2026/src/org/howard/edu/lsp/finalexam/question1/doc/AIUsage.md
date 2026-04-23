AI Tools Used: Claude

Prompts Used:
1. What are the shared resources in the RequestManager class?
2. Why is addRequest() unsafe in a multi-threaded environment?
3. How does AtomicInteger make addRequest() thread-safe?

How AI Helped: AI helped identify the shared resources and explain why each fix was correct or incorrect. It also helped demonstrate the AtomicInteger alternative approach with a code snippet.

Reflection: I learned that synchronizing only part of a critical section is not enough — the entire operation must be atomic to be thread-safe.