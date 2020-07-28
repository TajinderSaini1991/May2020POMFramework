pipeline {
  agent any
  stages {
    stage('Run on Dev') {
      parallel {
        stage('Run on Dev') {
          steps {
            sh 'echo "run on dev"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

      }
    }

  }
}