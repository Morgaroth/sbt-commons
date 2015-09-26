package io.github.morgaroth.sbt.commons

import io.github.morgaroth.sbt.commons.RepositoryTypes.{Releases, RepositoryType, Snapshots}
import sbt._


/**
 * Created by mateusz on 19.09.15.
 */
object Repositories extends Repositories

trait Repositories {

  object Typesafe {
    val releases = repository(Releases)
    val snapshots = repository(Snapshots)

    private def repository(rtype: RepositoryType): MavenRepository = {
      s"Typesafe ${rtype.name} repository" at s"http://repo.typesafe.com/typesafe/${rtype.name}/"
    }
  }

  val Pathikrit = Resolver.bintrayRepo("pathikrit", "maven")

  object Spray {
    val releases = "Spray.io repository" at "http://repo.spray.io"
    val nightlies = "Spray.io nightlies repository" at "http://nightlies.spray.io"
  }

  object ExNexu {
    val releases = "Bleibinha releases" at "http://bleibinha.us/archiva/repository/releases"
  }

}