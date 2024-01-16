pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Your build commands go here
                sh 'your_build_command'
            }
        }

        stage('Test') {
            steps {
                // Your testing commands go here
                sh 'your_test_command'
            }
        }

        stage('Deploy') {
            steps {
                // Your deployment commands go here
                sh 'your_deploy_command'
            }
        }
    }
}
