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
* **weight**: consultable y modificable. De tipo double, representa el peso de los atletas en kilogramos. Si no se conoce, aparece como 0.
* **team**: consultable y modificable. De tipo string, representa el nombre del equipo al que pertenecen los atletas.
* **noc**: consultable y modificable. De tipo string, representa las siglas del Comité Olímpico que organiza los juegos.
* **games**: consultable y modificable. De tipo string, representa el nombre de dichos Juegos.
* **season**: consultable y modificable. De tipo enum, representa la estación en la que se celebraron los Juegos. Puede ser Summer o Winter.
* **city**: consultable y modificable. De tipo String, representa la ciudad donde se celebraron los Juegos.
* **sport**: consultable y modificable. De tipo string, representa el deporte en el que participó ese atleta.
* **event**: consultable y modificable. De tipo string, representa el nombre de la prueba olímpica.
* **medal**: consultable y modificable. De tipo enum, representa la medalla que ganó ese atleta. Puede ser Gold, Silver o Bronze.
* **date**: consultable y modificable. De tipo LocalDate, representa el año en el que se llevaron a cabo los Juegos.
* **other_sports**: consultable y modificable. De tipo List, representa otros deportes que practica el atleta.

## Tipos implementados
Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo base - Atleta
Representa un atleta en concreto. **Propiedades**:

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
- R1: la propiedad name no puede estar vacía.
- R2: la fecha debe estar comprendida entre el 1/1/1900 y 1/1/2017.

**Criterio de igualdad**: Dos atletas son iguales si todas sus propiedades básicas son iguales.

**Criterio de orden natural**: por nombre y por evento.

**Otras operaciones**:
- _Double getIMC()_: es una propiedad derivada que devuelve el Índice de Masa Corporal a partir del peso y la altura.

#### Tipos auxiliares

- Season, enumerado. Puede ser Summer o Winter.
- Medal, enumerado. Puede ser Gold, Silver o Bronze.
- Olimpiadas, record. Representa los datos de la olimpiadas ese año, concretamente la ciudad, el nombre de los juegos y las siglas del Comité 
Olímpico que los organiza.

### Factoría - FactoriaAtletas
Clase de factoría para construir objetos de tipo Atletas.

- _Atletas leerAtletas(String nombreFichero)_:Crea un objeto de tipo Atletas a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.
- _Atletas leerAtletasStream(String nombreFichero)_:Crea un objeto de tipo Atletas a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.

### Tipo Contenedor - Atletas
Clase contenedora de los objetos de tipo Atleta.

**Propiedades**:

-  _atletas_, de tipo _List\<Atleta\>_, consultable. Lista de atletas. 
 
**Constructores**: 

- C1: Constructor por defecto. Crea un objeto de tipo Atletas sin ningún atleta almacenado.
- C2: Constructor con un parámetro de tipo Collection\<Atleta\>. Crea un objeto de tipo Atletas con los atletas incluidos en la colección dada como parámetro.
- C3: Constructor con un parámetro de tipo Stream\<Atleta\>. Crea un objeto de tipo Atletas con los atletas incluidos en el Stream dado.

**Criterio de igualdad**: Dos atletas son iguales si lo son sus propiedades atletas.


**Otras operaciones**:
- _Integer getNumeroAtletas()_: Devuelve el número de atletas del conjunto.
- _void anadirAtleta(Atleta at)_: Añade un atleta al objeto.
- _void anadirAtletas(Atleta ats)_: Añade una colección de atletas al objeto.
- _void eliminaAtleta(Atleta at)_: Elimina un atleta.
- _Boolean existeAtletaEdadAño(Integer edad, Integer year)_: Devuelve true o false dependiendo de si existe un atleta con las condiciones especificadas
como parámetro.
- _Integer getNumeroAtletasFecha(LocalDate f)_: Devuelve el número de atletas que participaron en la fecha dada como parámetro.
- _Set<Atleta> getAtletasPesoEquipo(Double p, String t)_: Devuelve un conjunto de los atletas con los cuales coincide el peso y el equipo dados como 
parámetros.
- _Map<String, Set<Atleta>> getAtletasPorEquipo()_: Devuelve un map en el cual las claves son los equipos y los valores son conjuntos con los atletas 
que pertenecen a ese equipo.
- _Map<String, Long> getNumeroAtletasPorEquipo()_: Devuelve un map en el cual las claves son los equipos y los valores son el numero de atletas que 
pertenecen a ese equipo.
- _Boolean existeAtletaEdadAñoStream(Integer edad, Integer year)_: Devuelve true o false dependiendo si existe un atleta con la edad especificada en el año especificado.
- _Integer getNumeroAtletasFechaStream(LocalDate f)_: Devuelve el número de atletas que han competido en la fecha especificada por parámetro.
- _Set<Atleta> getAtletasPesoEquipoStream(Double p, String t)_: Devuelve un conjunto en el cual aparecen los atletas en los que coinciden el peso y el equipo pasado por parametro.
- _Atleta getAtletaMayorPesoEquipo(String t)_: Devuelve el atleta de mayor peso filtrado por equipo.
- _SortedSet<String> getNombreAtletasEquipo(String t)_: Devuelve un conjunto ordenado de los nombres de los atletas ordenados alfabéticamente del equipo pasado por parámetro.
- _Map<String, Set<Atleta>> getAtletasPorEquipoStream()_: Devuelve un map en el cual las claves son los equipos y los valores son conjuntos con los atletas que pertenecen a ese equipo.
- _Map<String, Set<String>> getNombreAtletaPorEquipo()_: Devuelve un map que relaciona los equipos con el nombre de los atletas del equipo.
- _Map<String, Atleta> getAtletaMejorIMCPorEquipo()_: Devuelve un map en el que las claves son los equipos y los valores el atleta con mayor IMC de ese equipo.
- _SortedMap<String,List<String>> getNAtletasMayorIMCPorEquipo(Integer n)_: Devuelve un map en el que las claves son los equipos y los valores los n primeros atletas con mayor IMC.
- _String getEquipoMaxIMC()_: Devuelve el equipo con el mayor IMC de un map en el que las claves son los equipos y los valores el mayor IMC entre todos los atletas de ese equipo.