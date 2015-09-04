package io.github.morgaroth.sbt.commons

import sbt.AutoPlugin

import RepositoryTypes.{Releases, RepositoryType, Snapshots}
import sbt._

object Repositories {

  object Typesafe {
    val releases = repository(Releases)
    val snapshots = repository(Snapshots)

    private def repository(rtype: RepositoryType): MavenRepository = {
      s"Typesafe ${rtype.name} repository" at s"http://repo.typesafe.com/typesafe/${rtype.name}/"
    }
  }

  object Spray {
    val releases = "Spray.io repository" at "http://repo.spray.io"
    val nightlies = "Spray.io nightlies repository" at "http://nightlies.spray.io"
  }

  object ExNexu {
    val releases = "Bleibinha releases" at "http://bleibinha.us/archiva/repository/releases"
  }

}

object Libraries {

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

    object Can {
      val ver: (String) => ModuleID = sprayLibrary("spray-can", _)
      val `1.3.2` = ver("1.3.2")
      val `1.3.1` = ver("1.3.1")
      val `1.3.0` = ver("1.3.0")
    }

    object Client {
      val ver: (String) => ModuleID = sprayLibrary("spray-client", _)
      val `1.3.2` = ver("1.3.2")
      val `1.3.1` = ver("1.3.1")
      val `1.3.0` = ver("1.3.0")
    }

    object Json {
      val ver: (String) => ModuleID = sprayLibrary("spray-json", _)
      val `1.3.2` = ver("1.3.2")
    }

    object JsonAnnotation {
      val ExNexuRepository = Repositories.ExNexu.releases

      val ExNexuhVer: (String) => ModuleID = library("us.bleibinha", "spray-json-annotation", _)
      val MorgarothVer: (String) => ModuleID = library("io.github.morgaroth", "spray-json-anotation", _)
      val `0.5` = ExNexuhVer("0.5")
      val `0.4.2` = MorgarothVer("0.4.2")
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

  object uPickle {
    val ver: (String) => ModuleID = library("com.lihaoyi", "upickle", _)
    val `0.3.6` = ver("0.3.6")
  }

  object Paradise {
    def ver(version: String) = "org.scalamacros" % "paradise" % version cross CrossVersion.full

    val `2.1.0-M5` = ver("2.1.0-M5")
  }

}

object SbtCommons extends AutoPlugin {

  object autoImport {
    val Libraries = Releases
    // settings, keys, another which shoud be auto imported to sbt context
    println("[WARN] hello")
  }

}

