# RICK AND MORTY API 

- JAVA 17
- SPRING BOOT
- AOP
- ARQUITECTURA HEXAGONAL

La siguiente API guarda en una base de datos en memoria (H2)
las tablas CHARACTERS y AUDIT donde en audit se guardan los
movimientos o llamados a los empoints estos guaradados se realizan
con programacion orientada a aspectos 

## EMPOINTS
### obtener personajes 
con este empoint se obtienen los personajes paginados de 20 en 20 
si se requiere ir a una pagina en especifico se envia el parametro : ?page=

localhost:8080/apirickandmorty/get-all-characters?page=9

### Guardar personajes 
Para guardar un personaje se debe enviar el nombre del personaje 
si este existe en la API de rick y morty se guardara en la base de datos
H2 si ya existe no lo volvera a guardar 

localhost:8080/apirickandmorty/save-character/birdperson

## ACCESO A DB H2

para acceder a la base de datos H2 se ingresa a el siguiente 
link : localhost:8080/h2-console
en JDBC URL debe estar igual que  jdbc:h2:mem:testdb
las credenciales estan en el archivo properties 