mvn clean install
docker build -t app:1.0 -f Dockerfile .
chmod 700 get_helm.sh
./get_helm.sh
helm install counterapp counter-chart
