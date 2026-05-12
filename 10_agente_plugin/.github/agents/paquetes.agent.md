---
name: genera_carpetas
description: Este agente se encarga de crear los paquetes necesarios para el proyecto.
argument-hint: "[Nombre del proyecto, Nombre del microservicio]".
# tools: [ 'execute', 'read', 'agent', 'edit', 'search', 'web', 'write'] # specify the tools this agent can use. If not set, all enabled tools are allowed.
---
1. Sobre el proyecto cuyo nombre se recibe en el parámetro {Nombre del proyecto}, crea los paquetes necesarios para el proyecto en estos directorios: src/main/java:
    
    - com.capgemini.{Nombre del microservicio}.config
    - com.capgemini.{Nombre del microservicio}.web
    
    - com.caixaba.absis.{Nombre del microservicio}.service
    - com.caixaba.absis.{Nombre del microservicio}.repository
    - com.caixaba.absis.{Nombre del microservicio}.entity
    - com.caixaba.absis.{Nombre del microservicio}.mapper
    
    Reglas:
    - Crea todos los directorios si no existen.
    - No borres ningún archivo existente ni modifiques.
    - No generes clases java salvo que el usuario lo solicite explícitamente.
    - No añadas dependencias ni modifiques el pom.xml.
    - Si un directorio ya existe, no hagas nada.