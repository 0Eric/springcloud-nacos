#指定运行环境,alpine为精简版jdk
FROM java:8-alpine

#作者
MAINTAINER 1057718341@qq.com

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /tmp

#复制上下文目录下的target/demo-1.0.0.jar 到容器里
#COPY target/springcloud-nacos-1.0.2-SNAPSHOT.jar
ADD springcloud-nacos-1.0.2-SNAPSHOT.jar springcloud-nacos.jar

#bash方式执行，使demo-0.0.1jar可访问
#RUN新建立一层，在其上执行这些命令，执行结束后， commit 这一层的修改，构成新的镜像。
RUN sh -c 'touch /springcloud-nacos.jar'

#声明运行时容器提供服务端口，这只是一个声明，在运行时并不会因为这个声明应用就会开启这个端口的服务
EXPOSE 8093

#设置环境变量
ENV JAVA_OPTS="-Xmx2048m -Xms2048m"
ENV SERVER_PORT="8093"
ENV SPRING_PROFILES_ACTIVE="prod"
ENV SPRING_CLOUD_NACOS_DISCOVERY_SERVER_ADDR="192.168.0.87:8848"
ENV SPRING_CLOUD_NACOS_DISCOVERY_NAMESPACE="adfeb13b-291a-4154-ac97-b8526dcd8ca5"

#指定容器启动程序
#方式一：该种字符串拼接方式不支持变量替换，如果需要参数，可以指定写死
#ENTRYPOINT ["sh","-c","java -server -Xmx512m -Xms512m","-Djava.security.egd=file:/dev/./urandom","-jar","/daison-gateway.jar"]
#方式二：该种方法支持变量替换，通过docker run -e "JAVA_OPTS=-Xmx2048m -Xms2048m" -p 9090:9090 [容器id]
ENTRYPOINT java -server ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /springcloud-nacos.jar server.port=${SERVER_PORT} spring.profiles.active==${SPRING_PROFILES_ACTIVE} spring.cloud.nacos.discovery.server-addr=${SPRING_CLOUD_NACOS_DISCOVERY_SERVER_ADDR} spring.cloud.nacos.discovery.namespace=${SPRING_CLOUD_NACOS_DISCOVERY_NAMESPACE}

