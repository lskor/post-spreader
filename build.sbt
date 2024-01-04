import sbt.Keys.libraryDependencies

import scala.collection.Seq

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

ThisBuild / scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-Ymacro-annotations",
    )

lazy val root = (project in file("."))
  .settings(
    name := "post-spreader",
    libraryDependencies ++= Seq(
      "co.fs2" %% "fs2-core" % Dependencies.fs2Version,
      "org.typelevel" %% "cats-core" % Dependencies.catsCoreVersion,
      "org.typelevel" %% "cats-effect" % Dependencies.catsEffectVersion,
      "org.augustjune" %% "canoe" % Dependencies.canoeVersion,
      "org.typelevel" %% "log4cats-slf4j" % Dependencies.log4CatsVersion,
      "ch.qos.logback" % "logback-classic" % Dependencies.logbackClassic,
      "org.jsoup" % "jsoup" % Dependencies.jsoup,
      "org.scalatest" %% "scalatest" % Dependencies.scalaTestVersion % Test
    )
  )
