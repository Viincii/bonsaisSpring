create table if not exists watering (id_watering UUID, datetime timestamp, id_bonsai UUID);
alter table watering add constraint PK_watering PRIMARY KEY (id_watering);
alter table watering add constraint FK_owner FOREIGN KEY(id_bonsai) references bonsai(id);
