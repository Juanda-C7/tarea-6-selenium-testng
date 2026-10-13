<div align="center">

<h1>Tarea 3: Selenium y TestNG, de Maven a Gradle</h1>

Pruebas de navegador contra <a href="https://www.saucedemo.com">saucedemo.com</a> con Selenium WebDriver, TestNG y Page Objects.<br>
El proyecto se construye con Maven, y la tarea es pasarlo a Gradle.

[![Java 21](https://img.shields.io/badge/Java-21-555555?style=flat-square&logo=openjdk)](#requisitos)
[![Selenium WebDriver](https://img.shields.io/badge/Selenium-WebDriver-43B02A?style=flat-square&logo=selenium&logoColor=white)](#qué-trae)
[![TestNG](https://img.shields.io/badge/TestNG-suite-555555?style=flat-square)](#qué-trae)
[![De Maven a Gradle](https://img.shields.io/badge/Maven%20a%20Gradle-02303A?style=flat-square&logo=gradle)](#ejercicio)
[![Entrega 15 oct 23:59](https://img.shields.io/badge/entrega-15%20oct%2023%3A59-2E5D4B?style=flat-square)](#entrega)

[Requisitos](#requisitos) | [Qué trae](#qué-trae) | [Ejercicio](#ejercicio) | [Entrega](#entrega)

</div>

---

## Requisitos

Se necesita Java 21, Maven y Google Chrome. Con eso, el proyecto corre tal como viene:

```bash
mvn test                     # suite de testng.xml, 6 pruebas
mvn test-compile exec:java   # suite armada en código, solo smoke
```

## Qué trae

| Archivo | Contenido |
|---|---|
| `src/test/java/edu/ufm/qa/pages/` | Los Page Objects de login, inventario, carrito y checkout. |
| `src/test/java/edu/ufm/qa/tests/` | `LoginTest` y `CartTest`, con sus grupos `smoke` y `regression`. |
| `testng.xml` | La suite que corre `mvn test`. |
| `src/test/java/edu/ufm/qa/DynamicSuiteRunner.java` | La misma idea de suite, armada en código. |
| `pom.xml` | El build de Maven. |

## Ejercicio

Se permite usar LLMs en todos los pasos.

1. Hacer fork de este repo y correr las pruebas.
2. Correrlas con el navegador visible.
3. Editar `testng.xml` para cambiar qué pruebas corren.
4. Convertir el proyecto de Maven a Gradle y correr las pruebas con Gradle.

## Entrega

La fecha límite es el jueves 15 de octubre de 2026 a las 23:59. Se entregan dos cosas:

- El link al fork, con el proyecto ya en Gradle.
- Un video del flujo corriendo con Gradle y el navegador visible.
