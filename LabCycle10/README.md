#Start the Minikube Cluster

minikube start --driver=docker

#Verify Minikube status

minikube status

#Configure Docker Environment for Minikube

eval $(minikube docker-env)

#Build the Docker image into the Docker Environment

docker build -t myprg10 .

docker images

#Create the YAML file

kubectl create -f kuber.yaml

#Access the Spring Boot app

minikube service myapp-service

#To open the Dashboard

minikube dashboard

#To close Minikube

minikube stop
