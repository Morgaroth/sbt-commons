sbtPlugin := true

name := """Sbt Commons"""

organization := """io.github.morgaroth"""

version := "0.17"

pomExtra := githubPom(name.value, "Mateusz Jaje", "Morgaroth")

publishTo := publishRepoForVersion(version.value)

enablePlugins(BuildInfoPlugin)

buildInfoKeys := Seq[BuildInfoKey](version)

buildInfoPackage := "io.github.morgaroth.sbt.commons"