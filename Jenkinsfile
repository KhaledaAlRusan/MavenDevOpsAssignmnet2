pipeline {
    agent any
    environment {
        dockerImage = 'khaledalrusan/assignment3:tagname'
        dockerUsername = 'khaledalrusan'
        dockerRegistry = 'docker.io'
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
                withCredentials([string(credentialsId: 'docker-hub-credentials', variable: 'DOCKER_HUB_ACCESS_TOKEN')]) {
                    sh 'echo "$DOCKER_HUB_ACCESS_TOKEN" | docker login -u $dockerUsername --password-stdin'
                }
            }
        }
        stage('Docker Push') {
            steps {
                sh 'docker tag $dockerImage $dockerRegistry/$dockerUsername/$dockerImage'
                sh 'docker push $dockerRegistry/$dockerUsername/$dockerImage'
            }
        }
    }
}