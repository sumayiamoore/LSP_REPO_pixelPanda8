Heuristic 1:

Name: Minimize the public interface of a class.

Explanation: A class should only expose methods that external clients truly need. Keeping internal helper methods private reduces coupling, makes the class easier to maintain, and prevents outside code from depending on implementation details that may change.

Heuristic 2:

Name: A class should capture one and only one key abstraction.

Explanation: When a class is responsible for a single concept, it becomes easier to read, test, and modify. Changes to one responsibility do not ripple into unrelated parts of the code, improving maintainability.

Heuristic 3:

Name: Keep related data and behavior together.

Explanation: Data and the methods that operate on it should live in the same class. Scattering state across multiple classes forces callers to manage it externally, increases coupling, and makes the code base harder to follow and debug.

