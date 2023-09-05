 create table users(
    user_id int primary key IDENTITY(1,1),
    username varchar(50) not null,
    phone_number VARCHAR(10) not null CHECK (phone_number LIKE '[6-9]%' AND LEN(phone_number) = 10 AND phone_number NOT LIKE '%[^0-9]%'),
    role_id int not null REFERENCES roles(role_id) on delete CASCADE ON UPDATE CASCADE ,
    created_at date not NULL
  )
insert into users values('vardhan','7799008254',101,'2017-08-18'),('usha','9347498836',100,'2020-09-19'),('J.K. Rowling','8809907654',101,'2015-04-20'),('ravi',9682651484,100,'2021-06-22'),('Mark Twain','9908805463',101,'2004-07-18'),('Leo Tolstoy','8176872345',101,'2016-04-16'),('niranjan','9879568941',100,'2018-09-02'),('praveen','8796432898',100,'2022-05-09'),('William Shakespeare','8879863498',101,'2020-03-19'),('Jane Austen','8099960688',101,'2009-06-26'),('maha','9888755653',100,'2020-12-26')