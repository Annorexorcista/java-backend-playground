# NoSQL - CRUD, CAP y BASE

## Objetivo

Implementar operaciones CRUD utilizando una base de datos NoSQL,
aplicando conceptos de persistencia documental, el teorema CAP y el modelo BASE.

## Tecnologías

- Java 17
- Spring Boot
- Spring Data MongoDB
- MongoDB 7
- Docker Compose

## Base de datos NoSQL

Se utilizó MongoDB como base de datos documental.

A diferencia de una base de datos relacional donde la información se almacena
en tablas y registros, MongoDB almacena la información como documentos JSON
dentro de colecciones.

Ejemplo:

```json
{
  "_id": "1",
  "name": "Keyboard",
  "price": 100
}
```
Teorema CAP

El teorema CAP establece que un sistema distribuido no puede garantizar
simultáneamente:

Consistencia

Todos los nodos observan el mismo estado de los datos.

Disponibilidad

El sistema continúa respondiendo aunque existan fallos.

Tolerancia a particiones

El sistema continúa funcionando ante problemas de comunicación entre nodos.

Los sistemas NoSQL realizan diferentes compromisos entre estas propiedades
dependiendo de sus necesidades de disponibilidad y consistencia.

Modelo BASE

BASE es un modelo utilizado en sistemas distribuidos:

Basically Available

El sistema permanece disponible aunque existan fallos parciales.

Soft State

El estado del sistema puede cambiar mientras los nodos sincronizan información.

Eventually Consistent

Los datos pueden no ser consistentes inmediatamente, pero alcanzarán
consistencia después de un periodo de sincronización.