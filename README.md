## Introduction
Lint rule to replace Kotlin's defaults `MutableMap` and `MutableSet` implementations by the _lightweight_ [ArrayMap](https://developer.android.com/reference/android/support/v4/util/ArrayMap) and [ArraySet](https://developer.android.com/reference/android/support/v4/util/ArraySet) implementations. This library works with Android Studio to create an inspection directly into the editor and will suggest you to replace while you you are writting your code.

<img src="https://github.com/VincentMasselis/ArrayMapArraySetLint/raw/master/assets/pictures/warning.png" width="400">
<img src="https://github.com/VincentMasselis/ArrayMapArraySetLint/raw/master/assets/pictures/description.png" width="400">
<img src="https://github.com/VincentMasselis/ArrayMapArraySetLint/raw/master/assets/pictures/suggestion.png" width="400">
<img src="https://github.com/VincentMasselis/ArrayMapArraySetLint/raw/master/assets/pictures/fix.png" width="400">

## Dependencies
```groovy
lintChecks 'com.vincentmasselis.arraymaparrayset:arraymaparrayset-lint:1.0.0'
implementation 'com.vincentmasselis.arraymaparrayset:arraymaparrayset-extensions:1.0.0'
```

## Ressources
There is a video from Android Developpers explains why and when you should use `ArrayMap`:

[![Youtube Video](https://img.youtube.com/vi/ORgucLTtTDI/0.jpg)](https://www.youtube.com/watch?v=ORgucLTtTDI)
