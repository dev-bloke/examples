ThisBuild / scalaVersion := "2.13.5"
ThisBuild / organization := "com.meridal"
ThisBuild / version      := "1.0-SNAPSHOT"

val junit          = "junit" % "junit" % "4.13.2" % Test
val scalatest      = "org.scalatest" %% "scalatest" % "3.2.5" % Test
val scalatestJunit = "org.scalatestplus" %% "junit-4-13" % "3.2.5.0" % Test
val specs2         = "org.specs2" %% "specs2-core" % "4.10.6" % Test
val specs2Junit    = "org.specs2" %% "specs2-junit" % "4.10.6" % Test

lazy val scalaBasics = (project in file("scala-basics"))
  .settings(
    name := "Scala Basics",
    libraryDependencies ++= Seq(
      junit,
      scalatest,
      scalatestJunit,
      specs2,
      specs2Junit
    )
  )
  
lazy val scalaWebapp = (project in file("scala-webapp"))
  .settings(
    name := "Example Scala Web Application",
    libraryDependencies ++= Seq(
      junit,
      scalatest,
      specs2,
    )
  )

lazy val scalaPlaySimple = (project in file("scala-play-simple"))
  
lazy val scalatraWebapp = (project in file("scalatra-webapp"))
