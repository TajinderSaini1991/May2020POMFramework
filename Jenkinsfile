pipeline {
  agent any
  stages {
    stage('Run on Dev') {
      parallel {
        stage('Run on Dev') {
          steps {
            shell('echo "run on dev env"')
          }
        }

        stage('chrome') {
          steps {
            shell('echo "run on chrome browser"')
          }
        }

      }
    }

  }
}

def shell(command) {
    return bat(returnStdout: true, script: "sh -x -c \"${command}\"").trim()
}
