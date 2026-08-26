# Enunciado original — Color RGB con TextWatcher

Fuente: `011_ EJERCICIO TextWacther y RGB.pdf` de Desarrollo de Interfaces.

Crear una interfaz con un `LinearLayout` vertical como contenedor principal. Su primer hijo será un `TableLayout`, configurado para estirar las columnas al ancho disponible, con dos filas y tres columnas para mostrar las etiquetas de los colores y sus respectivas cajas de texto. En la parte inferior habrá un `TextView` inicialmente con fondo negro.

Las tres cajas de texto representan las intensidades **R**, **G** y **B** y deben:

- aceptar únicamente enteros positivos;
- permitir como máximo tres caracteres;
- representar valores entre `0` y `255`.

Cada vez que cambie cualquiera de las tres cajas se deben leer los tres valores y actualizar inmediatamente el color de fondo del `TextView` inferior mediante `Color.rgb(rojo, verde, azul)`.

Para ello debe utilizarse un **listener `TextWatcher` común** asociado a las tres cajas mediante `addTextChangedListener()`. De los tres métodos de `TextWatcher`, el ejercicio utiliza `afterTextChanged()` para reaccionar a cada modificación.

También deben controlarse los errores de conversión cuando una caja está vacía y evitar que cualquiera de los tres valores supere `255`.

No existe una base de datos asociada al ejercicio.
