def dockerImageBuild(String imageName) {
    echo "Image is building..."
    sh """
      docker build -t ${imageName} .
    """   
}

def deployContainer(String imageName, String portMapping ="8083:8081") {
    echo "Image is building..."
    sh 'docker rm -f $(docker ps -aq)'
    sh """
      docker run -d -p ${portMapping} ${imageName} 
    """   

}

