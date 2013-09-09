import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "tapingoapp"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "com.typesafe" %% "play-plugins-mailer" % "2.1.0",
    "org.twitter4j" % "twitter4j-stream" % "3.0.3",
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
    scalaVersion := "2.10.0"
  )

}
