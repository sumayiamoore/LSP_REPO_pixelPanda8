# AI Prompts & Transcript – Assignment 3

**Author:** Sumayia Moore
**Tool Used:** Claude

---

## Purpose

This file documents the prompts I asked the AI assistant and summarizes
the responses I received. I reviewed all suggestions and adapted them
to fit the assignment requirements and my own understanding.

---

## Prompt 1

**Me:** I have a working Java ETL pipeline in one class from Assignment 2.
My professor wants me to redesign it to be more object-oriented for
Assignment 3. How should I split it into classes?

**AI Response Summary:**
The AI suggested splitting the pipeline into separate classes based on
responsibility: one class to represent a product (data object), one to
handle reading the CSV, one to handle transformations, and one main class
to coordinate everything. It also suggested using an abstract base class
for file handling to demonstrate inheritance.

**How I used it:**
I used this as the basis for my class design. I adopted the Product,
CSVReader, ProductTransformer, and ETLPipeline structure. I also added
FileHandler as an abstract base class to satisfy the inheritance requirement.

---

## Prompt 2

**Me:** What is encapsulation and how can I apply it to my Product class?

**AI Response Summary:**
The AI explained that encapsulation means hiding internal data by making
fields private and only allowing access through public getter and setter
methods.

**How I used it:**
I applied this directly to Product.java. All fields are private, and I
created public getters and setters for each. I reviewed the code and
verified that no fields were accidentally left public.

---

## Prompt 3

**Me:** How can I use inheritance in this ETL project to satisfy the OO
requirement?

**AI Response Summary:**
The AI suggested creating an abstract FileHandler class that holds a
filePath field and declares an abstract process() method. CSVReader would
then extend FileHandler and provide its own implementation of process().

**How I used it:**
I implemented FileHandler.java as suggested. I verified that CSVReader
correctly calls super(filePath) in its constructor and that the @Override
annotation is present on the process() method.

---

## Prompt 4

**Me:** Can you help me write Javadocs for each class and public method?

**AI Response Summary:**
The AI generated Javadoc comments for each class and method, including
@param, @return, and @author tags where appropriate.

**How I used it:**
I reviewed each Javadoc comment carefully and edited them for accuracy.
I confirmed that @param and @return descriptions matched what the methods
actually do.

---

## Prompt 5

**Me:** How do I confirm that Assignment 3 produces the same output as
Assignment 2?

**AI Response Summary:**
The AI suggested running both programs with the same input file and
comparing the console output and the generated transformed_products.csv
files. It also suggested testing edge cases like a missing input file.

**How I used it:**
I ran both programs and confirmed the run summary numbers matched exactly
(12 read, 7 transformed, 5 skipped). I compared the output CSV files and
confirmed they were identical.