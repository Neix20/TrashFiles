# Curl Sample Rest API (Akin to Kubernetes Get Pod)
curl --location 'https://reqres.in/api/users?page=2'

# Upload File To Nexus
curl --fail -u admin:root --upload-file ./neix.json 'http://localhost:8081/repository/trash-upload/'

# Download File From Nexus
wget --user=admin --password=root "http://localhost:8081/repository/trash-upload/momma.json"
wget --user=admin --password=root "http://nexus:8081/repository/trash-upload/neix.json"

curl  -u admin:root -L -X GET 'http://localhost:8081/repository/trash-upload/momma.json'
curl  -u admin:root -L -X GET 'http://nexus:8081/repository/trash-upload/momma.json'

docker network connect jenkinNexusNetwork jenkins_sandbox
docker network connect jenkinNexusNetwork nexus

docker network inspect jenkinNexusNetwork

docker exec -it 234 /bin/sh
apt-get install -y iputils-ping

cp *.groovy ~/Documents/Github/Trashfiles
cp temp/script.sh ~/Documents/Github/Trashfiles
