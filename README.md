[![Stories in Ready](https://badge.waffle.io/Morgaroth/sbt-commons.png?label=ready&title=Ready)](http://waffle.io/Morgaroth/sbt-commons)

# sbt-commons

## Main goal of project
Main goal of this sbt plugin is provinding various libraries for sbt as normal classes and values.
This helps in looking for some library by name with IDE completions.
Moreover, for libraries published to other than sonatype or maven repos, there is hardcoded link to them one, as Resolvers.

Additionally, on start plugin checks if there is newer version published and informs user about it.

## Contents

* **spray.io** libraries (can, client, http, httpx, caching, routing, testkit)
* **akka** libraries (actor, stream, http, remote, cluster, testkit)
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
* **Joda Time** rich time library [JodaTime](http://www.joda.org/joda-time/)
* **Joda Convert** helper library for Joda time [info site](http://www.joda.org/joda-convert/)

## Versions

* **0.15** ```addSbtPlugin("io.github.morgaroth" %% "sbt-commons" % "0.15")```
* **0.14** *BROKEN* ```addSbtPlugin("io.github.morgaroth" %% "sbt-commons" % "0.14")```
* **0.13** ```addSbtPlugin("io.github.morgaroth" %% "sbt-commons" % "0.13")```
* **0.12** ```addSbtPlugin("io.github.morgaroth" %% "sbt-commons" % "0.12")```
* **0.11** ```addSbtPlugin("io.github.morgaroth" %% "sbt-commons" % "0.11")```


## Changelog

#### 0.16

* added new versions of joda-time, joda-convert, better-files, scala-test
* added logback library, logback extensions library (from user repository)
* added *last* field to libraries

#### 0.15

* fixed broken build

#### 0.14

* added sbt-buildinfo plugin so some job is automated
* added missing versions of akka libraries
* added missing akka libraries (remote, cluster, testkit)
* added missing spray libraries (http, httpx)

#### 0.13
* added Jumblr API library
* added new version of **morgaroth's mongodb** library  

#### 0.12
* Slick libraries 3.1.0-RC2 and 3.1.0
* nremond's pbkdf2 library


#### 0.11 and previous
* too much for describe :/
