pipeline {
    agent any
    
    // triggers {
    //     cron("H/5 * * * *")
    // }

    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Neix20/pytest-intro-vs.git']])
            }
        }
        
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/Neix20/pytest-intro-vs.git'
                sh 'python3 ops.py'
            }
        }
        
        stage('Test') {
            steps {
                git branch: 'main', url: 'https://github.com/Neix20/pytest-intro-vs.git'
                sh 'python3 -m pytest'
            }
        }
        
        stage("Check Status") {
            steps {
                sh 'curl --location \'https://reqres.in/api/users?page=2\' > momma.json'

                // Upload to Nexus
                sh 'curl --fail -u admin:root --upload-file ./momma.json \'http://nexus:8081/repository/trash-upload/\''
            }
        }
    }
}
