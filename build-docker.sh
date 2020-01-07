#Go to social app project and run this

mvn clean install -Dmaven.test.skip=true

docker build --build-arg  JAR_FILE=target/*.jar -t fx-app-img .

docker run -p 8080:8080 fx-app-img



