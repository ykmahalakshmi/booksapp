create table roles(
    role_id int primary key IDENTITY(100,1),
    rolename varchar(20) not null CHECK (rolename='generaluser' or rolename='author'),
  )
  insert into roles values('generaluser'),('author')