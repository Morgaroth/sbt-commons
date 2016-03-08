package io.github.morgaroth.sbt.commons

/**
  * Created by mateusz on 19.09.15.
  */
object Libraries extends Libraries

trait Libraries
  extends CoreLibrariesAndFrameworks
  with ScalaUtilityLibraries
  with JavaLibraries
  with LogbackLibraries

