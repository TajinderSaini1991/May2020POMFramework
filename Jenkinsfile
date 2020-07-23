pipeline {
  agent any
  stages {
    stage('Run on Dev') {
      parallel {
        stage('Run on Dev') {
          steps {
            bat 'echo "run on dev env"'
          }
        }

        stage('chrome') {
          steps {
            bat 'echo "run on chrome browser"'
          }
        }

      }
    }

  }
}
