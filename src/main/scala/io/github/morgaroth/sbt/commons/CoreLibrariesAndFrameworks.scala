package io.github.morgaroth.sbt.commons

import sbt.ModuleID

/**
  * Created by mateusz on 15.10.15.
  */
trait CoreLibrariesAndFrameworks extends ScalaLibraryHelpers {

  object Akka {

    def akkaLibrary: (String, String) => ModuleID = library("com.typesafe.akka", _, _)

    trait AkkaVersions {
      def name: String

      val ver: (String) => ModuleID = akkaLibrary(name, _)
      val `2.3.12` = ver("2.3.12")
      val `2.3.11` = ver("2.3.11")
      val `2.3.10` = ver("2.3.10")
      val `2.4.0-RC2` = ver("2.4.0-RC2")
      val `2.4.0-RC3` = ver("2.4.0-RC3")
      val `2.4.0` = ver("2.4.0")
      val `2.4.1` = ver("2.4.1")

    }

    object Actor extends AkkaVersions {
      override def name: String = "akka-actor"
    }

    object Cluster extends AkkaVersions {
      override def name: String = "akka-cluster"
    }

    object Slf4j extends AkkaVersions {
      override def name: String = "akka-slf4j"
    }

    object Remote extends AkkaVersions {
      override def name: String = "akka-remote"
    }

    object TestKit extends AkkaVersions {
      override def name: String = "akka-testkit"
    }


    object Stream {
      val ver: (String) => ModuleID = akkaLibrary("akka-stream-experimental", _)
      val `2.0.1` = ver("2.0.1")
      val `2.0` = ver("2.0")
      val `2.0-M2` = ver("2.0-M2")
      val `2.0-M1` = ver("2.0-M1")
      val `1.0` = ver("1.0")
    }

    object Http {
      val ver: (String) => ModuleID = akkaLibrary("akka-http-experimental", _)
      val `2.0.1` = ver("2.0.1")
      val `2.0` = ver("2.0")
      val `2.0-M2` = ver("2.0-M2")
      val `2.0-M1` = ver("2.0-M1")
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

    object Httpx extends SprayVersions {
      def name: String = "spray-httpx"
    }

    object Http extends SprayVersions {
      def name: String = "spray-http"
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

}
