package io.github.morgaroth.sbt.commons

import sbt._
/**
 * Created by mateusz on 15.10.15.
 */
trait ScalaLibraryHelpers {

  def library(organization: String, library: String, version: String) = organization %% library % version
}
