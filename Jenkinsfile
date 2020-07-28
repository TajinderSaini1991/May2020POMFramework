pipeline {
  agent any
  stages {
    stage('Build Dev') {
      parallel {
        stage('Build Dev') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('Run on Dev') {
          steps {
            sh 'mvn test -Denv="dev"'
          }
        }

      }
    }

    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('Run on QA') {
          steps {
            sh 'mvn test -Denv=qa'
          }
        }

      }
    }

    stage('Build Stage') {
      parallel {
        stage('Build Stage') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('Run on stage') {
          steps {
            sh 'mvn test -Denv=stage'
          }
        }

      }
    }

  

 
  }



  
  tools {

    maven 'M3'
  }
}