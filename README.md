# Taskapp
Gerenciador de Tarefas - Java com JSF, Primefaces, CDI, JPA e Mysql

Um pequeno gerenciador de tarefas desenvolvido com o framework JSF que permite autenticação de usuários, bem como gerenciamento de tarefas entre os mesmos.

### Requisitos da Aplicação

- JDK 8
- Eclipse
- Mysql
- Tomcat 8.5

### Instruções para implantação em Linux

- Instalando mysql-server

```shell
$ sudo apt-get install mysql-server

$ sudo mysql_secure_installation

$ mysql -u root -p

> create database db_tarefa;

> quit

$ mysql -u root -p db_tarefa < /path_to_db_tarefa/db_tarefa.sql

$ mysql -u root -p

> create user taskuser idenfied by 'task12345';

> grant all on hospedagemjsf.* to algaworks;

> quit
```

- Instalando jdk

```shell
$ sudo apt-get install -y default-jdk
```

-  Instalando e configurando o Tomcat

```shell
$ cd /tmp

$ wget http://ftp.unicamp.br/pub/apache/tomcat/tomcat-8/v8.5.15/bin/apache-tomcat-8.5.15.tar.gz

$ tar xvfz apache-tomcat-8.5.15.tar.gz

$ sudo mv apache-tomcat-8.5.15 /opt/tomcat

$ vim /opt/tomcat/bin/setenv.sh # o conteúdo desse arquivo é: JAVA_OPTS='-Djava.security.egd=file:/dev/urandom'

$ chmod +x /opt/tomcat/bin/*.sh

$ /opt/tomcat/bin/startup.sh # use o shutdown.sh para parar
```

- Implantando o pacote da aplicação no tomcat e iniciando container

```shell
$ /opt/tomcat/bin/shutdown.sh

$ mv /path_to_pacote/Taskapp.war /opt/tomcat/webapps/.

$ /opt/tomcat/bin/startup.sh
```

- Acessando a aplicação

Via browser: http://localhost:8080/Taskapp/









