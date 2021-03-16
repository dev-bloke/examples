val springBootJpa  = "org.springframework.boot" % "spring-boot-starter-data-jpa" % "2.4.3"
val springBootWeb  = "org.springframework.boot" % "spring-boot-starter-web" % "2.4.3"
val swagger2       = "io.springfox" % "springfox-swagger2" % "2.7.0"
val swaggerUi      = "io.springfox" % "springfox-swagger-ui" % "2.7.0"

val h2             = "com.h2database" % "h2" % "1.4.200"
val jaxb           = "javax.xml.bind" % "jaxb-api" % "2.3.1"

val junit          = "junit" % "junit" % "4.13.2" % Test
val scalatest      = "org.scalatest" %% "scalatest" % "3.2.5" % Test
val scalatestJunit = "org.scalatestplus" %% "junit-4-13" % "3.2.5.0" % Test
val springBootTest = "org.springframework.boot" % "spring-boot-starter-test" % "2.4.3" % Test

lazy val scalaSpringBoot = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.meridal",
      scalaVersion := "2.13.5",
      version := "1.0-SNAPSHOT"     
    )),
    name := "Scala Spring Boot",
    libraryDependencies ++= Seq(
      springBootJpa,
      springBootWeb,
      swagger2,
      swaggerUi,
      h2,
      jaxb,
      junit,
      scalatest,
      scalatestJunit,
      springBootTest
    )
  )
