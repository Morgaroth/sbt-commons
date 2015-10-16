[![Stories in Ready](https://badge.waffle.io/Morgaroth/sbt-commons.png?label=ready&title=Ready)](http://waffle.io/Morgaroth/sbt-commons)

# sbt-commons

## Main goal of project
Main goal of this sbt plugin is provinding various libraries for sbt as normal classes and values.
This helps in looking for some library by name with IDE completions.
Moreover, for libraries published to other than sonatype or maven repos, there is hardcoded link to them one, as Resolvers.

Additionally, on start plugin checks if there is newer version published and informs user about it.

## Contents

* **spray.io** libraries (can, client, http, httpx, caching, routing, testkit)
* **akka** libraries (actor, stream, http)
* **Typesafe config**
* **Ficus config**
* **Slick**
* Pathikrit's **better-files** library
* **uPickle**
* **Joda time** and **convert**
* **Salat**, [project site](https://github.com/salat/salat)
* **ScalaTest**
* **Paradise** plugin for macros
* **PBKDF2-scala** library for calculating pbkdf2 hash, by nremond [project site](https://github.com/nremond/pbkdf2-scala)
* **Jumblr** API library for [tumblr.com](https://github.com/tumblr/jumblr)

## Versions

* **0.13** ```addSbtPlugin("io.github.morgaroth" %% "sbt-commons" % "0.13-SNAPSHOT")```
* **0.12** ```addSbtPlugin("io.github.morgaroth" %% "sbt-commons" % "0.12")```
* **0.11** ```addSbtPlugin("io.github.morgaroth" %% "sbt-commons" % "0.11")```


## Changelog

#### 0.13

* added Jumblr API library
* added new version of **morgaroth's mongodb** library  

#### 0.12
* Slick libraries 3.1.0-RC2 and 3.1.0
* nremond's pbkdf2 library


#### 0.11 and previous
* too much for describe :/
