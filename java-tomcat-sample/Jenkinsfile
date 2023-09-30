pipeline {
    agent any
	tools{
		maven 'maven'
	}
    stages {
        stage('Build Application') {
            steps {
                sh 'mvn -f java-tomcat-sample/pom.xml clean package'
            }
            post {
                success {
                    echo "Now Archiving the Artifacts...."
                    archiveArtifacts artifacts: '**/*.war'
                }
            }
        }
        stage('Build Docker App'){
            steps{
                sh "docker build -t haseeb38/dockerapp:0.0.1.RELEASE ./java-tomcat-sample"
            }
        }
        // stage('Deploy in Staging Environment'){
        //     steps{
		//     script{
	    // 	echo "Deploying..."
        //         build job: 'Deploy_To_Staging', wait: true
		// 	    }
        //     }
        // }
    }
}
