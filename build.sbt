name := "schala-wrapper"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq("org.specs2" %% "specs2" % "3.7" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")
