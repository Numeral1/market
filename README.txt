http://localhost:8080/api/v1/market/price (post)- реализована симуляция загрузки данных от ппоставщиков по ценам и дате, по истечении которой цена не актуальна (нажать несколько раз для загрузки данных в бд).
http://localhost:8080/api/v1/market/shipment (post) - реализована симуляция поставки товаров (нажать несколько раз для загрузки данных в бд).
http://localhost:8080/api/v1/market/shipment (get) - выдает отчет о поставках товаров в csv файлах(нажать один раз, файл появиться в корневом каталоге). 
Тестировать удобнее всего через Postman т.к. swagger не подключал.
