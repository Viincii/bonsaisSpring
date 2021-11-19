create table if not exists pruning (id_pruning UUID, datetime varchar, id_bonsai UUID);
alter table pruning add constraint PK_pruning PRIMARY KEY (id_pruning);
alter table pruning add constraint FK_owner FOREIGN KEY(id_bonsai) references bonsai(id);