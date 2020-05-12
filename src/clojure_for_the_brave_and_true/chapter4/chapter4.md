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