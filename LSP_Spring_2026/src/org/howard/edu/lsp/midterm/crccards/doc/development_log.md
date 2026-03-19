# Development Log

## External Resources Used

- **AI Tool: Claude (Anthropic)**
  Used to help implement the Task and TaskManager classes based on the CRC cards
  and Driver requirements.

**Me:** can you go thru this file and explain for me

**Claude:** Provided Task.java and TaskManager.java implementations with full Javadoc, using LinkedHashMap to preserve insertion order and match expected Driver output.

**Me:** minimal comments please

**Claude:** Provided trimmed versions of Task.java and TaskManager.java with minimal inline Javadoc comments.

**Me:** how do i run

**Claude:** Explained how to run Driver.java in Eclipse via Run As > Java Application.

---

After filling all 5 files, **run the Driver** and confirm you see this output:
```
OPEN TASKS
T1 Write report [OPEN]
T3 Submit homework [OPEN]

TESTING DUPLICATE TASK ID
Duplicate task ID detected.

TESTING INVALID STATUS
T4 Invalid status test [UNKNOWN]

TESTING FIND TASK
T2 Study for exam [IN_PROGRESS]
Task not found.