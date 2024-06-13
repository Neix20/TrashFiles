namespace=null

def data = [ "apple","orange" ]


data.each {val-> 
    println(val)
}

pipeline {
    agent any
    
    // triggers {
    //     cron("2 * * * *")
    // }

    parameters {
        choice choices: ['hk', 'hkbea', 'ph', 'th'], name: "country"
        choice choices: ['dev', 'sit', 'uat', 'prod', 'dr'], name: "environment"
    }


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
                script {
                    git branch: 'main', url: 'https://github.com/Neix20/pytest-intro-vs.git'
                    sh 'python3 -m pytest'

                    countrySel="${country.toLowerCase()}"
                    envSel=""

                    if (environment == "dev") {
                        envSel = "d"
                    } else if (environment == "sit") {
                        envSel = "s"
                    } else if (environment == "uat") {
                        envSel = "u"
                    } else if (environment == "prod") {
                        envSel = "p"
                    } else if (environment == "dr") {
                        envSel = "r"
                    }

                    namespace = "ns-go-${envSel}-${countrySel}-ms01"

                    for (def val: )
                }
            }
        }
        
        // stage("Check Status") {
        //     steps {

        //         script {
        //             def DATE_TIME = sh(script: "date +%Y%m%d", returnStdout: true).trim()
        //             def RANDOM_NUM = new Random().nextInt(100000)

        //             def FILE_NAME = "${namespace}_${DATE_TIME}_${RANDOM_NUM}.json"

        //             sh label: "Create File", script: "echo '> curl --location \'https://reqres.in/api/users?page=2\'' > ${FILE_NAME}"                

        //             sh label: "Write To File", script: "curl --location 'https://reqres.in/api/users?page=2' >> ${FILE_NAME}"

        //             // Upload to Nexus
        //             sh label: "Upload File", script: "curl --fail -u admin:root --upload-file ./${FILE_NAME} 'http://nexus:8081/repository/trash-upload/'"

        //             // Clean File
        //             sh label: "Clean File", script: "rm -f ./${FILE_NAME}.json"
        //         }
        //     }
        // }
    }
}
