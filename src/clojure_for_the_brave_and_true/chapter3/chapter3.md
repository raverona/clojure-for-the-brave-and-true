# Chapter 3: Do Things: A Clojure Crash Course

## Syntax

### Forms

#### Literals

```clojure
1 ;numbers
"some string" ;strings
\a ; characters
nil ; null
true
false ; booleans
:some-keyword ;keywords
```

#### Operations

```clojure
(operator operand1 operand2 ... operandn)
```

* commas = whitespaces

### Control Flow

#### If

```clojure
(if boolean-form
  then-form
  optional-else-form)
```

* returns `then-form` if `boolean-form` evaluates to `true`
* returns `optional-else-form` if `boolean-form` evaluates to `false`
* else branch can be omitted
    * returns `nil` if `boolean-form` evaluates to `false`
    
#### Do

```clojure
(if boolean-form
  (do some-then-form
      another-then-form)
  (do some-optional-else-form
      another-optional-else-form))
```

* lets you do multiple actions inside the if expression's branches

#### When

```clojure
(when boolean-form
    some-then-form
    another-then-form)
```

* combination of `if` and `do`
* when `boolean-form` evaluates to `true`, do `some-then-form` and `another-then-form`
* always returns `nil` when `boolean-form` evaluates to `false`

#### nil, true, false, Truthiness, Equality, and Boolean Expressions

```clojure
(nil? some-value) ; checks if `some-value` is `nil`
```

* `nil` and `false` represent logical falseness
    * all other values are logically truthy
    
```clojure
(= 1 1) ; = is the equality operator
(== 1.0 1) ; == is the equality operator for numbers across different categories
```

* = can compare different types of sequential collections

* `or` returns the first truthy value or the last one
* `and` returns the first falsy or the last truthy 

### Def

```clojure
def some-value "a-value" ; `def` binds the string `"a-value"` to the name `some-value`
```

## Data Structures

### Numbers

```clojure
42 ; Long
3.14 ; Float
1/5 ; Ratio
1N ; BigInt
1M ; BigDecimal
```

* Operations with BigInt and floating point types will result in BigInt and double, respectively

### Strings

```clojure
"some string"
"\"some quote\""
```

* single quotes are not allowed to delineate strings

### Maps

```clojure
{} ; empty map
{:some-keyword some-value} ; `some-value` can be pretty much anything, a number, a function, a string, a map, ...

(hash-map key1 value1 key2 value2 ...) ; `hash-map` function creates maps

(get map-name key default-value?) ; `get` is used to look up keys, returns `nil` (or `default-value` when supplied) if `key` is not present in `map-name`
(get-in map-name [keys]) ; `get-in` is used to look up nested keys
(map-name key) ; another way to look up a key is passing it as argument to the map
```

### Keywords

```clojure
:some-keyword

(:keyword {:keyword value} default-value?) ; is equivalent to (get {:keyword value} :keyword default-value?)
```

### Vectors

```clojure
[0 1 2 3]
(vector 0 1 2 3)

(get vector-name index) ; look up value at index `index` of vector `vector-name`

(conj vector-name value) ; appends `value` to `vector-name`
```

### Lists

```clojure
'(1 2 3 4)
(list 1 2 3 4)

(nth list-name index) ; look up value at index `index` of list `list-name`, it is slower than `get` on vectors
(conj list-name value) ; prepends `value` to `list-name`
```

### Sets

```clojure
#{1 2 3}
(hash-set 1 2 3)

(conj set-name value) ; includes `value` to `set-name` if it is not already there
(set vector-or-list) ; creates a set from the vector or list `vector-or-list`
(contains? set-name value) ; in addition to get and keywords, membership within a set can be checked with the `contains` function
```

## Functions

### Calling Functions

```clojure
(function-name parameter1 parameter2 ... parameterN)
```

### Defining Functions

```clojure
(defn function-name
    "a string that describes the function"
    [parameters]
    function-body)
```

#### Parameters and arity

```clojure
(defn multi-arity
  ([first-arg second-arg]
     (do-things first-arg second-arg))
  ([first-arg]
     (do-things first-arg)))

(defn favorite-things
  [name & things] ; rest parameter puts all other arguments in a list
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))
```

#### Destructuring

```clojure
(defn destructuring-a-vector-or-a-list
  [[first-element second-element & all-other-elements]]
  function-body)

(defn destructuring-a-map
➊   [{some-map-value :some-map-key another-map-value :another-map-key}]
  function-body)

(defn another-way-to-destructure-a-map
  [{:keys [some-key-name another-key-name]}] ; the symbol `some-key-name` is associated with the value from the key `:some-key-name`
  function-body)

(defn another-way-to-destructure-a-map
  [{:keys [some-key-name]} :as map-name] ; `:as` is used to retain access to the map
  function-body)
```

#### Function Body

* Can contain forms of any kind
* Returns the last form evaluated

### Anonymous Functions

```clojure
(fn [param-list]
  function-body)

#(function-body)
```

* in the `#` form parameters are accessed with the `%` symbol
    * if `%` is not present at the function body the function is created with arity 0
    * if `%` is present at the function body the function has arity 1
    * to access multiple arguments use `%1`, `%2`, `%3` and so on
        * `%` and `%1` are equivalent
        * `%&` is used to represent a rest parameter
        
### Returning Functions

```clojure
(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)
; => 10
```

## Putting It All Together

### Let

```clojure
(let [name value])
```

* binds names to values
* creates a new scope

### Loop

```clojure
(loop [symbol-name initial-value]
  do-something
  (recur next-iteration-value-for-symbol-name))
```

### Regular Expressions

```clojure
#"regular-expression"
```

* the `re-find` function tests is a string matches a pattern