pipeline {
    agent any
    environment {
        dockerImage = 'khaledalrusan/assignment3:tagname'
        registryCredentials = 'Aa@206081'
        dockerUsername = 'KhaledAlrusan'
        dockerRegistry = 'KhaledAlrusan/khaled_devops_assignment2'
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
            steps {
                script {
                    docker.build dockerImage
                }
            }
        }
        stage('Docker Login') {
            steps {
                withCredentials([string(credentialsId: 'Aa@206081', variable: 'DOCKER_HUB_ACCESS_TOKEN')]) {
                    sh 'echo "$DOCKER_HUB_ACCESS_TOKEN" | docker login -u KhaledAlrusan --password-stdin'
                }
            }
        }
        stage('Docker Push') {
            steps {
                sh 'docker push $dockerImage'
            }
        }
    }
}