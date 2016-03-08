package io.github.morgaroth.sbt.commons

import sbt._

/**
  * Created by mateusz on 15.10.15.
  */
trait ScalaUtilityLibraries extends ScalaLibraryHelpers {

  object Salat {
    val ver: (String) => ModuleID = library("com.novus", "salat", _)
    val `1.9.9` = ver("1.9.9")
  }

  object Ficus {
    val ficusLibrary: (String, String) => ModuleID = library("net.ceedubs", _, _)
    val ficusNewLibrary: (String, String) => ModuleID = library("com.iheart", _, _)

    object Config {
      val ver: (String) => ModuleID = ficusLibrary("ficus", _)
      val `1.1.3` = ver("1.1.3")
      val `1.1.2` = ver("1.1.2")
      val `1.1.1` = ver("1.1.1")
      val `1.0.1` = ver("1.0.1")
      val last = `1.1.3`
    }

  }

  object Morgaroth {
    val morgarothLibrary: (String, String) => ModuleID = library("io.github.morgaroth", _, _)

    object UtilsMongo {
      val ver: (String) => ModuleID = morgarothLibrary("utils-mongodb", _)
      val `2.0.0` = ver("2.0.0")
      val `1.2.10` = ver("1.2.10")
      val last = `2.0.0`
    }

  }

  object uPickle {
    val ver: (String) => ModuleID = library("com.lihaoyi", "upickle", _)
    val `0.3.6` = ver("0.3.6")
    val last = `0.3.6`
  }

  object Pathikrit {
    val repository = Repositories.Pathikrit
    val pathikritLib: (String, String) => ModuleID = library("com.github.pathikrit", _, _)

    object BetterFiles {
      val ver: (String) => ModuleID = pathikritLib("better-files", _)
      val `2.14.0` = ver("2.14.0")
      val `2.13.0` = ver("2.13.0")
      val `2.12.2` = ver("2.12.2")
      val `2.12.1` = ver("2.12.1")
      val `2.12.0` = ver("2.12.0")
      val `2.11.0` = ver("2.11.0")
      val `2.10.0` = ver("2.10.0")
      val `2.9.2` = ver("2.9.2")
      val `2.9.0` = ver("2.9.0")
      val `2.8.1` = ver("2.8.1")
      val `2.8.0` = ver("2.8.0")
      val `2.7.1` = ver("2.7.1")
      val `2.7.0` = ver("2.7.0")
      val `2.6.1` = ver("2.6.1")
      val `2.6.0` = ver("2.6.0")
      val `2.5.2` = ver("2.5.2")
      val `2.5.1` = ver("2.5.1")
      val `2.5.0` = ver("2.5.0")
      val `2.4.3` = ver("2.4.3")
      val `2.4.1` = ver("2.4.1")
      val `2.4.0` = ver("2.4.0")
      val `2.3.0` = ver("2.3.0")
      val last = `2.14.0`
    }

  }

  object Paradise {
    def ver(version: String) = "org.scalamacros" % "paradise" % version cross CrossVersion.full

    val `2.1.0-M5` = ver("2.1.0-M5")
  }

  object ScalaTest {
    val ver: (String) => ModuleID = library("org.scalatest", "scalatest", _)
    val `2.2.6` = ver("2.2.6")
    val `2.2.4` = ver("2.2.4")
    val last = `2.2.6`
  }

  object Slick {
    val ver: (String) => ModuleID = library("com.typesafe.slick", "slick", _)
    val `3.1.0` = ver("3.1.0")
    val `3.1.0-RC2` = ver("3.1.0-RC2")
  }

  object PBKDF2 {
    val ver: (String) => ModuleID = library("io.github.nremond", "pbkdf2-scala", _)
    val `0.5` = ver("0.5")
    val `0.4` = ver("0.4")
  }

}