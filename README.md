# Android RGB TextWatcher Example

Modernización del ejemplo académico `ColorRGB`: tres cajas numéricas controlan en tiempo real un color mediante un `TextWatcher` compartido.

## Comportamiento

Cada canal acepta valores de 0 a 255. Una caja vacía equivale a 0; si el usuario introduce un número superior a 255, se normaliza a 255. La vista previa cambia en cada edición y también se muestra el valor `R/G/B` y hexadecimal, de modo que el resultado no depende únicamente de la percepción del color.

## Mejoras

- Java 17, AGP 9.3.0, Gradle 9.5.0, compile/target SDK 37 y minSdk 23.
- AppCompat 1.8.0 y View Binding.
- Conserva `TextWatcher`, que es el concepto central del ejemplo.
- Evita reentradas al corregir valores superiores a 255.
- Parsing y clamp en una clase independiente con JUnit.
- Strings en recursos y resultado textual accesible.
- GitHub Actions con tests, lint y build.

La comparación detallada con el código histórico está en [`docs/ORIGINAL_REVIEW.md`](docs/ORIGINAL_REVIEW.md).
