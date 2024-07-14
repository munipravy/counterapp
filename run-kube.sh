

mvn clean install

docker build -t app:1.0 -f Dockerfile .

kubectl apply -f helm/counterapptemplate/blue.yml

kubectl apply -f helm/counter-chart/template/green.yml

kubectl apply -f helm/counter-chart/template/service.yml

kubectl apply -f helm/counter-chart/template/Ingress-controller.yml

kubectl apply -f helm/counter-chart/template/ingress.yml

.
