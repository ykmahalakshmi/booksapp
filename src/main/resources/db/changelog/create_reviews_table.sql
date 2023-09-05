create table reviews(
review_id int primary key IDENTITY(2000,1),
book_id int not null REFERENCES books(book_id) on delete CASCADE ON UPDATE CASCADE ,
user_id int not null REFERENCES users(user_id) on delete no ACTION ,
rating int  not null CHECK (rating<=10),
comment VARCHAR(100),
created_at datetime not null
)
insert into reviews VALUES
(3000,2,5,'I really enjoyed this book! The characters were so well-developed','2021-09-09'),
(3001,4,4,'The plot twists in this book were mind-blowing','2022-08-18'),
(3002,7,7,'The imagery in this book is breathtaking. I felt transported to another world','2023-08-08'),
(3003,8,8,'A great book for history buffs. The author research is impressive','2021-08-06'),
(3004,8,9,' really enjoyed this book! The characters were so well-developed','2023-02-19'),
(3001,2,6,'The humor in this book had me laughing out loud in public. Great read','2022-09-20')