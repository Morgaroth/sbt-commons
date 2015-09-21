package io.github.morgaroth.sbt.commons

import sbt._

/**
 * Created by mateusz on 21.09.15.
 */
trait Plugins {
  def plugin(organization: String, name: String, version: String): ModuleID =
    organization % name % version


  object Assembly {
    val ver: (String) => ModuleID = plugin("com.eed3si9n", "sbt-assembly", _)
    val `0.14.0` = ver("0.14.0")
  }

  object Revolver {
    val ver: (String) => ModuleID = plugin("io.spray", "sbt-revolver", _)
    val `0.7.1` = ver("0.7.1")
  }

  object Morgaroth {
    val morgarothPlugin: (String, String) => ModuleID = plugin("io.github.morgaroth", _, _)

    object SonatypeUtils {
      val ver: (String) => ModuleID = morgarothPlugin("sbt-sonatype-utils", _)
      val `0.2` = ver("0.2")

    }

  }

}

object Plugins extends Plugins
