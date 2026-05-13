Durante el proceso de creación de un microservicio con Spring boot
deberás tener en cuenta las siguientes directrices:
#arquitectura
- Inyección por constructor
- DTOs implementados con records
- Separación entidades de DTOs
- Mapeado entre entidades y DTO con Mapstruct
- Seguir siempre los principios SOLID a la hora de generar código
#service
- Separar interfaz y clase de implementación
- La clase siempre anotada con @Service
- Los tipos de devolución DTO y también los de entrada en caso de altas y modificaciones
- En la implementación se interacciona con repository y se mapea entidad/dto
#repository
- Utiliza Spring Data JPA
- Intenta utilizar Query keywords para nombres de métodos
- En caso de usar query, emplea JPQL
#controller
- Utiliza los convenios habituales para crear un API REST
- Los endpoint siempre devolverán ResponseEntity con código de estado adecuado en cada caso 
#configuracion
-Evita harcodear datos como direcciones, contraseñas u otra información sensible o susceptible de 
ser modificada. Define esos datos en archivos de configuración e inyectalos apropiadamente en el código
-Utiliza perfiles Spring (application-dev, application-prod,..) para gestionar configuraciones específicas de cada entorno

#general
- Cuando te hagan referencia al uso de skill, debes tener en cuenta que se encuentran
en alguna subcarpeta dentro de la carpeta .github/skills del proyecto
- Si alguno de los componentes creados se encuentra en un paquete que no dependa jerarárquicamente
del paquete en el que se encuentra la clase main, deberás incluir en esta clase las anotaciones
correspondiente para escaneado de paquetes de servicios, controladores, entidades, repositorios JPA y otros componentes existentes