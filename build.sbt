name := "ficusSpark"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.apache.commons" % "commons-email" % "1.4",
  "mysql" % "mysql-connector-java" % "5.1.29",
  "org.apache.spark" % "spark-core_2.10" % "1.4.1",
  "com.codahale" % "jerkson_2.9.1" % "0.5.0",
  "net.minidev" % "json-smart" % "1.3.1",
  "org.apache.hive" % "hive-jdbc" % "2.0.0"
)
play.Project.playScalaSettings


//resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers ++= Seq(
  "Apache Repository" at "https://repository.apache.org/content/repositories/releases/",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  Resolver.sonatypeRepo("public")
)

