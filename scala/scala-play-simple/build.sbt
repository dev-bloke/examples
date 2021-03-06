lazy val scalaPlaySimple = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """scala-play-simple""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.4",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "1.4.199",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
