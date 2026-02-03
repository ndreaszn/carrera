# Carrera - Práctica Métodos: 17/12/25

## 1. Descripción del proyecto
Este proyecto consiste en un simulador de carrera desarrollado en Java, ejecutado desde la consola.
El programa permite al usuario controlar a un corredor mediante decisiones estratégicas que influyen en su posición en la carrera y su nivel de estrés.

El objetivo es alcanzar la posición 1 antes de completar 20 acciones, evitando que el corredor choque debido a un exceso de estrés.

## 2. Objetivo
- Aplicar estructuras de control (bucles y condicionales).
- Utilizar clases estándar de Java (Scanner y Random).
- Implementar un sistema de toma de decisiones por turnos.
- Simular eventos aleatorios.
- Desarrollar lógica de juego basada en riesgo y recompensa.

## 3. Funcionamiento del programa
- El corredor comienza en la posición 15 con estrés 0.
- El usuario dispone de un máximo de 20 acciones.
- En cada turno, el usuario selecciona una acción:
    - PACIENTE
    - AGRESIVO
    - TEMERARIO

- Cada acción modifica el nivel de estrés y la posición del corredor.
- Si el estrés supera 80, existe una probabilidad de que el corredor choque, finalizando la carrera.

## 4. Acciones disponibles
| Acción    | Estrés | Efecto en posición | Riesgo |
| --------- | ------ | ------------------ | ------ |
| PACIENTE  | -20    | Puede perder 1     | Bajo   |
| AGRESIVO  | +15    | Puede ganar 1      | Medio  |
| TEMERARIO | +30    | Gana 2             | Alto   |

## 5. Condiciones de finalización
- Victoria: el corredor alcanza la posición 1.
- Derrota: el corredor choca por estrés elevado.
- Finalización normal: se completan las 20 acciones sin victoria ni choque.
