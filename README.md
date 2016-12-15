# TeamCollaboration
Angular routing SPA

This is Collaboration Project contains functions to  Chat,Create and View Blogs ,Add Forums  etc 
There are two project i.e it is based on Frontend Project and Backend Project.
The Frontend Project is an Angular Aplication(Dynamic Web Project) and Backend Project is Maven webapp Project.


##Technologies Used
HTML 5
CSS
JavaScript
Bootstrap 3.3.7
AngularJs 1.5
Maven 4.0.0
Spring 4.3.0
Hibernate 4.3.5
Apache Tomcat 8.0
Oracle 11.2.0
Java Development Kit version 8

###Prerequisites
You must have an understanding of how to install softwares. 

####Installations

Eclipse Installation-
Steps to Install Eclipse
•	For this project we will be installing the Eclipse Mars/Neon release, we are introducing a new Eclipse installer. This is a new and more efficient way to install Eclipse. It is a proper installer, so no more zip files, with a self extracting download that will lead you through the installation experience. For those not into installers, we still have the packages and zip files available on our download pages.

•	Download the Eclipse Installer windows 64bit (Recommended) or Windows 32bit, from https://eclipse.org/downloads/index.php

•	Start the Eclipse Installer executable For Windows users, after the Eclipse Installer executable has finished downloading it should be available in your download directory. Start the Eclipse Installer executable. You may get a security warning to run this file. If the Eclipse Foundation is the Publisher, you are good to select Run.

•	Select Eclipse IDE for JAVA EE Developers (Eclipse Mars).
 
•	Select your installation folder, Specify the folder where you want Eclipse to be installed. The default folder will be in your User directory. Select the ‘Install’ button to begin the installation.  
•	Launch Eclipse, Once the installation is complete you can now launch Eclipse.   

Installation Video: https://www.youtube.com/watch?v=35NUuhmQuB4

Maven Installation-

Maven is a Java tool, so you must have Java installed in order to proceed.
Downloading Apache Maven 3.3.9
Apache Maven 3.3.9 is the latest release and recommended version for all users. Which can be downloaded from http://maven.apache.org/download.cgi.

Another way to install Maven plug-in for Eclipse:
1.Open Eclipse
2.Go to Help -> Eclipse Marketplace
3.Search by Maven
4.Click "Install" button at "Maven Integration for Eclipse" section

##### Configuration
Configuring Maven into Eclipse

First install maven(Steps given in ####Installations) in your system and set Maven environment variables
M2_HOME: ....\apache-maven-3.0.5 \ maven installed path
M2_Repo: D:\maven_repo \If change maven repo location
M2: %M2_HOME%\bin

Steps to Configure maven on Eclipse IDE:

Select Window -> Preferences Note: If Maven option is not present, then add maven 3 to eclipse or install it.
Add the Maven location of your system
To check maven is configured properly:

Open Eclipse and click on Windows -> Preferences
Choose Maven from left panel, and select installations.
Click on Maven -> "User Settings" option form left panel, to check local repository location.

Configuring Tomcat8 server into Eclipse

Video Url : https://www.youtube.com/watch?v=kLgquZ2FiuQ
•	Download Tomcat 8 from https://tomcat.apache.org/download-80.cgi and place it within any local folder. 
•	Start Eclipse and click on “Servers” tab in the workbench. Go ahead and try adding a new server. You would find option for Tomcat 8 available for selection as shown below.  
•	After clicking Finish, you would see a new server added with the name as “Tomcat v8.0 Server at localhost”. Start the server.
•	Check http://localhost:8080 (provided you installed Tomcat 8 and set Http port as 8080)
•	Interestingly, you would NOT see the welcome page, but the 404 error page.
•	To get rid of that, Double click on  ”Tomcat v8.0 Server at localhost”. In the window that opens up, select “Use Tomcat installation” and, change deploy path from wtpwebapps to webapps. Look at the figure below.
 
•	Restart the server and access http://localhost:8080 .






