# Functional Programming

## Pure Functions: What and Why

* A function is pure if it meets two qualifications:
    * It always returns the same result if given the same arguments (_referential transparency_).
    * It can’t cause any side effects. That is, the function can’t make any changes that are observable outside the function itself.
* Pure functions are completely isolated, consistent, stable and problem free.

### Pure Functions Are Referentially Transparent

* To be Referentially Transparent functions must rely only on the following things to determine their return value: 
    * their own arguments
    * immutable values
* If the function reads from a file or generates a random number it is not referentially transparent as the file content is not immutable and the number generated changes with each execution.
* With Referentially Transparent functions you never have to consider what possible external conditions could affect the return value of the function, changes to external conditions won’t cause your code to break.

### Pure Functions Have No Side Effects

* To perform a side effect is to change the association between a name and its value within a given scope.
* Some side effects are necessary (ex: writing to disk, changing RGB values of your monitor pixels, etc).
* When you call a function that doesn’t have side effects, you only have to consider the relationship between the input and the output. You don’t have to worry about other changes that could be rippling through your system.
* Functions with side effects makes you worry about how the world is affected when you call the function. Every function that depends on a side-effecting function gets infected by this worry.

## Living with Immutable Data Structures

* Immutable data structures ensure that your code won’t have side effects.

### Recursion Instead of for/while

* mutating _internal_ variables, such as _i_ in `for(i = 0; i < 10; i++)`, is a side effect.
* each recursive call creates a new scope and same names are bounded to different values.
* using `recur` prevents stack overflow.

### Function Composition Instead of Attribute Mutation

* Combining functions so that the return value of one function is passed as an argument to another is called _function composition_.
* In functional programming you think of data as unchanging, and you derive new data from existing data. During this process, the original data remains safe and sound.

## Cool Things to Do with Pure Functions

* You can derive new functions from existing functions in the same way that you derive new data from existing data.

### comp

```clojure
(comp f1 f2 ... fn) ; returns a function g such that g(x1, x2, ... xn) = f1(f2(...fn(x1, x2, ... xn)...))
```

* The first function applied can take any number of arguments, whereas the remaining functions must be able to take only one argument.
* If one of the functions you want to compose needs to take more than one argument wrap it in an anonymous function.

### memoize

```clojure
(memoize fn) ; stores the arguments passed to `fn` and the return value of the it. That way, subsequent calls to the function with the same arguments can return the result immediately
```

## Peg Thing

### assoc-in

```clojure
(assoc-in map [k1 k2 ... kn] value) ; creates the nested map {k1 {k2 ... {kn value}...}} inside `map`
```

### get-in

```clojure
(get-in map [k1 k2 ... kn]) ; gets the value associated with `kn` nested within {k1 {k2 ... {kn value}...}} inside `map`
```