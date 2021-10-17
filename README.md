# Alejandro Ruiz Alfás 2ºDAM A
<br>
Enlace al repositorio del proyecto: https://github.com/AlejandroRuizAlfas/U1Practica3.git
<br>
<br>


> <br>NOTA: Cualquiera de los programas se pueden ejecutar desde el propio IDE (IntelliJ en este caso) o bien desde la terminal (haciendo uso del comando java -jar)
> <br>
> <br>


<br>
<br>

# Actividad 4
El ejercicio 4 permite traducir palabras del Español al Inglés de varias formas:
> NOTA: Debido a ciertos problemas (ya comentados por correo) con los archivos JAR, todos ellos se encuentran en su ruta predeterminada, bajo *out\artifacts\CarpetaJar_jar\archivo.jar*

## Caso1
El padre (el usuario en este caso) escribe y envia palabras al traductor para que este las utilice. Solo aquellas palabras incluidas en el diccionario interno serán traducidas.

En este caso no se requieren parámetros.

Ejemplo de uso:
``` bash
java -jar out/artifacts/Ex_jar/U1Practica3.jar
```

## Caso2
El padre (el usuario en este caso) escribe y envia palabras al traductor para que este las utilice. El usuario pasará como parámetro el fichero del diccionario con las traducciones.

La estructura del diccionario será la siguiente (o también ver archivo dict.txt en el proyecto):
``` bash
palabras;words  
raton;mouse  
ordenador;computer  
juguete;toy  
armario;wardrobe  
movil;phone  
```

Ejemplo de uso:
``` bash
java -jar out/artifacts/Ex_jar/U1Practica3.jar -d dict.txt
```

## Caso3
El padre (el usuario en este caso) pasa como parámetro las palabras en un fichero de texto, mientras que el traductor usará su diccionario interno de palabras.

La estructura del fichero de palabras será la siguiente (o también ver archivo file.txt en el proyecto):
``` bash
raton
techo
movil
casa
mando
botella
```

Ejemplo de uso:
``` bash
java -jar out/artifacts/Ex_jar/U1Practica3.jar -f file.txt
```
## Caso4
El padre (el usuario en este caso) pasa como parámetro las palabras en un fichero de texto, y también se añadirá otro parámetro adicional con el fichero con palabras que usara el traductor como diccionario.

La estructura del diccionario será la siguiente (o también ver archivo dict.txt en el proyecto):
``` bash
palabras;words  
raton;mouse  
ordenador;computer  
juguete;toy  
armario;wardrobe  
movil;phone  
```

La estructura del fichero de palabras será la siguiente (o también ver archivo file.txt en el proyecto):
``` bash
raton
techo
movil
casa
mando
botella
```

Ejemplo de uso:
``` bash
java -jar out/artifacts/Ex_jar/U1Practica3.jar -d dict.txt -f file.txt
```
> NOTA: Debido a problemas durante el planteamiento, es **obligatorio** que el orden de los parámetros sea **-d [fichero] -f [fichero]**

<br>


> Todas las palabras que se vayan traduciendo se iran anexando en el fichero **Translations.txt** 

<br>
<br>
<br> 

---
<br>
<br>
<br>

# Actividad 5
La actividad 5 permite pasar como parámetros uno o varios ficheros de texto con numeros (uno en cada linea) y se encargará de calcular la suma de cada uno de los ficheros de forma individual y luego la suma total de todos los ficheros.

Ejemplo de uso:
``` bash
java -jar out/artifacts/Ex5_Accounter_jar/U1Practica3.jar [numeros.txt] [numeros2.txt] ...
```
> El resultado de la suma de los ficheros se guardará en el fichero **totals.txt** 

Si no hay argumentos al ejecuta rel comando, el programa avisará al usuario que no ha pasado ficheros y terminará el programa.

