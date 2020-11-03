pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'echo "test"'
      }
    }

    stage('test1') {
      parallel {
        stage('test1') {
          steps {
            sleep 5
          }
        }

        stage('test2') {
          steps {
            echo 'Hello'
          }
        }

      }
    }

    stage('deploy') {
      steps {
        sh 'echo "test"'
      }
    }

  }
}