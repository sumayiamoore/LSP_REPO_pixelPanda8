Part 1:

Shared Resource #1: nextId (the integer counter used to generate unique request IDs)

Shared Resource #2: requests (the ArrayList storing all request strings)

Concurrency Problem: Race condition — two threads can read the same value of nextId before either increments it, resulting in duplicate IDs being assigned.

Why addRequest() is unsafe: It calls getNextId() and requests.add() as separate non-atomic operations. Two threads can interleave between getting an ID and adding to the list. ArrayList is also not thread-safe, so concurrent add() calls can corrupt the list.

Part 2:

Fix A: Not correct. Synchronizing only getNextId() protects the counter in isolation, but addRequest() is still unsynchronized. Two threads can still call requests.add() concurrently on the non-thread-safe ArrayList, causing corruption.

Fix B: Correct. Synchronizing addRequest() covers the entire critical section — getting the ID and adding to the list — in one atomic block. Only one thread can execute it at a time, preventing both the race on nextId and concurrent list modification.

Fix C: Not correct. Synchronizing getRequests() only protects the read/getter. It does nothing to prevent concurrent writes to nextId or requests.

Part 3:
No, getNextId() should not be public. According to Riel's heuristics, a class should minimize its public interface and only expose what external clients need. getNextId() is an internal helper used only by addRequest(), so it should be private to protect encapsulation.

Part 4:

Description: Use AtomicInteger for the ID counter and CopyOnWriteArrayList for the requests list. AtomicInteger provides lock-free thread-safe increment operations without needing the synchronized keyword.

Code Snippet:

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CopyOnWriteArrayList;

public class RequestManager {
    private AtomicInteger nextId = new AtomicInteger(1);
    private List<String> requests = new CopyOnWriteArrayList<>();

    public void addRequest(String studentName) {
        int id = nextId.getAndIncrement();
        requests.add("Request-" + id + " from " + studentName);
    }
}