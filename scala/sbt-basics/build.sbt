ThisBuild / scalaVersion := "2.13.5"
ThisBuild / organization := "com.meridal"

val scalatest = "org.scalatest" %% "scalatest" % "3.2.5" % Test

lazy val sbtbasics = (project in file("."))
  .settings(
    name := "SBT Basics",
    libraryDependencies += scalatest
  )
