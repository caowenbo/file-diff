pipeline {
  agent any
  stages {
    stage('aa') {
      parallel {
        stage('aa') {
          steps {
            echo 'hhhh'
          }
        }
        stage('bbbb') {
          steps {
            error 'oooo'
          }
        }
      }
    }
    stage('cccc') {
      steps {
        build 'hh'
        echo 'end'
      }
    }
  }
}