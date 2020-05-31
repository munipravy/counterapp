# Counterapp
1) write an http api with endpoints defined as below

    a) /counter:

        GET will return +1 of existing count

        POST will return +2 of existing count

        DELETE will return -1 of existing count

    b) /info:

         GET will return

            - git commit hash

            - branch name of the source code

            - environment name of the app

            - hostname

    * environment name to be determined based config or system variable during run time

2) Dockerize the app with minimal foot print

    preferably using multi stage building

3) Create a script which will allow

    a) install dependencies

    b) create Docker image - Docker tags either can be given as an argument or determine based on git hash

4) Create a README.MD file to describe how to run the app in local environment.

5) Design and document CI/CD work flow and code promotion

    ex: -  dev/qa/stress test/staging/prod etc.

6) Create helm chart for deploying the application.

helm install 

7) Modify the script on task 3) to use the helm chart to deploy the application to target environment.

8) Create helm chart and modify the script 3) to do blue green switch.

9) Add function in script 3) to increase or decrease the pods for the deployment on target enviroment.

10) Implement sticky session for the api so requests will always go to the same pod during blue green traffic shift

11) Update the read me files to explain how to use the script



Instructions to run

1.I have created two deployment scripts under templates directory blue.yml and green.yml
2.I have used selectors and labels for switching blue/green deployments 
3.# sh run-app.sh to use helm tool to configure the application
4.# sh run-kube.sh to use kubectl commnds to perform expected tasks

To perform blue/green deployment 
Please switch to helm/counterapp/template/service.yml. And change version number to 1.1


