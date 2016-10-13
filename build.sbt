import sbt._
import Keys._
name := "wqscurator"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.apache.thrift" % "libthrift" % "0.8.0",
  "com.twitter" %% "scrooge-core" % "3.18.1",
  "com.twitter" %% "finagle-thrift" % "6.24.0",
  "com.rabbitmq" % "amqp-client" % "3.4.3",
  "org.scurator" % "scurator_2.10" % "0.1.1",
  "org.slf4j"% "slf4j-api" % "1.7.7",
  "org.slf4j"% "slf4j-simple" % "1.7.7",
  "com.typesafe.akka" % "akka-actor_2.10" % "2.3.9"
)

resolvers += Resolver.url("cloudera", url("https://repository.cloudera.com/artifactory/cloudera-repos/"))

resolvers += Resolver.url("MavenOfficial", url("http://repo1.maven.org/maven2"))

resolvers += Resolver.url("conjars", url("http://conjars.org/repo"))

resolvers += Resolver.url("jboss", url("http://repository.jboss.org/nexus/content/groups/public-jboss"))


//libraryDependencies += "org.apache.thrift" %% "libthrift" % "0.5.0-1" intransitive

com.twitter.scrooge.ScroogeSBT.newSettings

scroogeBuildOptions in Compile := Seq("--finagle", "--verbose")

