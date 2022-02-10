create table if not exists users(id UUID, username varchar, password varchar, enabled boolean);
create table if not exists authorities(id UUID, authority varchar);
alter table users add constraint PK_users PRIMARY KEY (id);
alter table authorities add constraint FK_user FOREIGN KEY (id) references users(id);