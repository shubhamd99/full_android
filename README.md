# Android Development

![img_alt](https://i.imgur.com/ai9Kpdi.png)

## Jetpack
Modern Android Development with Declarative UI Approach.
Jetpack is a suite of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices so that developers can focus on the code they care about.

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