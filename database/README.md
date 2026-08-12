# Database - Transacciones y ACID

## Objetivo

Implementar un sistema de transacciones sobre PostgreSQL utilizando Spring Boot,
Spring Data JPA y Hibernate, aplicando los principios ACID, control transaccional,
concurrencia y optimización de consultas.

## Tecnologías

- Java 17
- Spring Boot 3.5.16
- Spring Data JPA
- Hibernate
- PostgreSQL 17
- Docker / Docker Compose

## Modelo

Se implementó una entidad `Account` con:

- id
- owner
- balance

La operación principal es una transferencia entre cuentas.

## Transacciones con Spring

La transferencia se implementa mediante:

`@Transactional`

La operación obtiene las cuentas, valida el saldo y modifica ambas cuentas
dentro de una única unidad transaccional.

### Atomicidad

Se realizó una prueba provocando una excepción después de modificar las
cuentas. Spring realizó un rollback y los saldos permanecieron en su estado
original.

También se utilizó `flush()` para demostrar la diferencia entre sincronizar
los cambios con la base de datos y confirmar definitivamente una transacción.

## Consistencia

Se implementó una restricción de base de datos:

```sql
CHECK (balance >= 0)