For SOAP XML errors : 
https://stackoverflow.com/questions/21246780/no-endpoint-mapping-found-for-saajsoapmessage

Use this to run SOAP XML part of projects:
mvn spring-boot:run -Dspring-boot.run.jvmArguments="--add-opens=java.xml.crypto/com.sun.org.apache.xml.internal.security=ALL-UNNAMED"