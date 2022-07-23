[![CircleCI](https://dl.circleci.com/status-badge/img/gh/sebas679pb/PrimiSketch/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/sebas679pb/PrimiSketch/tree/master)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/c654bfc1f3704b878f2bb33bddfb6e1f)](https://www.codacy.com/gh/sebas679pb/PrimiSketch/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=sebas679pb/PrimiSketch&amp;utm_campaign=Badge_Grade)

# PrimiSketch

https://primisketch.herokuapp.com/

## Autor

Jhon Sebastian Piñeros Barrera

## Resumen

Este proyecto consiste en realizar el diseño y construccion de una aplicacion que le permitira al usuario crear y visualizar horarios academicos de acuerdo a las materias que planee inscribir en el semestre; tambien permitira crear grupos para realizar esta organizacion simultaneamente entre varios usarios en tiempo real.

## Descripcion

Para un estudiante universitario es muy importante la planificacion de su horario academico pues a partir de este es que se va a relizar el desarrollo de sus actividades academicas durante el semestre, es por esto que parte importante durante este proceso viene a ser la organizacion de asignaturas para posteriormente realizar su inscripcion que debe ser un proceso agil sin embargo muchas veces por falta de atencion, mala organizacion o falta de cupos se puede ver afectado este proceso; con base en esta idea es que nace PrimiSketch que permitira al estudiante realizar de manera interactiva y facil la planificacion de uno o multiples horarios con la finalidad de que pueda organizar estos de distintas formas ya sea por horas o profesores, si desea tener segundas opciones en caso de que se agoten los cupos de algun grupo y a su vez no tenga que preocuparse por posibles conflictos de horario pues la aplicacion se encarga de advertir de estos. Adicionalmente PrimiSketch permitira la creacion de grupos de trabajo donde los integrantes podran colaborar en tiempo real en la creacion y edicion de horarios para aquellos estudiantes que deseen ver asignaturas con sus amigos.

[![image.png](https://i.postimg.cc/zv5TWMn3/image.png)](https://postimg.cc/VrGSPKZc)

## Historias de usuario

- <span style="color:red">Como</span> Usuario <span style="color:red">Quiero</span> iniciar sesion <span style="color:red">Para</span> poder vizualir mis horarios.
Criterios de aceptacion: 
    - Debe haber una sesion activa para poder acceder a las funciones de la aplicacion.
    - Debe existir la posibilidad de cerrar la sesion.

- <span style="color:red">Como</span> Usuario <span style="color:red">Quiero</span> consultar las materias y grupos <span style="color:red">Para</span> poder escoger cual planificar en mi horario.
Criterios de aceptacion:
    - El usario debe poder visualizar los grupos que contiene una materia y su informacion general.
    - El usuario debe poder visualizar la informacion del grupo seleccionado y su informacion especifica.

- <span style="color:red">Como</span> Usuario <span style="color:red">Quiero</span> crear horarios <span style="color:red">Para</span> poder visualizar las distintas maneras en que podria organizar las materias que planeo inscribir.
Criterios de aceptacion: 
    - Se debe poder adicionar materias al horario.
    - Se debe poder eliminar materias del horario.
    - El horario debe visualizarse en forma de planador.

- <span style="color:red">Como</span> Usuario <span style="color:red">Quiero</span> compartir horarios <span style="color:red">Para</span> realizar la organizacion del horario con otros usuarios.
Criterios de aceptacion: 
    - El horario debe quedar guardado en la sesion del usuario.
    - Se debe poder realizar cambion en tiempo real.
    - Se debe poder enviar una invitacion para que se unan otros usarios.

## Prerrequisitos

- Java
- mvn

## Diagramas de clase

### Diagrama de paquetes

[![image.png](https://i.postimg.cc/59sLRP1d/image.png)](https://postimg.cc/F1JYfV7D)

### Configurator

[![image.png](https://i.postimg.cc/k4040tjS/image.png)](https://postimg.cc/N9xBTLvG)

### Entities

[![image.png](https://i.postimg.cc/SRcW34Gy/image.png)](https://postimg.cc/jndwnG99)

### Repositories

[![image.png](https://i.postimg.cc/J49fj5sZ/image.png)](https://postimg.cc/YhzDHgfC)

### Rest

[![image.png](https://i.postimg.cc/28RpZxbv/image.png)](https://postimg.cc/fkKg4mvT)

### Services

[![image.png](https://i.postimg.cc/FFxbyr1Z/image.png)](https://postimg.cc/grn6dPVX)

### DataBase

[![image.png](https://i.postimg.cc/ncBX4Tdt/image.png)](https://postimg.cc/QHNNsgG6)

## Estructura de archivos

```
C:.
├───main
│   ├───java
│   │   └───co
│   │       └───edu
│   │           └───escuelaing
│   │               └───primisketch
│   │                   │   WebSiteController.java
│   │                   │
│   │                   ├───configurator
│   │                   │       SketchWebSocket.java
│   │                   │
│   │                   ├───entities
│   │                   │       DatesSubject.java
│   │                   │       Schedules.java
│   │                   │       ScheduleXSubject.java
│   │                   │       Subjects.java
│   │                   │       Users.java
│   │                   │       UserXSchedule.java
│   │                   │
│   │                   ├───repositories
│   │                   │       DatesSubjectRepository.java    
│   │                   │       SchedulesRepository.java       
│   │                   │       ScheduleXSubjectRepository.java
│   │                   │       SubjectsRepository.java        
│   │                   │       UsersRepository.java
│   │                   │       UserXScheduleRepository.java
│   │                   │
│   │                   ├───rest
│   │                   │       SchedulesRest.java
│   │                   │       SubjectsRest.java
│   │                   │       UsersRest.java
│   │                   │
│   │                   └───services
│   │                           DatesSubjectService.java
│   │                           SchedulesService.java
│   │                           ScheduleXSubjectService.java
│   │                           SubjectsService.java
│   │                           UsersService.java
│   │                           UserXScheduleService.java
│   │
│   └───resources
│       │   application.properties
│       │
│       └───static
│           │   editSchedule.html
│           │   home.html
│           │   index.html
│           │   mySchedules.html
│           │   newSchedule.html
│           │   schedule.html
│           │   subjectsInfo.html
│           │
│           ├───css
│           │       home.css
│           │       login.css
│           │       mySchedules.css
│           │       newSchedule.css
│           │       schedule.css
│           │       subjectsInfo.css
│           │
│           ├───imgs
│           │       background.jpg
│           │       groups.png
│           │       newSchedule.png
│           │       primiSiri.gif
│           │       schedules.png
│           │       subjectCard.jpg
│           │
│           └───js
│                   login.js
│                   mySchedules.js
│                   navBar.js
│                   schedule.js
│                   subjectsInfo.js
│
└───test
    └───java
        └───edu
            └───escuelaing
                └───arsw
                    └───app
                            PrimiSketchTest.java
```

## JavaDoc

El javadoc se puede vizualizar con el comando 

```
mvn javadoc:javadoc
```

y posteriormente vamos a la carpeta de nuestro proyecto y buscamos en target/site/apidocs/index.html