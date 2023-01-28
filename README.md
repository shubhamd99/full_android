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