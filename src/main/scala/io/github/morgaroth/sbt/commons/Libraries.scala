package io.github.morgaroth.sbt.commons

import sbt._

/**
 * Created by mateusz on 19.09.15.
 */
object Libraries extends Libraries

trait Libraries {

  def library(organization: String, library: String, version: String) = organization %% library % version

  def javaLibrary(organization: String, library: String, version: String) = organization % library % version

  object Akka {
    def akkaLibrary: (String, String) => ModuleID = library("com.typesafe.akka", _, _)

    object Actor {
      val ver: (String) => ModuleID = akkaLibrary("akka-actor", _)
      val `2.3.12` = ver("2.3.12")
      val `2.3.11` = ver("2.3.11")
      val `2.3.10` = ver("2.3.10")
      val `2.4.0-RC2` = ver("2.4.0-RC2")
      val `2.4.0-RC3` = ver("2.4.0-RC3")
    }

    object Stream {
      val ver: (String) => ModuleID = akkaLibrary("akka-stream-experimental", _)
      val `1.0` = ver("1.0")
    }

    object Http {
      val ver: (String) => ModuleID = akkaLibrary("akka-http-experimental", _)
      val `1.0` = ver("1.0")
    }

  }

  object Spray {
    val sprayLibrary: (String, String) => ModuleID = library("io.spray", _, _)

    trait SprayVersions {
      def name: String

      val ver: (String) => ModuleID = sprayLibrary(name, _)
      val `1.3.3` = ver("1.3.3")
      val `1.3.2` = ver("1.3.2")
      val `1.3.1` = ver("1.3.1")
      val `1.3.0` = ver("1.3.0")
    }

    object Can extends SprayVersions {
      def name: String = "spray-can"
    }

    object Client extends SprayVersions {
      def name = "spray-client"
    }

    object Routing extends SprayVersions {
      def name = "spray-routing"
    }

    object Caching extends SprayVersions {
      def name = "spray-caching"
    }

    object TestKit extends SprayVersions {
      def name = "spray-testkit"
    }

    object Json {
      val ver: (String) => ModuleID = sprayLibrary("spray-json", _)
      val `1.3.2` = ver("1.3.2")
    }

    object JsonAnnotation {
      val ExNexuRepository = Repositories.ExNexu.releases

      val ExNexuhVer: (String) => ModuleID = library("us.bleibinha", "spray-json-annotation", _)
      val MorgarothVer: (String) => ModuleID = library("io.github.morgaroth", "spray-json-annotation", _)
      val `0.5` = ExNexuhVer("0.5")
      val `0.4.2` = MorgarothVer("0.4.2")
    }

  }

  object Salat {
    val ver: (String) => ModuleID = library("com.novus", "salat", _)
    val `1.9.9` = ver("1.9.9")
  }

  object Ficus {
    val ficusLibrary: (String, String) => ModuleID = library("net.ceedubs", _, _)

    object Config {
      val ver: (String) => ModuleID = ficusLibrary("ficus", _)
      val `1.0.1` = ver("1.0.1")
      val `1.1.1` = ver("1.1.1")
      val `1.1.2` = ver("1.1.2")
    }

  }

  object Morgaroth {
    val morgarothLibrary: (String, String) => ModuleID = library("io.github.morgaroth", _, _)

    object UtilsMongo {
      val ver: (String) => ModuleID = morgarothLibrary("utils-mongodb", _)
      val `1.2.10` = ver("1.2.10")
    }

  }

  object Joda {

    object Time {
      val ver: (String) => ModuleID = javaLibrary("joda-time", "joda-time", _)
      val `2.8.2` = ver("2.8.2")
    }

    object Convert {
      val ver: (String) => ModuleID = javaLibrary("org.joda", "joda-convert", _)
      val `1.7` = ver("1.7")
    }

  }

  object Typesafe {
    val typesaveLibrary: (String, String) => ModuleID = library("com.typesafe", _, _)

    object Config {
      val ver: (String) => ModuleID = typesaveLibrary("config", _)
      val `1.3.0` = ver("1.3.0")
      val `1.2.1` = ver("1.2.1")
    }

  }

  object uPickle {
    val ver: (String) => ModuleID = library("com.lihaoyi", "upickle", _)
    val `0.3.6` = ver("0.3.6")
  }

  object Pathikrit {
    val repository = Repositories.Pathikrit
    val pathikritLib: (String, String) => ModuleID = library("com.github.pathikrit", _, _)

    object BetterFiles {
      val ver: (String) => ModuleID = pathikritLib("better-files", _)
      val `2.6.1` = ver("2.6.1")
      val `2.6.0` = ver("2.6.0")
      val `2.5.2` = ver("2.5.2")
      val `2.5.1` = ver("2.5.1")
      val `2.5.0` = ver("2.5.0")
      val `2.4.3` = ver("2.4.3")
      val `2.4.1` = ver("2.4.1")
      val `2.4.0` = ver("2.4.0")
      val `2.3.0` = ver("2.3.0")
    }

  }

  object Paradise {
    def ver(version: String) = "org.scalamacros" % "paradise" % version cross CrossVersion.full

    val `2.1.0-M5` = ver("2.1.0-M5")
  }

  object ScalaTest {
    val ver: (String) => ModuleID = library("org.scalatest", "scalatest", _)
    val `2.2.4` = ver("2.2.4")
  }

  object Slick {
    val ver: (String) => ModuleID = library("com.typesafe.slick", "slick", _)
    val `3.1.0` = ver("3.1.0")
    val `3.1.0-RC2` = ver("3.1.0-RC2")
  }

  object PBKDF2 {
    val ver = library("io.github.nremond", "pbkdf2-scala", _)
    val `0.5` = ver("0.5")
    val `0.4` = ver("0.4")
  }

}