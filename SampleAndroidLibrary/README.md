## AAR (Android Library)

https://developer.android.com/studio/projects/android-library

An Android Archive (AAR) file is a package file format that contains the compiled output of an Android library project, including resources, compiled code, and an Android manifest. AAR files can be used as a dependency for an Android app module. They can contain: Android resources, A manifest file, Shared resources like layouts and drawables, Kotlin or Java classes and methods, and C/C++ libraries for use by the app module's C/C++ code.

### Create a new module

![img_url](https://i.imgur.com/ePHztWG.png)

![img_url](https://i.imgur.com/8HFgfQZ.png)

### Project Structure -> Add module as dependency for the current project

![img_url](https://i.imgur.com/t4eCc5O.png)

### Write any code inside the library

![img_url](https://i.imgur.com/Nk6ahmD.png)

### Import the method from Lib and use it

![img_url](https://i.imgur.com/tnWesmZ.png)

### Create .aar file

```
./gradlew assembleRelease
```

![img_url](https://i.imgur.com/eSKPw8Y.png)
