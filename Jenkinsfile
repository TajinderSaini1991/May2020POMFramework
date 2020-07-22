pipeline {
  agent any
  stages {
    stage('Run on Dev ') {
      parallel {
        stage('Run on Dev ') {
          steps {
            bat 'echo "Run on Dev Environment"'
          }
        }

        stage('chrome') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Run on QA Env') {
      parallel {
        stage('Run on QA Env') {
          steps {
            bat 'echo "Run on QA env"'
          }
        }

        stage(' chrome') {
          steps {
            bat 'echo "Run on chrome"'
          }
        }

        stage('firefox') {
          steps {
            bat 'echo "run on firefox"'
          }
        }

      }
    }

    stage('Run on stage ') {
      parallel {
        stage('Run on stage ') {
          steps {
            bat 'echo "Run on stage env"'
          }
        }

        stage('chrome') {
          steps {
            bat 'echo "run on chrome"'
          }
        }

      }
    }

    stage('Run on Prod') {
      parallel {
        stage('Run on Prod') {
          steps {
            bat 'echo "Run on Prod env"'
          }
        }

        stage('firefox') {
          steps {
            bat 'echo "run on firefox"'
          }
        }

      }
    }

  }
}
