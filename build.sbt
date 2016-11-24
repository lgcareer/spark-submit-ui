name := "ficusSpark"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.6"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.apache.commons" % "commons-email" % "1.4",
  "mysql" % "mysql-connector-java" % "5.1.29",
  "org.apache.spark" % "spark-core_2.10" % "1.4.1",
  "com.codahale" % "jerkson_2.9.1" % "0.5.0",
  "net.minidev" % "json-smart" % "1.3.1",
  "org.apache.hive" % "hive-jdbc" % "2.0.0",
  "com.google.inject" % "guice" % "3.0",
  "com.tzavellas" % "sse-guice" % "0.7.1",
  "com.jolbox" % "bonecp" % "0.8.0.RELEASE",
  "org.apache.oozie" % "oozie-client" % "4.2.0",
  "org.apache.hadoop" % "hadoop-client" % "2.6.4"



)

play.Project.playScalaSettings


//resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers ++= Seq(
  "Apache Repository" at "https://repository.apache.org/content/repositories/releases/",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  Resolver.sonatypeRepo("public")
)

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }



