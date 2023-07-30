pipeline {
    agent any
    environment {
        dockerImage = 'khaled_devops_assignment2:tag'
        registryCredentials = 'dckr_pat_keldO5fR9w2fwaj_F1wfuBqspjo'
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
                withCredentials([string(credentialsId: registryCredentials, variable: 'DOCKER_PASSWORD')]) {
                    sh 'docker login -u $dockerUsername -p $DOCKER_PASSWORD'
                }
            }
        }
        stage('Docker Push') {
            steps {
                sh 'docker push $dockerRegistry'
            }
        }
    }
}