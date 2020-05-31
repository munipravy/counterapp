

mvn clean install

docker build -t app:1.0 -f Dockerfile .

kubectl apply -f /home/pguluru/.counterapp/counterapp/helm/counter-chart/template/blue.yml

kubectl apply -f /home/pguluru/.counterapp/counterapp/helm/counter-chart/template/green.yml

kubectl apply -f /home/pguluru/.counterapp/counterapp/helm/counter-chart/template/service.yml

kubectl apply -f /home/pguluru/.counterapp/counterapp/helm/counter-chart/template/Ingress-controller.yml

kubectl apply -f /home/pguluru/.counterapp/counterapp/helm/counter-chart/template/ingress.yml


