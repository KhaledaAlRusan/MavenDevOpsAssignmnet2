pipeline {
    agent any
    environment {
        dockerImage = 'khaled_devops_assignment2:tag'
        registryCredentials = 'docker-hub-credentials'
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
                withCredentials([usernamePassword(credentialsId: registryCredentials, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    sh 'echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin'
                }
            }
        }
        stage('Docker Push') {
            steps{
                sh "docker push ${registry}:${dockerImage.split(":")[1]}"
            }
        }
    }
}