# Core Functions in Depth

## Programming to Abstractions

* Functions are defined in terms of the sequence abstraction, 
not in terms of specific data structures

### Treating Lists, Vectors, Sets, and Maps as Sequences

* lists, vectors, sets and maps implement the sequence abstraction
* The sequence abstraction is about operating on members individually

#### first, rest and cons

```clojure
(first seq) ; returns the first element of `seq`
```

```clojure
(rest seq) ; returns `seq` minus it's first element
```

```clojure
(cons element seq) ; returns a seq with `element` prepended to `seq`
```

```clojure
(defn map
  [fn seq]
  (if-not (empty? seq)
    (cons (fn (first (seq))) (map fn (rest seq)))))
```

* `first`, `rest` and `cons` are the 3 core functions on a list
* Functions like `map` can be implemented on top of those 3
* That way you can use `map` with any data structure as long as it works with the 3 core functions

#### Abstraction Through Indirection

* In programming, _indirection_ is a generic term for the mechanisms a language employs so that one name can have multiple, related meanings
* Indirection is what makes abstraction of data structures possible
* _Polymorphism_ is one way that Clojure provides indirection
* The `seq` function also provides indirection by doing lightweight type conversion, producing a data structure that works with an abstraction’s functions

## Seq Function Examples

### map

```clojure
(map function seq)

(map function seq1 seq2 seq3 ...)
```

* Applies `function` to every element of `seq` and puts them in a list
* If more than a `seq` is provided the function has to accept a number of parameters equal to the number of `seq` provided and it will apply to each element of them until one ends, put the result in a list and ignore the rest of the elements

### reduce

```clojure
(reduce function val seq) 
```

* Returns the result of applying `function` to `val` and the first item of `seq`, then applying `function` to that result and so on
    * If `val` is not supplied it starts applying `function` to the first two items of `seq`
* Can be used to update values in a map
* Can be used to filter keys from a map

### take, drop, take-while, and drop-while

```clojure
(take number seq) ; returns the first `number` elements in `seq`
```

```clojure
(drop number seq) ; returns `seq` with the first `number` elements removed
```

```clojure
(take-while pred seq) ; applies `pred` to the elements of `seq` and returns them until the first which `pred` returns false to
```

```clojure
(drop-while pred seq) ; applies `pred` to the elements of `seq` and returns the elements after the first which `pred` returns false to
```

* `take-while` and `drop-while` can be used together to get an interval of a sequence that does not include the first and the last elements

### filter and some

```clojure
(filter pred seq) ; returns all elements from `seq` that test true for a predicate `pred`
```

* `filter` always processes all elements, therefore `take-while` and `drop-while` can be more efficient

```clojure
(some pred seq) ; test the elements of `seq` against `pred` and returns the first truthy value returned by `pred`
```

### sort and sort-by

```clojure
(sort seq) ; sort elements in ascending order
```

```clojure
(sort-by key-fn seq) ; sort elements based on the value returned by `key-fn` when applied to them
```

### concat 

```clojure
(concat one-seq another-seq) ; append the elements of `another-seq` to the end of `one-seq`
```

## Lazy Seqs

* A lazy seq is a seq whose members aren’t computed until you try to access them
* `map` and `filter, for example, return a lazy seq`
* Computing a seq’s members is called _realizing_ the seq
* Makes programs more efficient and allow you to construct infinite sequences

### Demonstrating Lazy Seq Efficiency

* whenever Clojure has to realize an element, it preemptively realizes some of the next elements as well
* lazy seq elements need to be realized only once

### Infinite Sequences

```clojure
(repeat element) ; creates an infinite sequence where every item is `element`
```

```clojure
(repeatedly fn) ; creates an infinite sequence where each element is generated calling `fn`
```

```clojure
(lazy-seq body) ; creates a recipe for the next item
```

## The Collection Abstraction

* vectors, maps, lists, and sets also take part in the collection abstraction
* the collection abstraction is about the data structure as a whole

### into

```clojure
(into one-coll another-coll) ; adds the elements of `another-coll` into `one-coll`
```

### conj

```clojure
(conj coll & elements) ; adds each one of `elements` into `coll`
```

## Function Functions

### apply

```clojure
(apply fn seq) ; explodes a `seq` so it can be passed to `fn`, a function that expects a rest parameter
```

### partial

```clojure
(partial fn & args) ; returns a function consisting of `fn` with `args` as its arguments 
```

### complement

```clojure
(complement fn) ; returns a function that returns the opposite of `fn`
```

## A Vampire Data Analysis Program for the FWPD

```clojure
(slurp f & opts) ; opens a reader on `f` and reads all its contents
```