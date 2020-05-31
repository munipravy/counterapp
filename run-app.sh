mvn clean install
docker build -t arc-gateway:1.0 -f deploy/Dockerfile .
kubectl apply -f deploy/deploy-app.yml
kubectl apply -f deploy/app-service.yml
