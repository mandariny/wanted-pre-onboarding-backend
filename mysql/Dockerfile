# 최신 버전 mysql 사용
FROM mysql:latest

# docker-entrypoint-initdb.d에 실행할 sql파일 복사
WORKDIR /docker-entrypoint-initdb.d
COPY ./sql/init.sql /docker-entrypoint-initdb.d/init.sql

# sql파일 실행권한
RUN chown -R mysql:mysql /docker-entrypoint-initdb.d/init.sql

# mysql 데몬 실행
CMD ["mysqld"]