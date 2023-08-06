pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                powershell 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                powershell 'mvn test'
            }
        }
    }
}

