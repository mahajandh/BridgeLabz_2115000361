+------------------+
|     Student     |
+------------------+
| - name: String  |
| - id: int       |
| - subjects: List<Subject> |
+------------------+
| + addSubject(Subject) |
| + getSubjects(): List<Subject> |
+------------------+
        |
        | Aggregation
        ▼
+------------------+
|     Subject     |
+------------------+
| - name: String  |
| - score: float  |
+------------------+
| + getScore(): float |
+------------------+

+----------------------+
|  GradeCalculator    |
+----------------------+
| + calculateGrade(Student): String |
+----------------------+

