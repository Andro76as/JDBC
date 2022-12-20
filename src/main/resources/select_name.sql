SELECT product_name FROM orders
JOIN customers ON orders.customer_id = customers.id
WHERE customers.name = :name;