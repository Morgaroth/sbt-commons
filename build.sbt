sbtPlugin := true

name := """Sbt Commons"""

organization := """io.github.morgaroth"""

version := "0.0.1-SNAPSHOT"

pomExtra := githubPom(name.value, "Mateusz Jaje", "Morgaroth")

publishTo := publishRepoForVersion(version.value)