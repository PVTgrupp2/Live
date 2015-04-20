import NativePackagerKeys._

herokuAppName	in	Compile	:=	"protected-savannah-6320”

libraryDependencies	+=	"mysql"	%	"mysql-connector-java"	%	"5.1.27"	

name := """pvtgrupp2play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)
