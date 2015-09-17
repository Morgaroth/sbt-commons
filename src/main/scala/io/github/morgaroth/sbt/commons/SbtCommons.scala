package io.github.morgaroth.sbt.commons

import sbt.AutoPlugin

import RepositoryTypes.{Releases, RepositoryType, Snapshots}
import sbt._

import scala.util.Success

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
      val `1.3.3` = ver("1.3.3")
      val `1.3.2` = ver("1.3.2")
      val `1.3.1` = ver("1.3.1")
      val `1.3.0` = ver("1.3.0")
    }

    object Client {
      val ver: (String) => ModuleID = sprayLibrary("spray-client", _)
      val `1.3.3` = ver("1.3.3")
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
      val MorgarothVer: (String) => ModuleID = library("io.github.morgaroth", "spray-json-annotation", _)
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

  def thisVersion = 0 -> 5

  def needUpgrade(fromInternet: (Int, Int)) = {
    if (thisVersion == fromInternet) {
      false
    } else if (thisVersion._1 < fromInternet._1) {
      // major is newer
      true
    } else if (thisVersion._1 == fromInternet._1 && thisVersion._2 < fromInternet._2) {
      // minor is newer
      true
    } else {
      // local is newer than internet?
      false
    }
  }


  def getInternetVersion = {
    val b = "https://oss.sonatype.org/content/repositories/releases/io/github/morgaroth/sbt-commons_2.10_0.13/"
    val r2 = """<td><a href=.*>(\d+\.\d+)/</a></td>""".r
    val r3 = """<td><a href=.*>(\d+\.\d+\.\d+)/</a></td>""".r
    val data = Http(b).asString.body
    val versions = r2.findAllMatchIn(data).toList.map(_.group(1)).map(_.split(".").toList.map(_.toInt))
    val a1 = versions.groupBy(_.head).mapValues(_.map(_.tail))
    val max1 = a1.keys.max
    val a2 = a1(max1).groupBy(_.head).mapValues(_.map(_.tail))
    val max2 = a2.keys.max
    val allempty = a2.values.forall(_.isEmpty)
    val allnonempty = a2.values.forall(_.nonEmpty)
    if (allempty && !allnonempty) {
      // wszystkie są formatu x.y
      Some(max1 -> max2)
    } else {
      None
    }
  }

  object autoImport {
    val Libraries = io.github.morgaroth.sbt.commons.Libraries
    val Repositories = io.github.morgaroth.sbt.commons.Repositories
    // settings, keys, another which shoud be auto imported to sbt context
    getInternetVersion.foreach { internet =>
      if (needUpgrade(internet)) {
        println(s"[INFO] `sbt commons` plugin from Morgaroth may be upgraded to version $internet (current is $thisVersion).")
      }
    }
  }
}

