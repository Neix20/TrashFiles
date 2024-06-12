// This Pipeline read data from Nexus Artifacts
// Then Sends in an Email
pipeline {
    agent any

    stages {
        stage('Email To People') {
            steps {
                sh 'curl  -u admin:root -L -X GET \'http://nexus:8081/repository/trash-upload/momma.json\' > momma.json'

                emailext(
                    to: 'txen2000@gmail.com',
                    subject: 'Email Report',
                    body: readFile('./momma.json')
                )

            }
        }
    }
}
