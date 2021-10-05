# Distributed-Counter

### Install RabbitMQ for Ubuntu 20 (focal)

Start in root mode using command 

```
sudo -i
```

Follow [this ](https://otodiginet.com/software/how-to-install-rabbitmq-on-ubuntu-20-04-lts/) to install rabbitmq for Ubuntu 20.04 focal


### Cassandra -datastax distribution (127.0.0.1 : 9042)
- Pull And Run DataStax Image
```
docker pull datastax/dse-server:6.8.2
docker run -e DS_LICENSE=accept -p 9042:9042 --memory 4g --name my-dse -d datastax/dse-server:6.8.2 -g -s -k
```
- Pull and run DataStax Studio Image (Notebook)
```
docker pull datastax/dse-studio:latest
docker run -e DS_LICENSE=accept --memory 4g --name my-dse -d datastax/dse-server -g -s -k
```
[Complete Guide to Setup Cassandra (datastax) on local machine](https://medium.com/@michaeljpr/five-minute-guide-getting-started-with-cassandra-on-docker-4ef69c710d84)   

