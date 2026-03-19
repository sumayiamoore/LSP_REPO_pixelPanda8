# CRC Cards Explanation

TaskManager collaborates with Task because its responsibilities include storing,
locating, and organizing Task objects, it cannot fulfill these responsibilities
without directly working with Task instances. Task, by contrast, is only
responsible for storing its own data and updating its own status, which requires
no knowledge of any other class. Since Task's responsibilities are entirely
self-contained, it has no need to reference or depend on TaskManager.
