create table if not exists owner(id_owner UUID, name varchar);
alter table bonsai add id_owner UUID;
alter table owner add constraint PK_owner PRIMARY KEY (id_owner);
alter table bonsai add constraint FK_owner FOREIGN KEY (id_owner) references owner(id_owner);