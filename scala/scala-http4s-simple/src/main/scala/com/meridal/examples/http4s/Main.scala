package com.meridal.examples.http4s

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    Scalahttp4sServer.stream[IO].compile.drain.as(ExitCode.Success)
}
