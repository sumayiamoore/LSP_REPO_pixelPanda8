# AI Usage Report

## Tool Used
Claude (claude.ai) - Anthropic AI Assistant

## How It Was Used

1. **Understanding the assignment** - Asked Claude to break down the assignment 
requirements step by step.

2. **Writing IntegerSetTest.java** - Asked Claude to generate JUnit 5 test cases 
for all 14 methods in IntegerSet, covering both normal cases and edge cases as 
required by the rubric.

3. **Fixing IntegerSet.java** - Claude identified that the Assignment 5 implementation 
had methods like union(), intersect(), diff(), and complement() returning new sets 
instead of modifying the existing set in place, which caused 9 test failures. 
Claude provided a corrected version.

4. **Creating IntegerSetException.java** - Claude provided the custom exception 
class needed for largest() and smallest() to throw the correct exception type.

## Prompts Used
- "Can we tackle this assignment step by step"
- "What are the errors and how do I fix them"
- "Help me understand what files I need"