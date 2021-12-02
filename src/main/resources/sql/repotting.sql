create table if not exists repotting (id_repotting UUID, datetime varchar, id_bonsai UUID);
alter table repotting add constraint PK_repotting PRIMARY KEY (id_repotting);
alter table repotting add constraint FK_owner FOREIGN KEY(id_bonsai) references bonsai(id);

alter table bonsai add  if not exists last_repotting varchar;