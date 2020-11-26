pipeline {
   agent any
   environment {
       registry = "nkolomiy/test-levelp"
   }
   stages {
       stage('SCM checkout') {
           steps {
               git url: 'https://github.com/bzdgn/docker-spring-boot-java-web-service-example',branch: 'master'
           }
       }
       stage("Maven Clean Package"){
           steps {
              sh "mvn clean install"
           }
       } 
       stage('Publish') {
           environment {
               registryCredential = 'dockerhub'
           }
           steps{
               script {
                   def appimage = docker.build registry + ":$BUILD_NUMBER"
                   docker.withRegistry( '', registryCredential ) {
                       appimage.push()
                       appimage.push('latest')
                   }
               }
           }
       }
       stage('Deploy App') {
           steps {
             script {
                 sh "kubect get pods"
                 sh "kubectl apply -f deployment.yml"
                 sh "kubectl apply -f service.yml"
                 sh "kubect get pods"
             }
           }
       }
   }
}
