pipeline {
    agent any

    environment {
        // Set your environment variables here
        DOCKER_REGISTRY = 'us-central1-docker.pkg.dev/seventh-sensor-429203-b1/counterapp'
        DEPLOYMENT_FILE = '/home/praveenmunirajuttn/deployment.yaml'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Clean the workspace
                    cleanWs()
                    // Checkout the code from the specified repository
                    checkout scm: [
                        $class: 'GitSCM', 
                        branches: [[name: '*/master']], // Change 'master' to your desired branch if needed
                        userRemoteConfigs: [[url: 'https://github.com/munipravy/counterapp.git']]
                    ]
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    // Run Maven build
                    sh 'cd /var/lib/jenkins/workspace/counterapp-pipeline && mvn clean install'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
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
                    // Define the new image tag, ensure proper indentation
                    def newImageTag = "        image: ${DOCKER_REGISTRY}/counterapp:${BUILD_NUMBER}"  // Adjust indentation as needed
        
                    // Use sed to replace the existing image line while preserving formatting
                    sh "sed -i 's|^\\s*image:.*|${newImageTag}|g' ${DEPLOYMENT_FILE}"
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
