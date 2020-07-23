pipeline {
  agent any
  stages {
    stage('Run on Dev') {
      parallel {
        stage('Run on Dev') {
          steps {
            sh 'echo "run on dev env"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome browser"'
          }
        }

      }
    }

  }
}