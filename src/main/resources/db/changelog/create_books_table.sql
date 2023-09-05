create table books(
    book_id int primary key IDENTITY(3000,1),
    publisher_id int not null REFERENCES publishers(publisher_id) on delete CASCADE ON UPDATE CASCADE ,
    author_id int not NULL REFERENCES users(user_id) on delete CASCADE ON UPDATE CASCADE ,
    title varchar(50) not null,
    filepath varchar(100) not null,
    created_at date not NULL

)
insert into books values (1000,3,'Anne of Green Gables','/home/developer/Documents/Maha/book1','2021-01-01')
insert into books values (1001,5,'Wonder','/home/developer/Documents/Maha/book2','2022-09-17'),(1002,6,'
The Fault in Our Stars','/home/developer/Documents/Maha/book3','2023-07-17')
insert into books values (1000,9,'Number the Stars','/home/developer/Documents/Maha/book4','2020-01-01')
insert into books values (1000,10,'Good Java Developer','/home/developer/Documents/Maha/book5','2023-01-01')