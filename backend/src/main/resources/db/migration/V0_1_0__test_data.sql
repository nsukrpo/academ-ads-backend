--password for all users is "password"
INSERT INTO "Users" (name, "regDate", type, "login", "password_hash") VALUES
('Vasiliy Vasiliev', '2023-12-22', 2, 'loginV', 1216985755),
('Admin Adminovich', '2023-12-01', 1, 'loginAdmin', 1216985755),
('Petr Petrov', '2023-12-22', 2, 'loginP', 1216985755),
('Lev Glebov', '2023-12-23', 2, 'loginL', 1216985755);

INSERT INTO "Advertisements" (header, description, price, category, author, "publicationDate", "countWatch", "status", "editDate")
VALUES ('Продам корову', 'Корова такая, что нужна самому', 20000, 5, 1, '2023-12-24', 0, 2, '2023-12-24'),
('Апельсины (витамины)', 'Рубль — штучка! Три рубля — кучка! В кучке три штучки.', 1, 5, 3, '2023-12-25', 0, 2, '2023-12-25'),
('Репетитор по матанализу', 'Репетирую вычисление замечательных пределов', 1000, 4, 4, '2023-12-25', 0, 2, '2023-12-25'),
('Теория вероятностей за 20 уроков!', 'Полный путь от подбрасывания кубика до центральной предельной теоремы', 20000, 4, 4, '2023-12-25', 0, 2, '2023-12-25'),
('Полное собрание сочинений А.С. Пушкина (1960)', 'Все 10 томов в наличии', 500, 1, 1, '2023-12-25', 0, 10, '2023-12-25'),
('Магнитофон «Грюндиг»', 'Четыре дорожки, стереофония, элегантный внешний вид. Вещь редкая, уйдёт в минуту.', 8000, 2, 4, '2023-12-25', 0, 9, '2023-12-25');

INSERT INTO "Purchases" (ads, seller, buyer, price, "date") VALUES
(5, 1, 4, 500, '2023-12-26');

INSERT INTO "Bookings" (ads, claimant, "dateStart", "dateUntil") VALUES
(6, 3, '2023-12-26', '2024-01-15');