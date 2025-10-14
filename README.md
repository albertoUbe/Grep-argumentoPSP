# 🗃️ Lanzador comando `grep`

Escribir en la entrada de un proceso desde el programa padre.
El proceso padre lanzará el comando grep de Linux con el argumento "psp" (grep PSP) y escribirá en la entrada del proceso hijo el siguiente contenido (en diferentes lineas):

> Me gusta PSP y java
> 
> PSP se programa en java
>
> es un módulo de DAM
> 
> y se programa de forma concurrente en PSP
> 
> PSP es programación.
> 
## 📦 Estructura del Proyecto

📁 com.psp.cmd.grep

    📁 Grep
  
      📄 Grep.java
 
    📁 Lanzador
  
      📄 Lanzador.java

---

## 🧑‍💻 Ejecución

Compila y ejecuta el programa por consola con maven: desde la carpeta raíz donde se encuentra el `pom.xml`.

```bash
mvn clean compile `(desde target/classes)`
java com.psp.cmd.grep.Lanzador.Lanzador
