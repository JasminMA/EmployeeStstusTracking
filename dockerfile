From openjdk:11
copy ./target/Tracking-Employee-Status-0.0.1-SNAPSHOT.jar Tracking-Employee-Status-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","Tracking-Employee-Status-0.0.1-SNAPSHOT.jar"]