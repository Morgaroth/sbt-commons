sbtPlugin := true

name := """Sbt Commons"""

organization := """io.github.morgaroth"""

version := "0.19"

crossSbtVersions := Vector("0.13.16", "1.0.4", "1.1.5")

scalaVersion := {
  if (sbtVersion.value.startsWith("1.")) "2.12.6" else scalaVersion.value
}

enablePlugins(BuildInfoPlugin)

buildInfoKeys := Seq[BuildInfoKey](version)

buildInfoPackage := "io.github.morgaroth.sbt.commons"

bintrayVcsUrl := Some("https://github.com/Morgaroth/sbt-commons")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

