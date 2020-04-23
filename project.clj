(defproject clojure-for-the-brave-and-true "0.1.0-SNAPSHOT"
  :description "A library with functions from the exercises of the book 'Clojure For The Brave And True'"
  :url "https://github.com/raverona/clojure-for-the-brave-and-true/"
  :license {:name "EPL-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "1.0.0"]]}}
  :repl-options {:init-ns clojure-for-the-brave-and-true.core})
