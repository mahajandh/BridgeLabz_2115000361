
+------------------+
|    Customer     |
+------------------+
| - name: String  |
| - id: int       |
| - products: List<Product> |
+------------------+
| + addProduct(Product) |
| + getProducts(): List<Product> |
+------------------+
        |
        | Composition
        ▼
+------------------+
|    Product      |
+------------------+
| - name: String  |
| - price: float  |
+------------------+
| + getPrice(): float |
+------------------+

+----------------------+
|   BillGenerator     |
+----------------------+
| + calculateTotal(Customer): float |
+----------------------+



