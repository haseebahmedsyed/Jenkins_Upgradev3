9job('java-tomcat-sample-job'){
  description('This is the code dsl file which will create a job in jenkins')
  scm{
    git('https://github.com/haseebahmedsyed/Jenkins_Upgradev3.git','*/master')
  }
  triggers{
    scm('* * * * *')
  }
  steps{
    maven('clean package','java-tomcat-sample/pom.xml')
    maven{
      goals('clean')
      goals('package')
      mavenInstallation('Maven 3.9.4')
    }
  }
  publishers{
    archiveArtifacts '**/*.war'
  }
}
