# Spring Project

### Поднять базу в докере

запустить базу
```sh
docker-compose up -d
```

При изменениях в миграциях надо базу пересоздать
```sh
docker-compose down -v
```

```sh
docker-compose up -d
```
Адрес swagger

http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
