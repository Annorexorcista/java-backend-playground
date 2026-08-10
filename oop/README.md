### Liskov Substitution Principle

`PhysicalProduct` y `DigitalProduct` pueden utilizarse mediante una referencia
de tipo `Product` sin alterar el comportamiento esperado por el consumidor.

Se evaluó una posible subclase `ChildrenProduct extends PhysicalProduct` que
restringía el stock mínimo a 5 unidades. Esto evidenció que una subclase no debe
fortalecer las precondiciones establecidas por su clase padre.

En este caso, `ChildrenProduct` no se implementó porque la relación de herencia
no representaba correctamente el dominio.