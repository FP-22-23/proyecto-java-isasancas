# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Isabel Sánchez Castro   uvus: isasancas

## Descripción
Voy a trabajar con el dataset athlete_events.csv. Este dataset muestra los datos de los Juegos Olímpicos celebrados desde 1896 a 2016. 

## Estructura de las carpetas del proyecto

* **/src**: contiene el código fuente del proyecto.
	* **fp.atletas**: Paquete que contiene los tipos del proyecto.
	* **fp.atletas.test**: Paquete que contiene las clases de test del proyecto.
	* **fp.utiles**: Paquete que contiene las clases de utilidad.
* **/data**: contiene el dataset del proyecto
    * **athlete_events.csv**: el dataset contiene los datos de las Olimpiadas desde 1900 a 2016.
    
## Estructura del *dataset*

El dataset original se puede descargar de la URL https://www.kaggle.com/datasets/samruddhim/olympics-althlete-events-analysis.
El dataset original está compuesto por 15 columnas y el usado en este proyecto tiene 15 columnas, 13 se han tomado 
del dataset original, y dos, date y other_sports, se han generado de forma aleatoria. A continuación se describen las 15 columnas del dataset:

* **name**: consultable y modificable. De tipo string, representa el nombre del atleta.
* **sex**: consultable y modificable. De tipo boolean, representa el sexo del atleta, masculino o femenino. La asignación es M (True) y F (False).
* **age**: consultable y modificable. De tipo integer, representa la edad del atleta. Si no se conoce, aparece como 0.
* **height**: consultable y modificable. De tipo integer, representa la altura de los atletas en centímetros. Si no se conoce, aparece como 0.
* **weight**: consultable y modificable. De tipo float, representa el peso de los atletas en kilogramos. Si no se conoce, aparece como 0.
* **team**: consultable y modificable. De tipo string, representa el nombre del equipo al que pertenecen los atletas.
* **season**: consultable y modificable. De tipo enum, representa la estación en la que se celebraron los Juegos. Puede ser Summer o Winter.
* **sport**: consultable y modificable. De tipo string, representa el deporte en el que participó ese atleta.
* **event**: consultable y modificable. De tipo string, representa el nombre de la prueba olímpica.
* **medal**: consultable y modificable. De tipo enum, representa la medalla que ganó ese atleta. Puede ser Gold, Silver o Bronze.
* **date**: consultable y modificable. De tipo LocalDate, representa el año en el que se llevaron a cabo los Juegos.
* **other_sports**: consultable y modificable. De tipo List

## Tipos implementados
Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo base - Atleta
Representa un atleta en concreto.

**Propiedades**
- _name_: consultable y modificable. De tipo string, representa el nombre del atleta.
- _sex_: consultable y modificable. De tipo boolean, representa el sexo del atleta, masculino o femenino. La asignación es M (True) y F (False).
- _age_: consultable y modificable. De tipo integer, representa la edad del atleta. Si no se conoce, aparece como 0.
- _height_: consultable y modificable. De tipo integer, representa la altura de los atletas en centímetros. Si no se conoce, aparece como 0.
- _weight_: consultable y modificable. De tipo float, representa el peso de los atletas en kilogramos. Si no se conoce, aparece como 0.
- _team_: consultable y modificable. De tipo string, representa el nombre del equipo al que pertenecen los atletas.
- _sport_: consultable y modificable. De tipo string, representa el deporte en el que participó ese atleta.
- _event_: consultable y modificable. De tipo string, representa el nombre de la prueba olímpica.
- _date_: consutable y modificable. De tipo LocalDate, representa la fecha de apertura de los Juegos.
- _other_sports_: consultable. De tipo List<String>, representa los otros deportes que practica el atleta.
- _olimp_: consultable. De tipo Olimpiadas, es un tipo auxiliar que representa los datos de la olimpiadas ese año, 
concretamente la ciudad, el nombre de los juegos y el Comité Olímpico que los organiza.

**Constructores**
- C1: Crea un objeto de tipo Atleta a partir de los siguientes parámetros: ```String name, String team, 
String event, Medal medal, LocalDate date, String other_sports```.
- C2: Tiene un parámetro por cada propiedad del tipo.

**Restricciones**
- R1: la propiedad name no puede estar vacía
- R2: la fecha debe estar comprendida entre el 14/5/1900 y la fecha actual.

**Criterio de igualdad**: Dos atletas son iguales si todas sus propiedades básicas son iguales.

**Criterio de orden natural**: por nombre y por evento.

**Otras operaciones**:
- _Double getIMC()_: es una propiedad derivada que devuelve el Índice de Masa Corporal a partir del peso y la altura.

####Tipos auxiliares

- Season, enumerado. Puede ser Summer o Winter.
- Medal, enumerado. Puede ser Gold, Silver o Bronze.
- Olimpiadas, record. Representa los datos de la olimpiadas ese año, concretamente la ciudad, el nombre de los juegos y el comité olímpico que los organiza.