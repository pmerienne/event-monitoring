# What's event-monitoring?

Collect and analyze timestamped events from your information system. 
By collecting events rather than metrics, this application lets you compute aggregate statistics post hoc. 
It also enables richer analysis, such as time series of arbitrary event sets.

Demo : http://eventmonitoring-pmerienne.rhcloud.com/


# Requirements

This application is compiled with JDK6. The launch scripts set up JVM options that may only be available since latest JDK6 versions.
If you use an old JDK6, please consider upgrading, or edit the scripts for removing the unsupported options.
If you use an JDK < 6, you have to upgrade.

You must have a mongodb 2.0+ instance running on localhost port 27017. Mongodb must have database named eventdb with an admin user (username : 'admin', password : 'admin')

# Getting started

You can download event-monitoring as a distribution bundle (.tar.gz or .zip) here (TODO make link). 
Unpack the binary and put the extracted directory into a convenient location.

Launch event-monitoring using the following command :

bin/startup.sh

# Configure event-monitoring

You can configure mongodb access in the property file : resources/mongodb.properties

Server (Jetty) configuration are located in the resources/jetty.xml file


# Compile event-monitoring

1) Pré requis pour la compilation
Créer la base nécessaire :
	use test
	db.addUser('test','test')

Installer antlr-gwt-runtime.jar dans votre repository maven local :
- Télécharger et extraire antlr-gwt-runtime.jar de http://gwtified.googlecode.com/files/gwt-antlr.zip
- Installer la librairie : mvn install:install-file -Dfile=antlr-gwt-runtime.jar -DgroupId=org.antlr -DartifactId=antlr-gwt-runtime -Dversion=3.3 -Dpackaging=jar

2) Compilation 
Lancer la commande : 
mvn install

3) Déploiement dans un tomcat
Copier le fichier config/mongodb.properties dans le classpath du tomcat (dans TOMCAT_HOME/lib par example)
Déployer le war provenant de la compilation dans le tomcat

4) Run with Google Plugin for Eclipse (GPE)
Importer le projet comme projet maven.
Run as Web Application
war folder : src/main/webapp
Ajouter dans les bootstrap entries du classpath (dans la run-configuration) le fichier config/mongodb.properties

