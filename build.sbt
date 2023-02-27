name := """play-tapir-exception-example"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "org.fusesource.jansi" % "jansi" % "2.4.0"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-play-server" % "1.2.9"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-json-play" % "1.2.9"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs" % "1.2.9"
libraryDependencies += "com.softwaremill.sttp.apispec" %% "openapi-circe-yaml" % "0.3.2"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-sttp-stub-server" % "1.2.9"
libraryDependencies += "com.softwaremill.sttp.tapir" %% "tapir-testing" % "1.2.9"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
