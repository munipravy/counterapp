mvn clean install
docker build -t app:1.0 -f Dockerfile .
curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3
chmod 700 get_helm.sh
./get_helm.sh
helm install counter-chart chart.yml

