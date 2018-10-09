# Simple Boot Integration demo TCP<-->AMQP<-->TCP

##  Prerequisites

```bash
brew install netcat
```

## Start client to subscribe to messages
```bash
netcat -l -p 11112
```

## Run the app
```bash
mvn spring-boot:run
```

## Run terminal for input and start typing
```bash
telnet localhost 11111
```
