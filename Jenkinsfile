pipeline {
    agent any

    environment {
        // Set your environment variables here
        DOCKER_REGISTRY = 'us-central1-docker.pkg.dev/seventh-sensor-429203-b1/counterapp'
        DEPLOYMENT_FILE = '/home/praveenmunirajuttn/deployment.yaml'
    }

    stages {
        stage('Build') {
            steps {
                script {
                    // Run Maven build
                    sh 'mvn clean install'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Navigate to the workspace directory
                    sh 'cd /var/lib/jenkins/workspace/countertop-freestyle'
                    
                    // Build Docker image
                    sh "docker build -t counterapp:${BUILD_NUMBER} ."
                }
            }
        }
        stage('Tag and Push Docker Image') {
            steps {
                script {
                    // Tag Docker image
                    sh "docker tag counterapp:${BUILD_NUMBER} ${DOCKER_REGISTRY}/counterapp:${BUILD_NUMBER}"

                    // Push Docker image to the registry
                    sh "docker push ${DOCKER_REGISTRY}/counterapp:${BUILD_NUMBER}"
                }
            }
        }
        stage('Update Deployment Configuration') {
            steps {
                script {
                    // Define the tag with the build number
                    def tag = "${BUILD_NUMBER}"

                    // Replace the image tag in the deployment YAML file
                    sh "sed -i 's/image: countertop/image:counterapp:${tag}/g' ${DEPLOYMENT_FILE}"
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Apply the deployment configuration to Kubernetes
                    sh "kubectl apply -f ${DEPLOYMENT_FILE}"
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
