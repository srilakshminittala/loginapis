# Test Script

The test suite tests the Login API and Registration API's.

please refer the pom.xml for dependencies.

## Installation & Setup (Linux)

Follow these instructions to set up environment to run the code successfully.

1. Download and install Java 8 version as per your OS.
2. Download and install [Apache maven 3.6.0](https://maven.apache.org/install.html)
3. Set path variable for maven home in .bash_profile like below.

```bash
export M2_HOME=/Users/myhome/apache-maven-3.6.0
export PATH=$PATH:$M2_HOME/bin
```

4. Run the below command in terminal to source

```bash
sh ~/.bash_profile
```

## Execution instructions 


1. Clone Git repo  https://github.com/srilakshminittala/loginapis.git into your local directory.

```bash
git clone https://github.com/srilakshminittala/loginapis.git
```
2. Build the project from the project root or in the pom.xml directory

```bash
mvn clean install 
```

3. Upon successful build, run tests as below.

```bash
mvn test
```



