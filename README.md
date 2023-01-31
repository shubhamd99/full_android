# Android Development

![img_alt](https://i.imgur.com/ai9Kpdi.png)

## Declarative vs Imperative UI in Android

Every application has a UI framework behind it. These frameworks play a huge part in how the applications are created and their performance as well. They also have different ways of operation but can be summarized into two: declarative and imperative.

* Imperative UI This is the most common paradigm. It involves having a separate prototype/model of the application’s UI. This design focuses on the how rather than the what. A good example is XML layouts in Android. We design the widgets and components which are then rendered for the user to see and interact with. Too complicated - a lot of moving parts. UI is coupled with the logic and vice versa. For example: to render a list witha a few items, you'll need to Create Recycler View which needs an adapter and each list item needs a view holder.

* Declarative UI This pattern is an emerging trend that allows the developers to design the user interface based on the data received. This on the other hand focuses on the what. This design paradigm makes use of one programming language to create an entire application.

* Before Jetpack compose, themes were set in the manifest files. The various style attributes were declared in the resources folder in XML files too. You also had Material design classes for the themes.

* In imperative UI, state management was not as easy as in declarative UI. Since the user interface was created using a tree of widgets, it became more error prone as the tree grew. To reflect a change in the data, you had to go through the widget tree to find the specific widget to update.

## Pros of Declarative UI

* No more manually updating each widget (setters and getters)
* No more XML UIs
* Data is passed down from the main function
* Events are sent up
* Recomposition - is the process of calling your composable function again when inputs change

## Cons of Imperative UI

* Traverse widget tree (expensive)
* Increase errors
* Changing the internal state of the widget manually
* Update conflicts happen

## Jetpack
Modern Android Development with Declarative UI Approach.
Jetpack is a suite of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices so that developers can focus on the code they care about.

Jetpack compose also comes with a pre-configured Material design theme. You can customize this theme to meet your own demands in an easier way. It provides properties like shapes, typography and colors in the MaterialTheme composable.

## Arch of Data use
![im_alt](https://i.imgur.com/pbblTIQ.png)

## Context
It's the context of current state of the application/object. It lets newly-created objects understand what has been going on. Typically, you call it to get information regarding another part of your program (activity and package/application).

* It allows us to access resources.
* It allows us to interact with other Android components by sending messages.
* It gives you information about your app environment.

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


## Dp or dip
Density-independent Pixels - an abstract unit that is based on the physical density of the screen. These units are relative to a 160 dpi screen, so one dp is one pixel on a 160 dpi screen. The ratio of dp-to-pixel will change with the screen density, but not necessarily in direct proportion. Note: The compiler accepts both "dip" and "dp", though "dp" is more consistent with "sp".

## sp
Scaleable Pixels OR scale-independent pixels - this is like the dp unit, but it is also scaled by the user's font size preference. It is recommended you use this unit when specifying font sizes, so they will be adjusted for both the screen density and the user's preference. 

## @Composable
Jetpack Compose is built around composable functions. These functions let you define your app's UI programmatically by describing how it should look and providing data dependencies, rather than focusing on the process of the UI's construction (initializing an element, attaching it to a parent, etc.). To create a composable function, just add the @Composable annotation to the function name.

## @Preview
In Jetpack Compose we can see the preview of our code in Android studio. It allows us to see the output without running our app. 

## Surface
Surface is the equivalent of CardView in view system.
Surface is a Box with a Modifier.surface() and material colors and elevation, it checks elevation of ancestors to be always on top of them, and only overload below blocking touch propagation behind the surface with pointerInput(Unit) {}.

## LazyColumn
A LazyColumn is a vertically scrolling list that only composes and lays out the currently visible items. It’s similar to a Recyclerview in the classic Android View system.

## remember 
Composable functions can use the remember API to store an object in memory. A value computed by remember is stored in the Composition during initial composition, and the stored value is returned during recomposition. remember can be used to store both mutable and immutable objects.

## State Hoisting
You should hoist UI state to the lowest common ancestor between all the composables that read and write it. You should keep state closest to where it is consumed. From the state owner, expose to consumers immutable state and events to modify the state.
The lowest common ancestor can also be outside of the Composition. For example, when hoisting state in a ViewModel because business logic is involved.

More Details - https://developer.android.com/jetpack/compose/state-hoisting

## Scaffold

A Scaffold is a layout which implements the basic material design layout structure. You can add things like a TopBar, BottomBar, FAB or a Drawer.

There are a lot of apps that contain TopAppBar, Drawer, Floating Action Button, BottomAppBar (in the form of bottom navigation), Snackbar. While you can individually set up all of these in an app but takes a lot of setups. Jetpack Compose provides Scaffold Composable which can save a lot of time. It’s like a prebuilt template. 

## JetPack Navigation

A set of modern tools and libraries for handling complex navigation cases in Android. Navigation Component has 3 major parts working together:

* Navigation Graph:
An XML resource that contains all navigation-related information in one centralized location. This includes all of the individual content areas within your app, called destinations, as well as the possible paths that a user can take through your app

* NavHost:
Hosts each navigation graph item - it swaps out each destination (composable) when users navigate to a new screen

* NavController
(Central API) Instructs navigation to occur (Navigation.navigate(route)). An object that manages app navigation within a NavHost. The NavController orchestrates the swapping of destination content in the NavHost as users move throughout your app.

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

## StateFlow
StateFlow is a state-holder observable flow that emits the current and new state updates to its collectors. The current state value can also be read through its `value` property.

## Room
The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

## Dependency Injection
Dependency injection (DI) is a technique widely used in programming and well suited to Android development. By following the principles of DI, you lay the groundwork for good app architecture.

Implementing dependency injection provides you with the following advantages:

* Reusability of code
* Ease of refactoring
* Ease of testing

Classes often require references to other classes. For example, a Car class might need a reference to an Engine class. These required classes are called dependencies, and in this example the Car class is dependent on having an instance of the Engine class to run.

There are three ways for a class to get an object it needs:

* The class constructs the dependency it needs. In the example above, Car would create and initialize its own instance of Engine.
* Grab it from somewhere else. Some Android APIs, such as Context getters and getSystemService(), work this way.
* Have it supplied as a parameter. The app can provide these dependencies when the class is constructed or pass them in to the functions that need each dependency. 

## Manual Dependency Injection VS Hilt
Manual DI works fine, but as the app scales, it can be very difficult to manager dependencies.

Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.

Hilt provides a standard way to use DI in your application by providing containers for every Android class in your project and managing their lifecycles automatically. Hilt is built on top of the popular DI library Dagger to benefit from the compile-time correctness, runtime performance, scalability, and Android Studio support that Dagger provides. 

Pros of Hilt:

* Reusability of code
* Ease of refactoring
* Ease of testing

## Dagger
Dagger is a fully static, compile-time dependency injection framework for Java, Kotlin, and Android.

## @AndroidEntryPoint
Marks an Android component class to be setup for injection with the standard Hilt Dagger Android components. Currently, this supports activities, fragments, views, services, and broadcast receivers.

## @HiltAndroidApp
Annotation for marking the Application class where the Dagger components should be generated. 
Usage of this annotation is similar to AndroidEntryPoint with the only difference being that it only works on application classes and additionally triggers Dagger component generation.

## @Singleton
Once instance that can happen. The Singleton Pattern is a software design pattern that restricts the instantiation of a class to just “one” instance

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