package io.github.morgaroth.sbt.commons

import sbt.Keys._
import sbt._

object SbtCommons extends AutoPlugin with CheckNewerVersion {

  def thisVersion: (Int, Int) = {
    val (maj :: min :: Nil) = BuildInfo.version.split(".").toList
    maj.toInt -> min.toInt
  }

  object autoImport extends Libraries {
    val Repositories = io.github.morgaroth.sbt.commons.Repositories
  }

  val onLoadVersionCheck: (State) => State = (state: State) => {
    getInternetVersion.foreach { internet =>
      if (needUpgrade(internet)) {
        println(s"[info] `sbt commons` plugin from Morgaroth may be upgraded to version ${internet._1}.${internet._2} (current is ${thisVersion._1}.${thisVersion._2}).")
      }
    }
    state
  }

  override def projectSettings: Seq[Def.Setting[_]] = {
    Seq(
      onLoad in Global := {
        val previous: (State) => State = (onLoad in Global).value
        onLoadVersionCheck compose previous
      }
    )
  }
}

