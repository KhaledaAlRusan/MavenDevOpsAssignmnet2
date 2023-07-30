pipeline {
    agent any
    environment {
        dockerImage = ''
        registryCredentials = 'docker-hub-credentials'
        dockerImage = 'khaled_devops_assignment2:tag'
        registry = 'KhaledAlrusan/khaled_devops_assignment2'
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Maven Project') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker Build') {
            steps{
                script {
                    docker.build dockerImage
                }
            }
        }
        stage('Docker Login') {
            steps{
            withCredentials([string(credentialsId: 'docker-hub-credentials', variable: 'DOCKER_PASSWORD')]) {
                sh "docker login -u KhaledAlrusan -p ${env.DOCKER_PASSWORD}"
            }
        }
        stage('Docker Push') {
            steps{
                sh "docker push ${registry}"
            }
        }
    }
}
