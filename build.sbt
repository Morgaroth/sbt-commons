sbtPlugin := true

name := """Sbt Commons"""

organization := """io.github.morgaroth"""

version := "0.17"

crossSbtVersions := Vector("0.13.15", "1.0.0-RC2")

enablePlugins(BuildInfoPlugin)

buildInfoKeys := Seq[BuildInfoKey](version)

buildInfoPackage := "io.github.morgaroth.sbt.commons"

bintrayVcsUrl := Some("https://github.com/Morgaroth/sbt-commons")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

