package io.github.morgaroth.sbt.commons

/**
 * Created by mateusz on 03.09.15.
 */
object RepositoryTypes {

  sealed trait RepositoryType {
    def name: String
  }

  object Releases extends RepositoryType {
    override def name: String = "releases"
  }

  object Snapshots extends RepositoryType {
    override def name: String = "snapshots"
  }

}
