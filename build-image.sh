mvn clean package
docker build -t abettame/abetta-gateway:latest .
docker push abettame/abetta-gateway:latest
