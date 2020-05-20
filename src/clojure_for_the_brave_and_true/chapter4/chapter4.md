# Core Functions in Depth

## Programming to Abstractions

* Functions are defined in terms of the sequence abstraction, 
not in terms of specific data structures

### Treating Lists, Vectors, Sets, and Maps as Sequences

* Lists, Vectors, Sets and Maps implement the sequence abstraction

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

```

```clojure

```

### concat 

```clojure

```