## MVPBusinessCRM

### Функции:

- CRUD клиентов и продаж
- Продажи

### End-points: 
**Каждый end-point является защищенным.**

- **GET** `/client/all`: Список клиентов
- **GET** `/client/{id}`: Информация о клиенте
- **PUT** `/client/{id}`  ``{ClientDTO}``: Обновление информации о клиенте
- **GET** `/sale/all`: Список продаж
- **GET** `/sale/{id}`: Информация о сделке
- **POST** `/clients/create` ``{"clientFirstName"}``: Создать клиента
- **POST** `/sale/create` ``{clientID, productName}``: Создать продажу