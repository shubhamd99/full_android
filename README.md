# Android Development

![img_alt](https://i.imgur.com/ai9Kpdi.png)

## Gemini in Android Studio

![img_url](https://i.imgur.com/ZahxJC6.png)

## Declarative vs Imperative UI in Android

Every application has a UI framework behind it. These frameworks play a huge part in how the applications are created and their performance as well. They also have different ways of operation but can be summarized into two: declarative and imperative.

- Imperative UI This is the most common paradigm. It involves having a separate prototype/model of the application’s UI. This design focuses on the how rather than the what. A good example is XML layouts in Android. We design the widgets and components which are then rendered for the user to see and interact with. Too complicated - a lot of moving parts. UI is coupled with the logic and vice versa. For example: to render a list witha a few items, you'll need to Create Recycler View which needs an adapter and each list item needs a view holder.

- Declarative UI This pattern is an emerging trend that allows the developers to design the user interface based on the data received. This on the other hand focuses on the what. This design paradigm makes use of one programming language to create an entire application.

- Before Jetpack compose, themes were set in the manifest files. The various style attributes were declared in the resources folder in XML files too. You also had Material design classes for the themes.

- In imperative UI, state management was not as easy as in declarative UI. Since the user interface was created using a tree of widgets, it became more error prone as the tree grew. To reflect a change in the data, you had to go through the widget tree to find the specific widget to update.

## Pros of Declarative UI

- No more manually updating each widget (setters and getters)
- No more XML UIs
- Data is passed down from the main function
- Events are sent up
- Recomposition - is the process of calling your composable function again when inputs change

## Cons of Imperative UI

- Traverse widget tree (expensive)
- Increase errors
- Changing the internal state of the widget manually
- Update conflicts happen

## Jetpack

Modern Android Development with Declarative UI Approach.
Jetpack is a suite of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices so that developers can focus on the code they care about.

Jetpack compose also comes with a pre-configured Material design theme. You can customize this theme to meet your own demands in an easier way. It provides properties like shapes, typography and colors in the MaterialTheme composable.

## Arch of Data use

![im_alt](https://i.imgur.com/pbblTIQ.png)

## Context

It's the context of current state of the application/object. It lets newly-created objects understand what has been going on. Typically, you call it to get information regarding another part of your program (activity and package/application).

- It allows us to access resources.
- It allows us to interact with other Android components by sending messages.
- It gives you information about your app environment.

## Activity

An activity is one screen of an app. In that way the activity is very similar to a window in the Windows operating system.
Examples: Login screen, sign up screen, and home screen.
An activity in Android is a specific combination of XML files and JAVA files. It is basically a container that contains the design as well as coding stuff.

Unlike programming paradigms in which apps are launched with a main() method, the Android system initiates code in an Activity instance by invoking specific callback methods that correspond to specific stages of its lifecycle.

## App Bundle

An Android App Bundle is a publishing format that includes all your app’s compiled code and resources, and defers APK generation and signing to Google Play.
Google Play uses your app bundle to generate and serve optimized APKs for each device configuration, so only the code and resources that are needed for a specific device are downloaded to run your app. You no longer have to build, sign, and manage multiple APKs to optimize support for different devices, and users get smaller, more-optimized downloads.

## App Manifest

Every project in Android includes a Manifest XML file, which is AndroidManifest.xml, located in the root directory of its project hierarchy.
The manifest file is an important part of our app because it defines the structure and metadata of our application, its components, and its requirements. This file includes nodes for each of the Activities, Services, Content Providers, and Broadcast Receivers that make the application, and using Intent Filters and Permissions determines how they coordinate with each other and other applications.

The manifest file is also where you can declare what types of hardware or software features your app requires, and thus, which types of devices your app is compatible with. Google Play Store does not allow your app to be installed on devices that don't provide the features or system version that your app requires.

## Kotlin functions

Kotlin functions are first-class, which means they can be stored in variables and data structures, and can be passed as arguments to and returned from other higher-order functions. You can perform any operations on functions that are possible for other non-function values.

## Lambda expressions and anonymous functions

Lambda expressions and anonymous functions are function literals. Function literals are functions that are not declared but are passed immediately as an expression

```
max(strings, { a, b -> a.length < b.length })
```

The function max is a higher-order function, as it takes a function value as its second argument. This second argument is an expression that is itself a function, called a function literal, which is equivalent to the following named function:

```
fun compare(a: String, b: String): Boolean = a.length < b.length
```

## Abstract Classes

abstract class is declared using the abstract keyword in front of class. An abstract class can not instantiated means we can not create object for the abstract class.
If we declare a member function as abstract then we does not need to annotate with open keyword because these are open by default.
An abstract member function doesn’t have a body, and it must be implemented in the derived class.

## Data Classes

A data class in Kotlin is a class that is designed to hold data. It is a special type of class that provides a number of features that make it easier to work with data.

## Sealed Classes

A sealed class in Kotlin is a class that can only be subclassed within the same file where it's declared. It is used to define a closed set of subclasses. This means that no new subclasses can be created outside of the file where the sealed class is defined

## Companion Objects

A companion object is a special type of object declaration that is associated with a class rather than an instance of the class. It is declared using the companion keyword inside a class declaration. Companion objects are similar to static members in Java, but they are more powerful and flexible

```kotlin
class MyClass {
    companion object {
        private val instance = MyClass()

        fun getInstance(): MyClass {
            return instance
        }
    }
}
```

## Interface

Interfaces in Kotlin can contain declarations of abstract methods, as well as method implementations. What makes them different from abstract classes is that interfaces cannot store state. They can have properties, but these need to be abstract or provide accessor implementations.

## Dp or dip

Density-independent Pixels - an abstract unit that is based on the physical density of the screen. These units are relative to a 160 dpi screen, so one dp is one pixel on a 160 dpi screen. The ratio of dp-to-pixel will change with the screen density, but not necessarily in direct proportion. Note: The compiler accepts both "dip" and "dp", though "dp" is more consistent with "sp".

## sp

Scaleable Pixels OR scale-independent pixels - this is like the dp unit, but it is also scaled by the user's font size preference. It is recommended you use this unit when specifying font sizes, so they will be adjusted for both the screen density and the user's preference.

## @Composable

Jetpack Compose is built around composable functions. These functions let you define your app's UI programmatically by describing how it should look and providing data dependencies, rather than focusing on the process of the UI's construction (initializing an element, attaching it to a parent, etc.). To create a composable function, just add the @Composable annotation to the function name.

## @Preview

In Jetpack Compose we can see the preview of our code in Android studio. It allows us to see the output without running our app.

## Modifier

A modifier in Kotlin Compose is a way to change the appearance or behavior of a composable. Modifiers can be used to set the size, padding, background color, and other properties of a composable.

## Surface

Surface is the equivalent of CardView in view system.
Surface is a Box with a Modifier.surface() and material colors and elevation, it checks elevation of ancestors to be always on top of them, and only overload below blocking touch propagation behind the surface with pointerInput(Unit) {}.

## Column

Column is a fundamental layout component used to vertically arrange composables.

## Box

Box is a versatile layout component that allows you to layer and position UI elements on top of each other. The Box stacks its child composables, allowing you to overlay them. It’s useful when you want to create complex layouts by combining multiple elements.

## LazyColumn

A LazyColumn is a vertically scrolling list that only composes and lays out the currently visible items. It’s similar to a Recyclerview in the classic Android View system.

## remember

Composable functions can use the remember API to store an object in memory. A value computed by remember is stored in the Composition during initial composition, and the stored value is returned during recomposition. remember can be used to store both mutable and immutable objects.

## mutableStateOf

Unlike remember, mutableStateOf does not automatically cache the value across recompositions. Compose does not observe changes to this object by default, so no recomposition occurs unless explicitly triggered. Use When you need a mutable state variable but don’t necessarily require it to persist across recompositions. Useful for scenarios where you only want to observe changes without caching the value.

## derivedStateOf

Use derivedStateOf when your state or key changes frequently, and you want to update your UI selectively. It allows you to create a derived state based on other states or keys. Recomposition occurs only when the derived state changes, optimizing performance.

## rememberSaveable

Use rememberSaveable to restore your UI state after an activity or process is recreated. rememberSaveable retains state across recompositions. In addition, rememberSaveable also retains state across activity and process recreation. Example - Persist state on screen rotation.

## rememberSystemUiController

System UI Controller provides easy-to-use utilities for updating the System UI bar colors within Jetpack Compose.
To control the system UI in your composables, you need to get a SystemUiController instance. The library provides the rememberSystemUiController() function which returns an instance for the current system (currently only Android).

## State Hoisting

You should hoist UI state to the lowest common ancestor between all the composables that read and write it. You should keep state closest to where it is consumed. From the state owner, expose to consumers immutable state and events to modify the state.
The lowest common ancestor can also be outside of the Composition. For example, when hoisting state in a ViewModel because business logic is involved.

More Details - https://developer.android.com/jetpack/compose/state-hoisting

## Scaffold

A Scaffold is a layout which implements the basic material design layout structure. You can add things like a TopBar, BottomBar, FAB or a Drawer.

There are a lot of apps that contain TopAppBar, Drawer, Floating Action Button, BottomAppBar (in the form of bottom navigation), Snackbar. While you can individually set up all of these in an app but takes a lot of setups. Jetpack Compose provides Scaffold Composable which can save a lot of time. It’s like a prebuilt template.

## JetPack Navigation

A set of modern tools and libraries for handling complex navigation cases in Android. Navigation Component has 3 major parts working together:

- Navigation Graph:
  An XML resource that contains all navigation-related information in one centralized location. This includes all of the individual content areas within your app, called destinations, as well as the possible paths that a user can take through your app

- NavHost:
  Hosts each navigation graph item - it swaps out each destination (composable) when users navigate to a new screen

- NavController
  (Central API) Instructs navigation to occur (Navigation.navigate(route)). An object that manages app navigation within a NavHost. The NavController orchestrates the swapping of destination content in the NavHost as users move throughout your app.

Note: Incase of navigation with hilt use `hiltViewModel` otherwise it will throw an error `Cannot create an instance of class`
https://proandroiddev.com/jetpack-compose-adding-a-hilt-viewmodel-to-navigation-28cdc95e28bb

```
val dashboardViewModel = hiltViewModel<DashboardViewModel>()
```

### Other libraries

- https://voyager.adriel.cafe/ (Voyager) - A multiplatform navigation library built for, and seamlessly integrated with, Jetpack Compose.

## companion

Kotlin provides a companion keyword that can be used to create static members for a class definition.
In other languages like Java and C#, using the static keyword to an individual function or parameter inside a class would make it a class-level variable and you would be able to access that function or parameter without an actual class instance. In Kotlin, this behavior could be achieved using companion objects.

## Coil

Coil (Coroutine Image Loader) is a Kotlin-first image loading library for Android which uses Kotlin Coroutines behind the hood. It simplifies image loading from the internet by automatically handling the network request, image caching, request cancellation, error handling, memory management, and more.

## Multiple Styles In Text

To set different styles within the same Text composable, you have to use an AnnotatedString, a string that can be annotated with styles of arbitrary annotations.
https://developer.android.com/jetpack/compose/text#multiple-styles

## IME Actions

IME Action directs the keyboard what type of action should be displayed.
Keyboard Options can be used to handle options such as to toggle auto-correct, capitalization, the keyboard type, and the IME Action as well.

## ViewModel

It expose values/data to other classes and composables - single source of truth. The data is integral and away from the lifecycle of Activity and Composables.
The ViewModel class is a business logic or screen level state holder. It exposes state to the UI and encapsulates related business logic. Its principal advantage is that it caches state and persists it through configuration changes. This means that your UI doesn’t have to fetch data again when navigating between activities, or following configuration changes, such as when rotating the screen.

## ViewModelScope

A ViewModelScope is defined for each ViewModel in your app. Any coroutine launched in this scope is automatically canceled if the ViewModel is cleared. Coroutines are useful here for when you have work that needs to be done only if the ViewModel is active. For example, if you are computing some data for a layout, you should scope the work to the ViewModel so that if the ViewModel is cleared, the work is canceled automatically to avoid consuming resources.

## GlobalScope

A global CoroutineScope not bound to any job. Global scope is used to launch top-level coroutines which are operating on the whole application lifetime and are not cancelled prematurely. Active coroutines launched in GlobalScope do not keep the process alive. They are like daemon threads.

Note: This is a delicate API. It is easy to accidentally create resource or memory leaks when GlobalScope is used. A coroutine launched in GlobalScope is not subject to the principle of structured concurrency, so if it hangs or gets delayed due to a problem (e.g. due to a slow network), it will stay working and consuming resources.

## StateFlow

StateFlow is a state-holder observable flow that emits the current and new state updates to its collectors. The current state value can also be read through its `value` property.

## Live Data

LiveData is a part of the architecture patterns. It’s basically a data holder that contains primitive/collection types. It’s used for observing changes in the view and updating the view when it is ACTIVE. Thus, LiveData is lifecycle aware. We know that ViewModels are used to communicate the data to the View. Using ViewModels alone can be a tedious and costly operation since we need to make multiple calls each time the data has to alter the View. Plus we need to store the data Model at different places. LiveData is based on the Observer Pattern and makes the communication between the ViewModel and View easy. It observes for data changes and updates the data automatically instead of us doing multiple calls in adding and deleting data references from multiple places (for example SQLite, ArrayList, ViewModel).

## MutableLiveData

MutableLiveData is used in the ViewModel and then the ViewModel only exposes immutable LiveData objects to the observers. MutableLiveData is just a class that extends the LiveData type class.

## Compose Runtime

Fundamental building blocks of Compose's programming model and state management, and core runtime for the Compose Compiler Plugin to target.

## produceState: convert non-Compose state into Compose state

produceState launches a coroutine scoped to the Composition that can push values into a returned State. Use it to convert non-Compose state into Compose state, for example bringing external subscription-driven state such as Flow, LiveData, or RxJava into the Composition.

## Proguard

Proguard is a great tool for creating a production-ready application in Android. It assists us in reducing code and making apps faster.
To make your app as small as possible, you should enable shrinking in your release build to remove unused code and resources. When enabling shrinking, you also benefit from obfuscation, which shortens the names of your app’s classes and members, and optimization, which applies more aggressive strategies to further reduce the size of your app.

## Room

The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

## Dependency Injection

Dependency injection (DI) is a technique widely used in programming and well suited to Android development. By following the principles of DI, you lay the groundwork for good app architecture.

Implementing dependency injection provides you with the following advantages:

- Reusability of code
- Ease of refactoring
- Ease of testing

Classes often require references to other classes. For example, a Car class might need a reference to an Engine class. These required classes are called dependencies, and in this example the Car class is dependent on having an instance of the Engine class to run.

There are three ways for a class to get an object it needs:

- The class constructs the dependency it needs. In the example above, Car would create and initialize its own instance of Engine.
- Grab it from somewhere else. Some Android APIs, such as Context getters and getSystemService(), work this way.
- Have it supplied as a parameter. The app can provide these dependencies when the class is constructed or pass them in to the functions that need each dependency.

## Manual Dependency Injection VS Hilt

Manual DI works fine, but as the app scales, it can be very difficult to manager dependencies.

Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.

Hilt provides a standard way to use DI in your application by providing containers for every Android class in your project and managing their lifecycles automatically. Hilt is built on top of the popular DI library Dagger to benefit from the compile-time correctness, runtime performance, scalability, and Android Studio support that Dagger provides.

Pros of Hilt:

- Reusability of code
- Ease of refactoring
- Ease of testing

## Dagger

Dagger is a fully static, compile-time dependency injection framework for Java, Kotlin, and Android.

## @AndroidEntryPoint

Marks an Android component class to be setup for injection with the standard Hilt Dagger Android components. Currently, this supports activities, fragments, views, services, and broadcast receivers.

## @HiltAndroidApp

Annotation for marking the Application class where the Dagger components should be generated.
Usage of this annotation is similar to AndroidEntryPoint with the only difference being that it only works on application classes and additionally triggers Dagger component generation.

## @Singleton

Once instance that can happen. The Singleton Pattern is a software design pattern that restricts the instantiation of a class to just “one” instance

## Factory pattern

The factory pattern is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.

```kotlin
// The superclass
abstract class VehicleFactory {
    abstract fun createVehicle(): Vehicle
}

// Subclasses
class CarFactory : VehicleFactory() {
    override fun createVehicle(): Vehicle {
        return Car()
    }
}

class TruckFactory : VehicleFactory() {
    override fun createVehicle(): Vehicle {
        return Truck()
    }
}

// Usage
val vehicleFactory: VehicleFactory = CarFactory()
val vehicle: Vehicle = vehicleFactory.createVehicle()

// The vehicle variable will now contain a Car object.
```

## DAO

Data Access Objects are the main classes where you define your database interactions. They can include a variety of query methods.

## Coroutine

A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
On Android, coroutines help to manage long-running tasks that might otherwise block the main thread and cause your app to become unresponsive.

## suspend function

Suspend function is a function that could be started, paused, and resume. One of the most important points to remember about the suspend functions is that they are only allowed to be called from a coroutine or another suspend function.

## Flow

In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. For example, you can use a flow to receive live updates from a database.

Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously. The emitted values must be of the same type. For example, a Flow<Int> is a flow that emits integer values

## Repository

The repository pattern is a design pattern that isolates the data layer from the rest of the app. The data layer refers to the part of your app, separate from the UI, that handles the app's data and business logic, exposing consistent APIs for the rest of your app to access this data.

## OKHttp

HTTP is the way modern applications network. It’s how we exchange data & media. Doing HTTP efficiently makes your stuff load faster and saves bandwidth.

## Retrofit

The Retrofit library is a type-safe REST client for Android, Java, and Kotlin, developed by Square. With the help of the Retrofit library, we can have access to a powerful framework that helps us in authenticating and interacting with APIs and sending network requests with OkHttp. With the help of this library, downloading JSON or XML data from a web API becomes easy. In a Retrofit library, once the data is downloaded, it is parsed into a Plain Old Java Object (POJO) which must be defined for each “resource” in the response. Retrofit is an easy and fast library to retrieve and upload data via a REST-based web service.

## GSON

Gson is an open-source Java library to serialize and deserialize Java objects to JSON.

## Webview

The WebView class is an extension of Android's View class that allows you to display web pages as a part of your activity layout. It does not include any features of a fully developed web browser, such as navigation controls or an address bar. All that WebView does, by default, is show a web page.

## Accomanist WebView

A library which provides a Jetpack Compose wrapper around Android's WebView.

To implement this wrapper there are two key APIs which are needed: WebView, which is provides the layout, and rememberWebViewState(url) which provides some remembered state including the URL to display.

- rememberWebViewNavigator - Creates and remembers a WebViewNavigator using the default CoroutineScope or a provided override.

- WebViewNavigator - Allows control over the navigation of a WebView from outside the composable. E.g. for performing a back navigation in response to the user clicking the "up" button in a TopAppBar.

## Gradle

Gradle is an open-source build automation tool flexible enough to build almost any type of software. A build automation tool is used to automate the creation of applications. The building process includes compiling, linking, and packaging the code.

## Maven

Maven is a powerful project management tool that is based on POM (project object model). It is used for projects build, dependency and documentation.

## Plugins DSL (Domain Specific Language)

The plugins DSL provides a convenient way to declare plugin dependencies. It works with the Gradle plugin portal to provide easy access to both core and community plugins.

```
plugins {
    id 'com.jfrog.bintray' version '1.8.5'
}
```

## Kapt vs KSP

KAPT (Kotlin Annotation Processing Tool) is a Java-based Annotation Processor, which is tied to the JVM, while KSP is a code processor which depends only on Kotlin and can be more natural to Kotlin developers.

On another note, KAPT needs to have access to Java generated stubs to modify the program input based on annotations. This stage happens after all the symbols in the program (such as types) are completely resolved. This stage takes 30% of the compiler time and can be costly.

Kotlin Symbol Processing (KSP) is an API that you can use to develop lightweight compiler plugins.

## Animatable

Animatable is a value holder that can animate the value as it is changed via animateTo. This is the API backing up the implementation of animate\*AsState. It ensures consistent continuation and mutual exclusiveness, meaning that the value change is always continuous and any ongoing animation will be canceled.

## LaunchedEffect (Side-effects in Compose)

To call suspend functions safely from inside a composable, use the LaunchedEffect composable. When LaunchedEffect enters the Composition, it launches a coroutine with the block of code passed as a parameter. The coroutine will be cancelled if LaunchedEffect leaves the composition.

## Use HTTP (without security) in Android App

HTTP refers to Hyper Text Transfer Protocol. It is a prescribed syntax to present information or transfer the data over a network. A majority of websites use the HTTP protocol to send information over the internet, including website content and API calls. Hence, HTTP requests and responses play a vital role in the proper working of an android application.

The ‘S’ in HTTPS refers to secure. Hence, HTTPS is HTTP with encryption and verification. HTTPS uses TLS(SSL) to encrypt normal HTTP requests and responses.

Android does not allow to access HTTP URLs by default. Hence, it displays the error message informing that cleartext HTTP traffic is not permitted. However, Android does not provide any hindrance while accessing HTTPS URLs. The only problem arises when the site does not support HTTPS. As cleartext support is disabled by default in Android 9 (API level 28) and above, HTTP cleartext configuration is required to access HTTP sites.

https://www.geeksforgeeks.org/android-cleartext-http-traffic-not-permitted/

## GRPC

gRPC is a powerful framework for working with Remote Procedure Calls. RPCs allow you to write code as though it will be run on a local computer, even though it may be executed on another computer.

A RPC is a form of Client-Server Communication that uses a function call rather than a usual HTTP call.

It uses IDL (Interface Definition Language) as a form of contract on functions to be called and on the data type.

gRPC is very popular in service to service calls, as often HTTP calls are harder to understand at first glance.

## Protobuf

Protobuf is the most commonly used IDL (Interface Definition Language) for gRPC. It's where you basically store your data and function contracts in the form of a proto file.

As this is in the form of a contract, both the client and server need to have the same proto file. The proto file acts as the intermediary contract for client to call any available functions from the server.

## REST vs GRPC

- REST is a set of guidelines for designing web APIs without enforcing anything. On the other hand, gRPC enforces rules by defining a .proto file that must be adhered to by both client and server for data exchange.

- REST provides a request-response communication model built on the HTTP 1.1 protocol. Therefore, when multiple requests reach the server, it is bound to handle each of them, one at a time. However, gRPC follows a client-response model of communication for designing web APIs that rely on HTTP/2. Hence, gRPC allows streaming communication and serves multiple requests simultaneously. In addition to that, gRPC also supports unary communication similar to REST.

- REST typically uses JSON and XML formats for data transfer. However, gRPC relies on Protobuf for an exchange of data over the HTTP/2 protocol.

- REST utilizing HTTP 1.1 requires a TCP handshake for each request. Hence, REST APIs with HTTP 1.1 can suffer from latency issues. On the other hand, gRPC relies on HTTP/2 protocol, which uses multiplexed streams. Therefore, several clients can send multiple requests simultaneously without establishing a new TCP connection for each one. Also, the server can send push notifications to clients via the established connection.

## Intent

An intent is a messaging object used to request any action from another app component. Intents facilitate communication between different components in several ways. The intent is used to launch an activity, start the services, broadcast receivers, display a web page, dial a phone call, send messages from one activity to another activity, and so on.

- Explicit intents are communicated between two activities inside the same application.
- Implicit intent is communicated between two activities of an application.

## Deep Linking

A deep link is a URL that is used to direct users to a specific page or specific activity within the application. We can also pass data to our application with the help of these deep links.

## Push Notification

Push notifications are small, pop-up messages sent to a user’s device by a mobile app that appear even when the app isn't open. These notifications are designed to grab attention and can convey reminders, updates, promotions, and more. Push notifications can consist of a title, a message, an image, and a URL. They can also include logos, emojis, and other elements.

Examples: https://github.com/rawhasan/compose-exercise-notifications/blob/master/app/src/main/java/com/example/notifications/MainActivity.kt

## SharedPreferences

SharedPreferences is the common way used for storing key-value pairs in local storage. A SharedPreferences object points to a file (XML) containing key-value pairs and provides simple methods to read and write them.

### Disadvantages of SharedPreferences

- They are not safe to call on UI thread although as they have asynchronous API that can appear to be safe to call on the UI thread, but which actually does disk I/O operations that might cause issues.
- It’s not safe from runtime exceptions as they throw parsing errors
- Cannot signal errors
- It doesn’t provide Type-safety

## Preferences DataStore (Jetpack DataStore a replacement for SharedPreferences)

Preferences DataStore uses key-value pairs to store smaller datasets, without defining the schema upfront. This might remind you of SharedPreferences, but only in the way it structures your data models. It was built using Kotlin coroutines and Flow to store data asynchronously, consistently, and transactionally.

![img_alt](https://miro.medium.com/v2/resize:fit:720/format:webp/1*kDQKAjnpv6VHYrQcN3ouAQ.png)

## DMAIC process

Use DMAIC (DEFINE MEASURE ANALYZE IMPROVE CONTROL) methodology to help you solve performance issues consistently

- Define the problem, improvement activity, opportunity for improvement, the project goals, and customer (internal and external) requirements.
- Measure process performance.
- Analyze the process to determine root causes of variation, poor performance (defects).
- Improve process performance by addressing and eliminating the root causes.
- Control the improved process and future process performance.

## Material Theme

Jetpack Compose offers an implementation of Material Design, a comprehensive design system for creating digital interfaces. The Material Design components (buttons, cards, switches, and so on) are built on top of Material Theming, which is a systematic way to customize Material Design to better reflect your product’s brand. A Material Theme contains color, typography and shape attributes. When you customize these attributes, your changes are automatically reflected in the components you use to build your app.

Jetpack Compose implements these concepts with the MaterialTheme composable:

```kotlin
MaterialTheme(
    colors = // ...
    typography = // ...
    shapes = // ...
) {
    // app content
}
```

Material 3 is the latest version of Google’s open-source design system.

Builder Tool - https://material-foundation.github.io/material-theme-builder/

## MVC - Model-View-Controller

This is the standard pattern that most applications use to separate the model from the view. In this format, the controller identifies the data that matches the model.

With this pattern, the frontend and backend work as separate components, and the controller will be responsible for fetching the data, rendering the requests, and ensuring smooth communication.

## MVVM Architecture (Model-View-ViewMode)

Model-View-ViewModel (MVVM) is a software design pattern that is structured to separate program logic and user interface controls. MVVM is also known as model-view-binder and was created by Microsoft architects Ken Cooper and John Gossman.

### The four main blocks for any MVVM include:

1. View
2. ViewController
3. ViewModel
4. Model
5. Provider (Extra)

#### View

The view is your Interface, which you build with React Native framework. This is the point where the user will interact with your application.
Either they will input a command, use mouse movements or press a key to trigger the ViewController from the interface.
The interface doesn’t do much except take in and give out the display data.

#### ViewController

The ViewController will take up the command and pass it on to the ViewModel. It is important to note that one ViewController can pass commands to several ViewModels. You won't need to ramp up the controllers in this case.

#### ViewModel

This is the third and most important block of the MVVM architecture. At this point, the block is not communicating with the interface directly. So, it will not know whether the interface was built using React, Vue, or any other framework. It is a JS class that you can reuse to make any application.

#### Model

This is your source for accessing the data; from here, the ViewModel and ViewController will gain the necessary output and send it to View.
This part of the architecture will find databases, network layers, and services. Your logic should be restricted to helping the model send the necessary updates to the View.

#### Provider

When working with ViewModel, you will need to inject dependencies that can help quickly collect the data and send it to the View. That’s where the provider will help.
This block doesn’t carry any logic. It is designed to connect the different blocks properly.

## SSL Pinning

SSL (Secure socket layer) Certificate Pinning, or pinning for short, is the process of associating a host with its certificate or public key. Once you know a host’s certificate or public key, you pin it to that host.

In other words, you configure the app to reject all but one or a few predefined certificates or public keys. Whenever the app connects to a server, it compares the server certificate with the pinned certificate(s) or public key(s). If and only if they match, the app trusts the server and establishes the connection.

You usually add a service’s certificate or public key at development time. In other words, your mobile app should include the digital certificate or the public key within your app’s bundle. This is the preferred method since an attacker cannot taint the pin.

#### Types of SSL Certificate Pinning

- Pin the certificate: You can download the server’s certificate and bundle it into your app. At runtime, the app compares the server’s certificate to the one you’ve embedded.

- Pin the public key: You can retrieve the certificate’s public key and include it in your code as a string. At runtime, the app compares the certificate’s public key to the one hard-coded in your code.

## Google Code Scan API

The Google code scanner API provides a complete solution for scanning codes without requiring your app to request camera permission, while preserving user privacy. This is accomplished by delegating the task of scanning the code to Google Play services and returning only the scan results to your app. All image processing occurs on the device and Google doesn't store the results or image data. The API supports the same code formats as the ML Kit Barcode Scanning API and returns the same Barcode object.

This API is ideal for apps that simply need to scan a code and don’t require a custom UI or camera experience. The implementation resides entirely within Google Play services, so there is no significant impact to the size of your app. For more complex use cases that require a custom UI, use the ML Kit Barcode Scanning API directly.

## callbackFlow

callbackFlow is designed to transform callback-based types to stream-based types

### Await Close

Suspends the current coroutine until the channel is either closed or cancelled and invokes the given block before resuming the coroutine.

## Glance Widget

Glance provides a modern approach to build app widgets using Compose, but is restricted by the limitations of AppWidgets and RemoteViews. Therefore, Glance uses different composables from the Jetpack Compose UI. The provideGlance method is used to load data in an app widget created with Glance.

### AppWidgetProviderInfo

AppWidgetProviderInfo is an object in Android that defines the essential qualities of a widget. It can be defined in an XML resource file.

### GlanceAppWidgetReceiver

GlanceAppWidgetReceiver is a BroadcastReceiver class that helps observe the lifecycle of an app widget. It wires the receiver and the GlanceAppWidget instance, manages events, and refreshes its content when necessary. For example, when you drag and drop an app widget for the first time, onEnabled() will be called.

### Glance ActionCallback

Glance ActionCallback is a callback that performs an action when notified for a specific compose or view. It is used to handle widget actions. ActionCallback is executed in response to user action, before the content is updated.

## Kotlin Multiplatform

Kotlin Multi Platform Wizard - https://kmp.jetbrains.com/

Kotlin Multiplatform (KMP) is a software development kit (SDK) that allows developers to share code across different platforms. It's an open-source technology from JetBrains that lets developers create applications for Android, iOS, desktop, web, and other platforms. KMP allows developers to reuse code across platforms while maintaining the benefits of native programming. For example, developers can create cross-platform mobile applications that share code between Android and iOS project

KMP supports the following platforms: Android, iOS, Desktop, Web, and Server-side.

Google is experimenting with KMP, focusing on sharing business logic between Android and iOS. As part of this work, Google is converting some Jetpack libraries to multiplatform, but these libraries don't have Jetpack's usual stability guarantees for non-Android targets.

### Compose Multiplatform

Compose Multiplatform is a declarative framework for sharing user interfaces (UIs) across multiple platforms, including iOS, Android, desktop, and web. It's based on Kotlin and Jetpack Compos.

Compose Multiplatform allows you to:

- Build your UI once and use it on all platforms
- Use the same APIs from Jetpack Compose to build UIs for all platforms
- Use a variety of production-ready Kotlin libraries and frameworks
- Easily access the full capabilities of every platform
- Build your UIs with customizable widgets

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:

  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

#### Koin

Koin is the Kotlin Multiplatform (KMP) integration framework. You can write code once and deploy it on multiple platforms, with KMP as the main cross-platform technology, and Koin as the Dependency Injection framework.

#### Version catalogs - libs.version.toml

Gradle version catalogs enable you to add and maintain dependencies and plugins in a scalable way. Using Gradle version catalogs makes managing dependencies and plugins easier when you have multiple modules. Instead of hardcoding dependency names and versions in individual build files and updating each entry whenever you need to upgrade a dependency, you can create a central version catalog of dependencies that various modules can reference in a type-safe way with Android Studio assistance.
Start by creating a version catalog file. In your root project's gradle folder, create a file called libs.versions.toml.

## AAR (Android Library)

An Android Archive (AAR) file is a package file format that contains the compiled output of an Android library project, including resources, compiled code, and an Android manifest. AAR files can be used as a dependency for an Android app module. They can contain: Android resources, A manifest file, Shared resources like layouts and drawables, Kotlin or Java classes and methods, and C/C++ libraries for use by the app module's C/C++ code.

## Animations

- `tween`: a tween animation is a fundamental form of animation where an object smoothly transitions from one state to another over a specified duration. The term “tween” stands for the concept of transitioning between two values.
  In this example, the alpha property smoothly transitions between 1.0 (fully opaque) and 0.5 (semi-transparent) based on the enabled state. The animation duration is 300 milliseconds, and the easing curve is set to FastOutSlowInEasing.

```kotlin
val alpha: Float by animateFloatAsState(
    targetValue = if (enabled) 1f else 0.5f,
    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
)
```

- `animateDpAsState`: function is a convenient way to create animated properties for composables. It returns a State<Dp> object, which continuously updates its value during the animation until the animation completes. Note that you cannot stop or cancel the animation at runtime using animateDpAsState unless you remove the composable from the tree.
