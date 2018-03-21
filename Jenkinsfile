pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'trying to build'
        sh 'mvn clean package'
      }
    }
  }
}