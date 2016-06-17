name := "ficusSpark"

version := "1.0-SNAPSHOT"



libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.apache.commons" % "commons-email" % "1.4",
  "mysql" % "mysql-connector-java" % "5.1.29"
)

play.Project.playScalaSettings


resolvers ++= Seq(
  "Apache Repository" at "https://repository.apache.org/content/repositories/releases/",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  Resolver.sonatypeRepo("public")
)
