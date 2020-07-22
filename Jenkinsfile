pipeline {
  agent any
  stages {
    stage('Run on Dev ') {
      parallel {
        stage('Run on Dev ') {
          steps {
            sh 'echo "Run on Dev Environment"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Run on QA Env') {
      parallel {
        stage('Run on QA Env') {
          steps {
            sh 'echo "Run on QA env"'
          }
        }

        stage(' chrome') {
          steps {
            sh 'echo "Run on chrome"'
          }
        }

        stage('firefox') {
          steps {
            sh 'echo "run on firefox"'
          }
        }

      }
    }

    stage('Run on stage ') {
      parallel {
        stage('Run on stage ') {
          steps {
            sh 'echo "Run on stage env"'
          }
        }

        stage('chrome') {
          steps {
            sh 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Run on Prod') {
      parallel {
        stage('Run on Prod') {
          steps {
            sh 'echo "Run on Prod env"'
          }
        }

        stage('firefox') {
          steps {
            sh 'echo "run on firefox"'
          }
        }

      }
    }

  }
}
