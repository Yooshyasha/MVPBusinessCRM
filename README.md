## MVPBusinessCRM

### Функции:

- CRUD клиентов и продаж
- Продажи

### End-points: 
**Каждый (кроме `/jwt/**`) end-point является защищенным.**

- **POST** `/jwt/auth/login` ``RequestLogin``: Запрос на логин в систему
- **POST** `/jwt/auth/register` ``RequestRegister``: Запрос на регистрацию
- **GET** `/client/all`: Список клиентов
- **GET** `/client/{id}`: Информация о клиенте
- **PUT** `/client`  ``{Client}``: Обновление информации о клиенте
- **GET** `/sale/all`: Список продаж
- **GET** `/sale/{id}`: Информация о сделке
- **PUT** `/client` ``{Sale}``: Обновление информации о продаже