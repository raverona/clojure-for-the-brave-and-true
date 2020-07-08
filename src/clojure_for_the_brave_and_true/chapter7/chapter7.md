# Clojure Alchemy: Reading, Evaluation, and Macros

* Macros allow you to transform arbitrary expressions into valid Clojure, so you can extend the language itself to fit your needs.

## An Overview of Clojure’s Evaluation Model

* Clojure has a two-phase evaluation model
    * It _reads_ textual source code, producing Clojure data structures
    * It _evaluates_ these data structures traversing the data structures and performing actions like function application or var lookup
    * Languages that have this relationship between source code, data, and evaluation are called _homoiconic_.
    
* Non-Lisp programming languages evaluation process includes
    * parsing code into an _abstract syntax tree_ (AST)
        * which is inaccessible within the programming language
    * evaluating the AST the produce machine code
    
* Clojure (and Lisps) evaluation process includes
    * converting the text to a list (a native data structure)
    * evaluating the tree formed by the list and producing a result
        * you can send data structures directly to the Clojure evaluator with `eval`

```clojure
(eval form) ; evaluates the form and returns its result
```

* So Clojure is homoiconic: it represents abstract syntax trees using lists, and you write textual representations of lists when you write Clojure code.

## The Reader

* The reader converts the textual source code you save in a file or enter in the REPL into Clojure data structures.

### Reading

* Textual representation of data structures is called a _reader form_.
* The `read-string` function takes a string as an argument and processes it using Clojure’s reader, returning a data structure

```clojure
(read-string some-string) ; translates a string into clojure data structures
```

### Reader Macros

* Reader macros are sets of rules for transforming text into data structures.
* They’re designated by macro characters, like `'`, `#`, `@` and `;`
* The reader expands reader macros when it finds one of them.

## The Evaluator

* You can think of Clojure’s evaluator as a function that takes a data structure as an argument, processes the data structure using rules corresponding to the data structure’s type, and returns a result.

### These Things Evaluate to Themselves

* Whenever Clojure evaluates data structures that aren’t a list (except an empty one) or symbol, the result is the data structure itself
    * Ex: `true`, `false`, `{}`, `:some-keyword`, `()`
    
### Symbols

* In general, Clojure resolves a symbol by:
  1. Looking up whether the symbol names a special form. If it doesn’t . . .
  2. Looking up whether the symbol corresponds to a local binding. If it doesn’t . . .
  3. Trying to find a namespace mapping introduced by def. If it doesn’t . . .
  4. Throwing an exception
  
### Lists

* If it is not empty it evaluates to a call to the first element

#### Function Calls

* When performing a function call, each operand is fully evaluated and then passed to the function as an argument.

#### Special Forms

* _special forms_ are special because they implement core behavior that can’t be implemented with functions.
* Special forms don’t follow the same evaluation rules as normal functions.
    * Ex: with `if` you don’t want each operand to be evaluated; with `'` it tells the evaluator, “Instead of evaluating my next data structure like normal, just return the data structure itself.”
* `def`, `let`, `loop`, `fn`, `do`, and `recur` are all special forms as well.

### Macros

* Macros allow you to transform an arbitrary data structure like `(1 + 2)` into one that can Clojure can evaluate, like `(+ 1 2)`.
* Macros are different from a function call, because function calls always evaluate all of the arguments passed in. By contrast, when you call a macro, the operands are not evaluated. In particular, symbols are not resolved; they are passed as symbols. Lists are not evaluated either; that is, the first element in the list is not called as a function, special form, or macro.
* Another difference is that the data structure returned by a function is not evaluated, but the data structure returned by a macro is. 
    * The process of determining the return value of a macro is called _macro expansion_
    
```clojure
(macroexpand 'macro-form) ; returns the data structure `macro-form` returns before that data structure is evaluated
```

* The best way to think about this whole process is to picture a phase between reading and evaluation: the _macro expansion_ phase.
* Macros mean you can use Clojure to _extend itself_ so you can write programs however you please. In other words, macros enable _syntactic abstraction_.

### Syntactic Abstraction and the -> Macro

* the `->` macro, aka the _threading_ or _stabby_ macro gets the result of the form and inserts it as the first argument of the next expression, the result of that expression gets inserted as the first parameter of the next expression and so on for every expression
    * It is the same as nesting function calls but more human readable
    * This is a _syntactic abstraction_ because it lets you write code in a syntax that’s different from Clojure’s built-in syntax.