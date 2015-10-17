sbtPlugin := true

name := """Sbt Commons"""

organization := """io.github.morgaroth"""

version := "0.13"

pomExtra := githubPom(name.value, "Mateusz Jaje", "Morgaroth")

publishTo := publishRepoForVersion(version.value)