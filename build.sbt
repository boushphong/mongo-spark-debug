ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
  .settings(
    name := "mongo-spark-debug"
  )

val sparkVersion = "3.2.1"
val mongoVersion = "10.2.0"
val jacksonVersion = "2.12.0"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.mongodb.spark" %% "mongo-spark-connector" % mongoVersion
)

val `jackson-core` = "com.fasterxml.jackson.core" % "jackson-core" % jacksonVersion
val `jackson-databind` = "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion


dependencyOverrides += `jackson-core`
dependencyOverrides += `jackson-databind`

libraryDependencies ++= Seq(
  `jackson-databind`,
  `jackson-core`
)