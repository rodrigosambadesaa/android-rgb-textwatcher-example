# Revisión del ejemplo original ColorRGB

El ejemplo histórico usa una misma `Activity` como `TextWatcher` de tres `EditText`. Cada modificación vuelve a leer rojo, verde y azul, limita cada canal a 255 y actualiza el fondo de un `TextView` con `Color.rgb(...)`.

## Aspectos acertados

- Un único listener para los tres controles evita duplicar la misma lógica.
- El color se actualiza inmediatamente, por lo que el efecto de `TextWatcher` se entiende con facilidad.
- Se contempla que una caja vacía no pueda convertirse directamente a entero.

## Problemas corregidos

- `catch (Exception)` ocultaba cualquier tipo de error; la revisión limita el tratamiento a conversión numérica.
- `setText("255")` desde `afterTextChanged` puede provocar reentradas del listener; ahora existe una guarda explícita al normalizar.
- Los `findViewById` y casts se sustituyen por View Binding.
- Los textos estaban hardcodeados y el nombre de la app seguía siendo `controlesbasicos`.
- La vista solo comunicaba el resultado mediante color; ahora también muestra R/G/B y hexadecimal.
- Support Library y configuración Android antiguas se sustituyen por AndroidX y toolchain actual.
- La conversión/clamp de canal se separa en `RgbChannel` y tiene pruebas reales.
