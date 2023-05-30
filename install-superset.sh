git clone https://github.com/apache/superset.git
rm -rf superset/.git
docker-compose -f superset/docker-compose-non-dev.yml pull
docker-compose -f superset/docker-compose-non-dev.yml up -d
