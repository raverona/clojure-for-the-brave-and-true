# Organizing Your Project: A Librarian’s Tale

## Your Project as a Library

* _Namespaces_ maps _symbols_ to _vars_
* Namespaces are objects of type `clojure.lang.Namespace`
* `*ns*` refers to the current namespace
* `(ns-name namespace)` is used to get the namespace name
* In Clojure programs, you are always in a namespace.
* Symbols are data types within Clojure
    * When you give Clojure a symbol, it finds the corresponding var in the current namespace, and retrieves the object on the var address for you
    *  If you want to just use the symbol itself, and not the thing it refers to, you have to quote it
        * quoting can be achieved using `'` or the function `quote
       
    
## Storing Objects with def

* The primary tool in Clojure for storing objects is `def`. Other tools like `defn` use `def under the hood.

```clojure
(def great-books ["East of Eden" "The Glass Bead Game"])
; => #'user/great-books
```

* This code tells Clojure:
  1. Update the current namespace’s map with the association between `great-books` and the var.
  2. Store ["East of Eden" "The Glass Bead Game"] on a memory address.
  3. Write the address on the var.
  4. Return the var (in this case, `#'user/great-books).`

* This process is called _interning_ a var.
* The function `ns-interns` returns a map of interned vars 
* The function `ns-map` returns the full map that the namespace uses for looking up a var when given a symbol
* `#'user/great-books is the reader form of a var.`
* `#'user/great-books` lets you use the var associated with the symbol great-books within the user namespace
* The function `deref` returns the object a var points to
* Calling `def` on a symbol that has already associated with a var overwrites the var and the previous one is no longer accessible
    * This is referred to as a _name collision_
    * Clojure allows you to create as many namespaces as you like so you can avoid these collisions
    
## Creating and Switching to Namespaces

```clojure
(create-ns 'ns-symbol)
```

* Creates a namespace with `ns-symbol` as its name.

```clojure
(in-ns 'ns-symbol)
```

* Creates a namespace with `ns-symbol` as its name and switches to it.

* To use objects from other namespaces use a _fully qualified_ symbol.
    * The general form is namespace`/`name

### refer

```clojure
(refer 'ns-symbol & filters)
```

* Calling `refer` with a `ns-symbol` lets you refer to the objects in the `ns-symbol` namespace without having to use fully qualified symbols. 
    * It does this by updating the current namespace’s symbol/object map.
* Available filters are `:only`, `:exclude`, and `:rename`
    * ```clojure
      (refer 'some-ns :only ['some-symbol])
      ```
    * ```clojure
      (refer 'some-ns :exclude ['some-symbol])
      ```
    * ```clojure
      (refer 'some-ns :rename {'some-symbol 'some-other-symbol})
      ```

* Private functions are defined using `defn-`
    * even if you explicitly refer the function, you can’t use the function from another namespace, because you made it private.

### alias

```clojure
(alias 'ns-alias 'some-ns-symbol)
```

* `alias` lets us call symbols from the `some-ns-symbol` namespace with the shorter alias `ns-alias`

## Real Project Organization

### The Relationship Between File Paths and Namespace Names

* `ns` is the primary way to create and manage namespaces within Clojure. It is very similar to `in-ns`
* The source code’s root is the `src` folder by default.
* Dashes in namespace names correspond to underscores in the file­system. 
* The component preceding a period (.) in a namespace name corresponds to a directory.
* The final component of a namespace corresponds to a file with the .clj extension

### Requiring and Using Namespaces

```clojure
(require 'ns-symbol) ; reads and defines the symbols in the `ns-symbols` namespace
```

* After requiring a namespace its symbols can be accessed with `ns-symbol/symbol`
    * Using `(refer 'ns-symbols)` right after its symbols can be accessed only with `symbol`

```clojure
(require '[ns-symbol :as ns-s]) ; :as can be used to alias the namespace while requiring it
```

```clojure
(use 'ns-symbol) ; `use` combines `require` and `refer`, it also supports aliasing with :as
```

### The ns Macro

* `ns` incorporates `require`, `use`, `in-ns`, `alias`, and `refer`
* In the `ns` form the namespace symbol does not have to be quoted
* `ns` refers the `clojure.core` namespace by default
    * You can control what gets referred from clojure-core with `:refer-clojure`
        * ```clojure
          (ns my-namespace
            (:refer-clojure :exclude [println]))
          ```
* There are six possible kinds of _references_ within `ns`
    * `(:refer-clojure)`
    * `(:require)`
    * `(:use)`
    * `(:import)`
    * `(:load)`
    * `(:gen-class)`
    
* `(:require)` works like `require`
    * It can be used to require multiple libraries
    * It also allows you to refer some or all names
        ```clojure
        (ns some-namespace
          (:require [some-other-namespace :as o-ns]
                    [another-namespace :as a-ns]
                    [only-some-symbol-will-be-referred-from-this-ns :refer [some-symbol]]
                    [all-symbols-will-be-referred-from-this-ns :refer :all]))
        ```

## To Catch a Burglar

```clojure
(zipmap keys values) ; returns a map with the elements in `keys` mapped to the elements in `values`
```

```clojure
(merge-with f & maps) ; merge all `maps`, if a key occurs in more than one map it will be combined with (f val-from-result val-from-latter)
```